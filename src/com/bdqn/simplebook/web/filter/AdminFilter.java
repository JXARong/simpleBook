package com.bdqn.simplebook.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author: 赖榕
 * @date: 2019/11/2
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.web.filter
 */
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        Object admin = session.getAttribute("admin");

        String uri = request.getRequestURI();
        System.out.println("uri--->"+uri);
        if(admin==null && !"/simpleBook/houtai/login.html".equals(uri)){
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.sendRedirect("/simpleBook/houtai/index.html");
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
