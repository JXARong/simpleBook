package com.bdqn.simplebook.service;

import com.bdqn.simplebook.domain.Post;


import java.util.List;

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


    /**
     * 查询post表的所有数据，首页显示
     * @return
     * @throws Exception
     */
    public List<Post>selectAllPost()throws  Exception;

    PageUtils selPostByPage(PageUtils pageUtils, Post post,String sendDate) throws Exception;

    Integer delPostById(String[] pid) throws Exception;

    PageUtils selPostListOfTop(PageUtils pageUtils);
}
