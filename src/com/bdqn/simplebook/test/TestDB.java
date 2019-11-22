package com.bdqn.simplebook.test;

import com.bdqn.simplebook.dao.BaseDao;
import com.bdqn.simplebook.dao.PostDao;
import com.bdqn.simplebook.dao.impl.PostDaoImpl;
import com.bdqn.simplebook.dao.impl.UserDaoImpl;
import com.bdqn.simplebook.domain.Admin;
import com.bdqn.simplebook.domain.Post;
import com.bdqn.simplebook.domain.User;
import com.bdqn.simplebook.utils.ConstantUtils;
import com.bdqn.simplebook.utils.JdbcUtils;
import javafx.geometry.Pos;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author: 赖榕
 * @date: 2019/11/2
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.test
 */
public class TestDB extends BaseDao {

    @Test
    public void testGetDs() {
        Connection connection = JdbcUtils.getConnection();
        System.out.println(connection);
        DataSource ds = JdbcUtils.getDs();
        System.out.println(ds);
    }

    @Test
    public void testSelect() {
        List<Admin> admins = super.selectList(Admin.class, "select * from admin", null);
        System.out.println(admins);
    }

    @Test
    public void testUpdate() {
        int update = super.update("update admin set username = ? where id = ?", new Object[]{"admin", 1});
        System.out.println(update);
    }

    @Test
    public void testUser() {
        User user = super.selectOne(User.class, "select * from user", null);
        System.out.println(user);
    }

    @Test
    public void s() {
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println(format);
    }

    @Test
    public void show() {
        File file = new File(ConstantUtils.userPhoto + File.separatorChar + "0c916505b2cd49af871a61b3d87687bf.png");
        file.deleteOnExit();
        System.out.println(file);
    }

    public Post fun1() throws Exception {
        PostDao postDao = new PostDaoImpl();
        Post post = postDao.updateLookPostCount(1);
        post.setUser(new UserDaoImpl().selUserById(17263785));
        return post;
    }

    public List<Post> fun2(Post post) throws Exception {
        PostDao postDao = new PostDaoImpl();
        List<Post> posts = postDao.findAllPost(post);
        Random rd = new Random();
        while (posts.size() >= 6) {
            int randomNum = rd.nextInt(posts.size() - 1);
            posts.remove(randomNum);
        }
        System.out.println(posts.toString());
        return posts;
    }
    @Test
    public void fun4(){
       Post p= super.selectOne(Post.class,"select * from post where pid=?",new Object[]{1});
        System.out.println(p);
    }
}
