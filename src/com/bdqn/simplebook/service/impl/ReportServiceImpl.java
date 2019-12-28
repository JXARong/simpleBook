package com.bdqn.simplebook.service.impl;

import com.bdqn.simplebook.dao.ReportDao;
import com.bdqn.simplebook.dao.impl.ReportDaoImpl;
import com.bdqn.simplebook.domain.Post;
import com.bdqn.simplebook.domain.Report;
import com.bdqn.simplebook.domain.User;
import com.bdqn.simplebook.service.PostService;
import com.bdqn.simplebook.service.ReportService;
import com.bdqn.simplebook.service.UserService;
import com.bdqn.simplebook.utils.MailUtils;
import com.bdqn.simplebook.utils.PageUtils;
import com.sun.scenario.effect.impl.prism.ps.PPSBlend_ADDPeer;

import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.concurrent.atomic.DoubleAccumulator;

/**
 * @author: 龚皓冬
 * @date: 2019/11/18
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.service.impl
 */
public class ReportServiceImpl implements ReportService {
    private ReportDao dao = new ReportDaoImpl();
    private PostService postService = new PostServiceImpl();
    private UserService userService = new UserServiceImpl();

    /**
     * 根据用户编号和文章编号判断是否已经被举报过
     *
     * @param uid
     * @param pid
     * @return
     */
    @Override
    public boolean isReport(Integer uid, Integer pid) {
        Report report = dao.isReport(uid, pid);
        return report != null && report.getReportId() != null;
    }

    /**
     * 添加举报信息
     *
     * @param report
     * @return
     */
    @Override
    public int addReport(Report report) {
        report.setReportTime(Timestamp.valueOf(LocalDateTime.now()));
        return dao.addReport(report);
    }

    @Override
    public List<Report> getAllReport(PageUtils pageUtils) throws Exception {
        Integer limit = pageUtils.getLimit();
        Integer pageNum = pageUtils.getPageNum();
        List<Report> reports = dao.getAllReport((pageNum - 1) * limit, limit);
        for (Report report : reports) {
            Post post = postService.selPostById(report.getPid());
            User user = userService.selUserById(report.getUid());
            report.setPost(post);
            report.setUser(user);
        }

        // 查询所有举报信息的条数
        Long count = dao.selAllCount();
        pageUtils.setCount(Integer.valueOf(String.valueOf(count)));
        return reports;
    }

    // 举报成功
    @Override
    public boolean successOfReport(Integer reportId, Integer pid, Integer uid) throws Exception {

        // 处理日期格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 对所有举报该帖子的用户发送邮箱通知举报成功
        // 查询对该帖子的所有举报信息
        Report Info = new Report();
        Info.setPid(pid);
        Info.setUid(uid);
        List<Report> reports = dao.getReportsOfInfo(Info);

        // 循环每一条结果，并对该用户进行发送通知审核
        for (Report report : reports) {
            Integer uid1 = report.getUid();
            User user = userService.selUserById(uid1);
            Post post = postService.selPostById(report.getPid());
            String email = user.getEmail();
            String time = formatter.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(report.getReportTime().getTime()), ZoneId.systemDefault()));
            String emailContent = MailUtils.getEmailContent("简简书文章举报审核", "简简书文章审核结果通过啦", "亲爱的'" + user.getUname() + "'您好,在" + time + "时您对\"" + post.getTitle()
                    + "\"进行了举报！举报原因为：" + report.getReportContent() + ",我们已对该文章进行了删除,并对作者发送了通知，感谢您为简简书做的一切");
            MailUtils.sendMail(email,emailContent,"简简书文章举报审核结果");
        }

        // 删除举报信息
        Post post = new Post();
        post.setPid(pid);
        dao.delReportByPid(post);

        // 查询该帖子信息
        Post selPostById = postService.selPostById(pid);

        // 删除帖子信息
        String[] strings=new String[1];
        strings[0]=pid.toString();
        Integer integer = postService.delPostById(strings);
        String time = formatter.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(selPostById.getSendDate().getTime()), ZoneId.systemDefault()));

        // 对发布该帖子的人进行通知警告
        User user = userService.selUserById(uid);
        String userContent = MailUtils.getEmailContent("简简书删除文章删除通知","简简书文章删除","尊敬的\""+user.getUname()+"\",您好。由于您于 "+time+" 发布的 \""+selPostById.getTitle()+"\"文章被多名用户举报,现已删除该文章并对您进行通知。请文明上网");
        boolean sendMail = MailUtils.sendMail(user.getEmail(), userContent, "简简书文章删除通知");
        return sendMail;
    }

    @Override
    public boolean failOfReport(Integer pid, Integer uid, Integer reportId) throws Exception {
        // 处理日期格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        Report info=new Report();
        info.setUid(uid);
        info.setPid(pid);
        info.setReportId(reportId);
        List<Report> reports = dao.getReportsOfInfo(info);
        for (Report report : reports) {
            User user = userService.selUserById(uid);
            Post post = postService.selPostById(pid);
            String time = formatter.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(report.getReportTime().getTime()), ZoneId.systemDefault()));
            // 给所有的用户发送邮件
            String temp="亲爱的 "+user.getUname()+" 您好，您于 "+time+" 举报的文章\""+post.getTitle()+"\"由于证据不足举报失败。";
            String emailContent = MailUtils.getEmailContent("简简书文章举报审核", "文章举报审核失败", temp);
            MailUtils.sendMail(user.getEmail(),emailContent,"简简书文章举报审核结果");
        }
        // 删除所有有关该帖子的举报信息
        Post post=new Post();
        post.setPid(pid);
        int i = dao.delReportByPid(post);
        return i>0;
    }
}
