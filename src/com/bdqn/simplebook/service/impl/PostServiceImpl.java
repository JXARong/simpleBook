package com.bdqn.simplebook.service.impl;

import com.bdqn.simplebook.dao.PostDao;
import com.bdqn.simplebook.dao.impl.PostDaoImpl;
import com.bdqn.simplebook.domain.Post;
import com.bdqn.simplebook.service.PostService;

import java.util.List;

/**
 * @author: 龚皓冬
 * @date: 2019/11/18
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.service.impl
 */
public class PostServiceImpl implements PostService {

private PostDao dao=new PostDaoImpl();
    @Override
    public List<Post> selectAllPost() throws Exception {

        List<Post> posts=dao.selectAllPost();
        if (posts==null){
            throw new RuntimeException("文章为空，未查询到一条post");
        }
        return posts;
    }
}
