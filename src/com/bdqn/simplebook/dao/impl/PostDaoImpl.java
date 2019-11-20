package com.bdqn.simplebook.dao.impl;

import com.bdqn.simplebook.dao.BaseDao;
import com.bdqn.simplebook.dao.PostDao;
import com.bdqn.simplebook.domain.Post;

/**
 * @author: 赖榕
 * @date: 2019/11/18
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.dao.impl
 */
public class PostDaoImpl extends BaseDao implements PostDao {
    @Override
    public Post findPost(int pid) throws Exception {
        return super.selectOne(Post.class,"select * from post where pid=?",new Object[]{pid});
    }
}
