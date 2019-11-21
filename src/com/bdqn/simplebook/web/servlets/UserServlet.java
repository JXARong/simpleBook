package com.bdqn.simplebook.web.servlets;

import com.alibaba.fastjson.JSON;
import com.bdqn.simplebook.domain.User;
import com.bdqn.simplebook.service.UserService;
import com.bdqn.simplebook.service.impl.UserServiceImpl;
import com.bdqn.simplebook.utils.AjaxUtils;
import com.bdqn.simplebook.utils.PageUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author: 龚皓冬
 * @date: 2019/11/4
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.web.servlets
 */
public class UserServlet extends BaseServlet {

    private UserService service = new UserServiceImpl();

    /**
     * 登录用户信息
     *
     * @param request
     * @param response
     */
    public void login(HttpServletRequest request, HttpServletResponse response) {

    }

    /**
     * 修改与添加用户
     *
     * @param request
     * @param response
     * @throws IOException
     */
    public void addAndUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AjaxUtils ajaxUtils = new AjaxUtils();
        request.setCharacterEncoding("Utf-8");
        User user = new User();
        user.setUname(request.getParameter("uname"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        user.setSex(Integer.parseInt(request.getParameter("sex")));
        user.setBornthDay(Timestamp.valueOf(request.getParameter("bornthDay")));
        user.setPhoto(request.getParameter("filePath"));
        user.setMoney(Double.valueOf(request.getParameter("money")));
        user.setStatus(Integer.valueOf(request.getParameter("status")));
        // 判断是否包含id值，有则调用修改方法，否则调用添加方法
        String id = request.getParameter("uid");
        if (id != null && id.trim().length() > 0) {
            user.setUid(Integer.valueOf(id));
            try {
                int index = service.updateUser(user);
                if (index >= 1) {
                    ajaxUtils.setFlag(true);
                    ajaxUtils.setMsg("用户信息修改成功");
                } else {
                    ajaxUtils.setFlag(false);
                    ajaxUtils.setErrorMsg("修改失败");
                }
            } catch (Exception e) {
                ajaxUtils.setFlag(false);
                ajaxUtils.setErrorMsg(e.getMessage());
            }
        } else {
            try {
                int index = service.addUser(user);
                if (index >= 1) {
                    ajaxUtils.setFlag(true);
                    ajaxUtils.setMsg("用户添加成功");
                }
            } catch (Exception e) {
                ajaxUtils.setErrorMsg(e.getMessage());
                ajaxUtils.setFlag(false);
            }
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(ajaxUtils));
    }


    /**
     * 上传头像接口，响应使用uuid生成的头像名称
     *
     * @param request
     * @param response
     * @throws IOException
     */
    public void uploadPhoto(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }

    /**
     * 查询首页所有用户
     *
     * @param request
     * @param response
     */
    public void setUserService(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("utf-8");
            List<User> userList = service.selectIndexUser();
            request.setAttribute("userList", userList);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    /**
     * 查询数据
     *
     * @param request
     * @param response
     */
    public void selectUser(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // 存储分页信息
        PageUtils page = new PageUtils();
        String pageNum = request.getParameter("page");
        String limit = request.getParameter("limit");

        // 创建实体类，用于存储查询所携带的信息
        User user = new User();
        String uid = request.getParameter("uid");
        if (uid != null && uid.trim().length() > 0) {
            user.setUid(Integer.valueOf(uid));
        }
        user.setUname(request.getParameter("uname"));
        user.setEmail(request.getParameter("email"));
        String bornthDay = request.getParameter("bornthDay");
        if (bornthDay != null && bornthDay.trim().length() > 0) {
            user.setBornthDay(Timestamp.valueOf(bornthDay));
        }
        String sex = request.getParameter("sex");
        if (sex != null && sex.trim().length() > 0) {
            user.setSex(Integer.valueOf(sex));
        }
        String status = request.getParameter("status");
        if (status != null && status.trim().length() > 0) {
            user.setStatus(Integer.valueOf(status));
        }

        // 将数据封装到page对象中
        page.setLimit(Integer.valueOf(limit));
        page.setPageNum(Integer.valueOf(pageNum));

        page = service.selUserByPage(page, user);
        page.setCode(0);
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(JSON.toJSONStringWithDateFormat(page, "YYYY-MM-dd hh:mm:ss"));
    }

    /**
     * 根据用户id删除用户（可删除多个用户）
     *
     * @param request
     * @param response
     */
    public void delUserById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AjaxUtils ajaxUtils = new AjaxUtils();
        String[] uid = request.getParameterValues("uid");
        try {
            int index = service.delUserById(uid);
            ajaxUtils.setFlag(true);
            if (index == 1) {
                ajaxUtils.setMsg("成功删除该用户");
            } else {
                ajaxUtils.setMsg("成功删除" + index + "条用户信息");
            }
        } catch (Exception e) {
            ajaxUtils.setFlag(false);
            ajaxUtils.setErrorMsg(e.getMessage());
        }
        response.setCharacterEncoding("utf-8");
        String json = JSON.toJSONString(ajaxUtils);
        response.getWriter().write(json);

    }

    /**
     * 用戶注册
     * @param request
     * @param response
     * @throws IOException
     */
    public void register(HttpServletRequest request, HttpServletResponse response) throws IOException{
        AjaxUtils ajaxUtils = new AjaxUtils();
        String uname = request.getParameter("uname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        try {
            User user = new User();
            user.setUname(uname);
            user.setEmail(email);
            user.setPassword(password);
            user.setStatus(1);
            boolean result = true;
            for (User u : service.usersList()) {
                if (service.usersList().equals(email)){
                    result = false;
                }
            }

            if (result){
                int i = service.register(user);
                if (i==1){
                    ajaxUtils.setFlag(true);
                }else {
                    ajaxUtils.setErrorMsg("注册失败");
                    ajaxUtils.setFlag(false);
                }
            }else {
                ajaxUtils.setErrorMsg("邮箱已被注册！");
                ajaxUtils.setFlag(false);
            }


        } catch (Exception e) {
            ajaxUtils.setFlag(false);
            ajaxUtils.setErrorMsg(e.getMessage());
        }

        response.setCharacterEncoding("utf-8");
        String json = JSON.toJSONString(ajaxUtils);
        response.getWriter().write(json);
    }

    public void loginOn(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AjaxUtils ajaxUtils = new AjaxUtils();
        String unameOrEamil = request.getParameter("unameAndEmail");
        String password = request.getParameter("password");
        try {
            User user = service.login(unameOrEamil,password);
            if (user==null){
                ajaxUtils.setErrorMsg("密码错误！");
                ajaxUtils.setFlag(false);
            }else {
                ajaxUtils.setFlag(true);
            }
        } catch (Exception e) {
            ajaxUtils.setErrorMsg(e.getMessage());
            ajaxUtils.setFlag(false);
        }

    }
}
