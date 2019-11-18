package com.bdqn.simplebook.service.impl;

import com.bdqn.simplebook.dao.AdminDao;
import com.bdqn.simplebook.dao.impl.AdminDaoImpl;
import com.bdqn.simplebook.domain.Admin;
import com.bdqn.simplebook.service.AdminService;
import com.bdqn.simplebook.utils.MailUtils;

import java.util.Random;

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
        if (admin1==null){
            throw new Exception("未查找到该用户名");
        }else if (!admin1.getEmail().equals(admin.getEmail())){
            throw new Exception("邮箱填写错误");
        }
        return admin1;
    }

    @Override
    public int sendEmail(Admin forgetAdmin) {
        int code=(int)((Math.random()*9+1)*100000);
        String title="简简书-管理员密码重置";
        String content="管理员："+forgetAdmin.getUsername()+",您好<br>  您的验证码为："+code+",切勿让他人盗取！";
        boolean b = MailUtils.sendMail(forgetAdmin.getEmail(), content, title);

        // 发送失败返回-1，否则返回随机数字
        if (!b){
            return -1;
        }
        return code;
    }

    @Override
    public int updatePwdById(Admin admin) {
        return dao.updatePwdById(admin);
    }
}
