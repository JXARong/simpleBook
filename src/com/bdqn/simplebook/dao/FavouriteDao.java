package com.bdqn.simplebook.dao;

import com.bdqn.simplebook.domain.Post;
import com.bdqn.simplebook.domain.User;

/**
 * @author: 赖榕
 * @date: 2019/11/18
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.dao
 */
public interface FavouriteDao {
    int delFavouriteByUid(User user);

    int delFavouriteByPid(Post post);

    /**
     * 文章收获的喜欢数
     * @param user
     * @return
     */
    int getFavouriteUser(User user);

    /**
     * 查询帖子的喜爱人数
     * @param pid
     * @return
     */
    int getFavouriteByPid(Integer pid);
}
