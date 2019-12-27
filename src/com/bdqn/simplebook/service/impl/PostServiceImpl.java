package com.bdqn.simplebook.service.impl;


import com.bdqn.simplebook.dao.*;
import com.bdqn.simplebook.dao.impl.*;
import com.bdqn.simplebook.domain.Comments;
import com.bdqn.simplebook.domain.Post;
import com.bdqn.simplebook.domain.Topic;
import com.bdqn.simplebook.domain.User;
import com.bdqn.simplebook.service.PostService;
import com.bdqn.simplebook.utils.PageUtils;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: 龚皓冬
 * @date: 2019/11/18
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.service.impl
 */
public class PostServiceImpl implements PostService {


    /**
     * 文章dao接口
     */
    private PostDao dao = new PostDaoImpl();

    /**
     * 主题dao编号
     */
    private TopicDao topicDao = new TopicDaoImpl();

    private CommentsDao commentsDao = new CommentsDaoImpl();

    private Commons_LikeDao commons_likeDao = new Commons_LikeDaoImpl();

    private ReportDao reportDao = new ReportDaoImpl();

    private FavouriteDao favouriteDao = new FavouriteDaoImpl();

    private UserDao userDao = new UserDaoImpl();

    @Override
    public List<Post> selectAllPost() throws Exception {

        List<Post> posts = dao.selectAllPost();
        if (posts == null) {
            throw new RuntimeException("文章为空，未查询到一条post");
        }
        return posts;
    }

    /**
     * 查询post(post中可以携带参数)
     *
     * @param pageUtils 分页工具
     * @param post      封装好查询条件的post的实例
     * @return
     * @throws Exception
     */
    @Override
    public PageUtils selPostByPage(PageUtils pageUtils, Post post, String sendDate) throws Exception {
        List<Post> posts = dao.selPostByPage((pageUtils.getPageNum() - 1) * pageUtils.getLimit(), pageUtils.getLimit(), post, sendDate);
        if (posts == null || posts.size() == 0) {
            throw new Exception("暂无相关数据");
        } else {
            // 遍历查询的文章，查询该文章属于哪个主题
            for (Post postOne : posts) {
                Topic topic = topicDao.selTopicById(postOne.getTopicId());
                postOne.setTopic(topic);
            }
        }

        Long count = dao.selPostCount(post);
        pageUtils.setData(posts);
        pageUtils.setCount(Integer.valueOf(count.toString()));
        return pageUtils;
    }

    /**
     * 根据文章编号删除文章信息
     *
     * @param pids
     * @return
     */
    @Override
    public Integer delPostById(String[] pids) throws Exception {
        int count = 0;
        // 遍历所有的文章编号
        for (String pid : pids) {

            // 查询该文章下的所有评论
            List<Comments> comments = commentsDao.selCommentsByPid(Integer.valueOf(pid));

            // 遍历该文章的所有评论
            for (Comments comment : comments) {

                // 删除该评论的点赞信息
                Integer delCommonsByCid = commons_likeDao.delCommonsByCid(comment.getCid());
            }
            // 删除该文章的所有评论
            Integer delCommentsByPid = commentsDao.delCommentsByPid(Integer.valueOf(pid));

            Post post = new Post();
            post.setPid(Integer.valueOf(pid));
            // 删除该文章的所有举报信息
            int delReportByPid = reportDao.delReportByPid(post);
            // 删除该文章的所有被收藏信息
            int delFavouriteByPid = favouriteDao.delFavouriteByPid(post);

            // 删除该文章
            Integer delPostByPid = dao.delPostByPid(Integer.valueOf(pid));
            count += delPostByPid;
        }
        if (count == 0) {
            throw new Exception("成功删除0条信息");
        }
        return count;

    }

    @Override
    public List<Post> selPostByTid(Integer tid) {
        List<Post> posts = dao.selPostByTid(tid);
        for (Post post : posts) {
            this.setTopicAndUser(post);
        }
        return posts;
    }

    @Override
    public PageUtils selPostListOfTop(PageUtils pageUtils) {
        List<Post> list = dao.selPostOfTop((pageUtils.getPageNum() - 1) * pageUtils.getLimit(), pageUtils.getLimit());
        for (Post post : list) {
            this.setTopicAndUser(post);
        }
        pageUtils.setCount(20);
        pageUtils.setData(list);
        return pageUtils;
    }

    @Override
    public int getPostUser(User user) {
        return dao.getPostUser(user);
    }

    @Override
    public Long getCountByTid(Integer topicId) {
        return dao.getCountByTid(topicId);
    }

    @Override
    public List<Post> selPostByUIdOfTop10(Integer uid) {
        List<Post> posts = dao.selPostByUIdOfTop10(uid);
        for (Post post : posts) {
            this.setTopicAndUser(post);
        }
        return posts;
    }

    public void setTopicAndUser(Post post) {
        User user = userDao.selUserById(post.getUid());
        Topic topic = topicDao.selTopicById(post.getTopicId());
        post.setTopic(topic);
        post.setUser(user);

    }

    @Override
    public int sendPost(Post post) {
        // 封装发布时间
        post.setSendDate(Timestamp.valueOf(LocalDateTime.now()));
        int index = dao.sendPost(post);
        return index;
    }

    @Override
    public int selFavouriteByPid(Integer pid) {
        int favouriteByPid = new FavouriteServiceImpl().getFavouriteByPid(pid);
        return favouriteByPid;
    }

    @Override
    public List<Post> searchPost(String searchValue) {
        return dao.searchPost(searchValue);
    }
    public Post selPostById(Integer id) throws Exception {
        Post post = dao.selpostByPid(id);
        if (post==null || post.getPid()==null){
            throw new Exception("文章信息加载失败");
        }
        Integer uid = post.getUid();
        User user = userDao.selUserById(uid);
        if (user==null || user.getUid()==null){
            throw new Exception("用户信息加载失败");
        }
        post.setUser(user);
        return post;
    }

    @Override
    public void addReadOfPostByPid(Integer pid) {
        dao.addReadOfPostByPid(pid);
    }
}
