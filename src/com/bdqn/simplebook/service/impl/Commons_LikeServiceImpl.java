package com.bdqn.simplebook.service.impl;

import com.bdqn.simplebook.dao.Commons_LikeDao;
import com.bdqn.simplebook.dao.impl.Commons_LikeDaoImpl;
import com.bdqn.simplebook.service.CommentsService;
import com.bdqn.simplebook.service.Commons_LikeService;

/**
 * @author: 赖榕
 * @date: 2019/11/19
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.service.impl
 */
public class Commons_LikeServiceImpl implements Commons_LikeService {
    private Commons_LikeDao dao=new Commons_LikeDaoImpl();
}
