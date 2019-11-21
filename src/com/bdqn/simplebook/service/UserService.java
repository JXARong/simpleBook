package com.bdqn.simplebook.service;

import com.bdqn.simplebook.domain.User;

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
public interface UserService {
    /**
     * 查询首页所有的用户
     * @return
     * @throws Exception
     */
    public  List<User>selectIndexUser()throws  Exception;

    /**
     * 添加User
     * @param user
     * @return
     */
    int addUser(User user) throws Exception;

    int updateUser(User user) throws Exception;

    PageUtils selUserByPage(PageUtils page, User user);

    int delUserById(String[] uids) throws Exception;

    /**
     * 注册
     * @param user
     * @return
     * @throws Exception
     */
    int register(User user) throws Exception;

    List<User> usersList() throws Exception;

    /**
     * 登陆
     * @param emailOruname
     * @param pwd
     * @return
     * @throws Exception
     */
    User login(String emailOruname,String pwd) throws Exception;

}
