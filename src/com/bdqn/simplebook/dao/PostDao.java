package com.bdqn.simplebook.dao;

import com.bdqn.simplebook.domain.Post;

/**
 * @author: 赖榕
 * @date: 2019/11/18
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.dao
 */
public interface PostDao {
    Post findPost(int pid)throws Exception;
}
