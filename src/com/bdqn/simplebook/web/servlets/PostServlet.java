package com.bdqn.simplebook.web.servlets;


import java.io.*;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.bdqn.simplebook.domain.Post;
import com.bdqn.simplebook.domain.User;
import com.bdqn.simplebook.service.PostService;
import com.bdqn.simplebook.service.impl.PostServiceImpl;
import com.bdqn.simplebook.utils.AjaxUtils;
import com.bdqn.simplebook.utils.PageUtils;
import com.bdqn.simplebook.utils.UUIDUtils;
import com.sun.corba.se.spi.legacy.connection.GetEndPointInfoAgainException;
import com.sun.deploy.net.HttpResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.omg.PortableInterceptor.INACTIVE;
import org.omg.PortableInterceptor.RequestInfo;
import sun.management.snmp.jvmmib.JvmThreadInstanceTableMeta;

import javax.crypto.spec.PSource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.UUID;


/**
 * @author: 赖榕
 * @date: 2019/11/18
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.web.servlets
 */
public class PostServlet extends BaseServlet {


    private PostService service = new PostServiceImpl();

    /**
     * 查询首页所有的文章，
     *
     * @param request
     * @param response
     */
    public void selectAllPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("utf-8");
            List<Post> postList = service.selectAllPost();
            request.setAttribute("postList", postList);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    /**
     * 查询文章
     *
     * @param request
     * @param response
     * @throws IOException
     */
    public void selectPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PageUtils pageUtils = new PageUtils();
        Post post = new Post();

        pageUtils = getParameter(request);

        // 封装查询条件
        String pid = request.getParameter("pid");
        if (pid != null && pid.trim().length() > 0) {
            post.setPid(Integer.valueOf(pid));
        }

        String uid = request.getParameter("uid");
        if (uid != null && uid.trim().length() > 0) {
            post.setUid(Integer.valueOf(uid));
        }

        String title = request.getParameter("title");
        post.setTitle(title);

        String sendDate = request.getParameter("sendDate");

        try {
            pageUtils = service.selPostByPage(pageUtils, post,sendDate);
            pageUtils.setCode(0);
        } catch (Exception e) {
            pageUtils.setMsg(e.getMessage());
        }
        String json = JSON.toJSONString(pageUtils);
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);

    }

    /**
     * 根据文章编号删除文章信息(可同时删除多条)
     *
     * @param request
     * @param response
     */
    public void delPostByPid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AjaxUtils ajaxUtils = new AjaxUtils();
        String[] pids = request.getParameterValues("pid");
        try {
            Integer integer = service.delPostById(pids);
            if (integer > 1) {
                ajaxUtils.setMsg("成功删除" + integer + "条信息");
                ajaxUtils.setFlag(true);
            } else {
                ajaxUtils.setMsg("成功删除该条信息");
                ajaxUtils.setFlag(true);
            }
        } catch (Exception e) {
            ajaxUtils.setFlag(false);
            ajaxUtils.setErrorMsg("删除失败！请刷新后重试");
        }
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(JSON.toJSONString(ajaxUtils));

    }

    /**
     * 文章中添加图片
     *
     * @param request
     * @param response
     */
    public void uploadPhotoOfPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletContext context = request.getServletContext();

        // 获取当前的登录的用户
        User user = (User) request.getSession().getAttribute("user");

        // 获取每个用户独立的文件夹
        String realPath = context.getRealPath("/resources/post/" + 123123);

        // 判断该用户对应的文件夹是否存在，不存在则代表第一次发帖，删除该帖子
        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdir();
        }

        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);

        // 用户上传的图片文件
        InputStream is = null;
        //  存储改为UUID生成的图片名称
        String imageName = "";
        // 存放图片的相对路径返回至前台，用户显示图片
        String relativePath = "";
        try {
            List<FileItem> list = upload.parseRequest(request);
            for (FileItem item : list) {
                // 保存文件
                if (!item.isFormField()) {

                    // 获取文件输入流，获取用户上传的文件
                    is = item.getInputStream();

                    // 创建uuid，更改用户上传的图片名称
                    String uuid = UUIDUtils.createUUID();

                    // 用户上传的文件名称
                    String name = item.getName();
                    // 获取文件类型
                    String changeName = name.substring(name.lastIndexOf("."));
                    // 拼接更改后的图片名称
                    imageName = uuid + changeName;

                } else {
                    // 获取前台传送的postid
                    String postPathName = item.getString("utf-8");
                    // 拼接该图片的最终路径
                    realPath += "/" + postPathName + "/" + imageName;
                    relativePath = context.getContextPath() + "\\/resources\\/post" + "\\/" + 123123 + "\\/" + postPathName + "\\/" + imageName;
                }
            }

            // 获取文章路径
            File postPath = new File(realPath.substring(0, realPath.lastIndexOf("/") + 1));
            if (!postPath.exists()) {
                postPath.mkdir();
            }
            System.out.println(realPath);
            // 判断图片是否存在，不存在则创建新文件
            File imageFile = new File(realPath);
            if (!imageFile.exists()) {
                imageFile.createNewFile();
            }
            // 将图片保存到本地
            FileOutputStream fos = new FileOutputStream(imageFile);
            int count = 0;
            byte[] bytes = new byte[1024 * 5];
            while ((count = is.read(bytes)) != -1) {
                fos.write(bytes, 0, count);
            }
            is.close();
            fos.close();
            System.out.println("图片保存成功");
            response.setContentType("application/json;charset=utf-8");
            response.setCharacterEncoding("utf-8");
            String s = "{\"location\":" + "\"" + relativePath + "\"" + "}";
            System.out.println(s);
            response.getWriter().write(s);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询排行前20的帖子
     *
     * @param request
     * @param response
     */
    public void selPostListOfTop(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PageUtils pageUtils = getParameter(request);
        try {
            pageUtils = service.selPostListOfTop(pageUtils);
            pageUtils.setCode(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String json = JSON.toJSONString(pageUtils);
        System.out.println(json);
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    private PageUtils getParameter(HttpServletRequest request) {
        PageUtils pageUtils = new PageUtils();
        String pageNum = request.getParameter("page");
        String limit = request.getParameter("limit");

        // 封装分页条件
        if (pageNum != null || pageNum.trim().length() != 0) {
            pageUtils.setPageNum(Integer.valueOf(pageNum));
        }

        if (limit != null || limit.trim().length() > 0) {
            pageUtils.setLimit(Integer.valueOf(limit));
        }
        return pageUtils;
    }
}
