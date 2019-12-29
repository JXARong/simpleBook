package com.bdqn.simplebook.service;

import com.bdqn.simplebook.domain.Post;
import com.bdqn.simplebook.domain.User;
import com.bdqn.simplebook.utils.PageUtils;

import java.util.List;


/**
 * @author: 龚皓冬
 * @date: 2019/11/18
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.service
 */
public interface PostService {


    /**
     * 查询post表的所有数据，首页显示
     * @return
     * @throws Exception
     */
    public List<Post> selectAllPost()throws  Exception;

    PageUtils selPostByPage(PageUtils pageUtils, Post post,String sendDate) throws Exception;

    Integer delPostById(String[] pid) throws Exception;

    PageUtils selPostListOfTop(PageUtils pageUtils);

    List<Post> selPostByTid(Integer tid);

    int getPostUser(User user);

    Long getCountByTid(Integer topicId);

    List<Post> selPostByUIdOfTop10(Integer uid);

    /**
     * 发布文章
     * @param post
     * @return
     */
    int sendPost(Post post);

    /**
     * 根据帖子编号查询该篇帖子的喜欢数
     * @param pid
     * @return
     */
    int selFavouriteByPid(Integer pid);


    /**
     * 文章搜索
     * @param searchValue
     * @return
     */
    List<Post> searchPost(String searchValue);

    Post selPostById(Integer id) throws Exception;

    void addReadOfPostByPid(Integer pid);

}
