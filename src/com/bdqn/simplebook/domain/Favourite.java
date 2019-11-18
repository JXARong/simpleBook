package com.bdqn.simplebook.domain;

/**
 * @author: 赖榕
 * @date: 2019/11/18
 * @description: 用户喜欢文章类
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.domain
 */
public class Favourite {
    private Integer id; // 编号
    private Integer uid; // 用户编号
    private Integer pid ; // 文章编号
    private User user; // 用户信息
    private Post post ;// 文章信息

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Favourite{");
        sb.append("id=").append(id);
        sb.append(", uid=").append(uid);
        sb.append(", pid=").append(pid);
        sb.append(", user=").append(user);
        sb.append(", post=").append(post);
        sb.append('}');
        return sb.toString();
    }
}
