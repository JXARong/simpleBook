package com.bdqn.simplebook.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import sun.security.util.Resources;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author: 赖榕
 * @date: 2019/11/2
 * @description: jdbc工具类
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.utils
 */
public class JdbcUtils {

    private static DataSource ds;
    static {
        try {
            Properties properties=new Properties();
            properties.load(JdbcUtils.class.getClassLoader().getResourceAsStream("database.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接池对象
     * @return
     */
    public static DataSource getDs(){
        return ds;
    }

    /**
     * 获取数据库连接对象
     * @return
     */
    public static Connection getConnection(){
        if (ds!=null){
            try {
                return ds.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 释放jdbc资源
     * @param connection 数据库连接对象
     * @param stmt 数据库操作对象
     * @param rs 结果集对象
     */
    public static  void close(Connection connection, Statement stmt, ResultSet rs){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
