package com.bdqn.simplebook.domain;

import jdk.net.SocketFlow;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author: 赖榕
 * @date: 2019/11/18
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: 文章类
 */
public class Post {
    private Integer pid; // 文章编号
    private Integer uid; // 用户编号
    private Integer start ; // 点赞总数
    private Double gratuity;// 打赏金额
    private Integer readCount;// 阅读总数
    private Timestamp sendDate; // 发布时间
    private String article; // 文章内容
    private String title ;// 文章标题
    private Integer hot; // 热度
    private Integer status; // 状态
    private Integer topicId;  // 主题编号
    private Topic topic; // 主题信息
    private User user; // 发布人信息

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Double getGratuity() {
        return gratuity;
    }

    public void setGratuity(Double gratuity) {
        this.gratuity = gratuity;
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    public Timestamp getSendDate() {
        return sendDate;
    }

    public void setSendDate(Timestamp sendDate) {
        this.sendDate = sendDate;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Post{");
        sb.append("pid=").append(pid);
        sb.append(", uid=").append(uid);
        sb.append(", start=").append(start);
        sb.append(", gratuity=").append(gratuity);
        sb.append(", readCount=").append(readCount);
        sb.append(", sendDate=").append(sendDate);
        sb.append(", article='").append(article).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", hot=").append(hot);
        sb.append(", status=").append(status);
        sb.append(", topicId=").append(topicId);
        sb.append(", topic=").append(topic);
        sb.append(", user=").append(user);
        sb.append('}');
        return sb.toString();
    }
}
