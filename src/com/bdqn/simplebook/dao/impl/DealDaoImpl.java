package com.bdqn.simplebook.dao.impl;

import com.bdqn.simplebook.dao.BaseDao;
import com.bdqn.simplebook.dao.DealDao;
import com.bdqn.simplebook.domain.User;

/**
 * @author: 赖榕
 * @date: 2019/11/19
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.dao.impl
 */
public class DealDaoImpl extends BaseDao implements DealDao {
    @Override
    public Integer delDealByUid(User user) {
        String sql="delete from deal where uid = ?";
        int index = super.update(sql, new Object[]{user.getUid()});
        return  index;
    }
}
