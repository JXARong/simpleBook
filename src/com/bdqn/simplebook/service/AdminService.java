package com.bdqn.simplebook.service;

import com.bdqn.simplebook.domain.Admin;

import java.util.List;

/**
 * @author: 赖榕
 * @date: 2019/11/2
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.service
 */
public interface AdminService {

    /**
     * 管理员登录
     * @param admin
     * @return
     */
    Admin login(Admin admin);

    Admin selAdminByUsername(Admin admin) throws Exception;

    int sendEmail(Admin forgetAdmin);

    int updatePwdById(Admin admin,String oldPassword) throws Exception;

    Admin selAdminById(Admin admin) throws Exception;

    int updateInfo(Admin admin) throws Exception;

    List<Integer> getRegisterNumOfUser();

}
