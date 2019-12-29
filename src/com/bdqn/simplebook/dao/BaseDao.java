
package com.bdqn.simplebook.dao;

import com.bdqn.simplebook.utils.JdbcUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: 赖榕
 * @date: 2019/11/2
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.dao
 */
public class BaseDao {

    /**
     * 执行增删改操作
     *
     * @param sql
     * @param params
     * @return
     */
    protected int update(String sql, Object[] params) {
        Connection connection = JdbcUtils.getConnection();
        PreparedStatement ps = null;
        int index = 0;
        try {
            ps = connection.prepareStatement(sql);
            this.fullParams(ps, params);
            index = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection, ps, null);
        }
        return index;
    }

    /**
     * 获取多行数据
     *
     * @param clazz
     * @param sql
     * @param params
     * @param <T>
     * @return
     */
    protected <T> List<T> selectList(Class<T> clazz, String sql, Object[] params) {
        List<T> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            this.fullParams(ps, params);
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            // 创建字符串对象，存放结果集中所有的列
            String[] columns = new String[rsmd.getColumnCount()];
            for (int i = 0; i < columns.length; i++) {
                columns[i] = rsmd.getColumnLabel(i + 1);
            }
            // 遍历结果集
            while (rs.next()) {

                T entity = clazz.getConstructor().newInstance();
                for (int i = 0; i < columns.length; i++) {
                    try {
                        // 获取列名称
                        String column = columns[i];
                        // 获取属性
                        Field field = clazz.getDeclaredField(column);
                        //  拼接属性对应的setter方法名称
                        String methodName = "set" + column.substring(0, 1).toUpperCase() + column.substring(1);
                        Method setMethod = clazz.getMethod(methodName, field.getType());
                        // 属性类型为Timestamp类型
                        if (field.getType().getName().equals("java.sql.Timestamp")) {
                            // 获取值
                            String value = rs.getString(column);
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            Date date = sdf.parse(value);
                            long time = date.getTime();
                            setMethod.invoke(entity, field.getType().getConstructor(long.class).newInstance(time));
                        } else {
                            // 执行setter方法
                            setMethod.invoke(entity, field.getType().getConstructor(String.class).newInstance(rs.getString(column)));
                        }
                    } catch (Exception e) {
                    }
                }
                list.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection, ps, rs);
        }
        return list;
    }

    /**
     * 获取单行单列数据
     *
     * @param sql
     * @param params
     * @return
     */
    protected Object getCount(String sql, Object[] params) {
        Object object = new Object();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            this.fullParams(ps, params);
            rs = ps.executeQuery();
            if (rs.next())
                object = rs.getObject(1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection, ps, rs);
        }
        return object;
    }

    /**
     * 获取单行数据
     *
     * @param clazz
     * @param sql
     * @param params
     * @param <T>
     * @return
     */
    protected <T> T selectOne(Class<T> clazz, String sql, Object[] params) {
        List<T> list = this.selectList(clazz, sql, params);
        return list != null && list.size() > 0 ? list.get(0) : null;
    }

    protected  <T> List<T>  selRowsAndOneColumn(Class<T> clazz,String sql,Object[] params){
        List<T> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            this.fullParams(ps, params);
            rs = ps.executeQuery();
            while (rs.next()){
                list.add((T) rs.getObject(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection,ps,rs);
        }

        return list;
    }

    /**
     * 填充数据库
     *
     * @param ps     数据库操作对象
     * @param parasm 参数列表
     */
    private void fullParams(PreparedStatement ps, Object[] parasm) {
        if (parasm == null || parasm.length <= 0) {
            return;
        }
        for (int i = 0; i < parasm.length; i++) {
            try {
                ps.setObject(i + 1, parasm[i]);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
