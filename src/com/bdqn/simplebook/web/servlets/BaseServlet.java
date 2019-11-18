package com.bdqn.simplebook.web.servlets;

import sun.java2d.Surface;
import sun.reflect.generics.scope.MethodScope;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: 赖榕
 * @date: 2019/11/1
 * @description: 父类Servlet,分配所有请求
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.web.servlets
 */
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        Class<? extends BaseServlet> clazz = this.getClass();
        String action = uri.substring(uri.lastIndexOf("/") + 1);
        System.out.println(action);
        try {
            Method method = clazz.getMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(clazz.newInstance(),request,response);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
