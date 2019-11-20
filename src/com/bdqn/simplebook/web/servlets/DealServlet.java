package com.bdqn.simplebook.web.servlets;

import com.bdqn.simplebook.service.DealService;
import com.bdqn.simplebook.service.impl.DealServiceImpl;

/**
 * @author: 赖榕
 * @date: 2019/11/19
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.web.servlets
 */
public class DealServlet extends BaseServlet {
    private DealService service=new DealServiceImpl();
}
