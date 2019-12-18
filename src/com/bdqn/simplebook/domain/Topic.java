package com.bdqn.simplebook.domain;

/**
 * @author: 赖榕
 * @date: 2019/11/18
 * @description: 主题信息
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.domain
 */
public class Topic {
    private Integer topicId;// 主题编号
    private String topic; // 主题名称
    private String topicPicture;
    private Integer topicPost;
    private Integer topicFollow;
    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTopicPicture() {
        return topicPicture;
    }

    public void setTopicPicture(String topicPicture) {
        this.topicPicture = topicPicture;
    }

    public Integer getTopicPost() {
        return topicPost;
    }

    public void setTopicPost(Integer topicPost) {
        this.topicPost = topicPost;
    }

    public Integer getTopicFollow() {
        return topicFollow;
    }

    public void setTopicFollow(Integer topicFollow) {
        this.topicFollow = topicFollow;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topicId=" + topicId +
                ", topic='" + topic + '\'' +
                ", topicPicture='" + topicPicture + '\'' +
                ", topicPost=" + topicPost +
                ", topicFollow=" + topicFollow +
                '}';
    }
}
