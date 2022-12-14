
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코딩 산악회</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


<!-- jQeury 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">



</script>

<style type="text/css">


.header li {
	display: list-item;
	list-style-type: none;
}

.wrapper {
	width: 1140px;
	overflow: hidden;
}

.wrap {
	position: relative;
}

.header {
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

.container {
	position: relative;
	top: 110px;
	margin-bottom: 380px;
}

.container-wrap {
	margin-top:60px ;
}

.top-wrap {
	position: absolute;
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

.header-main-wrqp {
	position: relative;
    margin-top: 3px;
    height: 50px;
}

.header-title {
	padding: 0;
	height: 20px;
	margin-top: 30px;
}

.header-title a {
	position: relative;
	text-decoration: none;
	color: black;
}

.header-title img {
	width: 300px;
	height: 90px;
}

.header-menu {
	position: relative;
}

.header-menu .hmenulist {
	display: block;
	margin-left: 500px;
	width: 50%;
	height: auto;
} 

.header-menu .hmenulist li {
	float: left;
	margin-left: 60px;
	font-size: x-large;
	font-style: bold;
	margin-bottom: 15px;
}

.header-menu .hmenulist li a {
	width: 100px;
	color: black;
	text-decoration: none;
}

.header-menu .weather-wrap {
	display: inline-block;
	float: left;
	margin-left: 5%;
}

.header-menu .weather-wrap .weather {
	position: relative;
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

.header p{
	display: inline-block; 
    margin-top: 29px !important;
    font-size: xx-large; 
    font-weight: bolder; 
}

.header form{
	width:50%;
	margin: 0 auto;
}

#managerBoardForm{
	width:50%;
	margin: 0 auto;
}
.header select[multiple]{
	height: 109px; important!
}

.header option{
	text-align: center;
}

#managerBoardOption{
	text-align: center;
}

#managerBoardOption:hover{
	background-color: #ccc;
}
.header option:hover {
	background-color: #ccc;
}

#managerBoardButton{
	margin-left: 252px;
}

.header button {
	margin-left: 252px;
}

.thead{
	background-color: #E1FFB1 !important;
}
</style>

</head>
<body>
<div id="wrapper">
	<div class="wrap">
		<header id="header" class="header">
			<div class="top-wrap">
				<div class="header-wrap">
					<div class="top">
						<ul class="toplist">
						<%if ( session.getAttribute("userno") == null){ %>
		                <li><a href="/manager/login">로그인</a></li>
		                <% } else { %>
		                <li><a href="/manager/logout">로그아웃</a></li>
		                <% } %>
					</ul>
					</div> <!-- .top end -->
				</div> <!-- .header-wrap end -->
			</div> <!-- .top-wrap end -->	
			<div class="header-wrap">
				<div class="header-title">
					<p><a href="/manager/main">ADMIN</a></p>
				</div> <!--.header-title end -->
				<div class="header-menu">
					<ul class="hmenulist">
						<%if ( session.getAttribute("userno") == null){ %>
		                <li><a href="/manager/login">주문관리</a></li>
		                <% } else { %>
						<li><a href="/prodOrdAd/list">주문관리</a></li>
		                <% } %>
		                
						<%if ( session.getAttribute("userno") == null){ %>
		                <li><a href="/manager/login">게시판관리</a></li>
		                <% } else { %>
						<li><a href="/manager/board">게시판관리</a></li>
		                <% } %>
		                
		                
						<%if ( session.getAttribute("userno") == null){ %>
		                <li><a href="/manager/login">회원관리</a></li>
		                <% } else { %>
						<li><a href="/user/list">회원관리</a></li>
		                <% } %>
		                
		                
						<%if ( session.getAttribute("userno") == null){ %>
		                <li><a href="/manager/login">상품관리</a></li>
		                <% } else { %>
						<li><a href="/prod/list">상품관리</a></li>
		                <% } %>
					</ul>
						
				</div> <!-- .header-menu end -->
			</div> <!-- .header-wrap end -->
		</header>	
	</div> <!-- .wrap end -->


<div class="container">
	<div class="container-wrap">