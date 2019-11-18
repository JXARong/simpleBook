package com.bdqn.simplebook.service.impl;

import com.bdqn.simplebook.dao.UserDao;
import com.bdqn.simplebook.dao.impl.UserDaoImpl;
import com.bdqn.simplebook.domain.User;
import com.bdqn.simplebook.service.UserService;
import com.bdqn.simplebook.utils.ConstantUtils;
import com.bdqn.simplebook.utils.NumberUtils;
import com.bdqn.simplebook.utils.PageUtils;

import java.io.File;
import java.util.List;
import java.util.Random;

/**
 * @author: 龚皓冬
 * @date: 2019/11/18
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.service.impl
 */
public class UserServiceImpl implements UserService {

    private UserDao dao = new UserDaoImpl();

    /**
     * 添加用户
     *
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public int addUser(User user) throws Exception {
        String id = "";
        // 随机生成6-10位数字
        do {
            int len = new Random().nextInt(10) % (10 - 6 + 1) + 6;
            id = NumberUtils.createRandomNumber(len);

            // 判断该Id是否存在 ,不存在则停止生成随机数
            User userById = dao.selUserById(Integer.valueOf(id));
            if (userById == null) {
                break;
            }
        } while (true);
        user.setUid(Integer.valueOf(id));
        // 查找是否出现相同用户名的昵称，有抛出异常
        User userByUserName = dao.selUserByUserName(user.getUname());
        if (userByUserName != null) {
            throw new Exception("该用户已存在");
        }

        // 判断用户对象中是否存在头像，若不存在则使用系统默认头像
        if (user.getPhoto() == null || user.getPhoto().trim().length() == 0) {

        }
        int index = dao.addUser(user);
        // 加入添加失败则抛出异常
        if (index <= 0) {
            throw new Exception("添加失败，请稍后重试");
        }
        return index;
    }

    /**
     * 根据页数查询用户数据
     *
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public int updateUser(User user) throws Exception {
        // 获取该用户信息
        User selUserById = dao.selUserById(user.getUid());

        // 获取用户的头像信息并删除之前的头像
        if (selUserById != null) {
            File file = new File(ConstantUtils.userPhoto + selUserById.getPhoto());
            file.deleteOnExit();
        } else {
            throw new Exception("没有查找到需要修改的用户");
        }
        int index = dao.updateUserById(user);
        if (index == 0) {
            throw new Exception("修改失败");
        }
        return index;
    }

    /**
     * 根据分页查询用户信息
     *
     * @param page
     * @return
     */
    @Override
    public PageUtils selUserByPage(PageUtils page, User user) {
       /*
       查询指定页数中的数据
       startNum = (pageNum-1)*limit
       */
        List<User> users = dao.selUserByPage((page.getPageNum() - 1) * page.getLimit(), page.getLimit(), user);
        if (users.size() == 0) {
            page.setMsg("暂无相关数据");
        }
        Long count = dao.selUserCount(user);
        page.setData(users);
        page.setCount(Integer.valueOf(count.toString()));
        return page;
    }
}
