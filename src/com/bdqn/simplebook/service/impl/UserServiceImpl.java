package com.bdqn.simplebook.service.impl;


import com.bdqn.simplebook.dao.*;
import com.bdqn.simplebook.dao.impl.*;
import com.bdqn.simplebook.domain.Comments;
import com.bdqn.simplebook.domain.Post;

import com.bdqn.simplebook.domain.User;
import com.bdqn.simplebook.service.UserService;
import com.bdqn.simplebook.utils.ConstantUtils;
import com.bdqn.simplebook.utils.NumberUtils;
import com.bdqn.simplebook.utils.PageUtils;

import java.io.File;
import java.util.List;
import java.util.Random;

import java.util.List;

/**
 * @author: 龚皓冬
 * @date: 2019/11/18
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.service.impl
 */
public class UserServiceImpl  implements UserService {

    /**
     * 用户dao访问接口
     */
    private UserDao dao = new UserDaoImpl();
    /**
     * 文章dao 访问接口
     */
    private PostDao postDao = new PostDaoImpl();
    /**
     * 交易dao访问接口
     */
    private DealDao dealDao = new DealDaoImpl();
    /**
     * 用户喜爱文章dao接口
     */
    private FavouriteDao favouriteDao = new FavouriteDaoImpl();
    /**
     * 用户关注dao接口
     */
    private RelationDao relationDao = new RelationDaoImpl();
    /**
     * 用户举报dao接口
     */
    private ReportDao reportDao = new ReportDaoImpl();

    /**
     * 文章评论dao接口
     */
    private CommentsDao commentsDao = new CommentsDaoImpl();

    /**
     * 评论点赞表
     */
    private Commons_LikeDao commons_likeDao=new Commons_LikeDaoImpl();
  
  
    /**
     * 查询首页的所有用户
     */
  @Override
    public List<User> selectIndexUser() throws Exception {
        List<User>users=dao.selectIndexUser();
        if(users==null){
            throw  new  RuntimeException("用户为空，未查到数据");
        }
        return users;
      }

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

    /**
     * 根据uid删除用户信息
     *
     * @param uid
     * @return
     * @throws Exception
     */
    @Override
    public int delUserById(String[] uid) throws Exception {
        int index = 0;
        if (uid == null || uid.length == 0)
            throw new Exception("暂无该用户信息,删除失败");

        // 遍历所有需要删除的id
        for (String s : uid) {
            User user = new User();
            user.setUid(Integer.valueOf(s));

            // 查询该用户下的所有帖子
            List<Post> posts = postDao.selPostByUid(user);
            // 当该用户下有帖子时删除该帖子相关的所有信息
            if (posts != null || posts.size() > 0) {
                for (Post post : posts) {
                    // 删除该帖子的所有收藏信息(Favourite表)
                    int favouriteIndex = favouriteDao.delFavouriteByPid(post);
                    // 删除该帖子相关的所有举报信息
                    int report = reportDao.delReportByPid(post);

                    // 查询该文章下的所有评论
                    List<Comments> comments = commentsDao.selCommentsByPid(post.getPid());

                    // 遍历该文章所有的评论
                    for (Comments comment : comments) {
                        // 删除该评论下的所有点赞数量
                        Integer delCommonsByCid = commons_likeDao.delCommonsByCid(comment.getCid());
                    }

                    // 删除该文章下的所有评论
                    Integer delCommentsByPid = commentsDao.delCommentsByPid(post.getPid());
                }
            }

            // 删除该用户下的所有发布的帖子
            int postIndex = postDao.delPostByUid(user);
            // 删除用户交易信息
            int dealIndex = dealDao.delDealByUid(user);
            // 删除该用户下的所有关注人
            int relationIndex = relationDao.delRelationByUid(user);
            // 删除该用户被关注的所有信息
            int cRelationIndex = relationDao.delcRelationByCid(user);
            // 删除该用户关注的所有文章信息
            int favouriteIndex = favouriteDao.delFavouriteByUid(user);
            // 删除该用户所有举报信息
            int reportIndex = reportDao.delReportByUid(user);
            // 删除该用户所有的评论信息
            Integer delCommentsByUid = commentsDao.delCommentsByUid(user.getUid());
            // 删除该用户所有的评论点赞信息
            Integer delCommonsByUid = commons_likeDao.delCommonsByUid(user.getUid());
            // 删除用户信息
            index += dao.delUserById(user);
        }
        if (index == 0) {
            throw new Exception("成功删除0条用户信息");
        }
        return index;

    }

    @Override
    public int register(User user) throws Exception {
        int random = Integer.valueOf(NumberUtils.createRandomNumber(8));
        for (User i : dao.queryUser()) {
            if (random == i.getUid()){
                random = Integer.valueOf(NumberUtils.createRandomNumber(8));
            }
        }
        user.setUid(random);
        return dao.register(user);
    }

    @Override
    public List<User> usersList() throws Exception {
        return dao.queryUser();
    }

    @Override
    public User login(String emailOruname, String pwd) throws Exception {
        return dao.login(emailOruname,pwd);
    }
}
