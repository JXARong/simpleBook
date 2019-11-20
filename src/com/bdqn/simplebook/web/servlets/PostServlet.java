package com.bdqn.simplebook.web.servlets;

import com.bdqn.simplebook.domain.Post;
import com.bdqn.simplebook.service.PostService;
import com.bdqn.simplebook.service.impl.PostServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author: 赖榕
 * @date: 2019/11/18
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.web.servlets
 */
public class PostServlet extends BaseServlet {
    private PostService postService=new PostServiceImpl();

    /**
     * 查询首页所有的文章，
     * @param request
     * @param response
     */
    public void  selectAllPost(HttpServletRequest request, HttpServletResponse response){
        try {
            request.setCharacterEncoding("utf-8");
            List<Post> postList=  postService.selectAllPost();
            request.setAttribute("postList",postList);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

        }


    }

}
