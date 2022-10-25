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


<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=2f8d3a73bc0d81f7a11d7714389ee2d2"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(33.35944, 126.53201), // 지도의 중심좌표
        level: 2 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption);

// 마커가 표시될 위치입니다 
var markerPosition  = new kakao.maps.LatLng(33.35944, 126.53201); 

// 마커를 생성합니다
var marker = new kakao.maps.Marker({
    position: markerPosition
});

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);

var iwContent = '<div style="padding:5px; ">지리산 <br><a href="https://map.kakao.com/link/map/지리산,33.35944,126.53201" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/지리산,33.35944,126.53201" style="color:blue" target="_blank">길찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
    iwPosition = new kakao.maps.LatLng(33.35944, 126.53201); //인포윈도우 표시 위치입니다

// 인포윈도우를 생성합니다
var infowindow = new kakao.maps.InfoWindow({
    position : iwPosition, 
    content : iwContent 
});
  
// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
infowindow.open(map, marker); 



$(document).ready(function() {
	
	//작성버튼
	$("#btn-res").click(function() {
		
		var sw = new kakao.maps.LatLng(33.35954, 126.53251), // 사각형 영역의 남서쪽 좌표
		ne = new kakao.maps.LatLng(33.35944, 126.53201); // 사각형 영역의 북동쪽 좌표
		
		//사각형을 구성하는 영역정보를 생성합니다
		//사각형을 생성할 때 영역정보는 LatLngBounds 객체로 넘겨줘야 합니다
		var rectangleBounds = new kakao.maps.LatLngBounds(sw, ne);
		
		//지도에 표시할 사각형을 생성합니다
		var rectangle = new kakao.maps.Rectangle({
		bounds: rectangleBounds, // 그려질 사각형의 영역정보입니다
		strokeWeight: 4, // 선의 두께입니다
		strokeColor: '#FF3DE5', // 선의 색깔입니다
		strokeOpacity: 1, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
		strokeStyle: 'shortdashdot', // 선의 스타일입니다
		fillColor: '#FF8AEF', // 채우기 색깔입니다
		fillOpacity: 0.8 // 채우기 불투명도 입니다
		});
		
		//지도에 사각형을 표시합니다
		rectangle.setMap(map);
		
	})
	
	
	//작성버튼
	$("#btn-to").click(function() {
		
		var sw = new kakao.maps.LatLng(33.35924, 126.53241), // 사각형 영역의 남서쪽 좌표
		ne = new kakao.maps.LatLng(33.35944, 126.53201); // 사각형 영역의 북동쪽 좌표
		
		//사각형을 구성하는 영역정보를 생성합니다
		//사각형을 생성할 때 영역정보는 LatLngBounds 객체로 넘겨줘야 합니다
		var rectangleBounds = new kakao.maps.LatLngBounds(sw, ne);
		
		//지도에 표시할 사각형을 생성합니다
		var rectangle = new kakao.maps.Rectangle({
		bounds: rectangleBounds, // 그려질 사각형의 영역정보입니다
		strokeWeight: 4, // 선의 두께입니다
		strokeColor: '#E1FFB1', // 선의 색깔입니다
		strokeOpacity: 1, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
		strokeStyle: 'shortdashdot', // 선의 스타일입니다
		fillColor: '#FCFFB8', // 채우기 색깔입니다
		fillOpacity: 0.8 // 채우기 불투명도 입니다
		});
		
		//지도에 사각형을 표시합니다
		rectangle.setMap(map);
		
	})
	
	//작성버튼
	$("#btn-comf").click(function() {
		
		var sw = new kakao.maps.LatLng(33.35874, 126.53101), // 사각형 영역의 남서쪽 좌표
		ne = new kakao.maps.LatLng(33.35944, 126.53201); // 사각형 영역의 북동쪽 좌표
		
		//사각형을 구성하는 영역정보를 생성합니다
		//사각형을 생성할 때 영역정보는 LatLngBounds 객체로 넘겨줘야 합니다
		var rectangleBounds = new kakao.maps.LatLngBounds(sw, ne);
		
		//지도에 표시할 사각형을 생성합니다
		var rectangle = new kakao.maps.Rectangle({
		bounds: rectangleBounds, // 그려질 사각형의 영역정보입니다
		strokeWeight: 4, // 선의 두께입니다
		strokeColor: '#496EE3', // 선의 색깔입니다
		strokeOpacity: 1, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
		strokeStyle: 'shortdashdot', // 선의 스타일입니다
		fillColor: '#D6E0F6', // 채우기 색깔입니다
		fillOpacity: 0.8 // 채우기 불투명도 입니다
		});
		
		//지도에 사각형을 표시합니다
		rectangle.setMap(map);
		
	})
	
})


</script>
</body>



<%@ include file="../layout/footer.jsp" %>