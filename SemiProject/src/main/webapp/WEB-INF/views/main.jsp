<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코딩 산악회</title>

<!-- jQeury 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 부트스트랩 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">

@font-face {
   font-family: 'dalseo';
   src: url('/resources/css/DalseoHealingBold.ttf') format('truetype');
}

@font-face {
    font-family: 'GmarketSansMedium';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansMedium.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

.header li {
	display: list-item;
	list-style-type: none;
}

.header a {
	color: #777  !important;
	text-decoration: none !important;
	cursor: pointer;
}
.header a:hover {
	color: #000 !important;
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
	top: 25px;
	left: 40%;
	height: 80px;
} 

.header-menu .hmenulist ul {
	display: -webkit-inline-box;
	font-family: 'dalseo';
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
	top: 5px;
	left: 90%;
}

@media screen and (max-width: 1500px){
	.header-menu .weather-wrap{
	display: none;
	}
}

.weather-widget p {
	font-family: "돋움", Dotum,'Apple SD Gothic Neo', 'Malgun Gothic', 'Helvetica Neue', Helvetica, sans-serif;
	z-index: 99;
}

.weather-widget .weather-back {
	position: absolute;
}

.weather-widget .weather-back .weatherImg{
	width: 140px;
	height: 70px;
	border-radius: 0.5em;
	z-index: 1;
	opacity: 0.5;
}

.weather-widget .weather-content {
	position: absolute;
	width: 142%;
}	

.weather-widget .weather-content .time {
	font-family: 'dalseo';
	font-size: 5px;
	text-align: center;
	color: gray;
	font-family: bold;
	margin: 1px auto;
}

.weather-widget .weather-content .ctemp {
	font-family: 'dalseo';
	margin: 0 auto;
	font-size: 26px;
	text-align: center;
	padding-left: 13px;
}

.weather-widget .weather-content ul {
	display: -webkit-inline-box;
	margin: 0;
	padding-left: 12px;
	float: left;
	font-family: 'dalseo';
}

.weather-widget .weather-content ul li {
	display: list-item;
	list-style-type: none;
	float: left;
	font-size: 12px;
}

.hightemp {
	color: #FA5050;
	font-family: bold;

}

.lowtemp {
	margin-left: 10px;
	color: #4683FC;
	font-family: bold;
}
.weather-widget .icon-wrap {
	display: inline-block;
	width: 100px;
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
						<%	if( session.getAttribute("userno") != null ) { %>
					
						<% } else { %>
						<li><a href="/user/join">회원가입</a></li>
						<% } %>
						<%if ( session.getAttribute("userno")==null && session.getAttribute("kakaono") == null){ %>
		                <li><a href="/cmc/login">로그인</a></li>
		                <% } else if(session.getAttribute("userno")!=null && session.getAttribute("kakaono")==null){ %>
		                <li><a href="/cmc/logout">로그아웃</a></li>
		                <% } else if(session.getAttribute("kakaono")!=null && session.getAttribute("userno")==null){ %>
		                <li><a href="/kakao/logout">로그아웃</a></li>
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
							<% if( null != session.getAttribute("gradeno") && (int)session.getAttribute("gradeno") ==3){ %>
							<li><a href="/BoardAccessDenied.jsp">게시판</a></li>
							<% } else{ %>
							<li><a href="/board/notice">게시판</a></li>
							<%} %>
							<% if( session.getAttribute("userno")==null&&session.getAttribute("kakaono")==null){ %>
							<li><a href="/NeedLogin.jsp">등산 도우미</a></li>
							<% } else {%>
							<li><a href="/map">등산 도우미</a></li>
							<% } %>
							<% if(session.getAttribute("userno")==null&&session.getAttribute("kakaono")==null){ %>
							<li><a href="/NeedLogin.jsp">굿즈샵</a></li>
							<% }else{ %>
							<li><a href="/goods/list">굿즈샵</a></li>
							<% } %>
						</ul>
					</div>
					<div class="weather-wrap">
						<div class="weather-widget">
							<div class="weather-back">
								<img src="/resources/image/weatherBackground.jpg" class="weatherImg">
							</div>
							<div class="weather-content">
								<p class="time"></p>
								<p class="ctemp"></p>
								<ul>
									<li class="hightemp">최고: </li>
									<li class="lowtemp">최저: </li>
								</ul>
							</div>
							<div class="icon-wrap">
								<p class="icon"></p>
							</div>
						</div>
					</div> <!-- .weather-wrap end -->
				</div> <!-- .header-menu end -->
			</div> <!-- .header-wrap end -->
		</div> <!--.header-title end -->
	</header>	


<script type="text/javascript">

$.getJSON('https://api.openweathermap.org/data/2.5/weather?q=Seoul&appid=89205d456ca75c3e8437b84277bf671e&units=metric'
	, function(result) {
	
		$('.ctemp').append(result.main.temp + '°');
		$('.hightemp').append(result.main.temp_max);
		$('.lowtemp').append(result.main.temp_min);
		
		//result.weather[0].icon
		var wiconUrl = '<img src="http://openweathermap.org/img/wn/'+ result.weather[0].icon +
			'.png" alt="' + result.weather[0].discription +'">'
		$('.icon').append(wiconUrl);
		
		var ct = result.dt;
		
		function convertTime(t) {
			var ot = new Date(t * 1000);
			
			var mt = ot.getMonth()+1;
			var dt = ot.getDate();
			var hr = ot.getHours();
			var m = ot.getMinutes();
			
			return mt + '월 ' + dt + '일  ' + hr + ':' + m
		}
			
		var currentTime = convertTime(ct);
		$('.time').append(currentTime);

});

</script>


<div class="container">
	<div class="container-wrap">
<script type="text/javascript">



</script>

<style type="text/css">

@font-face {
	font-family: 'dalseo';
	src: url('/resources/css/DalseoHealingBold.ttf') format('truetype');
}

html {
	overflow-x: hidden;
	overflow-y: hidden;
}

.back {
	position: absolute;
	width:2200px;
}


.back img {
	position: absolute;
	right: 600px; 
	width: 100%;
	height: 820px;
	z-index: 0;
}

.text-slide{
	position: relative;
	top: 55px;
	left: 200px;
}
 

.textst{
	color: black;
	font-family: 'dalseo';
	font-size: 60px;
	text-align: center;
	padding: 0;
	padding-left: 183px;
	margin: 0;
	margin-left: 50%;
	transform: translateX(-200%);
	opacity: 0;
	width: 1000px;
	animation: slide-in-anim 0s ease-out forwards;
}
:is(.one, .two, .three, .four){
	color: white;
	font-family: 'dalseo';
	font-size: 60px;
	text-align: center;
	padding: 0;
	margin: 0;
	margin-left: 50%;
	transform: translateX(-200%);
	opacity: 0;
	animation: slide-in-anim 2s ease-out forwards;
}


.two {
  animation-delay: 2s;
}

.three {
  animation-delay: 4s;
}

.four {
  position: relative;
  animation-delay: 6s;
  left: -34px;
}

@keyframes slide-in-anim {
	20% {
		opacity: 0;
	}
	60% {
		transform: translateX(-45%);
	}
	75% {
		transform: translateX(-52%);
	}
	100% {
		opacity: 1;
		transform: translateX(-50%);
	}
}

.agent {
	color: #00CC88;
}

@media screen and (max-width: 1500px){
.together{
	display: none;
}


</style>
		<div class="back">
			<img src="/resources/image/unit-sunrise-md.png">
		</div>
		
		<label>
			<div class="text-slide">
				<p class="one"><span class="agent">가족</span><span class="together">과 함께</span></p>
				<p class="two"><span class="agent">친구</span><span class="together">와 함께</span></p>
				<p class="three"><span class="agent">연인</span><span class="together">과 함께</span></p>
				<p class="four"><span class="agent">혼자</span><span class="together">서도</span></p>
				<p class="textst">즐길수 있는 스포츠</p>
			</div>
		</label>

	</div> <!-- .container-wrap end -->
</div> <!-- .container end -->



<footer id="footer" class="footer" style="position:absolute;  max-height: 300px; background-color: white; z-index: 100;">
	<div class="footer-wrap">
		<p class="footerlist-wrap">
			<span class="footerlist">
				<span>(주)코딩산악회</span>
				<span>세미 프로젝트</span>
				<span>팀원</span>
				<span>강창민 권정화 김다운 김동현 변민재 이샤론</span>
			</span>
			<br>
			<span class="footerlist">
				<span>GIT :</span>
				<span><a href="https://github.com/ByunMinJae/SemiProject.git" id="git">https://github.com/ByunMinJae/SemiProject.git</a></span>
			</span>
			<br>
			<span class="copyright">
				COPYRIGHT©codingMountaineeringSociety.ALL RIGHTS RESERVED
			</span>
		</p>		
	</div>
</footer>





</div> <!-- .wrapper end -->	

</body>
</html>