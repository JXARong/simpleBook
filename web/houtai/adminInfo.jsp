<%--
  Created by IntelliJ IDEA.
  User: 17779
  Date: 2019/11/8
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理员信息表</title>
</head>
<link rel="stylesheet" href="/simpleBook/js/layui/css/layui.css" media="all">
<script src="/simpleBook/js/layui/layui.js" charset="utf-8"></script>
<body>
<div class="layui-card" style="width: 97%; height: 70%; margin: 0 auto;background-color: white;margin-top: 12px">
    <div class="layui-card-header" id="title"></div>
    <div class="layui-card-body">
        <form class="layui-form" lay-filter="adminInfo">
            <input type="hidden" name="id" id="id" value="${sessionScope.admin.id}"/>
            <div class="layui-form-item">
                <label class="layui-form-label">用户名</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input " id="username" required lay-requered="username" readonly
                           name="username"
                           value="">
                </div>
                <label class="layui-form-mid layui-word-aux">用于登录后台，不可修改</label>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">邮箱</label>
                <div class="layui-input-inline">
                    <input type="email" class="layui-input" id="email" placeholder="必填" required lay-verify="email"
                           lay-reqText="请输入正确的邮箱" name="email" value="">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">头像</label>
                <div class="layui-input-inline">
                    <img src="" id="portrait" alt="头像"
                         style="width: 50px;height: 50px;" class="layui-input-inline">
                    <div class="layui-upload" style="padding: 10px 0 0 20px;">
                        <button type="button" class="layui-btn layui-btn-sm" id="uploadPhoto">上传图片</button>
                    </div>
                    <input type="hidden" id="fileName" name="fileName" value="">
                </div>
                <label class="layui-word-aux layui-form-mid">不填写则使用默认头像</label>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">联系电话</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" name="phone" id="phone" value="">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">性别</label>
                <div class="layui-input-block" id="sex">
                    <input type="radio" value="1" name="sex" title="男"/>
                    <input type="radio" value="0" name="sex" title="女">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <input type="button" class="layui-btn" lay-filter="updateInfo" lay-submit id="submit" value="修改">
                    <input type="button" class="layui-btn" id="reset" value="重置">
                </div>
            </div>
        </form>
    </div>
</div>
</body>
<script type="application/javascript">
    layui.use(["form", 'upload', 'jquery'], function () {
        var form = layui.form;
        var upload = layui.upload;
        var $ = layui.jquery;

        var uploadResult = false;
        // 文件上传
        var uploadInst = upload.render({
            elem: "#uploadPhoto",
            auto: true,
            url: "<%=request.getContextPath()%>/photo/uploadPhoto",
            size: 1024 * 5,
            choose: function (obj) {
                // 上传前显示在页面中
                obj.preview(function (index, file, result) {
                    $('#portrait').attr('src', result);
                })
            }, done: function (res, index, upload) {
                uploadResult = true;
                // 上传成功，将返回的随机文件名称赋值到隐藏域中
                $("#fileName").val(res.data);
            },
        });

        // 重置表单数据
        $("#reset").on("click", function () {
            // 重新加载信息
            loadAdminInfo();
            deletePhoto();
        });

        // 删除图片
        function deletePhoto(){
            // 若图片上传成功点了重置按钮，将删除刚刚上传的文件
            if (uploadResult){
                $.ajax({
                    url:"<%=request.getContextPath()%>/photo/delPhoto",
                    method:"post",
                    data:{fileName:$("#fileName").val()},
                    success:function (data) {
                        uploadResult=false;
                    },error:function () {

                    }
                });
            }
        }

        // 提交按钮点击事件
        form.on("submit(updateInfo)",function (data) {
            $.ajax({
                url:"<%=request.getContextPath()%>/admin/updateInfo",
                method:"post",
                data:$("form").serialize(),
                dataType:"json",
                success:function (data) {
                    if (data.flag==true){
                        layer.msg(data.msg,{icon:6});
                    } else{
                        layer.msg(data.errorMsg,{icon:2});
                    }
                },error:function () {
                    layer.msg("服务器繁忙,修改失败",{icon:2});
                }
            });
        });

        // 加载管理员信息
        function loadAdminInfo() {
            $.ajax({
                url: "<%=request.getContextPath()%>/admin/selAdminById",
                method: "post",
                data: {id: $("#id").val()},
                dataType: "json",
                success: function (data) {
                    console.log(data);
                    if (data.flag == true) {
                        $("#title").text(data.data.username + "-管理员信息");
                        $("#username").val(data.data.username);
                        $("#email").val(data.data.email);
                        $("#portrait").attr("src", "/simpleBook/resources/userPhoto/" + data.data.portrait);
                        $("#phone").val(data.data.phone);
                        $("#fileName").val(data.data.portrait);
                        $("input:radio[value='1']").prop("checked", data.data.sex == 1 ? true : false);
                        $("input:radio[value='0']").prop("checked", data.data.sex == 0 ? true : false);
                        form.render(null, "adminInfo");
                    } else {
                        layer.msg(data.errorMsg + ",正在为您转跳至登录页面", {icon: 2});
                        setTimeout(function () {
                            parent.location.href = "<%=request.getContextPath()%>/houtai/login.html";
                        }, 2000);
                    }
                }, error: function () {
                    layer.msg("获取管理员信息异常", {icon: 2});
                }
            });
        }

        // 加载管理员信息
        loadAdminInfo();
        form.render();
    });
</script>
</html>
