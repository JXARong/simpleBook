<%--
  Created by IntelliJ IDEA.
  User: ARong
  Date: 2019/12/26
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>阅读</title>
    <script src="/simpleBook/js/layui/layui.js"></script>
    <link rel="stylesheet" href="/simpleBook/js/layui/css/layui.css">
</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${user==null}">
    <jsp:include page="header.jsp"/>
</c:if>
<c:if test="${user!=null}">
    <jsp:include page="header2.jsp"/>
</c:if>
<style>
    .title{
        margin: 0px 0px 20px 0px;
        box-sizing: border-box;
    }
    .attention {
        height: 23px;
        width: 50px;
        border-radius: 20px;
        border: 1px solid #EC7259;
        background-color: #fff;
        color: #EC7259;
    }
    .message_message *{
        margin-right: 10px;
    }
    .float_left {
        float: left;
    }
    .attention {
        height: 23px;
        width: 50px;
        border-radius: 20px;
        line-height: 23px;
        outline: none;
        background-color: #fff;
        color: #EC7259;
    }
    .roundness{
        border-radius: 50%;
    }
    #postInfo{
        font-size: 14px;
        color: #969696;
    }
    .message {
        width: 100%;
        height: 80px;
        padding: 17px 0px;
        box-sizing: border-box;
    }
    .message_message{
        padding: 10px;
    }
    .postContext{
        width: 752px;
        height: 10000px;
        padding: 24px;
        position: absolute;
        left: 450px;
    }
</style>
<div class="postContext">
    <h1 class="title">废掉一个人最隐蔽的方式，是让他忙到没时间成长</h1>
    <div class="message">
        <img src="images/default_head_portrait.jpg" height="45px" width="45px" class="roundness inline_block float_left">
        <div class="inline_block float_left message_message">
            <a href="" title="ig666" class="message_style_a float_left" id="uname">HelloWorld</a>
            <button class="attention float_left layui-btn-sm layui-btn">关注</button>
            <p class="margin0px message_style_p float_left" id="postInfo">2019.10.29 12:49:29 字数 707 阅读 3,202</p><br>
        </div>

    </div>
    <article>
        <p>【香知蜜读1187】&nbsp;2019/03/16&nbsp;星期六&nbsp;；荐书蜜友：书童珊珊</p>
        <p>文：粥左罗</p>
        <p>大家可能都看过一个观点：废掉一个人最快的方式，就是让他闲着</p>
        <p><b>我认同吗？非常认同</b></p>
        <p>"但我今天想讲另外一个角度，"
            <b>废掉一个人最隐蔽的方式，是让他忙到没时间成长。</b>
        </p>
        <p>
            <b>而且我认为这个点更重要，因为大部分人都不闲，大家都在努力的生活，北上广深等大城市的年轻人，尤其是互联网从业者，不仅不闲，还每天忙的要死，甚至周末都不休息。</b>
        </p>
        <p>这样一群人，我根本不怕他们太闲，我更怕他们太忙，，尤其是怕他们忙到他们没时间成长。</p>
        <p>01</p>
        <p><b>废掉一个人最隐蔽的方式</b></p>
        <p><b>是让他忙到没时间成长</b></p>
        <p>我的团队都是社群里招的，所以大家价值观一致做事理念一致，目标一致，我们彼此深度信任，因此我不怎么管着他们，他们也超级努力，一个表现就是：</p>
        <p>
            <b>下班之后他们主动加班，周末他们主动给自己工作加量，更快的推进工作，总之特别忙，工作时间超长。</b>
        </p>
        <p>很多老板喜欢看到员工这样，但我总是担心，担心他们忙到没有时间成长。我经常告诉他们要注意休息，周末也不要一直干活。</p>
        <p><b>我有一个课程助理，前几天我和他说了这么一段话：</b></p>
        <p>你一定要控制好自己的工作节奏，不用推进的太猛，每天早点下班，周末也不用这么拼。你空出来的时间，除了休息好，就是用来自我成长。</p>
        <p>"比如，你的工作要写东西，那么你必须保证每天拿出固定的时间学习、大量阅读、听课，甚至这要变成一个强制的学习任务，跟你的工作任务同样重要，甚至你上班时间也可以这样做没关系"</p>
        <p>"我写作三年多，为什么越写越好，永不枯竭，永远有新东西可写，永远能提出新观点，因为每天晚上12点到凌晨3点左右，几乎是我雷打不动的学习时间，不管当天多累，这个习惯我都没有中断。"</p>
        <p><b>你必须有时间成长，而不是无休止的工作。</b></p>
        <p><b>不信你问问自己：</b>
            <b>过去一个月的忙碌中，过去一年的忙碌中，你有多少时间在成长？你成长了多少？</b>
        </p>
        <p>如果你每天忙到连认真读几篇好文章的时间都没有，忙到连听一个小时课都没有，忙到想在周末精进一下某项能力、某项技能的时间都没有，你必须要正视这个问题了。</p>
        <p>很多人沉浸在每天的忙碌工作中，早上八点出门，晚上十点多回家，累的洗漱完倒头就睡，明天又重复这样一天......日复一日。</p>
        <p>
            <b>这是废掉一个人最隐蔽的方式，因为你会觉得明明自己每一天都特别充实，每天都干了很多活。</b>
        </p>
        <p>
            <b>你每天都干了很多活，是没错，但你过去这半年，这一年进步了多少？你心里没有一点数吗。</b>
        </p>
        <p><b>为什么说这样是废掉呢？</b></p>
        <p>因为学习是一种习惯，成长是一种习惯，精进也是一种习惯，你若是一年两年里都忙到没时间成长，你最终也会习惯了每天不成长的状态，毕竟不成长本身也是人最舒服的状态。</p>
        <p><b>因此，时间长了你就丧失了成长的能力。</b></p>
        <p><b>而大部分老板并不关心这些，为什么呢？</b></p>
        <p>"比如一个新媒体工作的老板招一个小编，如果这个小编成长很快，可以做更有价值的事情，这对老板来说是意外之喜；如果这个小编不成长，那完全没关系，老板招你来就是让你做小编的工作的，你一年不进步也没关系，你就日复一日做好你本职工作就好。"</p>
        <p>"因此，你成长，是老板可遇不可求的，是不可控的；而在"<b>[你能胜任的工作]"上给你不断加任务、工作量，是老板可控的、可明显有更大收益的做法。所以，你需要自己争取成长时间。"</b></p>
        <p>02</p>
        <p><b>一个人在职场里持续上升</b></p>
        <p><b>必须要有持续的增量成长</b></p>
        <p>有人说：工作的过程，不就是很好的成长过程吗？</p>
        <p>我认同么，非常认同。但同时，有很大的局限性。</p>
        <p>为什么呢？</p>
        <p><b>&nbsp;01&nbsp;</b> &nbsp;<b>每份工作必然包含大比例的重复性、同质化工作。</b></p>
        <p>比如我做新媒体讲师时，前期准备课程时，我每天进步很大，我每天再打磨新的东西，等这个课程做出来，自己出去讲一次进步很大，再讲第二次，还有很大进步.......</p>
        <p>但这毕竟是一个重复的、同质化工作，我每天出去出去就是讲那几百页PPT，当我疲于奔波在一个个公开课和一家家企业、没有时间学习新东西是，我的进步就变得很慢了</p>
    </article>

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
</body>
</html>
