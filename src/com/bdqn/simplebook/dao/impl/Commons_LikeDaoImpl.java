package com.bdqn.simplebook.dao.impl;

import com.bdqn.simplebook.dao.BaseDao;
import com.bdqn.simplebook.dao.Commons_LikeDao;

/**
 * @author: 赖榕
 * @date: 2019/11/19
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.dao.impl
 */
public class Commons_LikeDaoImpl extends BaseDao implements Commons_LikeDao {

    /**
     *  根据评论编号删除所有的点赞信息
     * @param cid
     * @return
     */
    @Override
    public Integer delCommonsByCid(Integer cid) {
        String sql="delete from commons_like where cid = ?";
        int index = super.update(sql, new Object[]{cid});
        return index;
    }

    /**
     * 根据用户编号删除所有该用户相关的评论点赞信息
     * @param uid
     * @return
     */
    @Override
    public Integer delCommonsByUid(Integer uid) {
        String sql="delete from commons_like where uid = ?";
        return super.update(sql, new Object[]{uid});
    }
}
