<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>weather</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<style type="text/css">

.weather-widget p {
	font-family: "돋움", Dotum,'Apple SD Gothic Neo', 'Malgun Gothic', 'Helvetica Neue', Helvetica, sans-serif;
	z-index: 99;
}

.weather-widget .weather-back {
	position: absolute;
}

.weather-widget .weather-back .weatherImg{
	width: 150px;
	height: 100px;
	border-radius: 1.8em;
	border: 1px solid gray;
	z-index: 1;
	/* opacity: 0.5; */
}

.weather-widget .weather-content {
	position: absolute;
}	

.weather-widget .weather-content ul {
	margin-top: 30px;
}

.ctemp {
	font-size: 30px;
	text-align: center;
}
.weather-widget .weather-content ul li {
	display: list-item;
	list-style-type: none;
	float: left;
	margin-left: 15px;
}


.weather-widget .icon-wrap {
	display: inline-block;
	width: 100px;
}

</style>

</head>
<body>

<div class="weather-widget">
	<div class="weather-back">
		<img src="/resources/image/weatherBackground.jpg" class="weatherImg">
	</div>
	<div class="weather-content">
		<p class="time">현재 시간: </p>
		<p class="ctemp" ></p>
		<ul>
			<li class="hightemp">최고: </li>
			<li class="lowtemp">최저: </li>
		</ul>
	</div>
	<div class="icon-wrap">
		<p class="icon"></p>
	</div>
</div>

<script type="text/javascript">

$.getJSON('https://api.openweathermap.org/data/2.5/weather?q=Seoul&appid=89205d456ca75c3e8437b84277bf671e&units=metric'
	, function(result) {
	
		$('.ctemp').append(result.main.temp);
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
			
			return mt + '월' + dt + '일' + hr + ':' + m
		}
			
		var currentTime = convertTime(ct);
		$('.time').append(currentTime);

});




</script>

</body>
</html>