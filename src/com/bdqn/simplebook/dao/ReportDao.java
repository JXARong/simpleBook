package com.bdqn.simplebook.dao;

import com.bdqn.simplebook.domain.Post;
import com.bdqn.simplebook.domain.Report;
import com.bdqn.simplebook.domain.User;

import java.util.List;

/**
 * @author: 赖榕
 * @date: 2019/11/18
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.dao
 */
public interface ReportDao {
    int delReportByUid(User user);

    int delReportByPid(Post post);

    Report isReport(Integer pid,Integer uid);

    int addReport(Report report);

    List<Report> getAllReport(Integer page,Integer size);

    Long selAllCount();

    List<Report> getReportsOfInfo(Report report);

    void updStatus(Integer status,Integer uid1, Integer pid);
}
