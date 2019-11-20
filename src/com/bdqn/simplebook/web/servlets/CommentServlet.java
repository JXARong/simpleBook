package com.bdqn.simplebook.web.servlets;

import com.bdqn.simplebook.service.CommentsService;
import com.bdqn.simplebook.service.impl.CommentsServiceImpl;

/**
 * @author: 赖榕
 * @date: 2019/11/20
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.web.servlets
 */
public class CommentServlet extends BaseServlet {

    private CommentsService service = new CommentsServiceImpl();
}
