package com.bdqn.simplebook.dao;

/**
 * @author: 赖榕
 * @date: 2019/11/20
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.dao
 */
public interface Commons_LikeDao {

    public Integer delCommonsByCid(Integer cid);

    public Integer delCommonsByUid(Integer uid);
}
