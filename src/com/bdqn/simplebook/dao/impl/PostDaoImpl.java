package com.bdqn.simplebook.dao.impl;

import com.bdqn.simplebook.dao.BaseDao;
import com.bdqn.simplebook.dao.PostDao;
import com.bdqn.simplebook.domain.Post;
import com.bdqn.simplebook.domain.User;
import javafx.geometry.Pos;

import java.util.LinkedList;
import java.util.List;


/**
 * @author: 赖榕
 * @date: 2019/11/18
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.dao.impl
 */
public class PostDaoImpl extends BaseDao implements PostDao {

    @Override
    public List<Post> selectAllPost() throws Exception {
        String sql = "select * from post";
        Class clazz = Post.class;
        List<Post> post = super.selectList(clazz, sql, null);
        return post;
    }

    @Override
    public Post findPost(int pid) throws Exception {
        return super.selectOne(Post.class, "select * from post where pid=?", new Object[]{pid});

    }

    /**
     * 根据用户Id删除文章内容
     *
     * @param user
     * @return
     */
    @Override
    public Integer delPostByUid(User user) {
        String sql = "delete from post where uid = ?";
        int index = super.update(sql, new Object[]{user.getUid()});
        return index;
    }


    @Override
    public List<Post> selPostByUid(User user) {
        String sql = "select * from post where uid =? and status = 0 order by hot desc";
        List<Post> posts = super.selectList(Post.class, sql, new Object[]{user.getUid()});
        return posts;
    }

    /**
     * 根据填写的信息获取所有的文章内容
     *
     * @param post
     * @return
     */
    @Override
    public List<Post> selPostByPage(Integer start, Integer limit, Post post, String sendDate) {
        String sql = "select * from post where 1 = 1";
        List params = new LinkedList();
        sql = this.appenSql(sql, post, params);
        if (sendDate != null) {
            sql += "and sendDate like ?";
            params.add("%" + sendDate + "%");
        }
        sql+=" order by hot desc";
        sql += " limit ?,?";
        params.add(start);
        params.add(limit);
        List<Post> posts = super.selectList(Post.class, sql, params.toArray());
        return posts;
    }

    /**
     * 获取查询到post数量
     *
     * @param post
     * @return
     */
    @Override
    public Long selPostCount(Post post) {
        String sql = "select count(*) from post where 1=1";
        List params = new LinkedList();
        sql = this.appenSql(sql, post, params);
        Object count = super.getCount(sql, params.toArray());
        return (long) count;
    }

    /**
     * 根据文章编号删除文章信息
     *
     * @param pid
     * @return
     */
    @Override
    public Integer delPostByPid(Integer pid) {
        String sql = "delete from post where pid = ?";
        return super.update(sql, new Object[]{pid});
    }

    @Override
    public List<Post> selPostOfTop(int i, Integer limit) {
        String sql = "SELECT * FROM post ORDER BY (readCount+hot)*10 DESC LIMIT ?,?";
        List<Post> posts = super.selectList(Post.class, sql, new Object[]{i, limit});
        return posts;
    }

    /**
     * 拼接sql语句
     *
     * @param sql
     * @param post
     * @param params
     * @return
     */
    private String appenSql(String sql, Post post, List params) {
        if (post.getPid() != null) {
            sql += " and pid = ?";
            params.add(post.getPid());
        }
        if (post.getUid() != null) {
            sql += " and uid = ?";
            params.add(post.getUid());
        }
        if (post.getTitle() != null) {
            sql += " and  title  like ?";
            params.add("%" + post.getTitle() + "%");
        }
        if(post.getStatus()!=null){
            sql +=" and status = ?";
            params.add(post.getStatus());
        }
        return sql;
    }

    @Override
    public Integer delPostByTid(Integer id) {
        String sql = "delete from post where topicId = ?";
        return super.update(sql, new Object[]{id});
    }

    @Override
    public List<Post> selPostByTid(Integer tid) {
        String sql = "select * from post where topicId = ?";
        List<Post> posts = super.selectList(Post.class, sql, new Object[]{tid});
        return posts;
    }

    public int getPostUser(User user) {
        String sql = "select count(uid) from post uid = ?";
        int i = (int) super.getCount(sql, new Object[]{user.getUid()});
        return i;
    }

    @Override
    public Long getCountByTid(Integer topicId) {
        String sql = "select count(*) from post where topicId = ?";
        return (Long) super.getCount(sql, new Object[]{topicId});
    }

    @Override
    public List<Post> selPostByUIdOfTop10(Integer uid) {
        String sql = "select * from post where uid  = ? and status = 0 order by hot desc limit 10";
        return super.selectList(Post.class, sql, new Object[]{uid});
    }

    @Override
    public int sendPost(Post post) {
        // 文章编号 用户编号 点赞总数 打赏金额 浏览次数 发布时间 文章内容 标题 热度 状态 主题编号
        String sql = "insert into post values(default,?,0,0,0.0,?,?,?,0,0,?,null,?)";
        return super.update(sql, new Object[]{post.getUid(), post.getSendDate(), post.getArticle(), post.getTitle(), post.getTopicId(),post.getTextNum()});
    }

    @Override
    public Post selpostByPid(Integer id) {
        String sql="select * from post where pid = ?";
        return super.selectOne(Post.class,sql,new Object[]{id});
    }

    @Override
    public List<Post> searchPost(String searchValue) {
        String sql = "select * from post where title like ? and status = 0";
        List<Post> searchPostList = super.selectList(Post.class,sql,new Object[]{"%"+searchValue+"%"});
        return searchPostList;
    }


    @Override
    public void addReadOfPostByPid(Integer pid) {
        String sql="update post set readCount=readCount+1 where pid =?";
        super.update(sql,new Object[]{pid});
    }

    @Override
    public Integer addStart(Integer pid) {
        String sql="update post set start = start +1 where pid = ?";
        return super.update(sql,new Object[]{pid});
    }

    @Override
    public List<Integer> selUidGroupByTextNumDesc(Integer uid) {
        String sql="SELECT uid FROM post GROUP BY  uid HAVING 1=1  ";
        List<Object> params=new LinkedList<>();
        if (uid!=null){
            sql+=" and uid!=?";
            params.add(uid);
        }
        sql+=" ORDER BY SUM(textNum) DESC";
        return super.selRowsAndOneColumn(Integer.class,sql,params.toArray());
    }

    /**
     * 修改文章的状态
     * @param status
     * @param pid
     * @return
     */
    @Override
    public int updPostStatus(Integer status, Integer pid) {
        String sql="update post set status = ? where pid = ?";
        return super.update(sql,new Object[]{status,pid});
    }
}
