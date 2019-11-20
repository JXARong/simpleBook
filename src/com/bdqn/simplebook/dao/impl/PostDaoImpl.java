package com.bdqn.simplebook.dao.impl;

import com.bdqn.simplebook.dao.BaseDao;
import com.bdqn.simplebook.dao.PostDao;
import com.bdqn.simplebook.domain.Post;
import javafx.geometry.Pos;

import java.sql.ResultSet;
import java.util.List;

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
    public List<Post> selectAllPost() throws Exception {
        String sql="select * from post";
        Class clazz = Post.class;
        List<Post> post=super.selectList(clazz,sql,null);
        return post;
    }
}
