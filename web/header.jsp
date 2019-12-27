<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="/simpleBook/css/personal_one.css"/>
    <link rel="stylesheet" href="/simpleBook/css/personal_two.css"/>
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="width-limit">
        <!-- 左上方 Logo -->
        <a class="logo" href="/simpleBook/index.jsp"><img src="/simpleBook/images/jianjianshulogo.png" alt="Nav logo"/></a>

        <!-- 右上角 -->
        <!-- 未登录显示登录/注册/写文章 -->
        <a class="btn write-btn" target="_blank" href="/simpleBook/writePost.jsp">
            <i class="iconfont ic-write"></i>写文章
        </a>
        <a class="btn sign-up" id="sign_up" href="/simpleBook/login.html">注册</a>
        <a class="btn log-in" id="sign_in" href="/simpleBook/register.html">登录</a>

        <div class="container">
            <div class="collapse navbar-collapse" id="menu">
                <ul class="nav navbar-nav">
                    <li class="tab active">
                        <a href="/simpleBook/index.jsp">
                            <span class="menu-text">首页</span><i class="iconfont ic-navigation-discover menu-icon"></i>
                        </a>
                    </li>

                    <li class="search">
                        <form target="_blank" action="" accept-charset="UTF-8" method="get">
                            <input type="text" name="q" id="q" value="" autocomplete="off" placeholder="搜索" class="search-input"/>
                            <a class="search-btn" onclick="tiaozhuan()">
                                <i class="iconfont ic-search"></i>
                            </a>
                            <script>
                                function tiaozhuan() {

                                    var search = document.getElementById("q").value;

                                    window.location.href="/simpleBook/post/selectPostUserType?search="+encodeURI(search);
                                }
                            </script>

                    </li>
                </ul>
            </div>
        </div>
    </div>
</nav>
</body>
</html>
