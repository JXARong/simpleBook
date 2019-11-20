package com.bdqn.simplebook.service.impl;

import com.bdqn.simplebook.dao.CommentsDao;
import com.bdqn.simplebook.dao.impl.CommentsDaoImpl;
import com.bdqn.simplebook.service.CommentsService;

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
}
