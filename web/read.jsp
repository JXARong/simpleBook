<%--
  Created by IntelliJ IDEA.
  User: ko no dio da!
  Date: 2019/11/11
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="icon" type="image/x-icon" href="/simpleBook/images/girl.png" />
    <title>Title</title>
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

        .header {
            background-color: #ffffff;
            position: fixed;
            height: 58px;
            width: 100%;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.3);
            z-index: 1;
        }

        .middle {

        }

        .hidden {
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

        .left img {
            position: relative;
            left: 12px;
            top: 12px;
        }

        #shang {
            position: relative;
            left: 10px;
            top: 10px;
        }

        .left_style label, .left_style img:hover {
            cursor: pointer;
        }

        .roundness {
            border-radius: 50%;
        }

        .right {
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
        }

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
        .attention:hover{
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

        .header > div {
            margin: 0px 13.78947368421053%;
            line-height: 58px;
        }

        .footer div {
            margin-left: 20%;
        }

        .header_left > a {
            color: rgb(236, 114, 89);
            text-decoration: none;
            font-size: 28px;
            font-weight: 500;
            display: inline-block;
            margin-right: 4%;
            float: left;
        }

        .header_left > a:hover {
            color: rgb(240, 141, 121);
        }

        .header_left > a:active {
            color: rgb(232, 87, 57);
        }

        .header_left > ul {
            display: inline-block;
            height: 58px;
            float: left;
            margin: 0px;
            margin-right: 16px;
        }

        .header_left ul li {
            float: left;
            background-color: #fff;
            height: 58px;
            width: 74px;
        }

        .header_left ul li a {
            display: inline-block;
            font-size: 17px;
            color: #000000;
            height: 58px;
            width: 74px;
            text-align: center;
            text-decoration: none;
        }
        .author img{
            float: left;
            border: 1px solid #EEEEEE;
        }
        .header_left ul li a:hover {
            background-color: rgb(242, 242, 242);
        }

        .search > form > input {
            width: 160px;
            height: 36px;
            padding: 10px;
            border: none;
            margin-top: 11px;
            outline: none;
            background-color: #F2F2F2;
            border-radius: 20px;
            padding-right: 40px;
        }

        .search > form > img {
            height: 36px;
            width: 36px;
            position: absolute;
            z-index: 1;
            bottom: 11px;
            left: 117px;
            box-sizing: border-box;
            padding: 6px;
            cursor: pointer;
        }

        .search {
            height: 58px;
            width: 200px;
            float: left;
            position: relative;
        }

        .header_right button {
            float: right;
            height: 40px;
            width: 108px;
            border-radius: 20px;
            border: none;
            outline: none;
            background: #EC7259;
            margin: 9px 0px;
        }

        .header_right button:hover {
            background: #ED7961;
        }

        .header_right button img {
            float: left;
            z-index: 1;
            height: 30px;
            width: 30px;
            padding-top: 5px;
        }

        .header_right button a {
            float: left;
            line-height: 40px;
            padding-left: 5px;
            font-size: 15px;
            color: #fff;
            text-decoration: none;
        }

        .search form img:hover {
            cursor: pointer;
        }

        .header_right_head img {
            margin-top: 8px;
            margin-left: 10px;
            height: 40px;
            width: 40px;
            border-radius: 50%;
            background-color: #000;
            margin-right: 100px;
        }

        .header_right_head {
            width: 80px;
            height: 58px;
            float: right;
            position: relative;
        }

        .header_right_head div {
            position: absolute;
            height: 0px;
            width: 0;
            border: 5px solid transparent;
            border-bottom: none;
            border-top: 5px solid #999999;
            left: 56px;
            bottom: 25px;
        }

        .header_right_head:hover {
            background-color: #F2F2F2;
        }

        img[src="images/font_zuan.png"] {
            position: absolute;
            bottom: 1px;
        }

        .font_zuan {
            position: relative;
            float: right;
            height: 56px;
            width: 113px;
        }


        .review img{
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
        .right_head_text{
            position: absolute;
            top: 31px;
            width: 175px;
            padding-left: 6px;
        }
        .message_style_a{
            color: #000;
            text-decoration: none;
        }
        .message_style_p{
            color: #969696;
        }
        .review form textarea:focus {
            height: 72px;
            width: 500px;
        }
        .fill{
            height: 77px;
            width: 100%;
        }
        .title{
            margin: 0px 0px 20px 0px;
           box-sizing: border-box;
        }
        .message{
            width: 100%;
            height: 80px;
            padding: 17px 0px;
            box-sizing: border-box;
        }
        .float_left{
            float: left;
        }
        .float_right{
            float: right;
        }
        .message_message{
            padding: 10px;
        }
        .message_message *{
            margin-right: 10px;
        }


    </style>
    <script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript">
        window.onload = function () {

            document.getElementsByClassName("left_style")[0].onclick = function () {
                var uid=1;
                var pid=1;

            }
            document.getElementsByClassName("roundness inline_block float_left")[0].onclick = function (){
                alert("888");
            }
            document.getElementsByClassName("attention float_left")[0].onclick = function (){
                var uid=1;
                var cid=1;
            }
            document.getElementsByClassName("left_style")[1].onclick = function () {
                var time = setInterval(function () {
                    var top = document.body.scrollTop || document.documentElement.scrollTop;
                    console.log(top);
                    scroll(0, top - 40);
                    if (top <= 0) {
                        clearInterval(time);
                    }
                }, 1)
            }
        }
        var fixedDom = document.getElementsByClassName("reading")[0];
        window.onscroll = function () {
            if (document.body.scrollTop >= 100) {

            } else {
                fixedDom.style.position = "relative";
            }
        }
        var riview = document.getElementById("riview");
        riview.onfocus = function () {
            alert(666)
        }
    </script>
</head>
<body>

<header class="header">
    <div class="header_left">
        <a href="#">简·简书</a>
        <ul>
            <li><a href="#">发现</a></li>
            <li><a href="#">关注</a></li>
            <li><a href="#">消息</a></li>
        </ul>
        <div class="search">
            <form action="">
                <input type="text" placeholder="搜索">
                <img src="images/sousuo.png" alt="搜索">
            </form>
        </div>
    </div>
    <div class="header_right">
        <button>
            <img src="images/write.png" alt="">
            <a href="">写文章</a>
        </button>
        <div class="header_right_head">
            <img src="images/default_head_portrait.jpg" alt="">
            <div></div>
        </div>
        <div class="font_zuan">
            <img src="images/font_zuan.png" alt="">
        </div>
    </div>
</header>
<div class="middle">
    <div class="fill"></div>
    <div class="hidden">
        <h1 class="title">废掉一个人最隐蔽的方式，是让他忙到没时间成长</h1>
        <div class="message">
            <img src="images/default_head_portrait.jpg" height="45px" width="45px" class="roundness inline_block float_left">
            <div class="inline_block float_left message_message">
                <a href="" title="ig666" class="message_style_a float_left">ig666</a>
                <button class="attention float_left">关注</button>
                <p class="margin0px message_style_p float_left">2019.10.29 12:49:29 字数 707 阅读 3,202</p><br>
            </div>

        </div>
        <article>
            <p>【香知蜜读1187】&nbsp;2019/03/16&nbsp;星期六&nbsp；荐书蜜友：书童珊珊</p>
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
            <p><b>&nbsp01&nbsp</b> &nbsp<b>每份工作必然包含大比例的重复性、同质化工作。</b></p>
            <p>比如我做新媒体讲师时，前期准备课程时，我每天进步很大，我每天再打磨新的东西，等这个课程做出来，自己出去讲一次进步很大，再讲第二次，还有很大进步.......</p>
            <p>但这毕竟是一个重复的、同质化工作，我每天出去出去就是讲那几百页PPT，当我疲于奔波在一个个公开课和一家家企业、没有时间学习新东西是，我的进步就变得很慢了</p>
        </article>

        <div>
            <span><h3>全部评论</h3></span>
        </div>
        <div style="float: left ">
            <img src="images/qq.png" >
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
            <div class="left_aside roundness">
                <img src="images/shang_gary.png" height="30" width="30" id="shang"/>
            </div>
            <label>喜欢</label>
        </div>
        <div class="left_style">
            <div class="left_aside roundness">
                <img src="images/go_top.png" height="24" width="24"/>
            </div>
            <label>顶部</label>
        </div>
    </div>

</div>
<div class="footer">
    <div class="review">
        <form action="">
            <textarea placeholder="写下你的评论..." id="review"></textarea><button>发布</button>

        </form>

    </div>
</div>
</body>
</html>
