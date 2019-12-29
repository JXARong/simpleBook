package com.bdqn.simplebook.dao;

import com.bdqn.simplebook.domain.User;

import java.util.List;

/**
 * @author: 赖榕
 * @date: 2019/11/18
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.dao
 */
public interface UserDao {

    /**
     * 添加用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 根据用户名查询用户
     * @param uname
     * @return
     */
    User selUserByUserName(String uname);

    /**
     * 根据编号查询用户信息
     * @param id
     * @return
     */
    User selUserById(Integer id);

    /**
     * 根据编号修改用户信息
     * @param user
     * @return
     */
    int updateUserById(User user);

    List<User> selUserByPage(Integer startNum, Integer limit, User user,String borthday);

    Long selUserCount(User user,String bornthday);


    /**
     * 查询首页的所有用户
     *
     * @return
     * @throws Exception
     */
    public List<User> selectIndexUser() throws Exception;

    /**
     * 根据编号删除用户信息
     * @param user
     * @return
     */
    int delUserById(User user);


    /**
     * 注册用户
     * @param user
     * @return
     */
    int register(User user);

    /**
     * 查询所有用户
     * @return
     */
    List<User> queryUser();

    /**
     * 登录
     * @param emailOrunam
     * @param pwd
     * @return
     */
    User login(String emailOrunam, String pwd);

    /**
     * 根据日期查询用户数量
     * @param format
     * @return
     */
    Long selUserCountByDate(String format);

    /**
     * 查询今天的用户注册数量
     * @param today
     * @return
     */
    Long selUserCountOfToday(String today);

    /**
     * 查询所有的用户数量
     * @return
     */
    Long selUserCountOfAll();

    /**
     * 用户搜索
     * @param searchValue
     * @return
     */
    List<User> searchUser(String searchValue);

}
