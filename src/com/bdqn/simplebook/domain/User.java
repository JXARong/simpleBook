package com.bdqn.simplebook.domain;

import java.sql.Timestamp;

/**
 * @author: 赖榕
 * @date: 2019/11/16
 * @description: 用户实体类
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.domain
 */
public class User {

    private Integer uid;// 用户编号
    private  String password;// 密码
    private String email;// 邮箱
    private Integer sex; // 性别
    private Timestamp bornthDay; // 出生日期
    private String photo;// 头像路径
    private  Double money; // 余额
    private Integer status; // 状态  0正常使用  1审核中 2 已封禁
    private String uname; // 昵称

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Timestamp getBornthDay() {
        return bornthDay;
    }

    public void setBornthDay(Timestamp bornthDay) {
        this.bornthDay = bornthDay;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("uid=").append(uid);
        sb.append(", password='").append(password).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", sex=").append(sex);
        sb.append(", bornthDay=").append(bornthDay);
        sb.append(", photo='").append(photo).append('\'');
        sb.append(", money=").append(money);
        sb.append(", status=").append(status);
        sb.append(", uname='").append(uname).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
