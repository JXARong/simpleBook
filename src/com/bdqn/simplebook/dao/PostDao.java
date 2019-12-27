package com.bdqn.simplebook.dao;

import com.bdqn.simplebook.domain.Post;
import com.bdqn.simplebook.domain.User;

import java.util.List;


/**
 * @author: 赖榕
 * @date: 2019/11/18
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.dao
 */
public interface PostDao {

    /**
     * 查询所有帖子信息
     * @return
     * @throws Exception
     */
    List<Post> selectAllPost() throws Exception;

    /**
     * 根据帖子编号查询帖子信息
     * @param pid
     * @return
     * @throws Exception
     */
    Post findPost(int pid) throws Exception;

    /**
     * 根据用户名删除帖子
     * @param user
     * @return
     */
    Integer delPostByUid(User user);

    /**
     * 根据用户名查询帖子
     * @param user
     * @return
     */
    List<Post> selPostByUid(User user);

    /**
     * 分页查询帖子信息
     * @param startNum
     * @param limit
     * @param post
     * @param sendDate
     * @return
     */
    List<Post> selPostByPage(Integer startNum, Integer limit, Post post, String sendDate);

    /**
     * 查询帖子的数量
     * @param post
     * @return
     */
    Long selPostCount(Post post);

    /**
     * 根据帖子编号删除帖子
     * @param pid
     * @return
     */
    Integer delPostByPid(Integer pid);

    /**
     * 查询i个帖子，并且排序
     * @param i
     * @param limit
     * @return
     */
    List<Post> selPostOfTop(int i, Integer limit);


    /**
     * 根据编号删除帖子
     *
     * @param id
     * @return
     */
    Integer delPostByTid(Integer id);

    /**
     * 根据主题编号查询该主题下的所有文章信息
     *
     * @param tid
     * @return
     */
    List<Post> selPostByTid(Integer tid);

    /**
     * 文章数
     *
     * @param user
     * @return
     */
    int getPostUser(User user);

    /**
     * 根据主题编号查询所有文章数量
     *
     * @param topicId
     * @return
     */
    Long getCountByTid(Integer topicId);

    /**
     * 查询某一个用户的前十条帖子
     *
     * @param uid
     * @return
     */
    List<Post> selPostByUIdOfTop10(Integer uid);

    /**
     * 发布帖子
     * @param post
     * @return
     */
    int sendPost(Post post);

    Post selpostByPid(Integer id);
}
