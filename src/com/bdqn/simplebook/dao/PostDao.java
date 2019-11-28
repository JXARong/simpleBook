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

   public List<Post> selectAllPost()throws  Exception;

    Post findPost(int pid)throws Exception;

    Integer delPostByUid(User user);

    List<Post> selPostByUid(User user);

    List<Post> selPostByPage(Integer startNum, Integer limit, Post post,String sendDate);

    Long selPostCount(Post post);

    Integer delPostByPid(Integer pid);

 List<Post> selPostOfTop(int i, Integer limit);
}
