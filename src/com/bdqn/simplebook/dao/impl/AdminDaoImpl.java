package com.bdqn.simplebook.dao.impl;

import com.bdqn.simplebook.dao.AdminDao;
import com.bdqn.simplebook.dao.BaseDao;
import com.bdqn.simplebook.domain.Admin;

/**
 * @author: 赖榕
 * @date: 2019/11/2
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.dao.impl
 */
public class AdminDaoImpl extends BaseDao implements AdminDao {

    @Override
    public Admin selAdminByNameAndPwd(Admin admin) {
        String sql="select * from admin where username = ? and password= ?";
        Admin resultAdmin = super.selectOne(Admin.class, sql, new Object[]{admin.getUsername(), admin.getPassword()});
        return resultAdmin;
    }

    @Override
    public Admin selAdminByUserName(String username) {
        String sql="select * from admin where username = ?";
        Admin admin = super.selectOne(Admin.class, sql, new Object[]{username});
        return admin;
    }

    @Override
    public int updatePwdById(Admin admin) {
        String sql="update admin set password = ? where id=?";
        return super.update(sql,new Object[]{admin.getPassword(),admin.getId()});
    }
}
