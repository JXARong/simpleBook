package com.bdqn.simplebook.service;

import com.bdqn.simplebook.domain.User;

/**
 * @author: 龚皓冬
 * @date: 2019/11/18
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.service
 */
public interface FavouriteService {

    int getFavouriteUser(User user);

    int getFavouriteByPid(Integer pid);
}
