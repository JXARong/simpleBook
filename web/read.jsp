<%--
  Created by IntelliJ IDEA.
  User: ko no dio da!
  Date: 2019/11/11
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        body {
            margin: 0px;
            padding: 0px;
            font-family: "Times New Roman", "Microsoft YaHei";
            background-color: #F9F9F9;
        }

        ul, ol {
            list-style: none;
        }

        .header {
            background-color: #ffffff;
            position: fixed;
            height: 58px;
            width: 100%;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.3);
            z-index: 1;
        }

        .middle {

        }

        .hidden {
            width: 682px;
            padding: 24px;
            background-color: #ff00ff;
            position: absolute;
            left: 450px;
        }
        .hidden>div:last-child{
            height: 100px;
            width: 100%;
            background-color: #ff0;
            float: left;
        }
        .left {
            position: fixed;
            left: 380px;
            top: 159px;
            color: #969696;
            font-size: 13px;
            text-align: center;
        }

        img {
            display: block;
        }

        .left_aside {
            width: 48px;
            height: 48px;
            line-height: 48px;
            background-color: rgb(255, 255, 255);
            box-shadow: 0 0 10px 5px rgba(245, 245, 245, 0.9);
        }

        .left img {
            position: relative;
            left: 12px;
            top: 12px;
        }

        #shang {
            position: relative;
            left: 10px;
            top: 10px;
        }

        .pointer {
            cursor: pointer;
        }

        .roundness {
            border-radius: 50%;
        }

        .right {
            width: 260px;
            height: 492px;
            position: absolute;
            left: 1191px;
            top: 68px;
            padding: 10px;
            border-radius: 4px;
        }

        .author {
            width: 228px;
            height: 45px;
            background: #fff;
            padding: 16px;
        }

        .inline_block {
            display: inline-block;
        }

        .reading {
            width: 228px;
            height: 363px;
            background: #fff;
            margin-top: 10px;
            padding: 16px;
        }

        .reading div + p {
            margin-top: 0px;
            float: left;
            margin-bottom: 8px;
        }

        .reading div:first-child {
            height: 18px;
            width: 4px;
            background-color: #f00;
            float: left;
            margin-top: 2px;
            margin-right: 10px;
        }

        .margin0px {
            margin: 0px;
        }

        .attention {
            height: 23px;
            width: 50px;
            border-radius: 20px;
            border: 1px solid #EC7259;
            outline: none;
            background-color: #fff;
            color: #EC7259;
        }

        .attention:hover {
            background-color: #F9F9F9;
        }

        .footer {
            position: fixed;
            background-color: #fff;
            z-index: 10;
            width: 100%;
            bottom: 0px;
            box-shadow: 0px -2px 10px rgba(0, 0, 0, 0.5);
        }

        .header > div {
            margin: 0px 13.78947368421053%;
            line-height: 58px;
        }

        . {
        }

        .header_left > a {
            color: rgb(236, 114, 89);
            text-decoration: none;
            font-size: 28px;
            font-weight: 500;
            display: inline-block;
            margin-right: 4%;
            float: left;
        }

        .header_left > a:hover {
            color: rgb(240, 141, 121);
        }

        .header_left > a:active {
            color: rgb(232, 87, 57);
        }

        .header_left > ul {
            display: inline-block;
            height: 58px;
            float: left;
            margin: 0px;
            margin-right: 16px;
        }

        .header_left ul li {
            float: left;
            background-color: #fff;
            height: 58px;
            width: 74px;
        }

        .header_left ul li a {
            display: inline-block;
            font-size: 17px;
            color: #000000;
            height: 58px;
            width: 74px;
            text-align: center;
            text-decoration: none;
        }

        .author img {
            float: left;
            border: 1px solid #EEEEEE;
        }

        .header_left ul li a:hover {
            background-color: rgb(242, 242, 242);
        }

        .search > form > input {
            width: 160px;
            height: 36px;
            padding: 10px;
            border: none;
            margin-top: 11px;
            outline: none;
            background-color: #F2F2F2;
            border-radius: 20px;
            padding-right: 40px;
        }

        .search > form > img {
            height: 36px;
            width: 36px;
            position: absolute;
            z-index: 1;
            bottom: 11px;
            left: 117px;
            box-sizing: border-box;
            padding: 6px;
            cursor: pointer;
        }

        .search {
            height: 58px;
            width: 200px;
            float: left;
            position: relative;
        }

        .header_right button {
            float: right;
            height: 40px;
            width: 108px;
            border-radius: 20px;
            border: none;
            outline: none;
            background: #EC7259;
            margin: 9px 0px;
            cursor: pointer;
        }

        .header_right button:hover {
            background: #ED7961;
        }

        .header_right button img {
            float: left;
            z-index: 1;
            height: 30px;
            width: 30px;
            padding-top: 5px;
        }

        .header_right button a {
            float: left;
            line-height: 40px;
            padding-left: 5px;
            font-size: 15px;
            color: #fff;
            text-decoration: none;
        }

        .search form img:hover {
            cursor: pointer;
        }

        .header_right_head img {
            margin-top: 8px;
            margin-left: 10px;
            height: 40px;
            width: 40px;
            border-radius: 50%;
            background-color: #000;
            margin-right: 100px;
        }

        .main + div img {
            height: 18px;
            width: 18px;
            padding: 6px;
            border-radius: 50%;
            border: 1px solid #f1f1f1;
            background: #fff;
        }

        .main + div {
            margin-top: 10px;
            position: relative;
        }

        .main + div p {
            color: #969696;
            margin: 5px 0px 0px 10px;
        }

        .main + div > div {
            padding: 6px;
            border: 1px solid #f1f1f1;
            margin-left: 10px;
            color: #969696;
        }

        .main + div > div:hover {
            cursor: pointer;
        }

        .main + div > ul > li {
            position: absolute;
            right: 0px;
            bottom: 5px;
            padding: 7px 10px;
            background-color: #F2F2F2;
            box-shadow: 0px 0px 10px #969696;
        }

        #report {
            display: none;
        }

        .line {
            height: 1px;
            width: 100%;
            background-color: rgba(35, 17, 6, 0.44);
            margin: 10px 0px;
        }

        .hidden_message {
            height: 225px;
            width: 100%;
            background-color: #f00;
            padding: 20px 0px;
            box-sizing: border-box;
        }

        .hidden_message > div:first-child > p {
            text-align: center;
            font-size: 18px;
        }

        .hidden_message > div:first-child > div {
            height: 40px;
            width: 100px;
            background-color: #f76;
            border-radius: 20px;
            margin: 0 auto;
            background: #EC7259;
            text-align: center;
            line-height: 40px;
            color: #FCFFF5;
        }

        .hidden_message > div:first-child > div:hover {
            color: #fff;
            background: #ED7961;
            cursor: pointer;
        }

        .hidden_message > div:last-child {
            height: 80px;
            width: 100%;
            margin-top: 25px;
            box-sizing: border-box;
            background-color: #FAFAFA;
        }

        .hidden_message > div:last-child img {
            height: 60px;
            width: 60px;
            padding: 10px;
        }

        .header_right_head {
            width: 80px;
            height: 58px;
            float: right;
            position: relative;
        }

        .header_right_head div {
            position: absolute;
            height: 0px;
            width: 0;
            border: 5px solid transparent;
            border-bottom: none;
            border-top: 5px solid #999999;
            left: 56px;
            bottom: 25px;
        }

        .header_right_head:hover {
            background-color: #F2F2F2;
        }

        img[src="images/font_zuan.png"] {
            position: absolute;
            bottom: 1px;
        }

        .font_zuan {
            position: relative;
            float: right;
            height: 56px;
            width: 113px;
        }

        .review {
            width: 100%;
            height: 36px;
            margin: 10px 0px;
            margin-left: 20%;
        }

        .review img {
            height: 24px;
            width: 24px;
            float: left;
        }

        .review form {
            float: left;
        }

        .review form textarea {
            outline: none;
            border: none;
            height: 36px;
            width: 400px;
            border-radius: 20px;
            padding: 10px 15px;
            background-color: #F2F2F2;
            resize: none;
        }

        li span {
            float: left;
            padding-left: 10px;
            color: #969696;
        }

        .review li {
            list-style: none;
            float: left;
            margin-top: 8px;
            padding: 0px 10px 0px 10px;
        }

        .review li:hover {
            cursor: pointer;
        }

        .review li a {
            text-decoration: none;
            color: #969696;
        }

        .review h1 {
            margin: 0px;

        }

        .right_head_text {
            position: absolute;
            top: 38px;
            width: 175px;
            padding-left: 6px;
        }

        .message_style_a {
            color: #000;
            text-decoration: none;
        }

        .message_style_p {
            color: #969696;
        }

        .textarea_focus {
            height: 72px !important;
            width: 500px !important;
            transition-property: height, width;
            transition-duration: 0.3s, 0.3s;
        }

        .fill {
            height: 77px;
            width: 100%;
        }

        .title {
            margin: 0px 0px 20px 0px;
            box-sizing: border-box;
        }

        .message {
            width: 100%;
            height: 80px;
            background-color: #00f;
            padding: 17px 0px;
            box-sizing: border-box;
        }

        .float_left {
            float: left;
        }

        .float_right {
            float: right;
        }

        .message_message {
            padding: 10px;
        }

        .message_message * {
            margin-right: 10px;
        }

        .register {
            width: 80px !important;
            margin-right: 10px !important;
            color: #EC7259;
            border: 1px solid #ec7259 !important;
            background: #fff !important;
            font-size: 16px;
        }

        .register:hover {
            background-color: #FEF8F7 !important;
        }

        .login {
            color: #969696;
            text-decoration: none;
            margin: 0px 15px 0px 10px;
        }

        .login:hover {
            color: #666666;
        }

        .height75 {
            height: 75px !important;
            transition-property: height;
            transition-duration: 0.5s;
        }
    </style>
    <script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript">
        window.onload = function () {
            document.getElementsByClassName("left_style")[0].onclick = function () {
                alert("666");
            }
            document.getElementsByClassName("left_style")[1].onclick = function () {
                alert("777");
            }
            document.getElementsByClassName("left_style")[2].onclick = function () {
                var time = setInterval(function () {
                    var top = document.body.scrollTop || document.documentElement.scrollTop;
                    console.log(top);
                    scroll(0, top - 40);
                    if (top <= 0) {
                        clearInterval(time);
                    }
                }, 1)
            }
            $("#review").click(function () {
                if (!$(".review").hasClass("height75")) {
                    $(".review").addClass("height75")
                    $("#review").addClass("textarea_focus");
                }
            })
            $("#report_button").click(function () {
                if ($("#report").is(":hidden")) {
                    $("#report").css(
                        {
                            display: "inline-block",
                            position: " absolute",
                            right: "0px",
                            bottom: "5px",
                            padding: "7px 10px",
                            background_color: "#F2F2F2",
                            box_shadow: "0px 0px 10px  #969696",
                        }
                    )
                } else {
                    $("#report").css(
                        {
                            display: "none",
                            position: " absolute",
                            right: "0px",
                            bottom: "5px",
                            padding: "7px 10px",
                            background_color: "#F2F2F2",
                            box_shadow: "0px 0px 10px  #969696",
                        }
                    )
                }
            })
        }
        window.onscroll = function () {
            if (document.body.scrollTop >= 100) {
                console.log(document.body.scrollTop)
                $(".reading").css(
                    {
                        position: "fixed",
                        top: 48
                    }
                )
            } else {
                $(".reading").css(
                    {
                        position: "static",
                        margin_top: "10px",
                        padding: "16px"
                    }
                )
            }
        }

    </script>
</head>
<body>

<header class="header">
    <div class="header_left">
        <a href="#">简·简书</a>
        <ul>
            <li><a href="/simpleBook/index.jsp">发现</a></li>
            <li><a href="#">关注</a></li>
        </ul>
        <div class="search">
            <form action="">
                <input type="text" placeholder="搜索">
                <img src="images/sousuo.png" alt="搜索">
            </form>
        </div>
    </div>
    <div class="header_right">
        <button>
            <img src="images/write.png" alt="">
            <a href="">写文章</a>
        </button>
        <c:choose>
            <c:when test="${user!=null}">
                <div class="header_right_head">
                    <img src="<c:choose>
            <c:when test="${user.photo!=null}">${user.photo}</c:when>
                <c:otherwise>images/default_head_portrait.jpg</c:otherwise>
            </c:choose>" alt="${user.uname}">
                    <div></div>
                </div>
            </c:when>
            <c:otherwise>
                <a href="register.html">
                    <button class="roundness register float_right">
                        注册
                    </button>
                </a>
                <a href="login.html" class="login float_right">登录</a>
            </c:otherwise>
        </c:choose>

        <div class="font_zuan">
            <img src="images/font_zuan.png" alt="">
        </div>
    </div>
</header>
<div class="middle">
    <div class="fill"></div>
    <div class="hidden">
        <h1 class="title">${test.title}</h1>
        <div class="message">
            <a href="">
                <img src="<c:choose>
            <c:when test="${test.user.photo!=null}">${test.user.photo}</c:when>
                <c:otherwise>images/default_head_portrait.jpg</c:otherwise>
            </c:choose>" height="45px" width="45px"
                     class="roundness inline_block float_left">
            </a>
            <div class="inline_block float_left message_message">
                <a href="" title="${test.user.uname}" class="message_style_a float_left">${test.user.uname}</a>
                <button class="attention float_left pointer">关注</button>
                <p class="margin0px message_style_p float_left">${test.sendDate} 阅读 ${test.readCount}</p>
            </div>
        </div>
        <div class="main">
            ${test.article}
        </div>
        <div>
            <img src="images/zan_gary.png" alt="" class="roundness float_left">
            <p class="float_left">${test.start}人点赞</p>
            <ul id="report">
                <li>举报文章</li>
            </ul>
            <div class="roundness float_right" id="report_button"><span>
                ···
            </span>
            </div>
            <p class="float_right"><c:choose>
                <c:when test="${test.topic!=null}">${test.topic}</c:when>
                <c:otherwise>笔记本</c:otherwise>
            </c:choose></p>
        </div>
        <div class="line float_left"></div>
        <div class="hidden_message float_left">
            <div>
                <p>"小礼物走一走，来简简书关注我"</p>
                <div><span>赞赏支持</span></div>
            </div>
            <div>
                <a href="">
                    <img src="<c:choose>
            <c:when test="${test.user.photo!=null}">${test.user.photo}</c:when>
                <c:otherwise>images/default_head_portrait.jpg</c:otherwise>
            </c:choose>" height="45px" width="45px"
                         class="roundness float_left">
                </a>
                <p class="float_left"></p>
                <div class="float_right"></div>
            </div>
        </div>
        <div>

        </div>
    </div>
    <div class="left">
        <div class="left_style pointer">
            <div class="left_aside roundness">
                <img src="images/zan_gary.png" height="24" width="24"/>
            </div>
            <label>${test.start}赞</label>
        </div>
        <div class="left_style pointer">
            <div class="left_aside roundness">
                <img src="images/shang_gary.png" height="30" width="30" id="shang"/>
            </div>
            <label>$${test.gratuity}</label>
        </div>
        <div class="left_style pointer">
            <div class="left_aside roundness">
                <img src="images/go_top.png" height="24" width="24"/>
            </div>
            <label>顶部</label>
        </div>
    </div>
    <div class="right">
        <div class="author">
            <a href="">
                <img src="<c:choose>
            <c:when test="${test.user.photo!=null}">${test.user.photo}</c:when>
                <c:otherwise>images/default_head_portrait.jpg</c:otherwise>
            </c:choose>" height="45px" width="45px" class="roundness inline_block">
            </a>
            <div class="inline_block right_head_text">
                <a href="" title="${test.user.uname}" class="message_style_a">${test.user.uname}</a>
                <button class="attention float_right pointer">关注</button>
            </div>

        </div>
        <div class="reading">
            <div></div>
            <p>推荐阅读</p>
            <div></div>
        </div>
    </div>
</div>
<div class="footer">
    <div class="review">
        <form action="">
            <textarea placeholder="写下你的评论..." id="review"></textarea>
        </form>
        <li><img src="images/review.png" alt=""><span>评论</span></li>
        <li><img src="images/zan_gary.png" alt=""><span>赞${test.start}</span></li>
        <li><a href=""><h1>···</h1></a></li>
    </div>
</div>
</body>
</html>
