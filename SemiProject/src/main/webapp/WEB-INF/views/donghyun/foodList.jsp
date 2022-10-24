<%@page import="donghyun.dto.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% List<Board> foodBoard = (List) request.getAttribute("foodBoard"); %>


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

<style type="text/css">


li {
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

.header-title p {
	position: relative;
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
	margin-left: 70px;
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

p{
	display: inline-block;
    margin-top: 29px;
    font-size: xx-large;
    font-weight: bolder;
}

form{
	width:50%;
	margin: 0 auto;
}

select[multiple]{
	height: 109px; important!
}

option{
	text-align: center;
}

option:hover {
	background-color: #ccc;
}

button {
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
							<li><a href="<%-- 마이페이지 링크 --%>" class="">마이페이지</a></li>
							<li><a href="<%-- 회원가입 링크 --%>">회원가입</a></li>
							<%if ( session.getAttribute("userno") == null){ %>
							<li><a href="/cmc/login">로그인</a></li>
							<% } else { %>
							<li><a href="/cmc/logout">로그아웃</a></li>
							<% } %>
						</ul>
					</div> <!-- .top end -->
				</div> <!-- .header-wrap end -->
			</div> <!-- .top-wrap end -->	
			<div class="header-wrap">
				<div class="header-title">
					<p>ADMIN</p>
				</div> <!--.header-title end -->
				<div class="header-menu">
					<ul class="hmenulist">
						<li><a href="<%-- 게시판 목록 링크--%>">게시판관리</a></li>
						<li><a href="<%-- 등산 도우미 링크--%>">회원관리</a></li>
						<li><a href="<%-- 굿즈샵 링크--%>">상품관리</a></li>
					</ul>
						
				</div> <!-- .header-menu end -->
			</div> <!-- .header-wrap end -->
		</header>	
	</div> <!-- .wrap end -->


<div class="container">
	<div class="container-wrap">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style type="text/css">
h1{
	text-align: center;
}

</style>
</head>
<body>
<h1>맛집 게시판</h1>
<hr>

<table class="table table-striped table-hover">

<tr class="thead">
	<th>글번호</th>
	<th>제목</th>
	<th>작성날짜</th>
	<th>카테고리번호</th>
	<th></th>

</tr>

<% for(int i=0; i<foodBoard.size(); i++){ %>
<tr>
	<td><%= foodBoard.get(i).getBoardno() %></td>
	<td><a href="./boardview?boardno=<%=foodBoard.get(i).getBoardno() %>"><%= foodBoard.get(i).getBoardtitle() %></a></td>
	<td><%= foodBoard.get(i).getBoarddate() %></td>
	<td><%= foodBoard.get(i).getCategoryno() %></td>
	<td><button>삭제</button></td>
</tr>
<% } %>

</table>
</body>
</html>