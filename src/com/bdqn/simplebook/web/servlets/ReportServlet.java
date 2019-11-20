package com.bdqn.simplebook.web.servlets;

import com.bdqn.simplebook.service.ReportService;
import com.bdqn.simplebook.service.impl.ReportServiceImpl;

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
}
