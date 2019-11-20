package com.bdqn.simplebook.dao;

import com.bdqn.simplebook.domain.Admin;

/**
 * @author: 赖榕
 * @date: 2019/11/2
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.dao
 */
public interface AdminDao {

    /**
     * 根据用户名与密码查找管理员
     * @param admin 封装用户名和密码
     * @return  返回查找到的管理员信息
     */
    Admin selAdminByNameAndPwd(Admin admin);

    /**
     * 根据邮箱查找管理员信息
     * @parram username 用户名
     * @return 返回查找到的管理员信息
     */
    Admin selAdminByUserName(String username);

    /**
     * 根据管理员编号修改信息
     * @param admin
     * @return
     */
    int updatePwdById(Admin admin);
}
