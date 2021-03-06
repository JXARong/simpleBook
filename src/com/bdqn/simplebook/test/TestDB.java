package com.bdqn.simplebook.test;

import com.alibaba.fastjson.JSON;
import com.bdqn.simplebook.dao.BaseDao;
import com.bdqn.simplebook.dao.PostDao;
import com.bdqn.simplebook.dao.impl.PostDaoImpl;
import com.bdqn.simplebook.domain.Admin;
import com.bdqn.simplebook.domain.Post;
import com.bdqn.simplebook.domain.User;
import com.bdqn.simplebook.service.impl.AdminServiceImpl;
import com.bdqn.simplebook.utils.ConstantUtils;
import com.bdqn.simplebook.utils.JdbcUtils;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.File;
import java.sql.Connection;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
    public  void testAllPost() {
        List<Post> post = super.selectList(Post.class, "select * from post", null);
        System.out.println(post.toString());
    }

    @Test
    public void s() {
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println(format);
    }

    @Test
    public void show(){
        File file=new File(ConstantUtils.userPhoto+File.separatorChar+"0c916505b2cd49af871a61b3d87687bf.png");
        file.deleteOnExit();
        System.out.println(file);
    }
    @Test
    public void fun1() throws Exception {
        PostDao postDao = new PostDaoImpl();
        System.out.println( postDao.findPost(1));

    }

    @Test
    public void showff(){
        List<User> userList = super.selectList(User.class, "select * from user", null);
        System.out.println(userList);
    }

    @Test
    public void testTimestamp(){
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        Calendar instance = Calendar.getInstance();
//        instance.add(Calendar.DATE,-2);
//        String format = sdf.format(instance.getTime());
//
//        System.out.println(format);
        AdminServiceImpl service=new AdminServiceImpl();
        List<Integer> numOfUser = service.getRegisterNumOfUser();
        System.out.println(JSON.toJSONString(numOfUser));
    }

    public static void main(String[] a){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
      String s= formatter.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()), ZoneId.systemDefault()));
        System.out.println(s);
    }
}
