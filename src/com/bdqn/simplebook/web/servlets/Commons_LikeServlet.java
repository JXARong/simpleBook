package com.bdqn.simplebook.web.servlets;

import com.alibaba.druid.filter.logging.CommonsLogFilter;
import com.bdqn.simplebook.service.Commons_LikeService;
import com.bdqn.simplebook.service.impl.Commons_LikeServiceImpl;

/**
 * @author: 赖榕
 * @date: 2019/11/20
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.web.servlets
 */
public class Commons_LikeServlet extends BaseServlet {
    private Commons_LikeService service=new Commons_LikeServiceImpl();
}
