package com.bdqn.simplebook.dao.impl;

import com.bdqn.simplebook.dao.BaseDao;
import com.bdqn.simplebook.dao.TopicDao;
import com.bdqn.simplebook.domain.Post;
import com.bdqn.simplebook.domain.Topic;

import java.util.List;

/**
 * @author: 赖榕
 * @date: 2019/11/18
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.dao.impl
 */
public class TopicDaoImpl extends BaseDao implements TopicDao {

    /**
     *  根据主题查询
     * @param id
     * @return
     */
    @Override
    public Topic selTopicById(Integer id) {
        String sql="select * from topic where topicId = ?";
        Topic topic = super.selectOne(Topic.class, sql, new Object[]{id});
        return topic;
    }

    /**
     * 查询所有的主题
     * @return
     */
    @Override
    public List<Topic> selTopicOfAll() {
        String sql="select * from topic";
        List<Topic> topics = super.selectList(Topic.class, sql, null);
        return topics;
    }

    /**
     *  根据主题名称查询主题
     * @param topic
     * @return
     */
    @Override
    public Topic selTopicByName(String topic) {
        String sql="select * from topic where topic = ?";
        Topic selectOne = super.selectOne(Topic.class, sql, new Object[]{topic});
        return selectOne;
    }

    /**
     *  添加主题
     * @param topic
     * @return
     */
    @Override
    public int addTopic(Topic topic) {
        String sql="insert into topic values(default,?)";
        int update = super.update(sql, new Object[]{topic.getTopic()});
        return update;
    }
}
