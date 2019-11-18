package com.bdqn.simplebook.domain;

/**
 * @author: 赖榕
 * @date: 2019/11/18
 * @description: 用户关注表
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.domain
 */
public class Relation {
    private Integer rid ; // 编号
    private Integer uid; // 关注用户编号
    private Integer cid; // 被关注用户编号
    private User user; // 关注用户信息
    private User cuser;// 被关注用户信息

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getCuser() {
        return cuser;
    }

    public void setCuser(User cuser) {
        this.cuser = cuser;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Relation{");
        sb.append("rid=").append(rid);
        sb.append(", uid=").append(uid);
        sb.append(", cid=").append(cid);
        sb.append(", user=").append(user);
        sb.append(", cuser=").append(cuser);
        sb.append('}');
        return sb.toString();
    }
}
