<%--
  Created by IntelliJ IDEA.
  User: 落雨丶
  Date: 2019/11/7
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>

        var hash={

            'qq.com': 'http://mail.qq.com',

            'gmail.com': 'http://mail.google.com',

            'sina.com': 'http://mail.sina.com.cn',

            '163.com': 'http://mail.163.com',

            '126.com': 'http://mail.126.com',

            'yeah.net': 'http://www.yeah.net/',

            'sohu.com': 'http://mail.sohu.com/',

            'tom.com': 'http://mail.tom.com/',

            'sogou.com': 'http://mail.sogou.com/',

            '139.com': 'http://mail.10086.cn/',

            'hotmail.com': 'http://www.hotmail.com',

            'live.com': 'http://login.live.com/',

            'live.cn': 'http://login.live.cn/',

            'live.com.cn': 'http://login.live.com.cn',

            '189.com': 'http://webmail16.189.cn/webmail/',

            'yahoo.com.cn': 'http://mail.cn.yahoo.com/',

            'yahoo.cn': 'http://mail.cn.yahoo.com/',

            'eyou.com': 'http://www.eyou.com/',

            '21cn.com': 'http://mail.21cn.com/',

            '188.com': 'http://www.188.com/',

            'foxmail.com': 'http://www.foxmail.com',

        };

        varurl = $("#email").text().split('@')[1]; //获取邮箱域

        for (var j in hash){

            $("#goEmail").attr("href",hash[url]); //替换登陆链接

        }

    </script>
    <link rel="stylesheet" type="text/css" href="/simpleBook/css/activate_skip.css">
    <script src="/simpleBook/js/jquery-1.12.4.min.js"></script>
</head>
<body>
<div align="center"><img src="/simpleBook/images/邮箱.png" alt="email"/></div>
<div class="row center-align" align="center">

    <b>验证邮件已发送到您的电子邮箱：</b>

    <b class="blue-text text-darken-1" id="email"></b>

</div>

<div class="row center-align" align="center">

    <span>请收到后按提示操作，请在48小时内完成激活。</span>

</div>

<div class="row center-align" align="center">

    <a id="goEmail" href="" class="btn waves-light bluewaves-effect" target="_blank">前往邮箱激活</a>

</div>
</body>
</html>
