package com.bdqn.simplebook.dao.impl;

import com.bdqn.simplebook.dao.BaseDao;
import com.bdqn.simplebook.dao.TopicDao;
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
    public List<Topic> selTopicOfAll(Integer pageNo,Integer limit) {
        String sql="select * from topic limit ?,?";
        List<Topic> topics = super.selectList(Topic.class, sql, new Object[]{(pageNo-1)*limit,limit});
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

    @Override
    public Long selTopicCount() {
        String sql="select count(*) from topic";
        Object count = super.getCount(sql, null);
        return (Long) count;
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

    @Override
    public int updTopic(Topic topic) {
        String sql="update topic set topic = ? where topicid = ?";
        int index = super.update(sql, new Object[]{topic.getTopic(), topic.getTopicId()});
        return index;
    }

    @Override
    public int delTopicById(Integer id) {
        String sql="delete from topic where topicId =?";
        return super.update(sql, new Object[]{id});
    }

    @Override
    public List<Topic> selAllTopic() {
        String sql="select * from topic ";
        return super.selectList(Topic.class,sql,null);
    }

    @Override
    public List<Topic> searchTopic(String searchValue) {
        String sql = "select * from topic where topic like ?";
        List<Topic> searchTopicList = super.selectList(Topic.class,sql,new Object[]{"%"+searchValue+"%"});
        return searchTopicList;
    }
}
