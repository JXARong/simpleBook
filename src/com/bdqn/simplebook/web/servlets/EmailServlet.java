package com.bdqn.simplebook.web.servlets;

import com.alibaba.fastjson.JSON;
import com.bdqn.simplebook.domain.Email;
import com.bdqn.simplebook.service.EmailService;
import com.bdqn.simplebook.service.impl.EmailServiceImpl;
import com.bdqn.simplebook.utils.AjaxUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: 赖榕
 * @date: 2019/11/20
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.web.servlets
 */
public class EmailServlet extends BaseServlet {

    private EmailService service = new EmailServiceImpl();

    /**
     * 修改邮箱
     *
     * @param request
     * @param response
     */
    public void updateEmail(HttpServletRequest request, HttpServletResponse response) throws IOException {

        AjaxUtils ajaxUtils = new AjaxUtils();

        // 获取email信息以及封装成对象
        String host = request.getParameter("host");
        String port = request.getParameter("port");
        String emailAccount = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Email email = new Email();
        email.setHost(host);
        email.setEmail(emailAccount);
        email.setEmailName(username);
        email.setPort(port);
        email.setPassword(password);

        ServletContext context = request.getServletContext();
        // 获取存储邮箱信息的properties文件路径
        String path = context.getRealPath("/WEB-INF/classes/email.properties");

        try {
            boolean result = service.updateEmail(path, email);
            if (result) {
                ajaxUtils.setFlag(true);
                ajaxUtils.setMsg("修改成功");
            } else {
                ajaxUtils.setFlag(false);
                ajaxUtils.setErrorMsg("修改失败，请稍后重试");
            }
        } catch (Exception e) {
            ajaxUtils.setFlag(false);
            ajaxUtils.setErrorMsg(e.getMessage());
        }
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(JSON.toJSONString(ajaxUtils));

    }

    /**
     *  查询邮箱信息
     * @param request
     * @param response
     * @throws IOException
     */
    public void selEmail(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AjaxUtils ajaxUtils=new AjaxUtils();
        try {
            Email email = service.selEmailInfo();
            ajaxUtils.setData(email);
            ajaxUtils.setFlag(true);
        } catch (Exception e) {
            ajaxUtils.setFlag(false);
            ajaxUtils.setErrorMsg(e.getMessage());
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(ajaxUtils));
    }
}
