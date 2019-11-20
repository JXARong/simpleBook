package com.bdqn.simplebook.web.servlets;

import com.alibaba.fastjson.JSON;
import com.bdqn.simplebook.utils.AjaxUtils;
import com.bdqn.simplebook.utils.UUIDUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author: 赖榕
 * @date: 2019/11/20
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.web.servlets
 */
public class PhotoServlet extends  BaseServlet {

    /**
     *  上传图片
     * @param request
     * @param response
     * @throws IOException
     */
    public void uploadPhoto(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AjaxUtils ajaxUtils = new AjaxUtils();
        // 保存文件路径
        String path = "";
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            List<FileItem> list = upload.parseRequest(request);
            for (FileItem fileItem : list) {
                if (!fileItem.isFormField()) {

                    // 使用uuid保存用户上传的头像
                    String uuid = UUIDUtils.createUUID();

                    ServletContext context = request.getServletContext();

                    // 获取用户上传头像的格式类型，例如.jpg
                    String fileType = fileItem.getName().substring(fileItem.getName().lastIndexOf('.'));

                    // 获取存储用户头像的绝对路径
                    path = context.getRealPath("/resources/userPhoto") + File.separatorChar + uuid + fileType;

                    InputStream inputStream = fileItem.getInputStream();
                    File file = new File(path);
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    FileOutputStream fos=new FileOutputStream(file);
                    int count=0;
                    byte[] bytes=new byte[1024*5];
                    while ((count=inputStream.read(bytes))!=-1){
                        fos.write(bytes,0,count);
                    }
                    fos.close();
                    inputStream.close();
                    ajaxUtils.setFlag(true);
                    ajaxUtils.setData(file.getName());
                }
            }
        } catch (FileUploadException | IOException e) {
            ajaxUtils.setErrorMsg("服务器繁忙，请稍后重试");
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(ajaxUtils));
    }

    /**
     * 删除指定文件
     * @param request
     * @param response
     */
    public void delPhoto(HttpServletRequest request,HttpServletResponse response){

        String realPath = request.getServletContext().getRealPath("/resources/userPhoto");

        String fileName = request.getParameter("fileName");

        File file=new File(realPath+File.separatorChar+fileName);
        // 删除该文件
        boolean delete = file.delete();

    }
}
