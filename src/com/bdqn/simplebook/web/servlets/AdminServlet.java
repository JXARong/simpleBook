package com.bdqn.simplebook.web.servlets;

import com.bdqn.simplebook.domain.Admin;
import com.bdqn.simplebook.service.AdminService;
import com.bdqn.simplebook.service.impl.AdminServiceImpl;
import com.bdqn.simplebook.utils.CodeUtils;
import javafx.scene.control.Alert;
import javafx.scene.layout.TilePane;
import org.omg.CORBA.ARG_OUT;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * @author: 赖榕
 * @date: 2019/11/1
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.web.servlets
 */
public class AdminServlet extends BaseServlet {

    private AdminService service = new AdminServiceImpl();

    // 登录
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPassword(password);
        Admin loginAdmin = service.login(admin);
        String tip = "";
        if (loginAdmin == null) {
            tip = "false";
        } else {
            tip = "true";
            request.getSession().setAttribute("admin", loginAdmin);
            System.out.println(admin);
        }
        PrintWriter writer = response.getWriter();
        writer.write(tip);
        writer.flush();
        writer.close();
    }

    // 生成验证码
    public void generateCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String code = CodeUtils.generateCode();
        HttpSession session = request.getSession();
        session.setAttribute("code", code);
        try {
            BufferedImage image = CodeUtils.generateImage(code);
            boolean stream = ImageIO.write(image, "jpg", response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 验证验证码
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String code = request.getParameter("code");  // 获取用户填写的验证码
        Object code1 = request.getSession().getAttribute("code");   // 获取系统生成的验证码

        System.out.println(code + "--" + code1);
        String flag = "";
        if (code != null) {
            if (code.equalsIgnoreCase(code1.toString())) {
                flag = "true";
            } else {
                flag = "false";
            }
        } else {
            flag = "false";
        }
        request.getSession().removeAttribute("code");
        PrintWriter writer = response.getWriter();
        writer.write(flag);

    }

    // 发送验证码至邮箱
    public void sendCodeToEmail(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setEmail(email);
        Admin forgetAdmin = null;
        String tip = "";
        try {
            forgetAdmin = service.selAdminByUsername(admin);
            int result = service.sendEmail(forgetAdmin);
            if (result==-1){
                tip="发送失败,服务器繁忙";
            }else{
                HttpSession session = request.getSession();
                session.setAttribute("forgetAdmin",forgetAdmin);
                session.setAttribute("emailCode",result);
                tip="验证码发送成功，请查看邮箱";
            }
        } catch (Exception e) {
            e.printStackTrace();
            tip=e.getMessage();
        }
        PrintWriter writer = response.getWriter();
        writer.write(tip);
        writer.flush();
        writer.close();
    }

    // 验证邮箱验证码
    public void verifyEmailCode(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String emailCode = request.getParameter("emailCode");
        Object code = request.getSession().getAttribute("emailCode");
        System.out.println(emailCode+"----"+code);
        Admin forgetAdmin = (Admin) request.getSession().getAttribute("forgetAdmin");
        String flag="";
        flag=emailCode.equals(code.toString())?forgetAdmin.getId().toString():"false";
        System.out.println(flag);
        PrintWriter writer = response.getWriter();
        writer.write(flag);
        writer.flush();
        writer.close();
    }

    // 修改密码
    public void updatePwd(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        Admin admin=new Admin();
        admin.setId(Integer.parseInt(id));
        admin.setPassword(pwd);
        int index = service.updatePwdById(admin);
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        if (index>0){
            writer.write("true");
        }else {
            writer.write("false");
        }
        writer.flush();
        writer.close();
    }
}
