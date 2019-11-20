package com.bdqn.simplebook.dao.impl;

import com.bdqn.simplebook.dao.BaseDao;
import com.bdqn.simplebook.dao.PostDao;
import com.bdqn.simplebook.domain.Post;

import com.bdqn.simplebook.domain.User;
import com.bdqn.simplebook.utils.PageUtils;
import javafx.geometry.Pos;

import java.util.LinkedList;
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
    public Post findPost(int pid) throws Exception {
        return super.selectOne(Post.class,"select * from post where pid=?",new Object[]{pid});


    /**
     * 根据用户Id删除文章内容
     *
     * @param user
     * @return
     */
    @Override
    public Integer delPostByUid(User user) {
        String sql = "delete from post where uid = ?";
        int index = super.update(sql, new Object[]{user.getUid()});
        return index;
    }



    @Override
    public List<Post> selPostByUid(User user) {
        String sql = "select * from post where uid =?";
        List<Post> posts = super.selectList(Post.class, sql, new Object[]{user.getUid()});
        return posts;
    }

    /**
     * 根据填写的信息获取所有的文章内容
     *
     * @param post
     * @return
     */
    @Override
    public List<Post> selPostByPage(Integer start, Integer limit, Post post) {
        String sql = "select * from post where 1 = 1";
        List params = new LinkedList();
        sql = this.appenSql(sql, post, params);
        sql += " limit ?,?";
        params.add(start);
        params.add(limit);
        List<Post> posts = super.selectList(Post.class, sql, params.toArray());
        return posts;
    }

    /**
     *  获取查询到post数量
     * @param post
     * @return
     */
    @Override
    public Long selPostCount(Post post) {
        String sql = "select count(*) from post where 1=1";
        List params = new LinkedList();
        sql = this.appenSql(sql, post, params);
        Object count = super.getCount(sql, params.toArray());
        return (long)count;
    }

    /**
     * 根据文章编号删除文章信息
     * @param pid
     * @return
     */
    @Override
    public Integer delPostByPid(Integer pid) {
        String sql="delete from post where pid = ?";
        return super.update(sql, new Object[]{pid});
    }

    /**
     * 拼接sql语句
     *
     * @param sql
     * @param post
     * @param params
     * @return
     */
    private String appenSql(String sql, Post post, List params) {
        if (post.getPid() != null) {
            sql += " and pid = ?";
            params.add(post.getPid());
        }
        if (post.getUid() != null) {
            sql += " and uid = ?";
            params.add(post.getUid());
        }
        if (post.getTitle() != null) {
            sql += " and  title  like ?";
            params.add("%"+post.getTitle()+"%");
        }
        if (post.getSendDate() != null) {
            sql += " and sendDate like ?";
            params.add("%" + post.getSendDate() + "%");
        }
        return sql;

    }
}
