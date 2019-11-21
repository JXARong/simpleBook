package com.bdqn.simplebook.web.servlets;

import com.alibaba.fastjson.JSON;
import com.bdqn.simplebook.domain.Admin;
import com.bdqn.simplebook.service.AdminService;
import com.bdqn.simplebook.service.impl.AdminServiceImpl;
import com.bdqn.simplebook.utils.AjaxUtils;
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
            if (result == -1) {
                tip = "发送失败,服务器繁忙";
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("forgetAdmin", forgetAdmin);
                session.setAttribute("emailCode", result);
                tip = "验证码发送成功，请查看邮箱";
            }
        } catch (Exception e) {
            e.printStackTrace();
            tip = e.getMessage();
        }
        PrintWriter writer = response.getWriter();
        writer.write(tip);
        writer.flush();
        writer.close();
    }

    // 验证邮箱验证码
    public void verifyEmailCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String emailCode = request.getParameter("emailCode");
        Object code = request.getSession().getAttribute("emailCode");
        System.out.println(emailCode + "----" + code);
        Admin forgetAdmin = (Admin) request.getSession().getAttribute("forgetAdmin");
        String flag = "";
        flag = emailCode.equals(code.toString()) ? forgetAdmin.getId().toString() : "false";
        System.out.println(flag);
        PrintWriter writer = response.getWriter();
        writer.write(flag);
        writer.flush();
        writer.close();
    }

    // 修改密码
    public void updatePwd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AjaxUtils ajaxUtils = new AjaxUtils();
        String id = request.getParameter("id");
        Admin admin = new Admin();
        // 判断id是否获取到
        if (id != null && id.length() > 0) {
            admin.setId(Integer.valueOf(id));
            // 获取用户输入的旧密码
            String oldPassword = request.getParameter("oldPassword");
            // 获取用户输入的密码
            admin.setPassword(request.getParameter("password"));
            try {
                int index = service.updatePwdById(admin, oldPassword);
                ajaxUtils.setMsg("密码修改成功");
                ajaxUtils.setFlag(true);
            } catch (Exception e) {
                ajaxUtils.setErrorMsg(e.getMessage());
                ajaxUtils.setFlag(false);
            }
        } else {
            ajaxUtils.setFlag(false);
            ajaxUtils.setErrorMsg("服务器繁忙,请刷新后重试");
        }
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(JSON.toJSONString(ajaxUtils));
    }

    /**
     * 根据编号查询管理员信息
     *
     * @param request
     * @param response
     * @throws IOException
     */
    public void selAdminById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AjaxUtils ajaxUtils = new AjaxUtils();
        String id = request.getParameter("id");
        Admin admin = new Admin();
        if (id != null && id.length() > 0) {
            admin.setId(Integer.valueOf(id));
            try {
                admin = service.selAdminById(admin);
                ajaxUtils.setData(admin);
                ajaxUtils.setFlag(true);
            } catch (Exception e) {
                ajaxUtils.setFlag(false);
                ajaxUtils.setErrorMsg(e.getMessage());
            }
        } else {
            ajaxUtils.setFlag(false);
            ajaxUtils.setErrorMsg("获取管理员信息失败，请重试登录");
        }
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(JSON.toJSONString(ajaxUtils));
    }

    /**
     * 查询最新的信息并保存至session中
     * @param request
     * @param response
     */
    public void saveSession(HttpServletRequest request,HttpServletResponse response){
        Admin admin=new Admin();
        admin.setId(Integer.valueOf(request.getParameter("id")));
        try {
            admin= service.selAdminById(admin);
            request.getSession().setAttribute("admin",admin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 管理员退出
     *
     * @param request
     * @param response
     */
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("admin");
        response.getWriter().write("true");
    }

    /**
     * 修改管理员信息
     *
     * @param request
     * @param response
     */
    public void updateInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AjaxUtils ajaxUtils = new AjaxUtils();
        Admin admin = new Admin();
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String sex = request.getParameter("sex");
        String fileName = request.getParameter("fileName");

        admin.setId(Integer.valueOf(id));
        admin.setUsername(username);
        admin.setEmail(email);
        admin.setPhone(phone);
        admin.setSex(Integer.valueOf(sex));
        admin.setPortrait(fileName);

        try {
            int index = service.updateInfo(admin);
            ajaxUtils.setMsg("修改成功");
            ajaxUtils.setFlag(true);
        } catch (Exception e) {
            ajaxUtils.setErrorMsg(e.getMessage());
            ajaxUtils.setFlag(false);
        }
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(JSON.toJSONString(ajaxUtils));
        writer.close();

    }

}
