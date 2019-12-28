<%--
  Created by IntelliJ IDEA.
  User: ARong
  Date: 2019/12/28
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>举报文章</title>
    <script src="/simpleBook/js/layui/layui.js"></script>
    <link rel="stylesheet" href="/simpleBook/js/layui/css/layui.css">
</head>
<script type="text/javascript">
    layui.use(['jquery', 'layer'], function () {
        var $ = layui.jquery;
        var layer = layui.layer;
        $("#sub").click(function () {
            var pid = $("#pid").val();
            var uid = $("#uid").val();
            var content = $("#content").val();
            $.ajax({
                url: "/simpleBook/report/addReport",
                data: {uid: uid, pid: pid, content: content},
                type: "post",
                success: function (data) {
                    if (data) {
                        layer.msg("提交举报信息成功，请耐心等待！届时会通过邮箱通知您");
                    } else {
                        layer.msg("服务器繁忙，举报失败");
                    }
                }, error: function () {
                    layer.msg("举报失败！");
                }
            })
        });
    })
</script>
<body>
<form class="layui-form">
    <input type="hidden" id="pid" value="">
    <input type="hidden" id="uid" value="${user.uid}">
    <div class="layui-form-item">
        <label class="layui-form-label">举报文章</label>
        <div class="layui-form-mid layui-word-aux" style="color: black" id="title"></div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">举报原因</label>
        <textarea cols="40" rows="10" placeholder="请输入举报原因" id="content"></textarea>
    </div>
    <button type="button" id="sub"></button>
</form>

</body>
</html>
