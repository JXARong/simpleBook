package com.bdqn.simplebook.web.servlets;

import com.bdqn.simplebook.domain.Email;
import com.bdqn.simplebook.service.EmailService;
import com.bdqn.simplebook.service.impl.EmailServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: 赖榕
 * @date: 2019/11/20
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.web.servlets
 */
public class EmailServlet extends BaseServlet {

    private EmailService service=new EmailServiceImpl();

    /**
     * 修改邮箱
     * @param request
     * @param response
     */
    public void updateEmail(HttpServletRequest request, HttpServletResponse response){
        String host = request.getParameter("host");
        String port = request.getParameter("port");
        String emailAccount = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Email email=new Email();
        email.setHost(host);
        email.setEmail(emailAccount);
        email.setEmailName(username);
        email.setPort(port);
        email.setPassword(password);

        ServletContext context = request.getServletContext();
        // 获取存储邮箱信息的properties文件路径
        String path = context.getRealPath("/WEB-INF/classes/email.properties");

        boolean result = service.updateEmail(path,email);

    }
}
