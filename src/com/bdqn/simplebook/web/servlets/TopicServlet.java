package com.bdqn.simplebook.web.servlets;

import com.alibaba.fastjson.JSON;
import com.bdqn.simplebook.domain.Topic;
import com.bdqn.simplebook.service.TopicService;
import com.bdqn.simplebook.service.impl.TopicServiceImpl;
import com.bdqn.simplebook.utils.AjaxUtils;

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

    private TopicService service=new TopicServiceImpl();

    public void selectTopic(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AjaxUtils ajaxUtils=new AjaxUtils();
        try {
            List<Topic> topics = service.selAllTopic();
            ajaxUtils.setFlag(true);
            ajaxUtils.setData(topics);
        } catch (Exception e) {
            ajaxUtils.setErrorMsg(e.getMessage());
            ajaxUtils.setFlag(false);
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(ajaxUtils));
    }

}
