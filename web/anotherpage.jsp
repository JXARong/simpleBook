<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="/simpleBook/css/personal_one.css"/>
    <link rel="stylesheet" href="/simpleBook/css/personal_two.css"/>
</head>
<script type="text/javascript" src="/simpleBook/js/jquery-1.12.4.min.js"></script>
<script>
    $(function () {
        // 关注按钮点击事件
        $("#follows").click(function () {

            // 关注该用户
            if ($("#follows").hasClass("off")) {
                $("#follows").removeClass("off  user-follow-button");
                $("#follows").addClass("on  user-follow-button");
            } else {
                // 取消关注该用户
                $("#follows").removeClass("on  user-follow-button");
                $("#follows").addClass("off  user-follow-button");
            }
        });

        // 加载所有信息
        (function () {
            // 获取该用户的编号
            <%--  <%=request.getParameter("uid")%>  --%>
            var uid = "72663782";
            $.ajax({
                url: "/simpleBook/user/selectUser",
                type: "get",
                data: {uid: uid,limit:1,page:1},
                success: function (data) {
                    var info = data.data[0];

                    $("#uname").text(info.uname);
                    $("#postNum").text(info.posts.length);
                    $("#money").text(info.money);
                    $(".js-intro").text(info.introduce);

                    $.each(info.posts,function (index,item) {
                        var title = item.title;
                        title=title.length>30?title.substring(0,30)+"...":title;
                        var context=item.article.substring(0,50);
                        var temp='<li id="note-57792457" data-note-id="57792457" class="have-img">' +
                            '                        <div class="content ">' +
                            '                            <a class="title" target="_blank" href="">'+title+'</a>' +
                            '                            <p class="abstract">'+context+'</p>' +
                            '                            <div class="meta">' +
                            '                                            <span><i class="iconfont ic-list-read"></i>'+item.readCount+'</span>' +
                            '                                <span>' +
                            '                                                <i class="iconfont ic-list-comments"></i> 12' +
                            '                                            </span> <span><i class="iconfont ic-list-like"></i> 25</span>' +
                            '                                <span class="time">'+item.sendDate+'</span>' +
                            '                            </div>' +
                            '                        </div>' +
                            '                    </li>';
                        $(".note-list").append($(temp));
                    })
                }, error: function () {

                }
            });

        })();

    });
</script>

<body>
<div class="container person">
    <div class="row">
        <div class="col-xs-16 main">
            <div class="main-top">
                <a class="avatar" href="">
                    <img src="/simpleBook/images/girl.png" alt="240" height="240"/>
                </a>
                <div class="follow-button"></div>
                <button class="off  user-follow-button" id="follows">
                    <i class="iconfont"></i>
                    <span>关注</span>
                </button>

                <div class="title">
                    <a class="name" id="uname" href=""></a>
                </div>
                <div class="info">
                    <ul>
                        <li>
                            <div class="meta-block">

                                <p>10</p>
                                <div>关注</div>
                                </a>
                            </div>
                        </li>
                        <li>
                            <div class="meta-block">

                                <p>99</p>
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
                                <p>100000</p>
                                <div>字数</div>
                            </div>
                        </li>
                        <li>
                            <div class="meta-block">
                                <p>10</p>
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