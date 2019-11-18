package com.bdqn.simplebook.domain;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author: 赖榕
 * @date: 2019/11/18
 * @description: 文章举报类
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.domain
 */
public class Report {
    private Integer reportId; // 举报信息编号
    private Integer pid;// 被举报文章Id
    private Integer uid;// 举报人编号
    private String reportContent; // 举报原因
    private Timestamp reportTime ; // 举报时间
    private Post post;  //  被举报文章信息
    private User user;   // 举报人信息

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

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

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public Timestamp getReportTime() {
        return reportTime;
    }

    public void setReportTime(Timestamp reportTime) {
        this.reportTime = reportTime;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Report{");
        sb.append("reportId=").append(reportId);
        sb.append(", pid=").append(pid);
        sb.append(", uid=").append(uid);
        sb.append(", reportContent='").append(reportContent).append('\'');
        sb.append(", reportTime=").append(reportTime);
        sb.append(", post=").append(post);
        sb.append(", user=").append(user);
        sb.append('}');
        return sb.toString();
    }
}

