package com.bdqn.simplebook.service;

import com.bdqn.simplebook.dao.TopicDao;
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

    List<Topic> selAllTopic() throws Exception;

}
