<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="icon" type="image/x-icon" id="photoIcon" href="/simpleBook/images/girl.png"/>
    <link rel="stylesheet" href="/simpleBook/css/personal_one.css"/>
    <link rel="stylesheet" href="/simpleBook/css/personal_two.css"/>
    <link rel="stylesheet" href="/simpleBook/js/layui/css/layui.css"/>
    <script type="text/javascript" src="/simpleBook/js/layui/layui.js"></script>
</head>
<script type="text/javascript" src="/simpleBook/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="js/changeRelation.js"></script>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${user==null}">
    <jsp:include page="header.jsp"/>
</c:if>
<c:if test="${user!=null}">
    <jsp:include page="header2.jsp"/>
</c:if>
<script>
    layui.use(['layer', 'jquery'], function () {
        var layer = layui.layer,
            $ = layui.jquery;

        // 关注按钮点击事件
        $("#follows").click(function () {

            if ($("#follows").hasClass("off")) {
                var flag = relation("true",$(this).attr("value"));
                if (flag) {
                    // 取消关注该用户
                    $("#follows").removeClass("off user-follow-button");
                    $("#follows").addClass("on user-follow-button");
                    $("#relationalStatus").text("已关注");
                }
            } else {
                var flag = relation("false",$(this).attr("value"));
                if (flag) {
                    // 关注该用户
                    $("#follows").removeClass("on user-follow-button");
                    $("#follows").addClass("off user-follow-button");
                    $("#relationalStatus").text("关注");
                }
            }
        });

        // 加载所有信息
        (function () {
            // 获取该用户的编号
            var cid = "<%=request.getParameter("cid")%>";
            $.ajax({
                url: "/simpleBook/user/selectUser",
                type: "get",
                async:false,
                data: {uid: cid, limit: 1, page: 1},
                success: function (data) {
                    var info = data.data[0];
                    $("head title").text(info.uname);
                    $("#photoIcon").attr("href","/simpleBook/resources/userPhoto/"+info.photo);
                    $("#uname").text(info.uname);
                    $("#postNum").text(info.posts.length);
                    $("#money").text(info.money);
                    $(".js-intro").text(info.introduce);
                    $("#fans").text(info.fans);
                    $("#attentionNum").text(info.attentionNum);
                    $("#favouriteNum").text(info.favouriteNum);
                    $("#textCount").text(info.textCount);
                    $("#photo").attr("src","/simpleBook/resources/userPhoto/"+info.photo);
                    $("#follows").attr("value",info.uid);
                    // 遍历所有的文章
                    $.each(info.posts, function (index, item) {
                        var title = item.title;
                        title = title.length > 30 ? title.substring(0, 30) + "..." : title;
                        var html = $("<span>"+item.article+"</span>");
                        var context = $(html).text().length>50?$(html).text().substring(0,50)+"...":$(html).text();
                        var temp = '<li id="note-57792457" data-note-id="57792457" class="have-img">' +
                            '                        <div class="content ">' +
                            '                            <a class="title" target="_blank" href="/simpleBook/read.jsp?pid='+item.pid+'">' + title + '</a>' +
                            '                            <p class="abstract">' + context + '</p>' +
                            '                            <div class="meta">' +
                            '                                            <span><i class="iconfont ic-list-read"></i>' + item.readCount + '</span>' +
                            '                                <span>' +
                            '                                                <i class="iconfont ic-list-comments"></i> 12'+ +
                            '                                            </span> <span><i class="iconfont ic-list-like"></i> ' + item.start + '</span>' +
                            '                                <span class="time">' + item.sendDate + '</span>' +
                            '                            </div>' +
                            '                        </div>' +
                            '                    </li>  ';
                        $(".note-list").append($(temp));
                    });

                }, error: function () {

                }
            });

            // 判断是否是登录用户，如果是则不显示关注按钮
            if(cid!="${sessionScope.user.uid}"){
                // 加载关注信息
                let isRelation = getRelation(cid);
                if (isRelation) {
                    // true代表已关注该用户
                    $("#follows").removeClass("off user-follow-button");
                    $("#follows").addClass("on user-follow-button");
                    $("#relationalStatus").text("已关注");
                } else {
                    // false未关注该用户
                    $("#follows").removeClass("on user-follow-button");
                    $("#follows").addClass("off user-follow-button");
                    $("#relationalStatus").text("关注");
                }
            }else{
                $("#follows").remove();
            }

        })();
    })
</script>

<body>
<div class="container person">
    <div class="row">
        <div class="col-xs-16 main">
            <div class="main-top">
                <a class="avatar" href="">
                    <img id="photo" src="/simpleBook/images/girl.png" alt="240" height="240"/>
                </a>
                <div class="follow-button"></div>
                <button class="off  user-follow-button" id="follows">
                    <i class="iconfont"></i>
                    <span id="relationalStatus">关注</span>
                </button>

                <div class="title">
                    <a class="name" id="uname" href=""></a>
                </div>
                <div class="info">
                    <ul>
                        <li>
                            <div class="meta-block">

                                <p id="attentionNum"></p>
                                <div>关注</div>
                                </a>
                            </div>
                        </li>
                        <li>
                            <div class="meta-block">

                                <p id="fans"></p>
                                <div>粉丝</div>
                                </a>
                            </div>
                        </li>
                        <li>
                            <div class="meta-block">

                                <p id="postNum">0</p>
                                <div>文章</div>
                                </a>
                            </div>
                        </li>
                        <li>
                            <div class="meta-block">
                                <p id="textCount"></p>
                                <div>字数</div>
                            </div>
                        </li>
                        <li>
                            <div class="meta-block">
                                <p id="favouriteNum"></p>
                                <div>收获喜欢</div>
                            </div>
                        </li>
                        <li>
                            <div class="meta-block">
                                <p id="money"></p>
                                <div>总资产</div>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>

            <ul class="trigger-menu">
                <li class="active">
                    <a href=""><i class="iconfont ic-articles"></i> 文章</a>
                </li>
            </ul>

            <div id="list-container">

                <ul class="note-list" infinite-scroll-url="/u/b3b2c03354f3?order_by=shared_at">
                </ul>
            </div>

        </div>
        <div class="col-xs-7 col-xs-offset-1 aside">
            <div class="title">个人介绍</div>
            <div class="description">
                <div class="js-intro">
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>