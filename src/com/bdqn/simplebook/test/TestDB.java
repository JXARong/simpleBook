package com.bdqn.simplebook.test;

import com.bdqn.simplebook.dao.BaseDao;
import com.bdqn.simplebook.domain.Admin;
import com.bdqn.simplebook.domain.Post;
import com.bdqn.simplebook.domain.User;
import com.bdqn.simplebook.utils.JdbcUtils;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

/**
 * @author: 赖榕
 * @date: 2019/11/2
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.test
 */
public class TestDB  extends BaseDao {

    @Test
    public void testGetDs(){
        Connection connection = JdbcUtils.getConnection();
        System.out.println(connection);
        DataSource ds = JdbcUtils.getDs();
        System.out.println(ds);
    }

    @Test
    public void testSelect(){
        List<Admin> admins = super.selectList(Admin.class, "select * from admin", null);
        System.out.println(admins);
    }

    @Test
    public void testUpdate(){
        int update = super.update("update admin set username = ? where id = ?", new Object[]{"admin", 1});
        System.out.println(update);
    }

    @Test
    public void testUser(){
        User user = super.selectOne(User.class, "select * from user", null);
        System.out.println(user);
    }
    @Test
    public  void testAllPost(){
        List<Post> post=super.selectList(Post.class,"select * from post",null);
        System.out.println(post.toString());
    }
}
