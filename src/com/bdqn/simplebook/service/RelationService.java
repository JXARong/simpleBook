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
public interface RelationService {

    int queryRelationUser(User user);

    int queryRelationCid(User user);

    /**
     * 判断两个用户之间是否有关注关系
     * @param uid
     * @param cid
     * @return
     */
    boolean verifyIsRelation(Integer uid,Integer cid);

    boolean changeRelational(Integer cid, Integer uid, String status);
}
