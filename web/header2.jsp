<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="/simpleBook/css/personal_one.css" />
		<link rel="stylesheet" href="/simpleBook/css/personal_two.css" />
		<script type="text/javascript" src="/simpleBook/js/jquery-1.12.4.min.js" ></script>
	</head>
	
	<script>
		$(function() {
			$("#userlog").hover(function() {
				$("#userlog").removeClass("user");
				$("#userlog").addClass("user open");
			},function(){
				$("#userlog").removeClass("user open");
				$("#userlog").addClass("user");
			})
		})
		
	</script>

	<body>
		<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
			<div class="width-limit">
				<!-- 左上方 Logo -->
				<a class="logo" href="/simpleBook/index.jsp"><img src="/simpleBook/images/jianjianshulogo.png" alt="Nav logo" /></a>

				<!-- 右上角 -->
				<!-- 登录显示写文章 -->
				<a class="btn write-btn" target="_blank" href="/simpleBook/writePost.jsp">
					<i class="iconfont ic-write"></i>写文章
				</a>
				<!-- 如果用户登录，显示下拉菜单 -->
				<div class="user" id="userlog">
					<div data-hover="dropdown">
						<a class="avatar" href="/simpleBook/personal.jsp">
							<img src="/simpleBook/resources/userPhoto/${user.photo}" alt="120" />
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
							<a rel="nofollow" data-method="delete" href="/simpleBook/user/loginOut">
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
								<a href="/">
									<span class="menu-text">发现</span>
									<i class="iconfont ic-navigation-discover menu-icon"></i>
								</a>
							</li>
							<li class="search">
								<form target="_blank" action="" accept-charset="UTF-8" method="get">
									<input type="text" name="q" id="q" value="" autocomplete="off" placeholder="搜索" class="search-input" />
									<a class="search-btn" onclick="tiaozhuan()">
										<i class="iconfont ic-search"></i>
									</a>
								</form>
								<script>
									function tiaozhuan() {

										var search = document.getElementById("q").value;

										window.location.href="/simpleBook/post/selectPostUserType?search="+encodeURI(search);
									}
								</script>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</nav>
	</body>

</html>