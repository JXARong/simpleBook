package com.bdqn.simplebook.service.impl;

import com.bdqn.simplebook.domain.Email;
import com.bdqn.simplebook.service.EmailService;
import com.bdqn.simplebook.utils.MailUtils;

import java.io.*;
import java.util.Properties;

/**
 * @author: 赖榕
 * @date: 2019/11/20
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.service.impl
 */
public class EmailServiceImpl implements EmailService {

    /**
     * 修改邮箱信息
     * @param path properties文件路径
     * @param email 已经封装好email信息
     * @return
     * @throws Exception
     */
    @Override
    public boolean updateEmail(String path, Email email) throws Exception {

        // 测试新的邮件是否能正常发送邮箱 ，如果不能发送将重新加载email.properties中的信息
        boolean b = MailUtils.testInfo(email.getHost(), email.getPort(), email.getEmailName(), email.getEmail(), email.getPassword());
        // 如果不能成功发送邮件抛出异常
        if (!b){
            throw new Exception("修改后的邮箱信息并不能完成发送邮件,信息将不会被保留");
        }else{
            // 将信息的邮箱信息加载到email.properties文件中
            boolean updateEmailInfo = MailUtils.updateEmailInfo(path, email);
            if (!updateEmailInfo){
                throw new Exception("服务器繁忙，请稍后重试");
            }
            return updateEmailInfo;
        }
    }

    /**
     * 获取email.properties中邮箱信息
     * @return
     * @throws Exception
     */
    @Override
    public Email selEmailInfo() throws Exception {
        try {
            InputStreamReader stream=new InputStreamReader(EmailServiceImpl.class.getClassLoader().getResourceAsStream("email.properties"),"utf-8");
            Properties properties=new Properties();
            properties.load(stream);
            Email email=new Email();
            email.setEmail(properties.getProperty("mail.user"));
            email.setPassword(properties.getProperty("mail.password"));
            email.setPort(properties.getProperty("mail.smtp.port"));
            email.setEmailName(properties.getProperty("mail.smtp.user"));
            email.setHost(properties.getProperty("mail.smtp.host"));
            return email;
        } catch (IOException e) {
            throw new Exception("服务器繁忙,获取邮箱信息失败");
        }
    }
}
