package com.bdqn.simplebook.web.servlets;

import com.bdqn.simplebook.service.FavouriteService;
import com.bdqn.simplebook.service.impl.FavouriteServiceImpl;

/**
 * @author: 赖榕
 * @date: 2019/11/18
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.web.servlets
 */
public class FavouriteServlet extends BaseServlet {
    private FavouriteService service=new FavouriteServiceImpl();
}
