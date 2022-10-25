<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>

<script type="text/javascript" src="/resources/se2/js/service/HuskyEZCreator.js"></script>
<style>

@font-face {
   font-family: 'dalseo';
   src: url('/resources/css/DalseoHealingBold.ttf') format('truetype');
}

.bodywrap {
	margin: 5% 10%;
}

.bodywrap li {
	display: list-item;
	list-style-type: none;
		font-family: 'GmarketSansMedium';
	
}

.bodywrap h1 {
	text-align: center;
	font-family:  bold 'GmarketSansMedium';
}

.mtitle {
	position: relative;
	width: 100%;
	margin: 0 auto;
}

.mtitle .m-spot {
	width: 100%;
	height: 50px;
	display: -webkit-inline-box;
	margin: 20px 0 30px 0;
}

.mtitle .m-spot li{
	float: left;
	margin: 0 10%;
	font-size: 30px;
}

.m-mountain {
	position: absolute;
	left: 20px;
	
}
.m-mountain li {
	font-size: 30px;
	margin: 50% 0;
}

.m-mountain li a{
	color: gray;
}

.m-mountain li:hover {
	color: black;
	border-bottom: none;
}

#map {
	width: 110%;
	height: 500px;
}


button {
	border: none;
	border-radius: 0.5em;
	padding: 10px 20px 5px 20px;
}


</style>


<body>

<div class="bodywrap">
	<h1>등산 도우미</h1>
	<div class="mtitle">
		<ul class="m-spot">
			<li><button id="btn-res">식당</button></li>
			<li><button id="btn-to">화장실</button></li>
			<li><button id="btn-comf">편의점</button></li>
		</ul>
	</div>
	<div class="m-mountain">
		<ul>
			<li><a href="/maph">한라산</li>
			<li><a href="/maps">설악산</li>
			<li><a href="/mapc">치악산</li>
			<li><a href="/mapj">지리산</li>	
		</ul>
	</div>
	<div id="map"></div>
</div>
</body>



<%@ include file="../layout/footer.jsp" %>