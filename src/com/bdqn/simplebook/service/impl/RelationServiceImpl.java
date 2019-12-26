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

    @Override
    public boolean verifyIsRelation(Integer uid, Integer cid) {
        int i = dao.verifyIsRelation(uid, cid);
        return i>0;
    }

    @Override
    public boolean changeRelational(Integer cid, Integer uid, String status) {
        boolean result=false;
        int i = 0;
        if("true".equals(status)){
            i = dao.addRelational(cid,uid);
        }else{
            i = dao.cancel(cid,uid);
        }
        return i>0;
    }
}
