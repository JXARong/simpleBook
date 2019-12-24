<%--
  Created by IntelliJ IDEA.
  User: ARong
  Date: 2019/12/24
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<link rel="stylesheet" href="/simpleBook/js/layui/css/layui.css" type="text/css">
<script type="text/javascript" src="/simpleBook/js/layui/layui.js"></script>
<body>
<nav class="first_header" style="display:inline-block;width: 60%;margin: 0 auto;margin-left: 300px">
    <ul class="header_login layui-nav" style="background-color: white;height: 60px">
        <div style="display: inline-block;width: 200px">
            <a href="" style="display:inline-block;height:60px;color: orangered;font-size: 24px;line-height: 60px">简·简书</a>
            <a href="" style="display: inline-block;height: 60px;color: orangered;font-size: 18px;line-height: 70px;float: right"><span class="layui-icon" style="font-size: 18px;font-weight: bold">&#xe705;</span>发现</a>
        </div>
        <div style="display: inline-block;width: 200px;height:60px;margin-left:200px ">
            <div style="position: relative">
                <input class="search_input" type="text" name="search" style="padding: 0 40px 0 20px;line-height:60px;border-radius:40px;height: 38px;font-size: 14px;border: 1px solid #eee;background: #eee;width: 200px;">
                <a href="" style="font-size: 20px;position: absolute;right: 10px;top: 14px;"><i class="layui-icon">&#xe615;</i></a>
            </div>
        </div>
        <div style="float: right;display: inline-block">
            <li class="layui-nav-item" lay-unselect="">
                <a href="javascript:;"><img src="<%=request.getContextPath()%>/resources/userPhoto/${user.photo}" class="layui-nav-img"><span style="color: black">我</span></a>
                <dl class="layui-nav-child">
                    <dd><a href="<%=request.getContextPath()%>/userInfo.jsp">个人信息</a></dd>
                    <dd><a href="javascript:;">修改密码</a></dd>
                    <dd><a href="javascript:;">安全退出</a></dd>
                </dl>
            </li>
            <li>
                <button type="button" class="layui-btn layui-btn-danger layui-btn-radius" onclick="location.href='<%=request.getContextPath()%>/writePost.jsp'">写文章</button>
            </li>
        </div>
    </ul>
</nav>
<script type="text/javascript">
    layui.use(['element'],function () {
        var element=layui.element;
    })
</script>
</body>
</html>
