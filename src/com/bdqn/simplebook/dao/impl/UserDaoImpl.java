package com.bdqn.simplebook.dao.impl;

import com.bdqn.simplebook.dao.BaseDao;
import com.bdqn.simplebook.dao.UserDao;
import com.bdqn.simplebook.domain.User;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: 赖榕
 * @date: 2019/11/18
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.dao.impl
 */
public class UserDaoImpl extends BaseDao implements UserDao {

    /**
     * 添加用户信息
     *
     * @param user
     * @return
     */
    @Override
    public int addUser(User user) {
        String sql = "insert into user values(?,?,?,?,?,?,?,1,?)";
        int update = super.update(sql, new Object[]{user.getUid(), user.getPassword(), user.getEmail(), user.getSex(), user.getBornthDay(), user.getPhoto(), user.getMoney(), user.getUname()});
        return update;
    }

    /**
     * 根据用户名称查询用户信息
     *
     * @param uname
     * @return
     */
    @Override
    public User selUserByUserName(String uname) {
        String sql = "select * from user where uname = ?";
        User user = super.selectOne(User.class, sql, new Object[]{uname});
        return user;
    }

    /**
     * 根据用户编号查询用户信息
     *
     * @param id
     * @return
     */
    @Override
    public User selUserById(Integer id) {
        String sql = "select * from user where uid = ?";
        User user = super.selectOne(User.class, sql, new Object[]{id});
        return user;
    }

    /**
     * 根据用户编号修改用户信息
     *
     * @param user
     * @return
     */
    @Override
    public int updateUserById(User user) {
        String sql = "UPDATE USER SET `password` = ?,`email`=?,`sex`=?,`bornthDay`=?,`photo`=?,`money`=?,`status`=?,`uname`=? WHERE `uid`=?";
        int index = super.update(sql, new Object[]{user.getPassword(), user.getEmail(), user.getSex(), user.getBornthDay(), user.getPhoto(), user.getMoney(), user.getStatus(), user.getUname(), user.getUid()});
        return index;
    }

    /**
     * 根据分页查询用户信息
     * @param startNum 开始下标
     * @param limit 长度
     * @param user 用户信息
     * @return
     */
    @Override
    public List<User> selUserByPage(Integer startNum, Integer limit, User user) {
        List params=new LinkedList();
        String sql="select * from user where 1=1";
        sql = appenSql(sql, user, params);
        sql+=" limit ?,?";
        params.add(startNum);
        params.add(limit);
        List<User> users = super.selectList(User.class, sql, params.toArray());
        return users;
    }

    /**
     * 可根据用户条件查询数据数量，也可以将参数封装到user类中作为sql条件
     * @param user
     * @return
     */
    @Override
    public Long selUserCount(User user) {
        String sql="select count(*) from user where 1=1";
        List params=new LinkedList();
        sql = appenSql(sql, user, params);
        Object count = super.getCount(sql, params.toArray());
        return ((Long) count);
    }

    @Override
    public int delUserById(User user) {
        String sql="delete from user where uid = ?";
        int index = super.update(sql, new Object[]{user.getUid()});
        return index;
    }

    private String appenSql(String sql, User user, List params){
        if (user!=null) {
            if (user.getUname()!=null){
                sql+=" and uname like ?";
                params.add("%"+user.getUname()+"%");
            }
            if (user.getBornthDay()!=null){
                sql+=" and bornthDay = ?";
                params.add(user.getBornthDay());
            }
            if (user.getSex()!=null){
                sql+=" and sex= ?";
                params.add(user.getSex());
            }
            if (user.getUid()!=null){
                sql+= " and uid =?";
                params.add(user.getUid());
            }
            if (user.getStatus()!=null){
                sql+=" and status = ?";
                params.add(user.getStatus());
            }
        }
        return sql;
    }

    @Override
    public int register(User user) {
        String sql = "insert into user values(?,?,?,?,?)";
        return super.update(sql,new Object[]{user.getUid(),user.getPassword(),user.getEmail(),user.getStatus(),user.getUname()});
    }

    @Override
    public List<User> queryUser() {
        String sql = "select * from user";
        List<User> userList = super.selectList(User.class,sql,null);
        return userList;
    }
}
