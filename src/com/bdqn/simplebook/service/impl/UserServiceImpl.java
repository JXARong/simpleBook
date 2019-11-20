package com.bdqn.simplebook.service.impl;

import com.bdqn.simplebook.dao.BaseDao;
import com.bdqn.simplebook.dao.UserDao;
import com.bdqn.simplebook.dao.impl.UserDaoImpl;
import com.bdqn.simplebook.domain.User;
import com.bdqn.simplebook.service.UserService;

import java.util.List;

/**
 * @author: 龚皓冬
 * @date: 2019/11/18
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.service.impl
 */
public class UserServiceImpl  implements UserService {

    private  UserDao userDao=new UserDaoImpl();
    @Override
    /**
     * 查询首页的所有用户
     */
    public List<User> selectIndexUser() throws Exception {
        List<User>users=userDao.selectIndexUser();
        if(users==null){
            throw  new  RuntimeException("用户为空，未查到数据");
        }
        return users;
    }
}
