package com.bdqn.simplebook.service;

import com.bdqn.simplebook.domain.Post;
import com.bdqn.simplebook.utils.PageUtils;

/**
 * @author: 龚皓冬
 * @date: 2019/11/18
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.service
 */
public interface PostService {

    PageUtils selPostByPage(PageUtils pageUtils, Post post) throws Exception;

    Integer delPostById(String[] pid) throws Exception;
}
