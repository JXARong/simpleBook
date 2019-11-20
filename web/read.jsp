<%--
  Created by IntelliJ IDEA.
  User: ko no dio da!
  Date: 2019/11/11
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            height: 10000px;
            padding: 24px;
            background-color: #ff00ff;
            position: absolute;
            left: 450px;
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

        .left_style label, .left_style img:hover {
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
        .attention:hover{
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

        .footer div {
            margin-left: 20%;
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
        .author img{
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
            width: 400px;
            height: 36px;
            float: left;
            margin: 10px 0px;
        }
        .review img{
            height: 40px;
            width: 40px;
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
        .right_head_text{
            position: absolute;
            top: 31px;
            width: 175px;
            padding-left: 6px;
        }
        .message_style_a{
            color: #000;
            text-decoration: none;
        }
        .message_style_p{
            color: #969696;
        }
        .review form textarea:focus {
            height: 72px;
            width: 500px;
        }
        .fill{
            height: 77px;
            width: 100%;
        }
        .title{
            margin: 0px 0px 20px 0px;
           box-sizing: border-box;
        }
        .message{
            width: 100%;
            height: 80px;
            background-color: #00f;
            padding: 17px 0px;
            box-sizing: border-box;
        }
        .float_left{
            float: left;
        }
        .float_right{
            float: right;
        }
        .message_message{
            padding: 10px;
        }
        .message_message *{
            margin-right: 10px;
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
        }
        var fixedDom = document.getElementsByClassName("reading")[0];
        window.onscroll = function () {
            if (document.body.scrollTop >= 100) {

            } else {
                fixedDom.style.position = "relative";
            }
        }
        var riview = document.getElementById("riview");
        riview.onfocus = function () {
            alert(666)
        }
    </script>
</head>
<body>

<header class="header">
    <div class="header_left">
        <a href="#">简·简书</a>
        <ul>
            <li><a href="#">发现</a></li>
            <li><a href="#">关注</a></li>
            <li><a href="#">消息</a></li>
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
        <div class="header_right_head">
            <img src="images/default_head_portrait.jpg" alt="">
            <div></div>
        </div>
        <div class="font_zuan">
            <img src="images/font_zuan.png" alt="">
        </div>
    </div>
</header>
<div class="middle">
    <div class="fill"></div>
    <div class="hidden">
        <h1 class="title">二十五个字二十五个字二十五个字二十五个字二</h1>
        <div class="message">
            <img src="images/default_head_portrait.jpg" height="45px" width="45px" class="roundness inline_block float_left">
            <div class="inline_block float_left message_message">
                <a href="" title="ig666" class="message_style_a float_left">ig666</a>
                <button class="attention float_left">关注</button>
                <p class="margin0px message_style_p float_left">2019.10.29 12:49:29 字数 707 阅读 3,202</p>
            </div>
        </div>
    </div>
    <div class="left">
        <div class="left_style">
            <div class="left_aside roundness">
                <img src="images/zan_gary.png" height="24" width="24"/>
            </div>
            <label>点赞</label>
        </div>
        <div class="left_style">
            <div class="left_aside roundness">
                <img src="images/shang_gary.png" height="30" width="30" id="shang"/>
            </div>
            <label>打赏</label>
        </div>
        <div class="left_style">
            <div class="left_aside roundness">
                <img src="images/go_top.png" height="24" width="24"/>
            </div>
            <label>顶部</label>
        </div>
    </div>
    <div class="right">
        <div class="author">
            <img src="images/default_head_portrait.jpg" height="45px" width="45px" class="roundness inline_block">
            <div class="inline_block right_head_text">
                <a href="" title="ig666" class="message_style_a">ig666</a>
                <button class="attention float_right">关注</button>
                <p class="margin0px message_style_p">hui</p>
            </div>

        </div>
        <div class="reading">

        </div>
    </div>
</div>
<div class="footer">
    <div class="review">
        <form action="">
            <textarea placeholder="写下你的评论..." id="review"></textarea>
        </form>
        <img src="images/review.png" alt="">
        <img src="images/zan_black.png" alt="">
    </div>
</div>
</body>
</html>
