<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Layui</title>
</head>
<%
    Object user = session.getAttribute("user");
    if(null==user){
        response.sendRedirect(application.getContextPath()+"/login.html");
    }
%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/layui/layui.js"></script>
<link href="<%=request.getContextPath()%>/js/layui/css/layui.css" rel="stylesheet" type="text/css" media="all">
<body style="color: white;padding: 5px">


<div class="layui-fluid" style="margin: 0 auto">

    <div class="layui-row layui-col-space12">
        <div class="layui-col-md15">
            <div class="layui-row layui-col-space15">
                <%--      个人发帖  --%>
                <div class="layui-col-md2 layui-bg-green">
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

                <%--    发布文章    --%>
                <div class="layui-col-md8 layui-bg-black">
                    <form class="layui-form">
                        <div class="layui-form-item">
                            <label class="layui-form-label">标题：</label>
                            <input type="text" class="layui-input layui-input-block" style="width: 50%"/>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">主题：</label>
                            <div class="layui-input-inline" style="width: 50%">
                                <select name="modules" lay-verify="required" lay-search="">
                                    <option value="">直接选择或搜索选择</option>
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
                            <button type="button" class="layui-btn layui-btn-primary">发布</button>
                        </div>
                    </form>
                </div>

                <%--   作者简介(作者的个人介绍)     --%>
                <div class="layui-col-md2 layui-bg-cyan">

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
        edit.build("context", {
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
    })
</script>
</body>
</html>
