package com.bdqn.simplebook.domain;

/**
 * @author: 赖榕
 * @date: 2019/11/20
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.domain
 */
public class Email {

    private String email; // 邮箱
    private String host; // 服务器地址
    private String port; // 端口
    private String password; // 秘钥
    private String emailName; // 邮箱名称

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailName() {
        return emailName;
    }

    public void setEmailName(String emailName) {
        this.emailName = emailName;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Email{");
        sb.append("email='").append(email).append('\'');
        sb.append(", host='").append(host).append('\'');
        sb.append(", port='").append(port).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", emailName='").append(emailName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
