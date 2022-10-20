<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코딩 산악회</title>

<!-- jQeury 2.2.4 -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 부트스트랩 Bootstrap 3 -->
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script> -->

<style type="text/css">
p {
	position: relative;
}

li {
	display: list-item;
	list-style-type: none;
}

.wrapper {
	width: 1140px;
	overflow: hidden;
}

#header {
	position: fixed;
	width: 100%;
	min-width: 1048px;
	top: 0;
	left: 0;
	max-height: 230px;
	border-bottom: 1px solid #ddd;
	background: #fff;
	z-index: 99;
}

.header-wrap {
	position: relative;
	top: 0;
	width: 75%;
	margin: 0 auto;
}

.container-wrap {
	position: relative;
	top: 0;
	width: 75%;
	margin: 0 auto;
}

.footer-wrap {
	position: relative;
	bottom: 0;
	width: 75%;
	margin: 0 auto;
}

.top-wrap {
	position: absolute;
	top: 0;
	right: 10px;
	width: 100%;
	height: 38px;
	background: #E1FFB1;
	z-index: 1;
}

.top-wrap .top {
	width: 100%;
}

.top-wrap .top .toplist {
	margin-top: 8px;
	float: right;
}

.top-wrap .top .toplist li {
	float: left;
	margin-left: 12px;
	color: gray;
	font-size: 14px;
}

.top-wrap .top .toplist li a {
	color: gray;
	text-decoration: none;
	font-family: "돋움", Dotum, 'Apple SD Gothic Neo', 'Malgun Gothic',
		'Helvetica Neue', Helvetica, sans-serif;
}

.header-main-wrqp {
	position: relative;
	margin-top: 3px;
	height: 50px;
}

.header-title {
	padding: 0;
	height: 15px;
	margin-top: 30px;
}

.header-title img {
	width: 300px;
	height: 90px;
}

.header-menu {
	position: relative;
}

.header-menu .hmenulist {
	margin-left: 500px;
	width: 50%;
}

.header-menu .hmenulist li {
	float: left;
	margin-left: 70px;
	padding-bottom: 20px;
	font-size: x-large;
	font-style: bold;
}

.header-menu .hmenulist li a {
	color: black;
	text-decoration: none;
}

.header-menu .weather {
	float: left;
	margin-left: 200px;
}

#footer {
	position: relative;
	width: 100%;
	min-width: 1048px;
	bottom: 0;
	left: 0;
	max-height: 50px;
	border-top: 1px solid #ddd;
	background: #fff;
	z-index: 99;
}

.footerlist-wrap {
	margin-top: 40px;
}

.footerlist {
	position: relative;
}

.footerlist span {
	color: gray;
	font-size: 14px;
	float: left;
	margin-left: 15px;
}

.footerlist a {
	text-decoration: none;
	color: gray;
}

.copyright {
	color: gray;
	font-size: 14px;
	margin-left: 15px;
}
</style>

</head>
<body>
	<div id="wrapper">
		<header id="header">
			<div class="top-wrap">
				<div class="header-wrap">
					<div class="top">
						<ul class="toplist">
							<li><a href="<%-- 마이페이지 링크 --%>" class="">마이페이지</a></li>
							<li><a href="<%-- 회원가입 링크 --%>">회원가입</a></li>
							<%if ( session.getAttribute("userid") == null){ %>
					<li><a href="/cmc/login">로그인</a></li>
					<% } else { %>
					<li><a href="/cmc/logout">로그아웃</a></li>
					<% } %>
						</ul>
					</div>
					<!-- .top end -->
				</div>
				<!-- .header-wrap end -->
			</div>
			<!-- .top-wrap end -->
			<div class="header-wrap">
				<div class="header-title">
					<p>
						<img src="/resources/image/logo.png" id="logo">
					</p>
				</div>
				<!--.header-title end -->
				<div class="header-menu">
					<ul class="hmenulist">
						<li><a href="<%-- 게시판 목록 링크--%>">게시판</a></li>
						<li><a href="<%-- 게시판 목록 링크--%>">등산 도우미</a></li>
						<li><a href="<%-- 게시판 목록 링크--%>">굿즈샵</a></li>
					</ul>
					<div class="weather">
						<ul>
							<li><a href="<%-- 날씨 위젯 --%>" id="wethwidget">날씨위젯</a>
						</ul>
					</div>
					<!-- .weather end -->
				</div>
				<!-- .header-menu end -->
			</div>
			<!-- .header-wrap end -->



		</header>
		<style type="text/css">
.back {
	position: relatvie;
	top: 250px;
	width: 100vw;
	height: 100vh;
}

.login {
	text-align: center;
	position: absolute;
	top: 300px;
	left: 1300px;
	color: black;
	background-color: white;
	padding: 30px 30px;
	box-sizing: border-box;
	width: 400px;
	height: 300px;
	padding: 20px 30px;
	background-color: white;
	border-radius: 30px;
	border: 2px solid black;
}

input, button {
	width: 200px;
	height: 20px;
}


</style>
		<img src="/resources/image/unit-sunrise-md.png" class="back">
		<form class="login">
			<p style="font-size:30px;">코딩 산악회</p>
			<div class="panel_inner" role="tabpanel" aria-controls="loinid">
				<div class="id_pw_wrap">
					<div class="input_row" id="id_line">
						<input type="text" id="id" name="id" placeholder="아이디" title="아이디"
							class="input_text" maxlength="41" value=""> <span
							role="button" class="btn_delete" id="id_clear"
							style="display: none;"> <span class="icon_delete">
								<span class="blind">삭제</span>
						</span>
						</span>
					</div>
						<input type="password" id="pw" name="pw" placeholder="비밀번호"
							title="비밀번호" class="input_text" maxlength="16"> <span
							role="button" class="btn_delete" id="pw_clear"
							style="display: none;"> <span class="icon_delete">
								<span class="blind">삭제</span>
						</span>
						</span>
					</div>
				</div>
				<br>
				<hr style="width: 200px;">
				<br>
				<div class="btn_login_wrap">

					<button type="submit" class="btn_login" id="log.login">
						<span class="btn_text">로그인</span>
					</button>

				</div>
			</div>
		</form>

		<%@ include file="./layout/footer.jsp"%>

