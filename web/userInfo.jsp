<%@ page import="com.bdqn.simplebook.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: ARong
  Date: 2019/12/18
  Time: 8:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>简简书-个人信息页</title>
    <link rel="icon" type="image/x-icon" href="/simpleBook/images/girl.png"/>
</head>
<%
    Object user = session.getAttribute("user");
    if (null == user) {
        response.sendRedirect(application.getContextPath() + "/index.jsp");
    }
%>
<style>
    * {
        padding: 0;
        margin: 0;
        list-style: none;
    }

    #bigPanel {
        width: 70%;
        height: 100%;
        display: flex; /*Flex布局*/
        display: -webkit-flex; /* Safari */
        align-items: center; /*指定垂直居中*/
        margin: 60px auto 0;
    }

    #option {
        width: 200px;
        display: inline-block;
        margin-right: 100px;
    }

    #option > li {
        border-radius: 3%;
        height: 40px;
        line-height: 35px;
        width: 200px;
        text-align: center;
    }

    #option > li span {
        font-family: -apple-system, SF UI Text, Arial, PingFang SC, Hiragino Sans GB, Microsoft YaHei, WenQuanYi Micro Hei, sans-serif;
        font-size: 16px;
        margin-left: 5px;
    }

    #option > li:hover {
        background: #F2F2F2;
        cursor: pointer;
    }

    #userInfo > div {
        border-bottom: 1px #F2F2F2 solid;
        margin-bottom: 10px;
        padding-bottom: 10px;
    }

    #userInfo > div:last-child {
        border-bottom: 0px;
    }

    .select {
        background: #F2F2F2;
    }
</style>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/layui/layui.js"></script>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/js/layui/css/layui.css">
<body>
<div id="bigPanel" style="height: 70%">
    <ul id="option">
        <li class="layui-icon layui-icon-username select" value="info"><span>个人信息</span></li>
        <li class="layui-icon layui-icon-password" value="change"><span>修改密码</span></li>
    </ul>
    <div id="userInfo" style="width: 40%;height: 100%;">
        <form class="layui-form" lay-filter="userInfo">
            <input type="hidden" value="" name="uid"/>
            <!--    头像  -->
            <div class="layui-form-item">
                <div class="layui-upload-list layui-input-inline">
                    <img class="layui-upload-img" id="portrait" src="" width="65px"
                         height="65px" style="display: inline-block;border-radius: 50%">
                    <button type="button" class="layui-btn layui-btn-primary layui-btn-radius layui-btn-sm" id="upload">
                        更换头像
                    </button>
                </div>
            </div>
            <div>
                <label>昵称：</label>
                <input class="layui-input layui-input-inline" value="" lay-verType="tips" id="nickName" name="uname"
                       lay-verify="nickName"/>
            </div>
            <div>
                <label>邮箱：</label>
                <input class="layui-input layui-input-inline" lay-verify="email" value="" name="email" readonly/>
            </div>
            <div>
                <label>生日：</label>
                <input class="layui-input layui-input-inline" lay-verType="tips" value="" id="bornthDay"
                       name="bornthDay"/>
            </div>
            <div>
                <label>余额：</label>
                <input class="layui-input layui-input-inline" value="" name="money" readonly/>
            </div>
            <div>
                <label>注册时间：</label>
                <input class="layui-input layui-input-inline" value="" readonly id="registerTime" name="registerTime"/>
            </div>
            <div class="layui-form-item">
                <label>性别：</label>
                <div>
                    <input type="radio" name="sex" value="1" title="男">
                    <input type="radio" name="sex" value="0" title="女">
                </div>
            </div>
            <div class="layui-form-item">
                <label>个人简介：</label>
                <textarea placeholder="请输入内容" lay-verify="profile" class="layui-textarea" name="profile"></textarea>
            </div>
            <input type="hidden" id="filePath" name="filePath" value=""/>
            <div>
                <input type="submit" lay-submit lay-filter="update" class="layui-btn layui-btn-primary layui-btn-lg"
                       width="100px"/>
                <input type="button" onclick="location.href='<%=request.getContextPath()%>/index.jsp'"
                       class="layui-btn layui-btn-primary layui-btn-lg" width="100px" value="返回首页"/>
            </div>
        </form>
    </div>
    <div id="changeUserPwd" style="display: none">
        <form class="layui-form" id="changPwd">
            <div class="layui-form-item">
                <label class="layui-form-label">原密码：</label>
                <input type="text" class="layui-input layui-input-inline" lay-verify="oldPwd" lay-vertype="tips"
                       name="oldPwd"/>
                <div class="layui-form-mid layui-word-aux">填写现在的密码</div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">新密码：</label>
                <input type="text" class="layui-input layui-input-inline" lay-verify="password" lay-vertype="tips"
                       name="password"/>
                <div class="layui-form-mid layui-word-aux">密码格式：6-16位英文数字组合而成</div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">确认密码：</label>
                <input type="text" class="layui-input layui-input-inline" lay-verify="password2" lay-vertype="tips"
                       name="password2"/>

            </div>
            <div class="layui-form-item">
                <label class="layui-form-label"></label>
                <button type="button" lay-submit lay-filter="changePwd" class="layui-btn layui-btn-sm">提交</button>
                <button type="button" class="layui-btn layui-btn-sm" onclick="location.href='/simpleBook/index.jsp'">返回首页</button>
            </div>
        </form>
    </div>
</div>
</body>
<script type="text/javascript">
    layui.use(["form", 'laydate', 'upload', 'jquery'], function () {
        var form = layui.form;
        var laydate = layui.laydate;
        var upload = layui.upload;
        var $ = layui.jquery;
        form.render();
        laydate.render({
            elem: "#bornthDay",
            type: "datetime"
        });

        // 右侧栏点击事件
        $("#option>li").click(function () {
            // 设置选中状态
            $(this).addClass("select");
            $("#option>li").not(this).removeClass("select");

            var value = $(this).attr("value");
            if (value == "info") {
                $("#userInfo").show();
                $("#changeUserPwd").hide();
            } else {
                $("#userInfo").hide();
                $("#changeUserPwd").show();
            }
        });

        form.verify({
            "nickName": function (value, item) {
                if (value == null || value == "") {
                    return "用户名不能为空";
                }
                if (value.length > 10 || value.length < 3) {
                    return "用户名格式不正确";
                }
            },
            "oldPwd": function (value, item) {
                if (value == null || value == "") {
                    return "旧密码不能为空！";
                }
                var flag=false;
                $.ajax({
                    url: "/simpleBook/user/verifyPwd",
                    data: {pwd: value},
                    type: "post",
                    async: false,
                    success: function (data) {
                        flag=data;
                    }, error: function () {
                        layer.msg("验证旧密码失败，请刷新后重试");
                    }
                });
                if (flag=="false") {
                    return "旧密码输入错误";
                }
            },
            "password": function (value, item) {
                if (value == null || value == "") {
                    return "新密码不能为空"
                }
                var password = /^[a-zA-Z0-9_-]{6,16}$/;
                if (!password.test(value)) {
                    return "密码格式不正确";
                }
            },
            "password2": function (value, item) {
                if (value == null || value == "") {
                    return "确定密码密码不能为空"
                }
                var pwd = $("input[name='password']").val();
                console.log(pwd+"---"+value)
                if (pwd != value) {
                    return "两次输入的密码不一致！";
                }
                var password = /^[a-z0-9_-]{6,18}$/;
                if (!password.test(value)) {
                    return "密码格式不正确";
                }
            }
        });

        form.on("submit(update)", function () {
            $.ajax({
                method: "post",
                url: "/simpleBook/user/addAndUpdate",
                data: $(":input").serializeArray(),
                success: function (data) {
                    console.log(data);
                    if (data.flag == true) {
                        layer.msg(data.msg, {icon: 1});
                    } else {
                        layer.msg(data.errorMsg, {icon: 2});
                    }
                }, error: function (data) {
                    layer.msg("服务器繁忙！", {icon: 2});
                }
            });
            return false;
        });

        form.on("submit(changePwd)", function () {

        });

        // 加载用户信息
        (function () {
            $.ajax({
                url: "/simpleBook/user/selectUser",
                type: "post",
                data: {uid: "${user.uid}", limit: 1, page: 1},
                success: function (data) {
                    var userInfo = data.data[0];
                    //给表单赋值
                    form.val("userInfo", { //formTest 即 class="layui-form" 所在元素属性 lay-filter="" 对应的值
                        "uname": userInfo.uname // "name": "value"
                        , "uid": userInfo.uid
                        , "email": userInfo.email
                        , "bornthDay": userInfo.bornthDay
                        , "money": userInfo.money
                        , "registerTime": userInfo.registerTime
                        , "profile": userInfo.profile
                        , "sex": userInfo.sex
                        , "filePath": userInfo.photo
                    });
                    $("#portrait").attr("src", "/simpleBook/resources/userPhoto/" + userInfo.photo)

                }, error: function () {
                    layer.msg("加载用户信息失败");
                }
            })
        })();

        // 文件上传
        upload.render({
            elem: "#upload"
            , url: "/simpleBook/user/uploadPhoto"
            , size: 1024 * 5
            , before: function (obj) {  // 上传前的回调函数
                // 实习图片预览
                obj.preview(function (index, file, result) {
                    $('#portrait').attr('src', result); //图片链接（base64）
                });
            }
            , done: function (res) {
                console.log(res);
                //如果上传失败
                if (res.flag == false) {
                    return layer.msg('头像上传失败', {icon: 2});
                } else {
                    $("#filePath").val(res.data);
                    return layer.msg("头像上传成功", {icon: 1});
                }
            }
            , error: function () {
                //演示失败状态，并实现重传
                return layer.msg("服务器繁忙,上传头像失败", {icon: 2})
            }
        });
    })
</script>
</html>
