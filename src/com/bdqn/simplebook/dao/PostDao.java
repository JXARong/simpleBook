package com.bdqn.simplebook.dao;

import com.bdqn.simplebook.domain.Post;

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
     * 首页的查询文章的显示
     * @return
     * @throws Exception
     */
   public List<Post> selectAllPost()throws  Exception;
}
