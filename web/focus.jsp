<%--
  Created by IntelliJ IDEA.
  User: QZY
  Date: 2019/11/19
  Time: 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>关注-简书</title>
</head>
<link rel="stylesheet" href="/simpleBook/css/focus.css" type="text/css">
<link rel="stylesheet" href="/simpleBook/css/indexof.css" type="text/css">
<link rel="stylesheet" href="/simpleBook/js/layui/css/layui.css" type="text/css">
<script type="text/javascript" src="/simpleBook/js/layui/layui.all.js"></script>
<body>
<nav class="first_header" style="width: 66%; position: relative;left: 250px">

    <ul class="header_login">
        <li><a href="" style="color: orangered;font-size: 24px;position: relative;left: 50px;top: 5px">简·简书</a></li>
        <li><a href="" style="color: #b0b0b0;position: relative;top:5px;left:80px;font-size: 18px">发现</a>
        </li>
        <li><a href="" style="position: relative;left: 100px;top: 5px;color: #b0b0b0;font-size: 18px">关注</a></li>
        <li><a href="" style="position: relative;left: 120px;top: 5px;color: #b0b0b0;font-size: 18px">消息</a></li>
        <li>
            <input class="search_input" type="text" name="search" style="padding: 0 40px 0 20px;border-radius:40px;height: 38px;font-size: 14px;border: 1px solid #eee;background: #eee;width: 200px;position: relative;left: 140px;top:2px">
            <a href="" style="position: relative;left: 100px;z-index: 9999;font-size: 20px"><i class="layui-icon">&#xe615;</i></a>
        </li>
        <li><a href="" style="position: relative;left: 400px;top: 5px "><img src="/simpleBook/images/Aaa.png" ></a></li>
        <li><a href=""style="position: relative;left: 230px;top: 2px"><img src="/simpleBook/images/beastApp.png" ></a>
        </li>
        <li><a href="" style="position: relative;left:350px"><img src="images/sujectpetetou.png" style="height: 50px;width: 50px;border-radius: 50%;"><i class="layui-icon">&#xe625;</i></a></li>

        <li>
            <button type="button" class="layui-btn layui-btn-danger layui-btn-radius"
                    style="position: relative;left: 380px">写文章
            </button>
        </li>

    </ul>
</nav>
<section class="focus_mune" style="margin:0 auto">
    <div style="width: 30% ; float: left ;margin: 20px 0px 0px 0px;border-right: 1px solid #b0b0b0" class="foucs_menu">
        <ul>
          <li style="margin: 10px 0px;;background-color: #f0f0f0"><i class="layui-icon" style="color: blue;font-size: 40px;position: relative;right: 80px">&#xe770;<span style="font-size: 12px;color: black">添加关注</span></i></li>
          <li style="margin: 10px 0px;"><img src="/simpleBook/images/sujectpetetou.png" alt="" style="width: 45px ;height: 45px ; border-radius: 50%;position: relative;right: 90px"><b style="font-size: 12px;position: relative;right: 80px">摄影</b></li><li style="margin: 10px 0px;"><img src="/simpleBook/images/sujectpetetou.png" alt="" style="width: 45px ;height: 45px ; border-radius: 50%;position: relative;right: 90px"><b style="font-size: 12px;position: relative;right: 80px">摄影</b></li>
            <li style="margin: 10px 0px;"><img src="/simpleBook/images/sujectpetetou.png" alt="" style="width: 45px ;height: 45px ; border-radius: 50%;position: relative;right: 90px"><b style="font-size: 12px;position: relative;right: 80px">摄影</b></li>
        </ul>
    </div>
<div class="layui-tab layui-tab-brief  focus_right" lay-filter="docDemoTabBrief" style="width: 65%;float: right;margin: 20px 0px 0px 20px">
    <ul class="layui-tab-title focus_filter">

        <li  class="layui-this"style=" font-size: 18px"><i class="layui-icon">&#xe612;&nbsp;</i>用户管理</li>
        <li style=" font-size: 18px"> <i class="layui-icon">&#xe653;&nbsp;</i>权限分配</li>
    </ul>
    <div class="layui-tab-content focus_guanzhu" style="height: 100px">

<div class="layui-tab-item">
    <ul>
        <li >
            <img src="/simpleBook/images/sujectpetetou.png" style="height: 50px;width: 50px" name="focus_img">
            <h3 style="position: relative;bottom: 50px ;left: 70px" name="focus_title">摄影</h3>
            <p style="position: relative;left: 70px ;bottom: 50px;color:#b0b0b0" name="focus_content">我是东京哦洒家打开撒娇到时间东京哦阿姐滴哦窘境送到家</p>
            <button type="button" class="layui-btn layui-btn-radius"  style="position:relative; left: 500px;bottom: 80px;width: 80px;height: 40px;font-size:20px">+关注</button>
            <a href=""style="position: relative;left: -30px;bottom: 50px"><i class="layui-icon" style="font-size: 10px;color:#b0b0b0 ">&#xe653;148.8K篇文章 · 2513.1K人关注</i></a>
        </li>
        <li >
            <img src="/simpleBook/images/sujectpetetou.png" style="height: 50px;width: 50px" name="focus_img">
            <h3 style="position: relative;bottom: 50px ;left: 70px" name="focus_title">摄影</h3>
            <p style="position: relative;left: 70px ;bottom: 50px;color:#b0b0b0" name="focus_content">我是东京哦洒家打开撒娇到时间东京哦阿姐滴哦窘境送到家</p>
            <button type="button" class="layui-btn layui-btn-radius"  style="position:relative; left: 500px;bottom: 80px;width: 80px;height: 40px;font-size:20px">+关注</button>
            <a href=""style="position: relative;left: -30px;bottom: 50px"><i class="layui-icon" style="font-size: 10px;color:#b0b0b0 ">&#xe653;148.8K篇文章 · 2513.1K人关注</i></a>
        </li>
        <li >
            <img src="/simpleBook/images/sujectpetetou.png" style="height: 50px;width: 50px" name="focus_img">
            <h3 style="position: relative;bottom: 50px ;left: 70px" name="focus_title">摄影</h3>
            <p style="position: relative;left: 70px ;bottom: 50px;color:#b0b0b0" name="focus_content">我是东京哦洒家打开撒娇到时间东京哦阿姐滴哦窘境送到家</p>
            <button type="button" class="layui-btn layui-btn-radius"  style="position:relative; left: 500px;bottom: 80px;width: 80px;height: 40px;font-size:20px">+关注</button>
            <a href=""style="position: relative;left: -30px;bottom: 50px"><i class="layui-icon" style="font-size: 10px;color:#b0b0b0 ">&#xe653;148.8K篇文章 · 2513.1K人关注</i></a>
        </li>
        <li >
            <img src="/simpleBook/images/sujectpetetou.png" style="height: 50px;width: 50px" name="focus_img">
            <h3 style="position: relative;bottom: 50px ;left: 70px" name="focus_title">摄影</h3>
            <p style="position: relative;left: 70px ;bottom: 50px;color:#b0b0b0" name="focus_content">我是东京哦洒家打开撒娇到时间东京哦阿姐滴哦窘境送到家</p>
            <button type="button" class="layui-btn layui-btn-radius"  style="position:relative; left: 500px;bottom: 80px;width: 80px;height: 40px;font-size:20px">+关注</button>
            <a href=""style="position: relative;left: -30px;bottom: 50px"><i class="layui-icon" style="font-size: 10px;color:#b0b0b0 ">&#xe653;148.8K篇文章 · 2513.1K人关注</i></a>
        </li>
        <button type="button" class="layui-btn layui-btn-radius" style="font-size: 20px;width: 100%;height: 30px;line-height: 30px;color: white">查看更多</button>
    </ul>
</div>
<div class="layui-tab-item">
    <ul>
        <li >
            <img src="/simpleBook/images/sujectpetetou.png" style="height: 50px;width: 50px" name="focus_img">
            <h3 style="position: relative;bottom: 50px ;left: 70px" name="focus_title">摄影</h3>
            <p style="position: relative;left: 70px ;bottom: 50px;color:#b0b0b0" name="focus_content">我是东京哦洒家打开撒娇到时间东京哦阿姐滴哦窘境送到家</p>
            <button type="button" class="layui-btn layui-btn-radius"  style="position:relative; left: 500px;bottom: 80px;width: 80px;height: 40px;font-size:20px">+关注</button>
            <a href=""style="position: relative;left: -30px;bottom: 50px"><i class="layui-icon" style="font-size: 10px;color:#b0b0b0 ">&#xe653;148.8K篇文章 · 2513.1K人关注</i></a>
        </li>
        <li >
            <img src="/simpleBook/images/sujectpetetou.png" style="height: 50px;width: 50px" name="focus_img">
            <h3 style="position: relative;bottom: 50px ;left: 70px" name="focus_title">摄影</h3>
            <p style="position: relative;left: 70px ;bottom: 50px;color:#b0b0b0" name="focus_content">我是东京哦洒家打开撒娇到时间东京哦阿姐滴哦窘境送到家</p>
            <button type="button" class="layui-btn layui-btn-radius"  style="position:relative; left: 500px;bottom: 80px;width: 80px;height: 40px;font-size:20px">+关注</button>
            <a href=""style="position: relative;left: -30px;bottom: 50px"><i class="layui-icon" style="font-size: 10px;color:#b0b0b0 ">&#xe653;148.8K篇文章 · 2513.1K人关注</i></a>
        </li>
        <li >
            <img src="/simpleBook/images/sujectpetetou.png" style="height: 50px;width: 50px" name="focus_img">
            <h3 style="position: relative;bottom: 50px ;left: 70px" name="focus_title">摄影</h3>
            <p style="position: relative;left: 70px ;bottom: 50px;color:#b0b0b0" name="focus_content">我是东京哦洒家打开撒娇到时间东京哦阿姐滴哦窘境送到家</p>
            <button type="button" class="layui-btn layui-btn-radius"  style="position:relative; left: 500px;bottom: 80px;width: 80px;height: 40px;font-size:20px">+关注</button>
            <a href=""style="position: relative;left: -30px;bottom: 50px"><i class="layui-icon" style="font-size: 10px;color:#b0b0b0 ">&#xe653;148.8K篇文章 · 2513.1K人关注</i></a>
        </li>
        <li >
            <img src="/simpleBook/images/sujectpetetou.png" style="height: 50px;width: 50px" name="focus_img">
            <h3 style="position: relative;bottom: 50px ;left: 70px" name="focus_title">摄影</h3>
            <p style="position: relative;left: 70px ;bottom: 50px;color:#b0b0b0" name="focus_content">我是东京哦洒家打开撒娇到时间东京哦阿姐滴哦窘境送到家</p>
            <button type="button" class="layui-btn layui-btn-radius"  style="position:relative; left: 500px;bottom: 80px;width: 80px;height: 40px;font-size:20px">+关注</button>
            <a href=""style="position: relative;left: -30px;bottom: 50px"><i class="layui-icon" style="font-size: 10px;color:#b0b0b0 ">&#xe653;148.8K篇文章 · 2513.1K人关注</i></a>
        </li>
        <button type="button" class="layui-btn layui-btn-radius" style="font-size: 20px;width: 100%;height: 30px;line-height: 30px;color: white">查看更多</button>
    </ul>
</div>
</div>
</div>
</section>
</body>
</html>
