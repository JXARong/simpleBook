package com.bdqn.simplebook.service;

import com.bdqn.simplebook.domain.User;

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

}
