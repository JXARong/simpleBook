package com.bdqn.simplebook.utils;

import com.alibaba.druid.sql.ast.statement.SQLCreateTriggerStatement;
import com.bdqn.simplebook.domain.Email;
import jdk.nashorn.internal.ir.ReturnNode;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.net.URLDecoder;
import java.nio.Buffer;
import java.util.Properties;

/**
 * 发邮件工具类
 */
public final class MailUtils {

    public static final Properties props = new Properties();

    public static BufferedReader emailReader = null;

    private static String defaultEmailTemp = "";

    // 加载发送邮件信息
    static {
        loadEmailInfo();

        // 初始化读取email文件的信息
        String path = MailUtils.class.getResource("/email.txt").getPath();
        try {
            emailReader = new BufferedReader(new FileReader(URLDecoder.decode(path, "UTF-8")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // 初始化默认的邮箱样板
        try {
            while (emailReader.ready()) {
                defaultEmailTemp += emailReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        props.setProperty("mail.smtp.timeout", "10000");

        // 测试邮件是否能否发送
        boolean result = MailUtils.sendMail("1131111310@qq.com", "测试修改邮箱", "管理员修改邮箱信息");
        // 发送失败抛出异常
        if (!result) {
            // 重新加载email.properties原有信息进properties中
            loadEmailInfo();
            return false;
        }
        return true;
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
            props.setProperty("mail.user", email.getEmail());
            props.setProperty("mail.smtp.user", email.getEmailName());
            props.setProperty("mail.smtp.host", email.getHost());
            props.setProperty("mail.smtp.port", email.getPort());
            props.setProperty("mail.password", email.getPassword());

            // 将信息持久化到硬盘中
            props.store(fos, "emailInfo");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) throws Exception { // 做测试用
        String emailContent = getEmailContent("简简书文章举报审核","简简书文章审核结果如下","亲爱的'天涯诺比邻'您好,在 2019-12-12 19:12:12 时您对进行了'海贼王中鹰眼的实力定位是什么？和大将四皇同级吗？'举报！举报原因为：太幼稚了,我们已对该文章进行了删除,并对作者进行了通知，感谢您为简简书做的一切");
        sendMail("1131111310@qq.com",emailContent , "测试");
    }

    public static String getEmailContent(String titleStr, String subTitle, String contentStr) {
        String temp=defaultEmailTemp;
        temp = temp.replace("titleStr", titleStr);
        temp = temp.replace("subTitleStr", subTitle);
        temp = temp.replace("contentStr", contentStr);
            System.out.println(temp);
            return temp;
    }
}
