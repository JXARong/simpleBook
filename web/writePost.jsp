<%@ page import="com.bdqn.simplebook.domain.User" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="java.time.Duration" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.ZoneOffset" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>简简书-发布文章</title>
    <link rel="icon" type="image/x-icon" href="/simpleBook/images/girl.png"/>
</head>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/layui/layui.js"></script>
<link href="<%=request.getContextPath()%>/js/layui/css/layui.css" rel="stylesheet" type="text/css" media="all">
<script type="text/javascript" src="/simpleBook/js/tinymce/tinymce.min.js"></script>
<body style="background-color: #F2F2F2;padding: 5px">

<div class="layui-fluid">
    <div class="layui-row layui-col-space10">

        <%--        // 最近发布的十个帖子--%>
        <div class="layui-col-md2">
            <div class="layui-card">
                <div class="layui-card-body">
                    <div style="padding: 5px">
                        <div style="height: 120px;margin-bottom: 15px;">
                            <img src="<%=request.getContextPath()%>/resources/userPhoto/${user.photo}" height="60px"
                                 width="60px" style="margin-top: 10px;border-radius: 50%">
                            <p id="uname"
                               style="display: inline-block;margin-left: 15px;font-size: 16px;vertical-align: middle">
                                我来自人间...</p>
                            <br>
                            <p id="registerTime" style="display: inline-block;margin-left: 30%;">简龄：6年</p>
                        </div>
                        <div style="height: 120px;">
                            <p><b>个人简介：</b></p>
                            <p id="introduce" style="text-indent: 2em">我来自人间，去往天堂,并且不留一丝痕迹</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="layui-card">
                <div class="layui-card-body">
                    <div>
                        <div>
                            <ul id="postList">
                                <style>
                                    #postList li {
                                        border-bottom: 1px solid #F2F2F2;
                                        padding: 5px 0;
                                    }

                                    #postList > li > p > span {
                                        color: #d63031;
                                        font-weight: bold;
                                    }
                                </style>
                                <%--<li>
                                    <b>人生低谷时、尽量多睡觉，少说话、多看书嘎嘎解放路卡戴珊kg哈宽带连接</b>
                                    <p>点赞:<span>100</span>&nbsp;&nbsp;热度:<span>10</span></p>
                                </li>
                                <li>
                                    <b>人生低谷时、尽量多睡觉，少说话</b>
                                    <p>点赞:100&nbsp;&nbsp;热度:10</p>
                                </li>--%>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <%--            发布文章板块--%>
        <div class="layui-col-md10">
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
    </div>
</div>
<script type="text/javascript">
    layui.use(['form', 'jquery', 'layedit'], function () {
        var form = layui.form,
            $ = layui.jquery;
        form.render();
        /*var editIndex = edit.build("context", {
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
        });*/
        tinymce.init({
            selector:"#context",
            language:'zh_CN',
            height:"500px",
            statusbar: false,
            content_css : 'js/layui/css/layui.css' ,
            toolbar: 'bold italic | underline strikethrough | alignleft aligncenter alignright | styleselect fontselect fontsizeselect | indent outdent ',
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

        // 加载10篇最近发帖，左侧
        (function () {
            $.ajax({
                url: "<%=request.getContextPath()%>/post/selPostByUIdOfTop10",
                type: "post",
                success: function (data) {
                    if (data.length > 0) {
                        $.each(data, function (index, item) {
                            if (index == 8) {
                                return;
                            }
                            var title = item.title;
                            // 截取标题
                            title = title.length > 15 ? title.substring(0, 14) + "..." : title;
                            var temp = "<li><b><a href='/simpleBook/read.jsp?pid="+item.pid+"'>" + title + "</a></b><p>点赞:<span>" + item.start + "</span>&nbsp;&nbsp;热度:<span>" + item.hot + "</span></p></li>";
                            $("#postList").append($(temp));
                        })
                    } else {
                        $("#postList").append($("<h4 style='text-align: center'>您还未发布过文章</h4>"))
                    }

                }, error: function () {
                    layer.msg("加载文章失败", {icon: 2});
                }
            })
        })();

        // 处理昵称
        <%
        User user = (User) session.getAttribute("user");
            if (user!=null){
                // 处理昵称
                String str=user.getUname();
                str = str.length()>7?str.substring(0,7)+"...":str;
                request.setAttribute("str",str);

                // 处理注册时间
                Timestamp timestamp = user.getRegisterTime();
                LocalDateTime now = LocalDateTime.now();
                LocalDateTime time =LocalDateTime.ofEpochSecond(timestamp.getTime()/1000,0,ZoneOffset.ofHours(8));
                Duration between = Duration.between(time,now);
                StringBuffer sb=new StringBuffer();
                // 求出相差的天数
                long days = between.toDays();
                // 获取年份数
                int year= (int) (days/365);
                System.out.println(now+"--"+time);
                System.out.println(days);
                // 若年份不等于0显示多少年
                if (year>0){
                    sb.append(year+"年");
                }
                // 获取除完年份剩下的天数
                long day = days%365;

                // 获取月份
                int month=((int) (day%30))==0?(int) (day/30)+1:(int) (day/30);
                sb.append(month+"月");
                request.setAttribute("registerTime",sb.toString());
            }else{
                response.sendRedirect(application.getContextPath() + "/login.html");
            }
        %>

        // 加载作者简单信息，右侧
        (function () {
            $("#uname").text("${str}");
            $("#registerTime").text("简龄:${registerTime}");
            $("#introduce").text("${user.introduce}");
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

        // 提交发布
        form.on("submit(sendPost)", function () {
            // 获取富文本中的纯文本内容(不包含html标签)
            var activeEditor = tinymce.activeEditor; 
            var editBody = activeEditor.getBody(); 
            activeEditor.selection.select(editBody); 
            var text = activeEditor.selection.getContent( { 'format' : 'text' } );
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
            } else {
                sendPost();
            }
        });

        // 封装发布文章
        function sendPost() {
            // 获取富文本中的纯文本内容(不包含html标签)
            var activeEditor = tinymce.activeEditor;
            var editBody = activeEditor.getBody();
            activeEditor.selection.select(editBody);
            var text = activeEditor.selection.getContent( { 'format' : 'text' } );
            // 发布帖子
            console.log("发布帖子");
            $.ajax({
                url: "<%=request.getContextPath()%>/post/sendPost",
                type: "post",
                data: {title: $("#title").val(), topicId: $("#topics").val(), context: tinyMCE.activeEditor.getContent(),textNum:text.length},
                success: function (data) {
                    console.log(data);
                    if (data) {
                        // 转跳至查看该文章页面
                        setTimeout(function () {
                            location.href = "<%=request.getContextPath()%>/index.jsp";
                        }, 1000);
                        layer.msg("发布成功，正在转跳至该文章页面...", {icon: 1});
                    }
                }, error: function () {
                    layer.msg("发布文章失败", {icon: 2});
                }
            });

        }
    })
</script>
</body>
</html>
