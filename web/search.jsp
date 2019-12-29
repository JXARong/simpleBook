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
                    <c:if test="${searchPostList.size()>0}">
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
                    </c:if>

                    <c:if test="${searchPostList.size()==0}">
                        <li style="border-bottom: 0px">
                            <h4 style="text-align: center">暂无搜索到相关信息</h4>
                        </li>
                    </c:if>

                </ul>
            </div>
        </div>

        <div class="col-xs-16 col-xs-offset-8 main" id="userlist" style="display: none;">
            <div class="search-content">
                <ul class="user-list">
                    <c:if test="${searchUserList.size()>0}">
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
                    </c:if>

                    <c:if test="${searchUserList.size()==0}">
                        <li style="border-bottom: 0px">
                            <h4 style="text-align: center">暂无搜索到相关信息</h4>
                        </li>
                    </c:if>
                </ul>
            </div>
        </div>

        <div class="col-xs-16 col-xs-offset-8 main" id="typelist" style="display: none;">
            <div class="search-content">
                <ul class="user-list">
                    <c:if test="${searchTopicList.size()>0}">
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
                    </c:if>
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

                    <c:if test="${searchTopicList.size()==0}">
                        <li style="border-bottom: 0px">
                            <h4 style="text-align: center">暂无搜索到相关信息</h4>
                        </li>
                    </c:if>
                </ul>
            </div>
        </div>
    </div>
</body>

</html>
