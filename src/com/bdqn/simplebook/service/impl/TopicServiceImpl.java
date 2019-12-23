package com.bdqn.simplebook.service.impl;

import com.bdqn.simplebook.dao.TopicDao;
import com.bdqn.simplebook.dao.impl.TopicDaoImpl;
import com.bdqn.simplebook.domain.Post;
import com.bdqn.simplebook.domain.Topic;
import com.bdqn.simplebook.service.PostService;
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

    private TopicDao dao = new TopicDaoImpl();

    private PostService postService = new PostServiceImpl();

    /**
     * 查询所有的主题信息
     *
     * @return
     */
    @Override
    public List<Topic> selAllTopic(String page, String limit) throws Exception {
        Integer pageNo = page == null ? 1 : Integer.parseInt(page);
        Integer limitInt = limit == null ? 6 : Integer.parseInt(limit);
        List<Topic> topics = dao.selTopicOfAll(pageNo, limitInt);
        if (topics == null || topics.size() == 0) {
            throw new Exception("暂无相关数据");
        }
        return topics;
    }

    @Override
    public Long selTopicCount() {
        return dao.selTopicCount();
    }

    @Override
    public Topic addTopic(Topic topic) throws Exception {
        // 查询是否已经存在该主题
        Topic selTopicByName = dao.selTopicByName(topic.getTopic());
        if (selTopicByName != null && selTopicByName.getTopic() != null) {
            throw new Exception("该主题已存在");
        }
        int index = dao.addTopic(topic);
        // 返回为1时，添加成功，查询该主题的编号以及名称
        if (index == 1) {
            topic = dao.selTopicByName(topic.getTopic());
        } else {
            throw new Exception("添加主题失败，请稍后重试");
        }
        return topic;
    }

    @Override
    public int updTopic(Topic topic) {
        return dao.updTopic(topic);
    }

    @Override
    public boolean existsTopicByName(String name) {
        return dao.selTopicByName(name) == null ? true : false;
    }

    @Override
    public int delTopicById(Integer id) {
        List<Post> posts = postService.selPostByTid(id);
        if (posts == null && posts.size() == 0) {
            return dao.delTopicById(id);
        }
        String[] pid=new String[posts.size()];
        // 否则删除该主题下的所有帖子
        for (int i = 0; i < pid.length; i++) {
            pid[i]= String.valueOf(posts.get(i).getPid());
        }
        Integer index = 0;
        try {
            index = postService.delPostById(pid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return index;
    }
}
