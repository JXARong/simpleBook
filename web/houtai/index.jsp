<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>简简书-后台管理</title>
    <link rel="stylesheet" href="/simpleBook/js/layui/css/layui.css">
    <script src="/simpleBook/js/layui/layui.js" charset="utf-8"></script>
</head>
<script type="application/javascript">
    layui.use(["jquery", "layer","element"], function () {
        var $ = layui.jquery;
        var element = layui.element;
        $("#changePwd").click(function (data) {
            layer.open({
                title: "修改密码",
                type: 2,
                content: "/simpleBook/houtai/changePwd.jsp",
                area: ["550px", "550px"]
            });
        });
        // 显示信息
        $("#showInfo").on("click", function () {
            layer.open({
                title: "管理员信息",
                type: 2,
                content: "/simpleBook/houtai/adminInfo.jsp",
                area: ["600px", "650px"]
            });
        });
        // 安全退出
        $("#logout").on("click", function () {
            layer.open({
                title: "安全退出",
                content: "确认退出吗？退出将会转跳至登录页面",
                btn: ["确定", "取消"],
                btn1: function () {
                    $.ajax({
                        url: "<%=request.getContextPath()%>/admin/logout",
                        success: function (data) {
                            parent.location.href = "<%=request.getContextPath()%>/houtai/login.html";
                        }, error: function () {
                            layer.msg("服务器繁忙,请刷新后重试")
                        }
                    })
                }
            });
        })
    })

</script>
<body class="layui-layout-body layui-bg-gray" style="height: 100%;">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">简简书-后台管理</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">控制台</a></li>
            <li class="layui-nav-item"><a href="<%=request.getContextPath()%>/houtai/userList.html" target="rightFrame">用户管理</a>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它系统</a>
                <dl class="layui-nav-child">
                    <dd><a href="<%=request.getContextPath()%>/houtai/emailManager.html" target="rightFrame">邮件管理</a>
                    </dd>
                    <dd><a href="javascript:layer.msg('该功能暂无开通,请敬请期待2.0版本')">支付管理</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="/simpleBook/resources/userPhoto/${sessionScope.admin.portrait}" class="layui-nav-img">
                    ${sessionScope.admin.username}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:void(0)" lay-filter="changePwd" id="changePwd">修改密码</a></dd>
                    <dd><a href="javascript:void(0)" lay-filter="showInfo" id="showInfo">基本资料</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="javascript:void(0)" id="logout">退出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="nav_tree">
                <li class="layui-nav-item layui-nav-itemed">
                    <a href="<%=request.getContextPath()%>/houtai/main.html" target="rightFrame">主页</a>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="<%=request.getContextPath()%>/houtai/userList.html" target="rightFrame">用户管理</a>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">文章管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="<%=request.getContextPath()%>/houtai/postList.html" target="rightFrame">文章列表</a>
                        </dd>
                        <dd><a href="javascript:layer.msg('暂未开放，请期待下一个版本更新',{icon:7})"
                               target="rightFrame">被举报文章</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="<%=request.getContextPath()%>/houtai/topic.html" target="rightFrame">主题管理</a>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">系统设置</a>
                    <dl class="layui-nav-child">
                        <dd><a href="<%=request.getContextPath()%>/houtai/emailManager.html"
                               target="rightFrame">邮箱设置</a>
                        </dd>
                        <dd><a href="javascript:layer.msg('该功能暂无开通,请敬请期待2.0版本')">支付设置</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <iframe src="<%=request.getContextPath()%>/houtai/main.html" frameborder="0" id="rightFrame"
                class="layui-bg-gray"
                name="rightFrame" style="width: 100%; height: 100%"></iframe>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © 简简书-后台管理
    </div>
</div>
</body>
</html>