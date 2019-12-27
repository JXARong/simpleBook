package com.bdqn.simplebook.dao.impl;

import com.bdqn.simplebook.dao.BaseDao;
import com.bdqn.simplebook.dao.FavouriteDao;
import com.bdqn.simplebook.domain.Post;
import com.bdqn.simplebook.domain.User;

import javax.annotation.processing.SupportedOptions;

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

    @Override
    public int getFavouriteUser(User user) {
        String sql = "select count(uid) from favourite where pid in (select pid from post where uid = ?)";
        int i = (int)super.getCount(sql,new Object[]{user.getUid()});
        return i;
    }

    @Override
    public int getFavouriteByPid(Integer pid) {
        String sql="select count(*) from favourite where pid = ?";
        return Integer.valueOf(String.valueOf(super.getCount(sql,new Object[]{pid})));
    }

    /**
     * 验证是否已经喜欢某篇文章了
     * @param pid
     * @param uid
     * @return
     */
    @Override
    public boolean verifyFavourite(Integer pid, Integer uid) {
        String sql="select count(*) from favourite where pid = ? and uid = ?";
        Object count = super.getCount(sql, new Object[]{pid, uid});
        return ((Long) count)>0;
    }

    @Override
    public boolean addFavourite(Integer pid, Integer uid) {
        String sql="insert into favourite values(default,?,?)";
        int update = super.update(sql, new Object[]{uid, pid});
        return update>0;
    }
}
