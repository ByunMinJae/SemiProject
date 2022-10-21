<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코딩 산악회</title>

<!-- jQeury 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<style type="text/css">


.header li {
	display: list-item;
	list-style-type: none;
}

.wrapper {
	width: 1140px;
	overflow: hidden;
}

.header {
	position: fixed;
    width: 100%;
    min-width: 1048px;
	top: 0;
	left: 0;
	max-height: 120px;
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

.container {
	position: relative;
	top: 100px;
	margin-bottom: 150px;
}

.container-wrap {
	width: 75%;
	margin: 0 auto;
}

.top-wrap {
	position: relative;
	top: 0;
	width: 100%;
	height: 38px;
	background:  #E1FFB1;
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
	font-family: "돋움", Dotum,'Apple SD Gothic Neo', 'Malgun Gothic', 'Helvetica Neue', Helvetica, sans-serif;
}

.header-title {
	position: relative;
	top: 0;
	height: 80px;
	margin: 0;
	padding: 0;
}

.header-menu {
	display: inline-box;
	position: relative;
	width: 100%;
}

.header-menu .p-logo {
	float: left;
	position: absolute;
	height: 50px;
}

.header-menu .p-logo p {
	margin: 0;
	padding: 0;
}

.header-menu .p-logo img {
	width: 280px;
	height: 80px;
}

.header-menu .hmenulist {
	position: absolute;
	float: left;
	top: 8px;
	left: 30%;
	height: 80px;
} 

.header-menu .hmenulist ul {
	display: -webkit-inline-box;
}

.header-menu .hmenulist ul li {
	float: left;
	margin-left: 70px;
	font-size: x-large;
	font-style: bold;
}

.header-menu .hmenulist ul li a {
	width: 100px;
	color: black;
	text-decoration: none;
	margin: o;
	padding: p;
}

.header-menu .weather-wrap {
	position: absolute;
	display: inline-block;
	top: 20px;
	left: 80%;
}

.header-menu .weather-wrap .weather {
	position: absolute;
}


.footer {
    width: 100%;
    min-width: 1048px;
	bottom: 0;
	left: 0;
	max-height: 50px;
	border-top: 1px solid #ddd;
	background: #fff;
	z-index: 99;
}

.footer-wrap {
	position: relative;
	bottom: 0;
	width: 75%;
	margin: 0 auto;
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

.footerlist a{
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
	<header id="header" class="header">
		<div class="top-wrap">
			<div class="header-wrap">
				<div class="top">
					<ul class="toplist">
						<li><a href="/mypage/main" class="">마이페이지</a></li>
						<li><a href="<%-- 회원가입 링크 --%>">회원가입</a></li>
						<%if ( session.getAttribute("userid") == null){ %>
						<li><a href="/cmc/login">로그인</a></li>
						<% } else { %>
						<li><a href="/cmc/logout">로그아웃</a></li>
						<% } %>
					</ul>
				</div> <!-- .top end -->
			</div> <!-- .header-wrap end -->
		</div> <!-- .top-wrap end -->	
		
		<div class="header-title">
			<div class="header-wrap">
				<div class="header-menu">
					<div  class="p-logo">
						<p><a href="/main"><img src="/resources/image/logo.png" id="logo"></a></p>
					</div>
					<div class="hmenulist">
						<ul>
							<li><a href="/board/notice">게시판</a></li>
							<li><a href="<%-- 등산 도우미 링크--%>">등산 도우미</a></li>
							<li><a href="<%-- 굿즈샵 링크--%>">굿즈샵</a></li>
						</ul>
					</div>
					<div class="weather-wrap">
						<ul class="">
							<li><a href="<%-- 날씨 위젯 --%>" id="wethwidget">날씨위젯</a>					
						</ul>
					</div> <!-- .weather-wrap end -->
				</div> <!-- .header-menu end -->
			</div> <!-- .header-wrap end -->
		</div> <!--.header-title end -->
	</header>	


<div class="container">
	<div class="container-wrap">