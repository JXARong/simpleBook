package com.bdqn.simplebook.web.servlets;

import com.alibaba.fastjson.JSON;
import com.bdqn.simplebook.domain.Report;
import com.bdqn.simplebook.service.ReportService;
import com.bdqn.simplebook.service.impl.ReportServiceImpl;
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
public class ReportServlet extends BaseServlet {
    private ReportService service = new ReportServiceImpl();

    public void getReport(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uid = request.getParameter("uid");
        String pid = request.getParameter("pid");
        boolean report = service.isReport(Integer.valueOf(uid), Integer.valueOf(pid));
        System.out.println(report);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(report));
    }

    public void addReport(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String uid = request.getParameter("uid");
        String pid = request.getParameter("pid");
        String content = request.getParameter("content");
        Report report=new Report();
        report.setPid(Integer.valueOf(pid));
        report.setUid(Integer.valueOf(uid));
        report.setReportContent(content);
        int i = service.addReport(report);
        boolean res=i>0;
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(res));
    }

    public void getAllReport(HttpServletRequest request,HttpServletResponse response) throws IOException {
        PageUtils pageUtils=getParameter(request);
        List<Report> reports=null;
        try {
            reports = service.getAllReport(pageUtils);
            pageUtils.setData(reports);
            pageUtils.setCode(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONStringWithDateFormat(pageUtils,"yyyy-MM-dd HH:mm:ss"));
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

    public void successOfReport(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String pid = request.getParameter("pid");
        String uid = request.getParameter("uid");
        String reportId = request.getParameter("reportId");
        boolean success=false;
        try {
            success = service.successOfReport(Integer.valueOf(reportId), Integer.valueOf(pid), Integer.valueOf(uid));
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(success));
    }

    public void failOfReport(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String pid = request.getParameter("pid");
        String uid = request.getParameter("uid");
        String reportId = request.getParameter("reportId");
        boolean res=false;
        try {
            res = service.failOfReport(Integer.valueOf(pid),Integer.valueOf(uid),Integer.valueOf(reportId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(res));
    }
}
