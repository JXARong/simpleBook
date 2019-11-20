package com.bdqn.simplebook.service.impl;

import com.bdqn.simplebook.dao.DealDao;
import com.bdqn.simplebook.dao.impl.DealDaoImpl;
import com.bdqn.simplebook.service.DealService;

/**
 * @author: 赖榕
 * @date: 2019/11/19
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.service.impl
 */
public class DealServiceImpl implements DealService {
    private DealDao dao=new DealDaoImpl();
}
