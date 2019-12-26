<%--
  Created by IntelliJ IDEA.
  User: ARong
  Date: 2019/12/25
  Time: 0:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试个人中心</title>
</head>
<script type="text/javascript" src="/simpleBook/js/layui/layui.js"></script>
<link rel="stylesheet" type="text/css" href="/simpleBook/js/layui/css/layui.css">
<style>
    *{
        padding: 0;
        margin: 0;
        list-style: none;
    }
    #bigPanel{
        width: 70%;
        height: 100%;
        display:flex;/*Flex布局*/
        display: -webkit-flex; /* Safari */
        align-items:center;/*指定垂直居中*/
        margin: 60px auto 0;
    }
    #option{
        width: 200px;
        display: inline-block;
        margin-right: 100px;
    }
    #option>li{
        border-radius: 3%;
        height: 40px;
        line-height: 35px;
        width: 200px;
        text-align: center;
    }
    #option>li span{
        font-family: -apple-system,SF UI Text,Arial,PingFang SC,Hiragino Sans GB,Microsoft YaHei,WenQuanYi Micro Hei,sans-serif;
        font-size: 16px;
        margin-left: 5px;
    }
    #option>li:hover{
        background: #F2F2F2;
        cursor: pointer;
    }
    #userInfo>div{
        border-bottom: 1px #F2F2F2 solid;
        margin-bottom: 10px;
        padding-bottom:10px;
    }
    #userInfo>div:last-child{
        border-bottom: 0px;
    }
    .select{
        background: #F2F2F2;
    }
</style>
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
                        <button type="button" class="layui-btn layui-btn-primary layui-btn-sm" id="upload" style="margin-left: 20px">更换头像</button>
                    </div>
                </div>
                <div>
                    <label>昵称：</label>
                    <input class="layui-input layui-input-inline" value="" lay-verType="tips" id="nickName" name="uname" lay-verify="nickName" />
                </div>
                <div>
                    <label>邮箱：</label>
                    <input class="layui-input layui-input-inline" lay-verify="email" value="" name="email"  readonly/>
                </div>
                <div>
                    <label>生日：</label>
                    <input class="layui-input layui-input-inline" lay-verType="tips" value=""  id="bornthDay" name="bornthDay" />
                </div>
                <div>
                    <label>余额：</label>
                    <input class="layui-input layui-input-inline" value="" name="money" readonly />
                </div>
                <div>
                    <label>注册时间：</label>
                    <input class="layui-input layui-input-inline" value="" readonly id="registerTime" name="registerTime" />
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
                    <input type="submit" lay-submit  lay-filter="update" class="layui-btn layui-btn-primary layui-btn-lg" width="100px"/>
                    <input type="button"  onclick="location.href='<%=request.getContextPath()%>/index.jsp'" class="layui-btn layui-btn-primary layui-btn-lg" width="100px" value="返回首页"/>
                </div>
            </form>
        </div>
        <div id="changeUserPwd">
            <form class="layui-form" id="changPwd">
                <div class="layui-form-item">
                    <label class="layui-form-label">原密码：</label>
                    <input type="text" class="layui-input layui-input-inline" name="oldPwd"/>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">新密码：</label>
                    <input type="text" class="layui-input layui-input-inline" name="oldPwd"/>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">确认密码：</label>
                    <input type="text" class="layui-input layui-input-inline" name="oldPwd"/>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label"></label>
                    <button type="button" class="layui-btn layui-btn-sm">提交</button>
                    <button type="button" class="layui-btn layui-btn-sm">返回首页</button>
                </div>
            </form>
        </div>
    </div>
</body>
<script type="text/javascript">
    layui.use(["form",'laydate','upload','jquery'],function () {
        var form = layui.form;
        var laydate = layui.laydate;
        var upload = layui.upload;
        var $ = layui.jquery;
        form.render();
        laydate.render({
            elem: "#bornthDay",
            type: "datetime"
        });


    });
</script>
</html>
