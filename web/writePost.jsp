<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Layui</title>
</head>
<%
    Object user = session.getAttribute("user");
    if (null == user) {
        response.sendRedirect(application.getContextPath() + "/login.html");
    }
%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/layui/layui.js"></script>
<link href="<%=request.getContextPath()%>/js/layui/css/layui.css" rel="stylesheet" type="text/css" media="all">
<body style="background-color: #F2F2F2;padding: 5px">

<div class="layui-fluid">
    <div class="layui-row layui-col-space10">

        <%--        // 最近发布的十个帖子--%>
        <div class="layui-col-md2">
            <div class="layui-card">
                <div class="layui-card-body">
                    <div>
                        <div>
                            <ul id="postList">
                                <li>
                                    <b>人生低谷时、尽量多睡觉，少说话、多看书…</b>
                                    <p>
                                        《道德经》里说：多言数穷，不如守中。
                                        意思是，人说的话太多，常常会让自己陷入困境，不如将一些话放在心里，保持谦卑的姿态。
                                    </p>
                                </li>
                                <li>
                                    <b>你好您好您好你好你好你好你好</b>
                                    <p>节流阀京东方开房记录范德萨减肥啦电脑卡V领打升级浪费简单示例女克里斯丁朵女郎你上课辣椒粉来得及；</p>
                                </li>
                                <li>
                                    <b>你好您好您好你好你好你好你好</b>
                                    <p>节流阀京东方开房记录范德萨减肥啦电脑卡V领打升级浪费简单示例女克里斯丁朵女郎你上课辣椒粉来得及；</p>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%--            发布文章板块--%>
        <div class="layui-col-md8">
            <div class="layui-card">
                <div class="layui-card-body">
                    <div>
                        <form class="layui-form">
                            <div class="layui-form-item">
                                <label class="layui-form-label">标题：</label>
                                <input type="text" class="layui-input layui-input-block" id="title" lay-verType="tips"
                                       lay-verify="title" style="width: 50%"/>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">主题：</label>
                                <div class="layui-input-inline" style="width: 50%">
                                    <select name="modules" required lay-verify="required" id="topics" lay-verType="tips"
                                            lay-search="">
                                    </select>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label class="layui-form-label">文章正文：</label>
                                <div class="layui-input-inline" style="width:80%">
                                    <textarea id="context"></textarea>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label"></label>
                                <button type="button" lay-submit lay-filter="sendPost"
                                        class="layui-btn layui-btn-primary">发布
                                </button>
                                <button type="button" onclick="location.href='<%=request.getContextPath()%>/index.jsp'"
                                        class="layui-btn layui-btn-primary">返回主页
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <%--            个人简介--%>
        <div class="layui-col-md2">
            <div class="layui-card">
                <div class="layui-card-body">
                    <div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    layui.use(['form', 'jquery', 'layedit'], function () {
        var form = layui.form,
            $ = layui.jquery,
            edit = layui.layedit;
        form.render();
        var editIndex = edit.build("context", {
            height: "65%",
            tool: [
                'strong' //加粗
                , 'italic' //斜体
                , 'underline' //下划线
                , 'del' //删除线

                , '|' //分割线

                , 'left' //左对齐
                , 'center' //居中对齐
                , 'right' //右对齐
                , 'link' //超链接
                , 'unlink' //清除链接
                , 'face' //表情
                , 'help' //帮助
            ]
        });

        // 加载主题信息,立即执行函数，只加载一次
        (function () {
            $.ajax({
                url: "<%=request.getContextPath()%>/topic/selAllTopic",
                type: "get",
                success: function (data) {
                    $.each(data, function (index, item) {
                        $("#topics").append(new Option(item.topic, item.topicId));
                    });
                    form.render();
                }, error: function () {
                    layer.msg("加载主题失败，请刷新重试", {icon: 2});
                }
            });
        })();
        // 验证信息是否填写正确
        form.verify({
            "title": function (value, item) {
                if (value == null || value == "") {
                    return "标题不能为空";
                }
                if (value.length > 30) {
                    return "标题字数不能超过30";
                }
            }
        });

        form.on("submit(sendPost)", function () {
            // 获取富文本中的纯文本内容(不包含html标签)
            var text = edit.getText(editIndex);
            if (text.length < 30) {
                var index = layer.open({
                    title: '在线调试'
                    , content: '字数太少了哦，可以尝试多编写一些文字！'
                    , async: false
                    , btn: ["继续发布", "确定"]
                    , btn1: function () {
                        sendPost();
                        isOk = true;
                        layer.close(index);
                    }
                });
            }else{
                sendPost();
            }
        });

        function sendPost() {
            // 发布帖子
            console.log("发布帖子");
            $.ajax({
               url:"<%=request.getContextPath()%>/post/sendPost",
               type:"post",
                data:{title:$("#title").val(),topicId:$("#topics").val(),context:edit.getContent(editIndex)},
               success:function (data) {
                    console.log(data);
                    if(data) {
                        // 转跳至查看该文章页面
                        setTimeout(function () {
                            location.href = "<%=request.getContextPath()%>/index.jsp";
                        }, 1000);
                        layer.msg("发布成功，正在转跳至该文章页面...", {icon: 1});
                    }
               } ,error:function () {
                    layer.msg("发布文章失败",{icon:2});
                }
            });

        }
    })
</script>
</body>
</html>
