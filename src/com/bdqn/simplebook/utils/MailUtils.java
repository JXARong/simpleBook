package com.bdqn.simplebook.utils;

import com.alibaba.druid.sql.ast.statement.SQLCreateTriggerStatement;
import com.bdqn.simplebook.domain.Email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.util.Properties;

/**
 * 发邮件工具类
 */
public final class MailUtils {

    public static final Properties props = new Properties();

    // 加载发送邮件信息
    static {
        loadEmailInfo();
    }

    /**
     * 加载邮箱信息
     */
    public static void loadEmailInfo() {
        try {
            InputStreamReader stream = new InputStreamReader(MailUtils.class.getClassLoader().getResourceAsStream("email.properties"), "utf-8");
            props.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送验证信息的邮件
     *
     * @param to    收件人邮箱
     * @param text  邮件正文
     * @param title 标题
     */
    public static boolean sendMail(String to, String text, String title) {
        try {
            // 构建授权信息，用于进行SMTP进行身份验证
            Authenticator authenticator = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    // 用户名、密码
                    String userName = props.getProperty("mail.user");
                    String password = props.getProperty("mail.password");
                    return new PasswordAuthentication(userName, password);
                }
            };
            // 使用环境属性和授权信息，创建邮件会话
            Session mailSession = Session.getInstance(props, authenticator);
            // 创建邮件消息
            MimeMessage message = new MimeMessage(mailSession);
            // 设置发件人
            String username = props.getProperty("mail.user");
            InternetAddress form = new InternetAddress(username, props.getProperty("mail.smtp.user"));
            message.setFrom(form);

            // 设置收件人
            InternetAddress toAddress = new InternetAddress(to);
            message.setRecipient(Message.RecipientType.TO, toAddress);

            // 设置邮件标题
            message.setSubject(title);

            // 设置邮件的内容体
            message.setContent(text, "text/html;charset=UTF-8");
            // 发送邮件
            Transport.send(message);
            return true;
        } catch (Exception e) {
            System.out.println("发送邮件失败");
        }
        return false;
    }


    /**
     * 测试修改的email是否能成功发送邮件
     *
     * @param host
     * @param port
     * @param username
     * @param account
     * @param password
     * @return
     * @throws Exception
     */
    public static boolean testInfo(String host, String port, String username, String account, String password) {
        // 赋值给保存发送邮件的properties中
        MailUtils.props.setProperty("mail.user", account);
        props.setProperty("mail.password", password);
        props.setProperty("mail.smtp.host", host);
        props.setProperty("mail.smtp.user", username);
        props.setProperty("mail.smtp.port", port);
        //设置超时时间为20秒
        props.setProperty("mail.smtp.timeout", "20000");

        // 测试邮件是否能否发送
        boolean result = MailUtils.sendMail("1131111310@qq.com", "测试修改邮箱", "管理员修改邮箱信息");
        // 发送失败抛出异常
        if (!result) {
            // 重新加载email.properties原有信息进properties中
            loadEmailInfo();
            return false;
        }
        return false;
    }

    /**
     * 修改当前内存中的email信息以及将它们持久化到email.properties中
     *
     * @param path  properties文件路径
     * @param email 封装了email信息
     * @return
     */
    public static boolean updateEmailInfo(String path, Email email) {

        try {
            FileOutputStream fos = new FileOutputStream(path);
            // 修改内存中的email信息
            props.setProperty("mail.user",email.getEmail());
            props.setProperty("mail.smtp.user",email.getEmailName());
            props.setProperty("mail.smtp.host",email.getHost());
            props.setProperty("mail.smtp.port",email.getPort());
            props.setProperty("mail.password",email.getPassword());

            // 将信息持久化到硬盘中
            props.store(fos,"emailInfo");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) throws Exception { // 做测试用
        boolean b = testInfo("smtp.163.com", "26", "fa", "fa", "fa");
    }
}
