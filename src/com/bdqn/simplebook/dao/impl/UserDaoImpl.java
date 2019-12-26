package com.bdqn.simplebook.dao.impl;

import com.bdqn.simplebook.dao.BaseDao;
import com.bdqn.simplebook.dao.UserDao;
import com.bdqn.simplebook.domain.Post;
import com.bdqn.simplebook.domain.User;

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
                                                                                                        // 编号，密码，邮箱，性别，生日，头像，余额，状态，用户名，注册时间，简介
        String sql = "insert into user values(?,?,?,?,?,?,?,?,?,default,default)";
        int update = super.update(sql, new Object[]{user.getUid(), user.getPassword(), user.getEmail(), user.getSex(), user.getBornthDay(), user.getPhoto(), user.getMoney(),user.getStatus(), user.getUname()});
        return update;
    }


    @Override
    /**
     * 查询首页所有用户
     */
    public List<User> selectIndexUser() throws Exception {
        String sql = "select * from user";
        Class clazz = Post.class;
        List<User> users = super.selectList(clazz, sql, null);
        return users;
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
        String sql = "UPDATE USER SET `uid`=? ";
        List<Object> params=new LinkedList<Object>();
        params.add(user.getUid());
        if (user.getPassword()!=null && !"".equals(user.getPassword())){
            sql+=", password = ?";
            params.add(user.getPassword());
        }
        if (user.getEmail()!=null && !"".equals(user.getEmail())){
            sql+=", email = ?";
            params.add(user.getEmail());
        }
        if (user.getSex()!=null && !"".equals(user.getSex())){
            sql+=", sex = ?";
            params.add(user.getSex());
        }
        if (user.getPhoto()!=null && !"".equals(user.getPhoto())){
            sql+=", photo = ?";
            params.add(user.getPhoto());
        }
        if (user.getMoney()!=null && !"".equals(user.getMoney())){
            sql+=", money = ?";
            params.add(user.getMoney());
        }
        if (user.getStatus()!=null && !"".equals(user.getStatus())){
            sql+=", status = ?";
            params.add(user.getStatus());
        }
        if (user.getUname()!=null && !"".equals(user.getUname())){
            sql+=", uname = ?";
            params.add(user.getUname());
        }
        if (user.getIntroduce()!=null && !"".equals(user.getIntroduce())){
            sql+=", introduce = ?";
            params.add(user.getIntroduce());
        }
        sql+=" WHERE `uid`=?";
        params.add(user.getUid());

        int index = super.update(sql, params.toArray());

        return index;
    }

    /**
     * 根据分页查询用户信息
     *
     * @param startNum 开始下标
     * @param limit    长度
     * @param user     用户信息
     * @return
     */
    @Override
    public List<User> selUserByPage(Integer startNum, Integer limit, User user, String bornthday) {
        List params = new LinkedList();
        String sql = "select * from user where 1=1";
        sql = appenSql(sql, user, params);
        if (bornthday != null) {
            sql += " and bornthday like ?";
            params.add("%" + bornthday + "%");
        }
        sql += " limit ?,?";
        params.add(startNum);
        params.add(limit);
        List<User> users = super.selectList(User.class, sql, params.toArray());
        return users;
    }

    /**
     * 可根据用户条件查询数据数量，也可以将参数封装到user类中作为sql条件
     *
     * @param user
     * @return
     */
    @Override
    public Long selUserCount(User user, String bornthday) {
        String sql = "select count(*) from user where 1=1";
        List params = new LinkedList();
        sql = appenSql(sql, user, params);
        if (bornthday != null) {
            sql += " and bornthday like ?";
            params.add("%" + bornthday + "%");
        }
        Object count = super.getCount(sql, params.toArray());
        return ((Long) count);
    }

    @Override
    public int delUserById(User user) {
        String sql = "delete from user where uid = ?";
        int index = super.update(sql, new Object[]{user.getUid()});
        return index;
    }

    private String appenSql(String sql, User user, List params) {
        if (user != null) {
            if (user.getUname() != null) {
                sql += " and uname like ?";
                params.add("%" + user.getUname() + "%");
            }
            if (user.getBornthDay() != null) {
                sql += " and bornthDay = ?";
                params.add(user.getBornthDay());
            }
            if (user.getSex() != null) {
                sql += " and sex= ?";
                params.add(user.getSex());
            }
            if (user.getUid() != null) {
                sql += " and uid =?";
                params.add(user.getUid());
            }
            if (user.getStatus() != null) {
                sql += " and status = ?";
                params.add(user.getStatus());
            }
            if (user.getEmail() != null) {
                sql += " and email like ?";
                params.add("%" + user.getEmail() + "%");
            }
        }
        return sql;
    }


    @Override
    public int register(User user) {
        String sql = "insert into user values(?,?,?,?,?,default)";
        return super.update(sql, new Object[]{user.getUid(), user.getPassword(), user.getEmail(), user.getStatus(), user.getUname()});
    }

    @Override
    public List<User> queryUser() {
        String sql = "select * from user";
        List<User> userList = super.selectList(User.class, sql, null);
        return userList;
    }

    @Override
    public User login(String emailOrunam, String pwd) {
        String sql = "select * from `user` where (? = email or ? = uname) and ? = `password`";
        User user = super.selectOne(User.class, sql, new Object[]{emailOrunam, emailOrunam, pwd});
        return user;
    }

    /**
     * 获取某一天的用户注册总量
     *
     * @param format
     * @return
     */
    @Override
    public Long selUserCountByDate(String format) {
        String sql = "select count(*) from user where registerTime like ?";
        Object count = super.getCount(sql, new Object[]{"%" + format + "%"});
        return ((Long) count);
    }

    @Override
    public Long selUserCountOfToday(String today) {
        String sql = "select Count(*) from user where registerTime like ?";
        Object count = super.getCount(sql, new Object[]{"%" + today + "%"});
        return ((Long) count);
    }

    @Override
    public Long selUserCountOfAll() {
        String sql = "select Count(*) from user";
        Object count = super.getCount(sql, null);
        return ((Long) count);
    }
}
