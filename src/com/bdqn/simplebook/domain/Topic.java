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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Topic{");
        sb.append("topicId=").append(topicId);
        sb.append(", topic='").append(topic).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
