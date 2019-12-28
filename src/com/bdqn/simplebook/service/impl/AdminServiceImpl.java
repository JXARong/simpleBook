package com.bdqn.simplebook.service.impl;

import com.bdqn.simplebook.dao.AdminDao;
import com.bdqn.simplebook.dao.UserDao;
import com.bdqn.simplebook.dao.impl.AdminDaoImpl;
import com.bdqn.simplebook.dao.impl.UserDaoImpl;
import com.bdqn.simplebook.domain.Admin;
import com.bdqn.simplebook.service.AdminService;
import com.bdqn.simplebook.utils.ConstantUtils;
import com.bdqn.simplebook.utils.MailUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author: 赖榕
 * @date: 2019/11/2
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.service.impl
 */
public class AdminServiceImpl implements AdminService {

    private AdminDao dao = new AdminDaoImpl();
    private UserDao userDao = new UserDaoImpl();

    @Override
    public Admin login(Admin admin) {
        return dao.selAdminByNameAndPwd(admin);
    }

    /**
     * 查找根据用户名查找管理员信息
     *
     * @param admin
     * @return 0:用户名错误,  1:邮箱错误,  2:  邮箱发送失败      邮箱发送成功返回验证码
     */
    @Override
    public Admin selAdminByUsername(Admin admin) throws Exception {
        // 使用用户名查找管理员
        Admin admin1 = dao.selAdminByUserName(admin.getUsername());
        if (admin1 == null) {
            throw new Exception("未查找到该用户名");
        } else if (!admin1.getEmail().equals(admin.getEmail())) {
            throw new Exception("邮箱填写错误");
        }
        return admin1;
    }

    /**
     * 发送邮箱
     *
     * @param forgetAdmin
     * @return
     */
    @Override
    public int sendEmail(Admin forgetAdmin) {
        int code = (int) ((Math.random() * 9 + 1) * 100000);
        String title = "简简书-管理员密码重置";
        String content = MailUtils.getEmailContent("简简书管理员密码重置", forgetAdmin.getUsername()+"-简简书管理员密码重置", "您的验证码为：" + code + ",请保管好您的验证码，验证码失效为5分钟");
        boolean b = MailUtils.sendMail(forgetAdmin.getEmail(), content, title);

        // 发送失败返回-1，否则返回随机数字
        if (!b) {
            return -1;
        }
        return code;
    }


    /**
     * 修改管理员密码
     *
     * @param admin
     * @param oldPassword
     * @return
     * @throws Exception
     */
    @Override
    public int updatePwdById(Admin admin, String oldPassword) throws Exception {
        Admin selAdminByUid = dao.selAdminById(admin.getId());

        // 判断旧密码是否输入错误
        if (selAdminByUid.getPassword().equals(oldPassword)) {
            int index = dao.updatePwdById(admin);
            if (index == 0) {
                throw new Exception("密码修改失败，请稍后重试");
            }
            return index;
        } else {
            throw new Exception("旧密码输入错误");
        }
    }

    /**
     * 根据id查询管理员信息
     *
     * @param admin
     * @return
     */
    @Override
    public Admin selAdminById(Admin admin) throws Exception {
        admin = dao.selAdminById(admin.getId());
        if (admin.getUsername() == null) {
            throw new Exception("获取管理员信息失败,请重新登录后重试");
        }
        return admin;
    }

    /**
     * 修改管理员信息
     *
     * @param admin
     * @return
     * @throws Exception
     */
    @Override
    public int updateInfo(Admin admin) throws Exception {

        // 查找旧头像的路径并删除
        Admin selAdminById = dao.selAdminById(admin.getId());
        String photoPath = ConstantUtils.userPhoto + selAdminById.getPortrait();
        File file = new File(photoPath);
        file.deleteOnExit();

        int index = dao.updateAdminInfo(admin);
        if (index == 0) {
            throw new Exception("修改失败,请稍后重试");
        }
        return index;
    }

    /**
     * 获取近一周的每天用户注册数量
     *
     * @return
     */
    @Override
    public List<Integer> getRegisterNumOfUser() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        List<Integer> list = new ArrayList<>();
        // 实例化时间类
        Calendar calendar = Calendar.getInstance();
        // 遍历前七天
        for (int i = 7; i >= 0; i--) {
            // 获取一天到七天前的时间,没循环一次时间推前一天
            calendar.add(Calendar.DAY_OF_MONTH, -i);
            String format = sdf.format(calendar.getTime());
            System.out.println(format);
            Long number = userDao.selUserCountByDate(format);
            list.add(Integer.valueOf(number.toString()));

            // 回到现在的时间
            calendar.add(Calendar.DAY_OF_MONTH, +i);
        }
        return list;
    }

    /**
     * 修改密码
     *
     * @param admin
     */
    @Override
    public void updatePwd(Admin admin) {
        dao.updatePwdById(admin);
    }
}
