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
     * 添加User
     * @param user
     * @return
     */
    int addUser(User user) throws Exception;

    int updateUser(User user) throws Exception;

    PageUtils selUserByPage(PageUtils page,User user);
}
