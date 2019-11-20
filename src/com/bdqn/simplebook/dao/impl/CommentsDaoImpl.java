package com.bdqn.simplebook.dao.impl;

import com.bdqn.simplebook.dao.BaseDao;
import com.bdqn.simplebook.dao.CommentsDao;
import com.bdqn.simplebook.domain.Comments;

import java.util.List;

/**
 * @author: 赖榕
 * @date: 2019/11/19
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.dao.impl
 */
public class CommentsDaoImpl extends BaseDao implements CommentsDao {

    /**
     * 根据文章id查询所有的评论
     * @param pid
     * @return
     */
    @Override
    public List<Comments> selCommentsByPid(Integer pid) {
        String sql="select * from comments where pid = ?";
        List<Comments> comments = super.selectList(Comments.class, sql, new Object[]{pid});
        return comments;
    }

    /**
     * 根据文章编号删除所有的评论
     * @param pid
     * @return
     */
    @Override
    public Integer delCommentsByPid(Integer pid) {
        String sql="delete from comments where pid = ?";
        int update = super.update(sql, new Object[]{pid});
        return update;
    }

    /**
     *  根据用户编号删除所有相关的评论信息
     * @param uid
     * @return
     */
    @Override
    public Integer delCommentsByUid(Integer uid) {
        String sql="delete from comments where uid = ?";
        return super.update(sql, new Object[]{uid});
    }
}
