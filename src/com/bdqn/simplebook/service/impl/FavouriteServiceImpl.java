package com.bdqn.simplebook.service.impl;

import com.bdqn.simplebook.dao.FavouriteDao;
import com.bdqn.simplebook.dao.impl.FavouriteDaoImpl;
import com.bdqn.simplebook.service.FavouriteService;

/**
 * @author: 龚皓冬
 * @date: 2019/11/18
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.service.impl
 */
public class FavouriteServiceImpl implements FavouriteService {
    private FavouriteDao dao=new FavouriteDaoImpl();
}
