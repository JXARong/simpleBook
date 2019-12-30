package com.bdqn.simplebook.dao.impl;

import com.bdqn.simplebook.dao.BaseDao;
import com.bdqn.simplebook.dao.ReportDao;
import com.bdqn.simplebook.domain.Post;
import com.bdqn.simplebook.domain.Report;
import com.bdqn.simplebook.domain.User;
import javafx.beans.binding.ObjectExpression;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: 赖榕
 * @date: 2019/11/18
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.dao.impl
 */
public class ReportDaoImpl extends BaseDao implements ReportDao {

    @Override
    public int delReportByPid(Post post) {
        String sql="delete from report where pid = ?";
        return super.update(sql,new Object[]{post.getPid()});
    }

    /**
     *  删除该用户下的所有举报信息
     * @param user
     * @return
     */
    @Override
    public int delReportByUid(User user) {
        String sql="delete from report where uid = ?";
        return super.update(sql,new Object[]{user.getUid()});
    }

    @Override
    public Report isReport(Integer uid, Integer pid) {
        String sql="select * from report where uid = ? and pid = ?";
        return super.selectOne(Report.class,sql,new Object[]{uid,pid});
    }

    @Override
    public int addReport(Report report) {
        // reportId     pid       uid  reportContent          reportTime
        String sql="insert into report values(default,?,?,?,?,default)";
        return super.update(sql,new Object[]{report.getPid(),report.getUid(),report.getReportContent(),report.getReportTime()});
    }

    /**
     * 查询全部的举报信息
     * @return
     */
    @Override
    public List<Report> getAllReport(Integer page,Integer size) {
        String sql="select * from report limit ?,?";
        return super.selectList(Report.class,sql,new Object[]{page,size});
    }

    @Override
    public Long selAllCount() {
        String sql="select count(*) from report";
        return (Long) super.getCount(sql,null);
    }

    @Override
    public List<Report> getReportsOfInfo(Report report) {
        String sql="select * from report where 1=1";
        List<Object> params=new LinkedList<>();
        if (report!=null){
            if(report.getUid()!=null){
                sql+=" and uid = ?";
                params.add(report.getUid());
            }
            if(report.getPid()!=null){
                sql+=" and pid = ?";
                params.add(report.getPid());
            }
            if(report.getReportId()!=null){
                sql+=" and reportId = ?";
                params.add(report.getReportId());
            }
        }
        List<Report> reports = super.selectList(Report.class, sql, params.toArray());
        return reports;
    }

    @Override
    public void updStatus(Integer status,Integer uid1, Integer pid) {
        String sql="update report set reportStatus = ? where uid = ? and pid =?";
        super.update(sql,new Object[]{status,uid1,pid});
    }
}
