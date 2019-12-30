
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="icon" type="image/x-icon" href="/simpleBook/images/girl.png"/>
    <style type="text/css">
        body {
            margin: 0px;
            padding: 0px;
            font-family: "Times New Roman", "Microsoft YaHei";
            background-color: #F9F9F9;
        }

        ul, ol {
            list-style: none;
        }

        .middle {

        }

        .postContext {
            width: 752px;
            height: 10000px;
            padding: 24px;
            position: absolute;
            left: 450px;
        }

        .left {
            position: fixed;
            left: 380px;
            top: 159px;
            color: #969696;
            font-size: 13px;
            text-align: center;
        }

        img {
            display: block;
        }

        .left_aside {
            width: 48px;
            height: 48px;
            line-height: 48px;
            background-color: rgb(255, 255, 255);
            box-shadow: 0 0 10px 5px rgba(245, 245, 245, 0.9);
        }


        #shang {
            margin-top: 13px;
        }

        .left_style {
            cursor: pointer;
        }

        .roundness {
            border-radius: 50%;
        }

        /*.right {
            width: 260px;
            height: 492px;
            position: absolute;
            left: 1191px;
            top: 68px;
            padding: 10px;
            border-radius: 4px;
        }

        .author {
            width: 228px;
            height: 45px;
            background: #fff;
            padding: 16px;
        }*/

        .inline_block {
            display: inline-block;
        }

        .reading {
            width: 228px;
            height: 363px;
            background: #fff;
            margin-top: 10px;
            padding: 16px;
        }

        .margin0px {
            margin: 0px;
        }

        .attention {
            height: 23px;
            width: 50px;
            border-radius: 20px;
            border: 1px solid #EC7259;
            outline: none;
            background-color: #fff;
            color: #EC7259;
        }

        .attention:hover {
            background-color: #F9F9F9;
        }

        .footer {
            position: fixed;
            background-color: #fff;
            z-index: 10;
            width: 100%;
            bottom: 0px;
            box-shadow: 0px -2px 10px rgba(0, 0, 0, 0.5);
        }


        .footer div {
            margin-left: 20%;
        }


        .author img {
            float: left;
            border: 1px solid #EEEEEE;
        }


        .header_right_head:hover {
            background-color: #F2F2F2;
        }

        img[src="images/font_zuan.png"] {
            position: absolute;
            bottom: 1px;
        }


        .review img {
            height: 40px;
            width: 40px;
            float: left;
        }

        .review form textarea {
            outline: none;
            border: none;
            height: 36px;
            width: 400px;
            border-radius: 20px;
            padding: 10px 15px;
            background-color: #F2F2F2;
            resize: none;
        }

        .message_style_a {
            color: #000;
            text-decoration: none;
        }

        .message_style_p {
            color: #969696;
        }

        .review form textarea:focus {
            height: 72px;
            width: 500px;
        }

        .fill {
            height: 77px;
            width: 100%;
        }

        .title {
            margin: 0px 0px 20px 0px;
            box-sizing: border-box;
        }

        .message {
            width: 100%;
            height: 80px;
            padding: 17px 0px;
            box-sizing: border-box;
        }

        .float_left {
            float: left;
        }

        .message_message {
            padding: 10px;
        }

        .message_message * {
            margin-right: 10px;
        }

        nav {
            box-shadow: 0 5px 5px #F2F2F2;
        }
    </style>
    <script type="text/javascript" src="/simpleBook/js/layui/layui.js"></script>
    <link rel="stylesheet" href="/simpleBook/js/layui/css/layui.css"/>
    <script type="text/javascript" src="/simpleBook/js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="/simpleBook/js/changeRelation.js"></script>
</head>
<script type="text/javascript">
    layui.use(['jquery', 'layer'], function () {
        var $ = layui.jquery;
        var layer = layui.layer;

        // 返回顶部按钮点击事件
        $(".returnTop").click(function () {
            var time = setInterval(function () {
                var top = document.body.scrollTop || document.documentElement.scrollTop;
                scroll(0, top - 40);
                if (top <= 0) {
                    clearInterval(time);
                }
            }, 1);
        });

        // 点击头像转跳至该作者的个人信息页面
        $("#photo").click(function () {
            location.href = "/simpleBook/anotherpage.jsp?cid=" + $(this).attr("value");
        });

        /**
         * 加载文章信息以及关注信息
         */
        (function () {

            // 存储该文章属于的用户编号
            var cid = 0;
            // 获取文章编号
            $.ajax({
                url: "/simpleBook/post/selPostByPid",
                type: "post",
                async: false,
                data: {pid: "<%=request.getParameter("pid")%>"},
                success: function (data) {
                    if (data.flag) {
                        var postInfo = data.data;
                        $("head title").text(postInfo.title);
                        $("#title").text(postInfo.title);
                        $("#photo").attr("src", "/simpleBook/resources/userPhoto/" + postInfo.user.photo);
                        $("#uname").text(postInfo.user.uname);
                        $("#photo").attr("value", postInfo.user.uid);
                        if (postInfo.user.uid == "${user.uid}") {
                            $("#changeRelation").remove();
                        }
                        cid = postInfo.user.uid;
                        // 2019.10.29 12:49:29 字数 707 阅读 3,202
                        var temp = postInfo.sendDate + " 字数 " + postInfo.textNum + " 阅读 " + postInfo.readCount;
                        $("#postInfo").text(temp);
                        $("#postContext").html(postInfo.article);
                        $("#changeRelation").attr("cid", postInfo.user.uid)
                    } else {
                        layer.msg(data.errorMsg, {icon: 2});
                    }
                }, error: function () {
                    layer.msg("加载文章信息失败！", {icon: 2});
                }
            });

            /**
             *  1.查看自己发布的文章，即不显示关注按钮
             *  2.查看别人发布的文章若关注了该用户则不显示关注按钮，若没有关注则显示按钮，并且加上点击事件
             */
            if("${user.uid}"==null || "${user.uid}"==''){

            }else{
                // 判断是否已关注，已关注的话关注按钮移出
                if (cid == "${sessionScope.user.uid}") {
                    $("#changeRelation").remove();
                }


                // 获取登录用户与改用的关注关系
                var relation = getRelation(cid);
                if (relation == true) {
                    $("#changeRelation").remove();
                }
            }

            // 添加该文章的阅读数
            $.ajax({
                url: "/simpleBook/post/addRead",
                type: "post",
                data: {pid: "<%=request.getParameter("pid")%>"},
                success: function () {
                }
            });
        })();

        // 关注按钮点击事件
        $("#changeRelation").click(function () {
            if("${user.uid}"==null || "${user.uid}"==''){
                layer.msg("您还没有登录哦！");
                setTimeout("location.replace('/simpleBook/login.html')",1000);
                return;
            }else{
                var cid = $(this).attr("cid");
                let b = relation("true", cid);
                if (b) {
                    $("#changeRelation").remove();
                }
            }

        });

        // 喜欢文章按钮点击事件
        $("#follows").click(function () {
            // 判断是否登录
            if ('${user.uid}' == null || '${user.uid}' == '') {
                location.href = "/simpleBook/login.html";
                return;
            }

            // 判断是否是自己的文章
            if ($("#photo").attr("value") == '${user.uid}') {
                layer.msg("不能给自己点赞哦！");
                return;
            }
            // 判断是否已经喜欢过
            $.ajax({
                url: "/simpleBook/favourite/verifyFavouriteUser",
                type: "post",
                data: {"pid":<%=request.getParameter("pid")%>, "uid": $("#photo").attr("value")},
                success: function (data) {
                    if (data.flag) {
                        layer.msg("点赞成功！");
                    } else {
                        layer.msg(data.errorMsg);
                    }
                }, error: function () {
                    layer.msg("服务器繁忙！");
                }
            });
        });

        // 举报文章
        $(".jubao").click(function () {

             // 判断是否已经登录
            if($("${user.uid}")==null || '${user.uid}'==''){
                layer.msg("登录后才能操作哦！");
                setTimeout("location.href='/simpleBook/login.html'",1000);
                return;
            }
            var isReport=false;
            // 判断该用户是否已经举报过该文章
            $.ajax({
                url:"/simpleBook/report/getReport",
                data:{uid:'${user.uid}',pid:<%=request.getParameter("pid")%>},
                async:false,
                type:"post",
                success:function (data) {
                    isReport=data;
                },error:function () {

                }
            });
            if(isReport){
                layer.msg("您已经举报过了，请耐心等待审核信息,届时会通过邮箱通知您");
                return;
            }

            // 打开举报窗口
            var index = layer.open({
                type: 2,
                content: '/simpleBook/jubao.jsp',
                title: "文章举报",
                area: ["600px", "350px"],
                btn: ["确定", "取消"],
                success: function () {
                    var body = layui.layer.getChildFrame('body', index);
                    body.find("#pid").val("<%=request.getParameter("pid")%>");
                    body.find("#title").text($("#title").text());
                },
                btn1: function () {
                    // 查找弹窗body部分
                    var body = layui.layer.getChildFrame('body', index);
                    // 查找修改和添加用户的表单提交按钮
                    var subBtn = body.find("#sub");
                    subBtn.click();
                }
            })
        });

        $("#sendComment").click(function () {
            alert("傻逼");
        });
    });
</script>
<body>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${user==null}">
    <jsp:include page="/header.jsp"/>

</c:if>
<c:if test="${user!=null}">
    <jsp:include page="/header2.jsp"/>
</c:if>

<div class="middle">
    <%--    <div class="fill"></div>--%>
    <div class="postContext">
        <h1 class="title" id="title"></h1>
        <div class="message">
            <img src="images/default_head_portrait.jpg" height="45px" width="45px"
                 class="roundness inline_block float_left" id="photo">
            <div class="inline_block float_left message_message">
                <a href="" title="ig666" class="message_style_a float_left" id="uname"></a>
                <button class="attention float_left" id="changeRelation" style="font-size: 14px" type="button" onclick="javascript:void(0)">关注</button>
                <p class="margin0px message_style_p float_left" id="postInfo"></p>
                <br>
            </div>

        </div>
        <article id="postContext"></article>

        <div>
            <span><h3>全部评论</h3></span>
        </div>
        <div style="float: left ">
            <img src="images/qq.png">
        </div>
        <div>
            <sapn><h4>爱吃火锅的大胖子</h4></sapn>
            <span>2楼</span>
            <span><time>01.28 17:56</time></span>
        </div>
        <div>
            <h4>丹青妙笔<br>拍案叫绝</h4>
        </div>
    </div>

    <div class="left">
        <div class="left_style">
            <div class="left_aside roundness" id="follows">
                <img src="/simpleBook/images/shang_gary.png" height="30" width="30" id="shang"/>
            </div>
            <label>喜欢</label>
        </div>
        <div class="left_style returnTop">
            <div class="left_aside roundness">
                <img src="/simpleBook/images/go_top.png" height="24" width="24" style="margin-top: 13px"/>
            </div>
            <label>顶部</label>
        </div>
        <div class="left_style jubao">
            <div class="left_aside roundness">
                <img src="/simpleBook/images/jubao.png" height="24" width="24" style="margin-top: 13px"/>
            </div>
            <label>举报</label>
        </div>
    </div>

</div>

<div class="footer">
    <div style="height: 150px;padding-top: 30px">
        <textarea style="padding: 5px;vertical-align: middle" id="commentContent" rows="3" cols="50" maxlength="100">

        </textarea>
        <button type="button" class="layui-btn layui-btn-primary" id="sendComment" style="display: inline-block;margin-left: 15px">发送</button>
    </div>
</div>
</body>
</html>
