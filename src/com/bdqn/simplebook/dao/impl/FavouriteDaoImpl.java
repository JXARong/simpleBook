package com.bdqn.simplebook.dao.impl;

import com.bdqn.simplebook.dao.BaseDao;
import com.bdqn.simplebook.dao.FavouriteDao;
import com.bdqn.simplebook.domain.Post;
import com.bdqn.simplebook.domain.User;

/**
 * @author: 赖榕
 * @date: 2019/11/18
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.dao.impl
 */
public class FavouriteDaoImpl extends BaseDao implements FavouriteDao {

    /**
     * 删除指定用户关注文章的所有信息
     * @param user
     * @return
     */
    @Override
    public int delFavouriteByUid(User user) {
        String sql="delete from favourite where uid = ?";
        return super.update(sql,new Object[]{user.getUid()});
    }

    /**
     * 根据帖子编号删除收藏信息
     * @param post
     * @return
     */
    @Override
    public int delFavouriteByPid(Post post) {
        String sql="delete from favourite where pid = ?";
        return super.update(sql, new Object[]{post.getPid()});
    }
}
