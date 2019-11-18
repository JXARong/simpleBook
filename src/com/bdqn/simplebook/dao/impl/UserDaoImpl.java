package com.bdqn.simplebook.dao.impl;

import com.bdqn.simplebook.dao.BaseDao;
import com.bdqn.simplebook.dao.UserDao;
import com.bdqn.simplebook.domain.User;

/**
 * @author: 赖榕
 * @date: 2019/11/18
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.dao.impl
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public int addUser(User user) {
        String sql="insert into user values(?,?,?,?,?,?,?,1,?)";
        int update = super.update(sql, new Object[]{user.getUid(), user.getPassword(), user.getEmail(), user.getSex(), user.getBornthDay(), user.getPhoto(), user.getMoney(), user.getUname()});
        return update;
    }
}
