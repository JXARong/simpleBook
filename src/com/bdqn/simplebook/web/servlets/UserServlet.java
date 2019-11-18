package com.bdqn.simplebook.web.servlets;

import com.alibaba.fastjson.JSON;
import com.bdqn.simplebook.utils.AjaxUtils;
import com.bdqn.simplebook.utils.UUIDUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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

    // /simpleBook/user/login?username=""
    public void login(HttpServletRequest request, HttpServletResponse response) {

    }

    public void register(HttpServletRequest request, HttpServletResponse response) {

    }

    public void uploadPhoto(HttpServletRequest request, HttpServletResponse response)  throws IOException {
        AjaxUtils ajaxUtils=new AjaxUtils();
        // 保存文件路径
        String path="";
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            List<FileItem> list = upload.parseRequest(request);
            for (FileItem fileItem : list) {
                if (!fileItem.isFormField()) {

                    // 使用uuid保存用户上传的头像
                    String uuid = UUIDUtils.createUUID();

                    ServletContext context = request.getServletContext();

                    // 获取用户上传头像的格式类型，例如.jsp
                    String fileType = fileItem.getName().substring(fileItem.getName().lastIndexOf('.'));
                    // 获取存储用户头像的绝对路径

                    path = context.getRealPath("/WEB-INF/classes/resources/userPhoto")+File.separatorChar+uuid+fileType;
                    InputStream inputStream = fileItem.getInputStream();
                    File file=new File(path);
                    if (!file.exists()){
                        file.createNewFile();
                    }
                    FileOutputStream fos=new FileOutputStream(file);
                    int count=0;
                    byte[] bytes=new byte[1024*5];
                    while ((count=inputStream.read(bytes))!=-1){
                        fos.write(bytes,0,count);
                    }
                    ajaxUtils.setFlag(true);
                    ajaxUtils.setData(file.getName());
                }
            }
        } catch (FileUploadException e) {
            ajaxUtils.setErrorMsg("服务器繁忙，请稍后重试");
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(ajaxUtils));
    }
}
