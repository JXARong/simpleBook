<%--
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

    $(function () {
        $("#visit").hover(function () {

            $("#dmenus").css({display:""});
        },function () {
            $("#dmenus").css({display:"none"});
        })
    })

</script>
<style type="text/css">



</style>

<body lang="zh-CN" class="reader-black-font">
<c:if test="${user==null}">
    <jsp:include page="header.jsp"/>
</c:if>
<c:if test="${user!=null}">
    <jsp:include page="header2.jsp"/>
</c:if>

<div class="container person">
    <div class="row">
        <div class="col-xs-16 main">
            <div class="main-top">

                <a class="avatar" href="/u/38268d4671c8">
                    <img src="" alt="240" />
                </a>

                <div class="title">
                    <a class="name" href="/u/38268d4671c8">${user.uname}</a>
                </div>
                <div class="info">
                    <ul>
                        <li>
                            <div class="meta-block">
                                    <p>${relationCid}</p>
                                    关注
                                </a>
                            </div>
                        </li>
                        <li>
                            <div class="meta-block">
                                    <p>${relationUid}</p>
                                    粉丝
                                </a>
                            </div>
                        </li>
                        <li>
                            <div class="meta-block">
                                <p>${postNumber}</p>
                                文章
                                </a>
                            </div>
                        </li>
                        <li>
                            <div class="meta-block">
                                <p>${favourite}</p>
                                <div>收获喜欢</div>
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
