package com.bdqn.simplebook.service.impl;

import com.bdqn.simplebook.dao.CommentsDao;
import com.bdqn.simplebook.dao.UserDao;
import com.bdqn.simplebook.dao.impl.CommentsDaoImpl;
import com.bdqn.simplebook.dao.impl.UserDaoImpl;
import com.bdqn.simplebook.domain.Comments;
import com.bdqn.simplebook.domain.User;
import com.bdqn.simplebook.service.CommentsService;
import com.bdqn.simplebook.service.UserService;

import java.util.List;

/**
 * @author: 赖榕
 * @date: 2019/11/19
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.service.impl
 */
public class CommentsServiceImpl implements CommentsService {

    private CommentsDao dao=new CommentsDaoImpl();

    @Override
    public List<Comments> selAllCommentsByPid(Integer pid) {
        List<Comments> comments = dao.selCommentsByPid(pid);
        UserDao userDao=new UserDaoImpl();
        // 查询评论对应的用户
        for (Comments comment : comments) {
            User user = userDao.selUserById(comment.getUid());
            comment.setUser(user);
        }
        return comments;
    }
}
