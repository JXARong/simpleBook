package com.bdqn.simplebook.web.servlets;

import com.bdqn.simplebook.service.RelationService;
import com.bdqn.simplebook.service.impl.RelationServiceImpl;

/**
 * @author: 赖榕
 * @date: 2019/11/18
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.web.servlets
 */
public class RelationServlet extends BaseServlet {
    private RelationService service=new RelationServiceImpl();
}
