package com.bdqn.simplebook.web.servlets;

import com.alibaba.fastjson.JSON;
import com.bdqn.simplebook.domain.Topic;
import com.bdqn.simplebook.service.TopicService;
import com.bdqn.simplebook.service.impl.TopicServiceImpl;
import com.bdqn.simplebook.utils.AjaxUtils;
import com.bdqn.simplebook.utils.PageUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author: 赖榕
 * @date: 2019/11/18
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.web.servlets
 */
public class TopicServlet extends BaseServlet {

    private TopicService service = new TopicServiceImpl();

    /**
     * 查询所有主题
     *
     * @param request
     * @param response
     * @throws IOException
     */
    public void selectTopic(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pageNo = request.getParameter("page");
        String limit = request.getParameter("limit");
        PageUtils pageUtils=new PageUtils();
        try {
            List<Topic> topics = service.selAllTopic(pageNo,limit);
            Long count = service.selTopicCount();
            pageUtils.setCode(0);
            pageUtils.setCount(Integer.valueOf(Long.toString(count)));
            pageUtils.setData(topics);
            System.out.println(JSON.toJSONString(pageUtils));
        } catch (Exception e) {
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(pageUtils));
    }

    /**
     * 添加主题
     *
     * @param request
     * @param response
     */
    public void addTopic(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AjaxUtils ajaxUtils = new AjaxUtils();
        String topicName = request.getParameter("topicName");
        Topic topic = new Topic();
        topic.setTopic(topicName);
        // 添加主题，返回带有该主题编号的实例
        try {
            topic = service.addTopic(topic);
            if (topic.getTopicId() != null) {
                ajaxUtils.setFlag(true);
                ajaxUtils.setData(topic);
                ajaxUtils.setMsg("添加主题成功");
            }else{
                ajaxUtils.setErrorMsg("添加失败");
                ajaxUtils.setFlag(false);
            }
        } catch (Exception e) {
            ajaxUtils.setFlag(false);
            ajaxUtils.setErrorMsg(e.getMessage());
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(ajaxUtils));
    }

    /**
     * 修改主题名称
     * @param request
     * @param response
     */
    public void updateTopic(HttpServletRequest request,HttpServletResponse response) throws IOException {

        AjaxUtils ajaxUtils=new AjaxUtils();
        String topicId = request.getParameter("topicId");
        String topicName = request.getParameter("topic");
        Topic topic=new Topic();
        topic.setTopic(topicName);
        topic.setTopicId(Integer.valueOf(topicId));
        int index = 0;
        try {
            index = service.updTopic(topic);
            if (index>0){
                ajaxUtils.setFlag(true);
                ajaxUtils.setMsg("修改成功");
            }else{
                ajaxUtils.setFlag(false);
                ajaxUtils.setMsg("修改失败");
            }
        } catch (Exception e) {
            ajaxUtils.setErrorMsg("服务器繁忙，修改失败");
            ajaxUtils.setFlag(false);
        }
        if (index>0){
            ajaxUtils.setFlag(true);
            ajaxUtils.setMsg("修改成功");
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(ajaxUtils));
    }

    /**
     * 根据名称查询主题信息
     * @param request
     * @param response
     */
    public void selTopicByName(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String name = request.getParameter("topic");
        boolean existsTopicByName = service.existsTopicByName(name);
        System.out.println(existsTopicByName);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(existsTopicByName));
    }

    public void delTopicById(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String topicId = request.getParameter("topicId");
        int index = service.delTopicById(Integer.valueOf(topicId));
        boolean flag=false;
        if (index>0){
            flag=true;
        }
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(flag));
    }

    /**
     * 查询全部主题信息
     * @param request
     * @param response
     * @throws IOException
     */
    public void selAllTopic(HttpServletRequest request,HttpServletResponse response) throws IOException {
        List<Topic> topics = service.selAll();
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(topics));
    }
}
