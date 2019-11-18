<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改密码</title>
</head>
<script src="/simpleBook/js/layui/layui.all.js" type="application/javascript" charset="UTF-8"></script>
<link href="/simpleBook/js/layui/css/layui.css" rel="stylesheet" type="text/css" media="all">
<body class="layui-bg-gray">
<div class="layui-col-md3">
    <div class="layui-card" style="width: 97%; height: 60%; margin: 0 auto;background-color: white;margin-top: 12px">
        <div class="layui-card-header">修改密码</div>
        <div class="layui-card-body">
            <form class="layui-form" method="post">
                <div class="layui-form-item">
                    <input type="hidden" class="layui-input" name="id" value="${admin.id}" autocomplete="off">
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">原密码</label>
                    <div class="layui-input-inline">
                        <input type="text" class="layui-input" name="oPwd" lay-verify="oPwd" autocomplete="off"
                               lay-verType="tips">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">新密码</label>
                    <div class="layui-input-inline">
                        <input type="text" class="layui-input" name="newPwd" lay-verify="newPwd" lay-verType="tips">
                    </div>
                    <label class="layui-word-aux layui-form-mid">6-16位新密码</label>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">确定密码</label>
                    <div class="layui-input-inline">
                        <input type="text" class="layui-input" name="conNewPwd" lay-verify="conNewPwd"
                               lay-verType="tips">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <input type="button" lay-submit class="layui-btn" id="submit" lay-filter="sub" value="确定修改">
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script>

    var $ = layui.jquery;
    var form = layui.form;
    var layer = layui.layer;
    var regExp = new RegExp("(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}");
    // 自定义表单验证
    form.verify({
        oPwd: function (value, item) {
            var oldPwd = "${sessionScope.admin.password}";
            if (value == null || value == "") {
                return "原密码不能为空"
            }
            if (!regExp.test(value)) {
                return "原密码格式错误";
            }
            if (oldPwd != value) {
                return "原密码错误,无法修改";
            }
        },
        newPwd: function (value, item) {
            if (value == null || value == "") {
                return "新密码不能为空";
            }
            if (!regExp.test(value)) {
                return "新密码格式错误";
            }
        },
        conNewPwd: function (value, item) {
            if (value == null || value == "") {
                return "确认密码不能为空";
            }

            if (!regExp.test(value)) {
                return "确认密码格式错误";
            }
            if (value != $("input[name='newPwd']").val()) {
                return "两次密码不同";
            }
        }
    });

    // 修改用户信息
    form.on("submit(sub)", function (data) {
        layer.alert(JSON.stringify(data.field))
    });

</script>
</body>
</html>