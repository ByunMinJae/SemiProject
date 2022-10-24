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
}

.mtitle {
	position: relative;
	width: 100%;
}

.mtitle .m-spot li{
	float: left;
	margin: 0 50px;
}

.m-mountain {
	position: relative;
	left: 0;

}

</style>


<body>

<div class="bodywrap">
	<h1>등산 도우미</h1>
	<div class="mtitle">
		<ul class="m-spot">
			<li>식당</li>
			<li>화장실</li>
			<li>편의점</li>
		</ul>
	</div>
	<div class="m-mountain">
		<ul>
			<li>한라산</li>
			<li>한라산</li>
			<li>한라산</li>
			<li>한라산</li>	
		</ul>
	</div>
	<div id="map" style="width:60%;height:350px;"></div>
	<div id="map" style="width:40%;height:350px;"></div>
</div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=2f8d3a73bc0d81f7a11d7714389ee2d2"></script>



<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption);

// 마커가 표시될 위치입니다 
var markerPosition  = new kakao.maps.LatLng(33.450701, 126.570667); 

// 마커를 생성합니다
var marker = new kakao.maps.Marker({
    position: markerPosition
});

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);

var iwContent = '<div style="padding:5px">한라산 <br><a href="https://map.kakao.com/link/map/Hello World!,33.450701,126.570667" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/Hello World!,33.450701,126.570667" style="color:blue" target="_blank">길찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
    iwPosition = new kakao.maps.LatLng(33.450701, 126.570667); //인포윈도우 표시 위치입니다

// 인포윈도우를 생성합니다
var infowindow = new kakao.maps.InfoWindow({
    position : iwPosition, 
    content : iwContent 
});
  
// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
infowindow.open(map, marker); 
</script>
</body>



<%@ include file="../layout/footer.jsp" %>