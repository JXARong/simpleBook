<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>阅读</title>
    <script src="/simpleBook/js/layui/layui.js"></script>
    <link rel="stylesheet" href="/simpleBook/js/layui/css/layui.css">
    <script src="/simpleBook/js/jquery-1.12.4.min.js"></script>
    <script src="/simpleBook/js/changeRelation.js"></script>
</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${user==null}">
    <jsp:include page="header.jsp"/>
</c:if>
<c:if test="${user!=null}">
    <jsp:include page="header2.jsp"/>
</c:if>
<div class="layui-fluid" style="padding-top: 30px">
    <div class="layui-row layui-col-space10">
        <%--      左侧栏，显示文章信息      --%>
        <div class="layui-col-md7  layui-col-md-offset1" style="height: 90%">
            <style>
                .indexTitle {
                    font-size: 18px;
                    line-height: 40px
                }

                .abstract {
                    color: #999;
                    font-size: 13px;
                    line-height: 24px;
                }

                #right li {
                    padding: 15px 2px 20px 0;
                    margin: 0 0 15px;
                    border-bottom: 1px solid #f0f0f0;
                }

                #right .meta {
                    font-size: 12px;
                }

                #right .meta a {
                    color: #b4b4b4;
                }

                #right .start {
                    color: #b4b4b4;
                }

            </style>
            <ul style="width: 70%;margin: 0 auto" id="right" class="flow-default">
                <%--<li style="width: 100%">
                    <div class="postContent">

                        &lt;%&ndash; 显示文章标题 &ndash;%&gt;
                        <a style="color: black" class="indexTitle" target="_blank" href="/simpleBook/read.jsp?pid=">30岁了没有一点方向</a>
                        &lt;%&ndash; 显示文章内容节选 &ndash;%&gt;
                        <p class="abstract">
                            晚上睡不着，干脆写篇文再睡。 我一直以为自己30岁，没结婚，还年轻。今天人家告诉我，再有几天过年了，过完年我就是32岁了，我们这都讲虚岁的。 那...
                        </p>
                        &lt;%&ndash; 显示文章点赞信息，评论信息 &ndash;%&gt;
                        <div class="meta">
                            <span class="jsd-meta">
                              <i class="iconfont ic-paid1"></i> 3.9
                            </span>
                            <a class="nickname" target="_blank" href="/u/f4ec3457f617">我是你的茉莉小姐</a>
                            <a target="_blank" href="/p/1931a925ddbe#comments">
                                <i class="iconfont ic-list-comments"></i> 4
                            </a> <span><i class="iconfont ic-list-like"></i> 17</span>
                        </div>
                    </div>
                </li>--%>
            </ul>

        </div>
        <%--    右侧栏    --%>
        <div class="layui-col-md3">
            <div class="layui-col-md12">
                <img id="huiyuan" src="images/OEZXS$%602CGGLITMHC%5DIA%7BCC.png">
            </div>
            <div class="layui-col-md12" style="padding-top: 50px">
                <style>
                    .userList li {
                        margin-bottom: 20px;
                    }

                    .indexFollow span, a {
                        color: #00bb29;
                    }

                    .indexFollow a:hover {
                        color: #00bb29;
                    }

                    .indexFollow a:visited {
                        color: #00bb29;
                    }

                    .indexFollow {
                        cursor: pointer;
                    }

                    #huiyuan {
                        cursor: pointer;
                    }

                    .userList img {
                        border-radius: 50%;
                    }
                    .userList img{
                        cursor: pointer;
                    }
                    .userList .name{
                        cursor: pointer;
                    }
                </style>
                <ul class="userList">
                </ul>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">

    layui.use(["jquery", "layer", "flow"], function () {
        var flow = layui.flow;
        var $ = layui.jquery;
        var layer = layui.layer;
        flow.load({
            elem: '#right' //流加载容器
            , done: function (page, next) { //执行下一页的回调
                $.ajax({
                    url: "/simpleBook/post/selectPost",
                    data: {page: page, limit: 6},
                    type: "post",
                    success: function (data) {
                        let count = data.count;
                        //插入查询的数据
                        setTimeout(function () {
                            var lis = [];
                            // 遍历查询到的数据
                            for (var i = 0; i < data.data.length; i++) {
                                var postInfo = data.data[i];
                                var content = $("<span>" + postInfo.article + "</span>").text();
                                content = content.length > 150 ? content.substring(0, 150) + "..." : content;
                                var temp = '<li style="width: 100%">' +
                                    '                    <div class="postContent">' +
                                    '\n' +
                                    '                        <a style="color: black" class="indexTitle" target="_blank" href="/simpleBook/read.jsp?pid=' + postInfo.pid + '">' + postInfo.title + '</a>\n' +
                                    '                        <p class="abstract">' + content +
                                    '                        </p>' +
                                    '                        <div class="meta">' +
                                    '                            <span class="jsd-meta">' +
                                    '                              <i class="iconfont ic-paid1"></i> ' + postInfo.hot +
                                    '                            </span>' +
                                    '                            <a class="nickname" target="_blank" href="/simpleBook/anotherpage.jsp?cid=' + postInfo.user.uid + '">&nbsp;&nbsp;&nbsp;' + postInfo.user.uname + '&nbsp;&nbsp;&nbsp;</a>' +
                                    '                            <a target="_blank" href="/p/1931a925ddbe#comments">' +
                                    '                                <i class="iconfont ic-list-comments"></i> 4' +
                                    '                            </a> ' +
                                    '                           <span class="start">' +
                                    '                               <i class="iconfont ic-list-like"></i>' + postInfo.start + '' +
                                    '                           </span>' +
                                    '                        </div>\n' +
                                    '                    </div>\n' +
                                    '                </li>';
                                lis.push(temp)
                            }

                            //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
                            //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
                            next(lis.join(''), page < (count / 6)); //假设总页数为 10
                        }, 500);
                    }, error: function () {
                        layer.msg("信息加载错误，请稍后访问");
                    }
                });
            }
        });

        // 会员点击事件
        $("#huiyuan").click(function () {
            location.href = "/simpleBook/huiyuan.jsp"
        });

        // 加载右侧栏人物信息
        (function () {
            $.ajax({
                url: "/simpleBook/user/selUserForIndex",
                type: "get",
                success: function (data) {
                    for (const user of data) {
                        // 遍历该用户的所有文章
                        var textNum = 0;
                        var start = 0;
                        for (const post of user.posts) {
                            start += post.start;
                            textNum += post.textNum;
                        }
                        textNum = (textNum / 1000).toFixed(1);
                        start = start < 1000 ? parseInt(start) : (start / 1000).toFixed(1);
                        var temp = ' <li style="width: 100%">' +
                            '                        <img src="/simpleBook/resources/userPhoto/' + user.photo + '" onclick="javascript:location.href=\'/simpleBook/anotherpage.jsp?cid='+user.uid+'\'"  width="50px" height="50px">' +
                            '                        <div style="display: inline-block;vertical-align: top;padding-top: 5px;width: 45%;">' +
                            '                            <span class="name" onclick="javascript:location.href=\'/simpleBook/anotherpage.jsp?cid='+user.uid+'\'">' + user.uname + '</span>' +
                            '                            <span class="indexFollow" style="float: right">' +
                            '                                <span style="display: inline-block;height: 20px;width: 60px;">' +
                            '                                    <span class="layui-icon" style="display: inline-block;width: 14px;">' +
                            '                                        &#xe654;' +
                            '                                    </span>' +
                            '                                    <a href="javascript:void(0)" value=' + user.uid + ' class="changeRelationForIndex" style="font-size: 13px;">关注</a>' +
                            '                                </span>' +
                            '                            </span>' +
                            '                            <br>' +
                            '                            <span style="font-size: 12px;display:inline-block;vertical-align: bottom;padding-top: 10px">写了' + textNum + 'k字 · ' + start + '喜欢</span>' +
                            '                        </div>' +
                            '                    </li>';
                        $(".userList").append($(temp));
                    }
                }, error: function () {
                    layer.msg("信息加载异常，请刷新后重新");
                }
            })
        })();


        // 关注按钮点击事件
        $(".userList").on("click",'.indexFollow', (function () {
                console.log("sjab");
                // 判断是否已经登录
                if ("${user.uid}" == '') {
                    layer.msg("还没有登录哦，不能点赞");
                    return;
                }
                let b = getRelation($(this).find("a").attr("value"));
                // 判断是否已经关注了
                if(b){
                    layer.msg("您已经关注过了哦");
                    return;
                }

                // 关注获取去取消关注
                let b1 = relation("true",$(this).find("a").attr("value"));
                if(b1){
                    $(this).find("a").prev().remove();
                    $(this).find("a").text("已关注");
                }
            })
        );
    })

</script>
</body>
</html>
