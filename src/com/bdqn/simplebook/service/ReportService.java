package com.bdqn.simplebook.service;

import com.bdqn.simplebook.domain.Report;
import com.bdqn.simplebook.utils.PageUtils;

import java.util.List;

/**
 * @author: 龚皓冬
 * @date: 2019/11/18
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.service
 */
public interface ReportService {

    boolean isReport(Integer uid,Integer pid);

    int addReport(Report report);

    List<Report> getAllReport(PageUtils pageUtils) throws Exception;

    boolean successOfReport(Integer reportId,Integer pid, Integer uid) throws Exception;

    boolean failOfReport(Integer pid, Integer uid, Integer reportId) throws Exception;
}
