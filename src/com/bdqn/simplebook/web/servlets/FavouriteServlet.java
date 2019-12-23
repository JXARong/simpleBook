package com.bdqn.simplebook.web.servlets;

import com.bdqn.simplebook.domain.User;
import com.bdqn.simplebook.service.FavouriteService;
import com.bdqn.simplebook.service.impl.FavouriteServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    public void getFavouriteUser(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int i = service.getFavouriteUser((User)request.getSession().getAttribute("user"));
        request.getSession().setAttribute("favourite",i);
    }
}
