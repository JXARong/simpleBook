<%--
  Created by IntelliJ IDEA.
  User: ARong
  Date: 2019/12/18
  Time: 8:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>简简书-个人信息页</title>
</head>
<style>
    .layui-form>div{
        margin-bottom: 20px;
    }
    .layui-form{
        margin-top: 20px;
    }
</style>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/layui/layui.js"></script>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/js/layui/css/layui.css">
<body>
    <div style="width: 20%;margin: 0 auto">
        <form class="layui-form">
            <input type="hidden" value="${user.uid}" name="id"/>
            <div class="layui-form-item">
                <img src="/simpleBook/images/girl.png" style="display: inline-block; width:70px;height:70px;border-radius: 50%" style="margin-right: 50px"/>
                <button class="layui-btn layui-btn-primary layui-btn-radius layui-btn-sm">更换头像</button>
            </div>
            <div>
                <label>昵称：</label>
                <input class="layui-input layui-input-inline" id="nickName" id="nickName" lay-verify="nickName" value="HelloWorld"/>
            </div>
            <div>
                <label>邮箱：</label>
                <input class="layui-input layui-input-inline" name="email" value="1131111310@qq.com" readonly/>
            </div>
            <div>
                <label>生日：</label>
                <input class="layui-input layui-input-inline" id="birthDay" name="birthDay" value="HelloWorld"/>
            </div>
            <div>
                <label>余额：</label>
                <input class="layui-input layui-input-inline" name="money" readonly value="111"/>
            </div>
            <div>
                <label>注册时间：</label>
                <input class="layui-input layui-input-inline" readonly id="registerTime" name="registerTime" value="2019-12-12"/>
            </div>
            <div class="layui-form-item">
                <label>性别：</label>
                <div>
                    <input type="radio" name="sex" value="男" title="男" checked="">
                    <input type="radio" name="sex" value="女" title="女">
                </div>
            </div>
            <div class="layui-form-item">
                <label>个人简介：</label>
                    <textarea placeholder="请输入内容" class="layui-textarea" name=""></textarea>
            </div>
            <div>
                <input type="submit" lay-even="submit" lay-filter="update" class="layui-btn layui-btn-primary layui-btn-radius layui-btn-lg" width="100px"/>
            </div>
        </form>
    </div>
</body>
<script type="text/javascript">
    layui.use(["form",'laydate'],function () {
        var form=layui.form;
        var laydate = layui.laydate;
        form.render();
        laydate.render({
            elem:"#birthDay",
            type:"datetime"
        });
        form.verify({
            "nickName":function (value,item) {

            },
            "":function (value,item) {

            }
        })
    })
</script>
</html>
