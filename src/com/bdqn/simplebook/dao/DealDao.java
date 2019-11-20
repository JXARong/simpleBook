package com.bdqn.simplebook.dao;

import com.bdqn.simplebook.domain.User;

/**
 * @author: 赖榕
 * @date: 2019/11/19
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.dao
 */
public interface DealDao  {
    Integer delDealByUid(User user);
}
