package com.bdqn.simplebook.service;

import com.bdqn.simplebook.domain.Topic;

import java.util.List;

/**
 * @author: 龚皓冬
 * @date: 2019/11/18
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.service
 */
public interface TopicService {

    List<Topic> selAllTopic(String page,String limit) throws Exception;

    Topic addTopic(Topic topic) throws Exception;

    Long selTopicCount();

    int updTopic(Topic topic);

    boolean existsTopicByName(String name);

    int delTopicById(Integer id);

    List<Topic> selAll();

    /**
     * 主题搜索
     * @param searchValue
     * @return
     */
    List<Topic> searchTopic(String searchValue);
}
