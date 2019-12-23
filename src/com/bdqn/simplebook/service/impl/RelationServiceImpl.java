package com.bdqn.simplebook.service.impl;

import com.bdqn.simplebook.dao.RelationDao;
import com.bdqn.simplebook.dao.impl.RelationDaoImpl;
import com.bdqn.simplebook.domain.User;
import com.bdqn.simplebook.service.RelationService;

/**
 * @author: 龚皓冬
 * @date: 2019/11/18
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.service.impl
 */
public class RelationServiceImpl implements RelationService {

    private RelationDao dao = new RelationDaoImpl();

    @Override
    public int queryRelationUser(User user) {
        return dao.queryRelationUid(user);
    }

    @Override
    public int queryRelationCid(User user) {
        return dao.queryRelationCid(user);
    }
}
