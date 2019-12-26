<%@ page import="com.bdqn.simplebook.domain.Post" %><%--
  Created by IntelliJ IDEA.
  User: 落雨丶
  Date: 2019/12/26
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>

    </title>
    <link rel="stylesheet" href="/simpleBook/css/sousuo1.css"/>
    <link rel="stylesheet" href="/simpleBook/css/sousuo2.css"/>
    <script type="text/javascript" src="/simpleBook/js/jquery-1.12.4.min.js"></script>
</head>
<script>
    $(function () {
        $("#postmenu").click(function () {
            $("#inter").removeClass("active");
            $("#typemenu").removeClass("active");
            $("#userlist").css("display", "none");
            $("#typelist").css("display", "none");
            $("#postmenu").addClass("active");
            $("#postlist").css("display", "block");

        })

        $("#inter").click(function () {
            $("#postmenu").removeClass("active");
            $("#postlist").css("display", "none");
            $("#typelist").css("display", "none");
            $("#typemenu").removeClass("active");
            $("#inter").addClass("active");
            $("#userlist").css("display", "block");
        })

        $("#typemenu").click(function () {
            $("#inter").removeClass("active");
            $("#postmenu").removeClass("active");
            $("#postlist").css("display", "none");
            $("#userlist").css("display", "none");
            $("#typemenu").addClass("active");
            $("#typelist").css("display", "block");
        })
    })
</script>

<body>
<c:if test="${user==null}">
    <jsp:include page="header.jsp"/>
</c:if>
<c:if test="${user!=null}">
    <jsp:include page="header2.jsp"/>
</c:if>
<div class="container search">
    <div class="row">
        <div class="aside">
            <div>
                <ul class="menu">
                    <li class="active" id="postmenu">
                        <a>
                            <div class="setting-icon"><i class="iconfont ic-search-note"></i></div>
                            <span>文章</span></a>
                    </li>
                    <li class="" id="inter">
                        <a>
                            <div class="setting-icon"><i class="iconfont ic-search-user"></i></div>
                            <span>用户</span></a>
                    </li>
                    <li class="" id="typemenu">
                        <a>
                            <div class="setting-icon"><i class="iconfont ic-search-collection"></i></div>
                            <span>专题</span></a>
                    </li>
                </ul>
            </div>
            <!---->
        </div>
        <div class="col-xs-16 col-xs-offset-8 main" id="postlist">
            <div class="search-content">

                <ul class="note-list">

                    <c:forEach items="${searchPostList}" var="postList" varStatus="status">

                        <li>

                            <div class="content">
                                <a href="" target="_blank" class="title">${postList.title}</a>
                                <p class="abstract">
                                    <%
                                        Post post = (Post) pageContext.getAttribute("postList");
                                        String article = post.getArticle().substring(0, 50);
                                    %>
                                    <%=article%>
                                </p>
                                <div class="meta">
                                    <span target="_blank">
                                        <i class="iconfont ic-list-read"></i> ${postList.readCount}
                                    </span>
                                    <span>
                                    <i class="iconfont ic-list-like"></i> ${postList.start}
                                </span>
                                </div>

                            </div>

                        </li>

                    </c:forEach>

                    <%--                    <li>--%>
                    <%--                        <div class="content">--%>
                    <%--                            <a href="" target="_blank" class="title">这个题目</a>--%>
                    <%--                            <p class="abstract">--%>
                    <%--                                ……专业考题类型管理运行工作负责人一般作业考题内容选项<em class="search-result-highlight">A</em>选项B选项C选项D选项E选项F正确答案--%>
                    <%--                                变电单选GYSZ本规程规定了工作人员在（ ）应遵守的安全要求。<em class="search-result-highlight">A</em>. 检修现场B. 运维现场C.--%>
                    <%--                                作业现场D……. 抢修现场C 变电单选GYSZ低［电］压：用于配电的交流系统中（）的电压等级。<em--%>
                    <%--                                        class="search-result-highlight">A</em>. 220V以下B. 220V及以下C. 1000V以下D. 1000V及以下D--%>
                    <%--                                变电单选GYSZ高［电］压：<em class="search-result-highlight">a</em>）通常……指超过低压的电压等级。b）特定情况下，指电力系统中（--%>
                    <%--                                ）的电压等级。<em class="search-result-highlight">A</em>. 输电B. 变电C. 配电D. 用电<em--%>
                    <%--                                        class="search-result-highlight">A</em> 变电单选GYSZ为加强电力生产现场管理，规范（--%>
                    <%--                                ），保证人身、电网和设备安全，依据国家……--%>
                    <%--                            </p>--%>
                    <%--                            <div class="meta">--%>
                    <%--                                <a href="/p/c07d6fcb155b" target="_blank">--%>
                    <%--                                    <i class="iconfont ic-list-read"></i> 6015--%>
                    <%--                                </a>--%>
                    <%--                                <a href="/p/c07d6fcb155b#comments" target="_blank">--%>
                    <%--                                    <i class="iconfont ic-list-comments"></i> 0--%>
                    <%--                                </a>--%>
                    <%--                                <span>--%>
                    <%--                                    <i class="iconfont ic-list-like"></i> 4--%>
                    <%--                                </span>--%>
                    <%--                            </div>--%>
                    <%--                        </div>--%>
                    <%--                    </li>--%>

                </ul>
            </div>
        </div>

        <div class="col-xs-16 col-xs-offset-8 main" id="userlist" style="display: none;">
            <div class="search-content">
                <ul class="user-list">

                    <c:forEach items="${searchUserList}" var="userList" varStatus="status">

                        <li>
                            <a href="" target="_blank" class="avatar">
                                <img src="/simpleBook/resources/userPhoto/${userList.photo}">
                            </a>
                            <div class="info">
                                <a href="" target="_blank" class="name">
                                        ${userList.uname}
                                </a>
                                <div class="meta">
                                    <span>关注${userList.attentionNum}</span>
                                    <span>粉丝${userList.fans}</span>
                                    <span>文章${userList.posts}</span>
                                </div>
                                <div class="meta">
                                    <span>
                                        写了 ${userList.textCount} 字，获得了 ${userList.favouriteNum} 个喜欢
                                    </span>
                                </div>
                            </div>
                        </li>

                    </c:forEach>

<%--                    <li>--%>
<%--                        <a href="/u/a79572799f73" target="_blank" class="avatar"><img--%>
<%--                                src="https://upload.jianshu.io/users/upload_avatars/2733509/503df8760ba4?imageMogr2/auto-orient/strip|imageView2/1/w/144/h/144/format/webp"></a>--%>
<%--                        <div class="info">--%>
<%--                            <a href="/u/a79572799f73" target="_blank" class="name">--%>
<%--                                a__--%>
<%--                            </a>--%>
<%--                            <div class="meta"><span>关注 0</span> <span>粉丝 2</span> <span>文章 0</span></div>--%>
<%--                            <div class="meta">--%>
<%--                                <span>--%>
<%--        							写了 0 字，获得了 0 个喜欢--%>
<%--                                </span>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </li>--%>
                </ul>
            </div>
        </div>

        <div class="col-xs-16 col-xs-offset-8 main" id="typelist" style="display: none;">
            <div class="search-content">
                <ul class="user-list">

                    <c:forEach items="${searchTopicList}" var="topicList" varStatus="status">

                        <span target="_blank" class="avatar-collection">
                            <img src="/simpleBook/resources/topic/${topicList.topicPicture}">
                        </span>
                        <div class="info">
                            <span target="_blank" class="name">
                                ${topicList.topic}
                            </span>
                            <div class="meta">
                                <span>
                                    收录了 ${topicList.topicPost} 篇文章，${topicList.topicFollow} 人关注
                                </span>
                            </div>
                        </div>

                    </c:forEach>

<%--                    <li>--%>
<%--                        <a href="/c/GQ5FAs" target="_blank" class="avatar-collection"><img--%>
<%--                                src="https://upload.jianshu.io/collections/images/49/66ba9fdegw1e61syw6tk6j20bj0go0wo.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/144/h/144/format/webp"></a>--%>
<%--                        <div class="info">--%>
<%--                            <a href="/c/GQ5FAs" target="_blank" class="name">--%>
<%--                                谈谈情，说说爱--%>
<%--                            </a>--%>
<%--                            <div class="meta">--%>
<%--                                <span>--%>
<%--        							收录了 80872 篇文章，1166976 人关注--%>
<%--                                </span>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </li>--%>
                </ul>
            </div>
        </div>
    </div>
</body>

</html>
