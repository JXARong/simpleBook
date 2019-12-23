package com.bdqn.simplebook.dao.impl;

import com.bdqn.simplebook.dao.BaseDao;
import com.bdqn.simplebook.dao.RelationDao;
import com.bdqn.simplebook.dao.ReportDao;
import com.bdqn.simplebook.domain.User;

/**
 * @author: 赖榕
 * @date: 2019/11/18
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.dao.impl
 */
public class RelationDaoImpl extends BaseDao implements RelationDao {

    /**
     *  根据用户编号删除该用户所有关注的信息
     * @param user
     * @return
     */
    @Override
    public int delRelationByUid(User user) {
        String sql="delete from relation where uid= ?";
        return  super.update(sql,new Object[]{user.getUid()});
    }

    /**
     *  根据指定用户编号删除所有被关注信息
     * @param user
     * @return
     */
    @Override
    public int delcRelationByCid(User user) {
        String sql="delete from relation where cid = ?";
        return  super.update(sql,new Object[]{user.getUid()});
    }


    @Override
    public int queryRelationUid(User user) {
        String sql = "select count(rid) from relation where cid = ?";
        Object num = super.getCount(sql,new Object[]{user.getUid()});
        return (int)num;
    }

    @Override
    public int queryRelationCid(User user) {
        String sql = "select count(cid) form relation where uid = ?";
        int num = (int)super.getCount(sql,new Object[]{user.getUid()});
        return num;
    }
}
