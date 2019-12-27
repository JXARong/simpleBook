<%@ page import="com.bdqn.simplebook.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: 落雨丶
  Date: 2019/12/19
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<head>
    <meta charset="utf-8">
    <link rel="icon" type="image/x-icon" href="/simpleBook/images/girl.png" />
    <title>${user.uname} - 简·简书</title>
    <link rel="stylesheet" href="/simpleBook/css/personal_two.css">
    <link rel="stylesheet" href="/simpleBook/css/personal_one.css">
    <link rel="stylesheet" href="/simpleBook/js/layui/css/layui.css">
    <script type="text/javascript" src="/simpleBook/js/layui/layui.js"></script>
    <script type="text/javascript" src="/simpleBook/js/jquery-1.12.4.min.js" ></script>
</head>
<script type="text/javascript">

    layui.use('element', function(){
        var element = layui.element;

        //一些事件监听
        element.on('tab(demo)', function(data){
            console.log(data);
        });
    });

    $(function() {
        $("#userlog").hover(function() {
            $("#userlog").removeClass("user");
            $("#userlog").addClass("user open");
        },function(){
            $("#userlog").removeClass("user open");
            $("#userlog").addClass("user");
        })
    })

    <%
    User user = (User) request.getSession().getAttribute("user");
    %>

    var  uid = <%=user.getUid()%>;
    $.ajax({
        url: "/simpleBook/user/selectUser",
        type: "get",
        data: {uid: uid, limit: 1, page: 1},
        success: function (data) {
            var info = data.data[0];

            $("#uname").text(info.uname);
            $("#postNum").text(info.posts.length);
            $("#money").text(info.money);
            $(".js-intro").text(info.introduce);
            $("#fans").text(info.fans);
            $("#attentionNum").text(info.attentionNum);
            $("#favouriteNum").text(info.favouriteNum);
            $("#textCount").text(info.textCount);

            // 遍历所有的文章
            $.each(info.posts, function (index, item) {
                var title = item.title;
                title = title.length > 30 ? title.substring(0, 30) + "..." : title;
                var context = item.article.substring(0, 50);
                var temp = '<li id="note-57792457" data-note-id="57792457" class="have-img">' +
                    '                        <div class="content ">' +
                    '                            <a class="title" target="_blank" href="">' + title + '</a>' +
                    '                            <p class="abstract">' + context + '</p>' +
                    '                            <div class="meta">' +
                    '                                            <span><i class="iconfont ic-list-read"></i>' + item.readCount + '</span>' +
                    '                                <span>' +
                    '                                                <i class="iconfont ic-list-comments"></i> 12' +
                    '                                            </span> <span><i class="iconfont ic-list-like"></i> ' + item.start + '</span>' +
                    '                                <span class="time">' + item.sendDate + '</span>' +
                    '                            </div>' +
                    '                        </div>' +
                    '                    </li>';
                $(".note-list").append($(temp));
            })
        }, error: function () {

        }
    });
</script>
<style type="text/css">



</style>

<body lang="zh-CN" class="reader-black-font">
<!-- 全局顶部导航栏 -->
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="width-limit">
        <!-- 左上方 Logo -->
        <a class="logo" href="/simpleBook/index.jsp"><img src="/simpleBook/images/jianjianshulogo.png" alt="Nav logo" /></a>

        <!-- 右上角 -->
        <!-- 登录显示写文章 -->
        <a class="btn write-btn" target="_blank" href="">
            <i class="iconfont ic-write"></i>写文章
        </a>
        <!-- 如果用户登录，显示下拉菜单 -->
        <div class="user" id="userlog">
            <div data-hover="dropdown">
                <a class="avatar" href="/simpleBook/personal.jsp">
                    <img src="img/qq.png" alt="120" />
                </a>
            </div>
            <ul class="dropdown-menu">
                <li>
                    <a href="/simpleBook/personal.jsp">
                        <i class="iconfont ic-navigation-profile"></i><span>我的主页</span>
                    </a>
                </li>
                <li>
                    <a href="/simpleBook/userInfo.jsp">
                        <i class="iconfont ic-navigation-settings"></i><span>设置</span>
                    </a>
                </li>
                <li>
                    <a href="/simpleBook/problem.html">
                        <i class="iconfont ic-navigation-feedback"></i><span>帮助与反馈</span>
                    </a>
                </li>
                <li>
                    <a rel="nofollow" data-method="delete" href="/simpleBook/index.jsp" <% request.getSession().removeAttribute("user"); %>>
                        <i class="iconfont ic-navigation-signout"></i>
                        <span>退出</span>
                    </a>
                </li>
            </ul>
        </div>

        <div id="navbar-jsds-enter">
        </div>

        <div id="view-mode-ctrl">
        </div>
        <div class="container">
            <div class="collapse navbar-collapse" id="menu">
                <ul class="nav navbar-nav">
                    <li class="tab active">
                        <a href="/simpleBook/index.jsp">
                            <span class="menu-text">发现</span>
                            <i class="iconfont ic-navigation-discover menu-icon"></i>
                        </a>
                    </li>
                    <li class="search">
                        <form target="_blank" action="/search" accept-charset="UTF-8" method="get"><input name="utf8" type="hidden" value="&#x2713;" />
                            <input type="text" name="q" id="q" value="" autocomplete="off" placeholder="搜索" class="search-input" />
                            <a class="search-btn" href="javascript:void(null)"><i class="iconfont ic-search"></i></a>
                        </form>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</nav>

<div class="container person">
    <div class="row">
        <div class="col-xs-16 main">
            <div class="main-top">

                <a class="avatar" href="/simpleBook/personal.jsp">
                    <img src="" alt="240" />
                </a>

                <div class="title">
                    <a class="name" href="/simpleBook/personal.jsp">${user.uname}</a>
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

            <ul class="trigger-menu" data-pjax-container="#list-container">
                <li class="active">
                    <a href=""><i class="iconfont ic-articles"></i> 文章</a>
                </li>
<%--                <li class="">--%>
<%--                    <a href=""><i class="iconfont ic-feed"></i> 动态</a>--%>
<%--                </li>--%>
<%--                <li class="">--%>
<%--                    <a href=""><i class="iconfont ic-latestcomments"></i> 最新评论</a>--%>
<%--                </li>--%>
<%--                <li class="">--%>
<%--                    <a href=""><i class="iconfont ic-hot"></i> 热门</a>--%>
<%--                </li>--%>
            </ul>

            <div id="list-container">

                <ul class="note-list" infinite-scroll-url="/u/38268d4671c8?order_by=shared_at">

                    <!--<li id="note-55964837" data-note-id="55964837" class="">
                        <div class="content ">
                            <a class="title" target="_blank" href="/p/6cceefcfcc33">无标题文章</a>
                            <p class="abstract">
                                123
                            </p>
                            <div class="meta">
                                <a target="_blank" href="/p/6cceefcfcc33">
                                    <i class="iconfont ic-list-read"></i> 0
                                </a>
                                <a target="_blank" href="/p/6cceefcfcc33#comments">
                                    <i class="iconfont ic-list-comments"></i> 0
                                </a> <span><i class="iconfont ic-list-like"></i> 0</span>
                                <span class="time" data-shared-at="2019-11-05T16:17:19+08:00"></span>
                            </div>
                        </div>
                    </li>-->

                </ul>

            </div>
        </div>

        <div class="col-xs-7 col-xs-offset-1 aside">
            <div class="title">个人介绍</div>
            <div class="description">
                <div class="js-intro">${user.introduce}</div>

            </div>
<%--            <ul class="list user-dynamic">--%>
<%--                <li>--%>
<%--                    <a href="/users/38268d4671c8/liked_notes">--%>
<%--                        <i class="iconfont ic-like"></i> <span>我喜欢的文章</span>--%>
<%--                    </a>--%>
<%--                </li>--%>
<%--            </ul>--%>
        </div>

    </div>
</div>
<div data-vcomp="side-tool"></div>

</body>

</html>
