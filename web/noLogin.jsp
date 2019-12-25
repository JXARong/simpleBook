<%--
  Created by IntelliJ IDEA.
  User: ARong
  Date: 2019/12/24
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>未登录导航栏</title>
</head>
<link rel="icon" type="image/x-icon" href="/simpleBook/images/girl.png"/>
<link rel="stylesheet" href="/simpleBook/css/indexof.css" type="text/css">
<link rel="stylesheet" href="/simpleBook/js/layui/css/layui.css" type="text/css">
<script type="text/javascript" src="/simpleBook/js/layui/layui.all.js"></script>
<body>
<nav class="first_header" style="width: 66%; position: relative;left: 250px">
    <ul class="header_login">
        <li><a href="/simpleBook/index.jsp" style="color: orangered;font-size: 24px;position: relative;left: 50px;top: 5px">简·简书</a></li>
        <li><a href="/simpleBook/index.jsp"
               style="text-decoration: none;color: orangered;position: relative;top:5px;left:80px;font-size: 18px">首页</a>
        </li>
        <li>
            <input class="search_input" type="text" name="search"
                   style="padding: 0 40px 0 20px;border-radius:40px;height: 38px;font-size: 14px;border: 1px solid #eee;background: #eee;width: 200px;position: relative;left: 100px;top:2px">
            <a href="" style="position: relative;left: 70px;z-index: 9999;font-size: 20px"><i class="layui-icon">&#xe615;</i></a>
        </li>

        <li name="login_simple"><a href="/simpleBook/login.html"
                                   style="color:#b0b0b0;position: relative;left: 300px;top: 5px;font-size: 20px;">登录</a>
        </li>
        <li>
            <button type="button" class="layui-btn layui-btn-primary layui-btn-radius" onclick="location.href='/simpleBook/register.html'"
                    style="color: orangered;position: relative;left: 350px">注册</注册>
            </button>
        </li>
        <li>
            <button type="button" class="layui-btn layui-btn-danger layui-btn-radius" onclick="location.href='/simpleBook/writePost.jsp'"
                    style="position: relative;left: 380px">写文章
            </button>
        </li>

    </ul>
</nav>
</body>
</html>
