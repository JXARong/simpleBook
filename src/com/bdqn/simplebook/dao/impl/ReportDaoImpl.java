package com.bdqn.simplebook.dao.impl;

import com.bdqn.simplebook.dao.BaseDao;
import com.bdqn.simplebook.dao.ReportDao;
import com.bdqn.simplebook.domain.Post;
import com.bdqn.simplebook.domain.User;

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
}
