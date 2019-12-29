package com.bdqn.simplebook.service.impl;

import com.bdqn.simplebook.dao.FavouriteDao;
import com.bdqn.simplebook.dao.impl.FavouriteDaoImpl;
import com.bdqn.simplebook.domain.User;
import com.bdqn.simplebook.service.FavouriteService;
import com.bdqn.simplebook.service.PostService;

/**
 * @author: 龚皓冬
 * @date: 2019/11/18
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.service.impl
 */
public class FavouriteServiceImpl implements FavouriteService {
    private FavouriteDao dao=new FavouriteDaoImpl();
    private PostService postService=new PostServiceImpl();
    @Override
    public int getFavouriteUser(User user) {
        int i = dao.getFavouriteUser(user);
        return i;
    }

    @Override
    public int getFavouriteByPid(Integer pid) {
        return dao.getFavouriteByPid(pid);
    }

    @Override
    public boolean verifyFavourite(Integer pid, Integer uid) throws Exception {
        boolean b = dao.verifyFavourite(pid, uid);
        if (b){
            throw new Exception("不能重复点赞");
        }else{
            // 添加喜欢信息
            boolean favourite = dao.addFavourite(pid, uid);
            // 给post中start加1
            if (favourite){
                return postService.addStart(pid);
            }
            return false;
        }
    }
}
