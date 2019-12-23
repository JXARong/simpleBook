package com.bdqn.simplebook.web.servlets;

import com.bdqn.simplebook.domain.User;
import com.bdqn.simplebook.service.RelationService;
import com.bdqn.simplebook.service.impl.RelationServiceImpl;

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
public class RelationServlet extends BaseServlet {
    private RelationService service=new RelationServiceImpl();

    public void getRelationUid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int i = service.queryRelationUser((User) request.getSession().getAttribute("user"));
        request.getSession().setAttribute("relationUid",i);
    }

    public void getRelationCid(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int i = service.queryRelationCid((User)request.getSession().getAttribute("user"));
        request.getSession().setAttribute("relationCid",i);
    }
}
