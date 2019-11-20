package com.bdqn.simplebook.service.impl;

import com.bdqn.simplebook.dao.TopicDao;
import com.bdqn.simplebook.dao.impl.TopicDaoImpl;
import com.bdqn.simplebook.domain.Topic;
import com.bdqn.simplebook.service.TopicService;

import java.util.List;

/**
 * @author: 龚皓冬
 * @date: 2019/11/18
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.service.impl
 */
public class TopicServiceImpl implements TopicService {

    private TopicDao dao=new TopicDaoImpl();

    /**
     * 查询所有的主题信息
     * @return
     */
    @Override
    public List<Topic> selAllTopic() throws Exception {
        List<Topic> topics = dao.selTopicOfAll();
        if (topics==null || topics.size()==0){
            throw new Exception("暂无相关数据");
        }
        return topics;
    }
}
