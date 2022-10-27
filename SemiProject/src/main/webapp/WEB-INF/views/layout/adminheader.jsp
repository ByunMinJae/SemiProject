
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

p{
	display: inline-block; 
    margin-top: 29px !important;
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
						
					</div> <!-- .top end -->
				</div> <!-- .header-wrap end -->
			</div> <!-- .top-wrap end -->	
			<div class="header-wrap">
				<div class="header-title">
					<p>ADMIN</p>
				</div> <!--.header-title end -->
				<div class="header-menu">
					<ul class="hmenulist">
						<li><a href="/prodOrdAd">주문관리</a></li>
						<li><a href="/manager/board">게시판관리</a></li>
						<li><a href="/user/list">회원관리</a></li>
						<li><a href="">상품관리</a></li>
					</ul>
						
				</div> <!-- .header-menu end -->
			</div> <!-- .header-wrap end -->
		</header>	
	</div> <!-- .wrap end -->


<div class="container">
	<div class="container-wrap">