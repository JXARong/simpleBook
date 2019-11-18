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
        <div class="layui-card-header">${sessionScope.admin.username}-基本资料</div>
        <div class="layui-card-body">
            <form action="" class="layui-form" enctype="multipart/form-data">
                <div class="layui-form-item">
                    <label class="layui-form-label">用户名</label>
                    <div class="layui-input-inline">
                        <input type="text" class="layui-input " required lay-requered="username" readonly name="username" value="${admin.username}">
                    </div>
                    <label class="layui-form-mid layui-word-aux">用于登录后台，不可修改</label>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">邮箱</label>
                    <div class="layui-input-inline">
                        <input type="email" class="layui-input" placeholder="必填" required lay-verify="email" lay-reqText="请输入正确的邮箱" name="email" value="${admin.email}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">头像</label>
                    <div class="layui-input-inline">
                        <img src="/simpleBook/portrait/${admin.portrait}" id="portrait" alt="头像" style="width: 50px;height: 50px;" class="layui-input-inline">
                        <div class="layui-upload" style="padding: 10px 0 0 20px;">
                            <button type="button" class="layui-btn layui-btn-sm" id="uploadPhoto">上传图片</button>
                        </div>
                    </div>
                    <label class="layui-word-aux layui-form-mid">不填写则使用默认头像</label>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">联系电话</label>
                    <div class="layui-input-inline">
                        <input type="text" class="layui-input" name="phone" value="${admin.phone}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">性别</label>
                    <div class="layui-input-block">
                        <input type="radio" value="1" name="sex" title="男" <c:if test="${admin.sex==1}">checked</c:if>/>
                        <input type="radio" value="1" name="sex" title="女" <c:if test="${admin.sex==0}">checked</c:if>>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <input type="button" class="layui-btn" id="submit" value="修改">
                        <input type="button" class="layui-btn" id="reset" value="重置">
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
<script type="application/javascript">
    layui.use(["form",'upload','jquery'],function () {
       var form = layui.form;
       var upload = layui.upload;
       var $ = layui.jquery;
       // 文件上传
      var uploadInst = upload.render({
          elem:"#uploadPhoto",
          auto:false,
          bindAvtion:"#submit",
          field:"protrait",
          size:1024*5,
          choose:function (obj) {
              obj.preview(function (index,file,result) {
                  $('#portrait').attr('src', result);
              })
          }
      });

      $("#submit").click(function () {
          var data=new FormData();
         console.log($("input[type='file']").val());
      });

       form.render();
    });
</script>
</html>
