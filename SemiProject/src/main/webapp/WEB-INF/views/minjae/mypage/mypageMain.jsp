<%@page import="minjae.dto.MpMain"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%	MpMain mpMain = (MpMain)request.getAttribute("mpMain"); %>

<%@	include file="../../layout/header.jsp" %>

<script type="text/javascript">
$(document).ready(function() {
	
	//우측 카테고리에 이미지 띄우기
	hiddenImg("#btnCateg1", "#mi1")
	hiddenImg("#btnCateg2", "#mi2")
	hiddenImg("#btnCateg3", "#mi3")
	
})

function hiddenImg( btnCateg, mi ) {
	
	$(btnCateg).mouseover(function() {
		$(mi).attr("style", "display: inline-block")
	})
	$(btnCateg).mouseout(function() {
		$(mi).attr("style", "display: none")
	})
	
}

</script>

<style type="text/css">
#mpmWrap {
	width: 1100px;
    height: 500px;
    margin: 100px auto;
    text-align: center;
    position: relative;
}
#mpmLeft {
	width: 40%;
	height: 80%;
	float: left;
}
#mpmRight {
	width: 55%;
	height: 80%;
	float: right;
}
#userImg {
	width: 300px;
	height: 200px;
	background: url("/resources/image/user_profile.png") no-repeat 0 0;
}
#ropeImg {
	background: url(/resources/image/rope.png) no-repeat 0 0;
    width: 40px;
    height: 150px;
    position: absolute;
    top: 107px;
    left: 447px;
}
ul#ul_left {
	margin: 68px 71px;
    padding: 0;
    text-align: -webkit-center;
}
li.info_left {
	font-size: 40px;
	font-weight: bold;
	color: #555;
}
li.info_left a:hover {
	cursor: pointer;
	color: #54abdf;
}
.rope1, .rope2 {
	border-right: 2px solid #444;
    position: absolute;
}
.rope1 {
    width: 5px;
    height: 193px;
    top: 0px;
    left: 458px;
}
.rope2 {
	width: 5px;
    height: 186px;
    top: 215px;
    left: 451px;
}
.btnCateg {
	width: 144px;
    height: 42px;
    margin: 20px 0 10px;
    background-color: #4eab51;
    border-color: #2f7e4f;
    border-radius: 7px;
    cursor: pointer;
    font-size: 15px;
    font-weight: bold;
    color: #fff;
}
.btnCateg:hover {
    background-color: #27602b;
}
.mount_img {
	width: 35px;
	height: 30px;
	display: inline-block;
	background: url("/resources/image/logo_h30px.png") no-repeat 0 0;
	position: absolute;
    top: -1px;
    display: none;
}
#contents {
	width: 500px;
    height: 300px;
    background: #ddd;
    margin-left: 53px;
    border-radius: 14px;
}
.cont_img1 {
	background: url("/resources/image/mypage_car.png") no-repeat 0 0;
	
}
.cont_img2 {
	background: url("/resources/image/mypage_box.png") no-repeat 0 0;

}
.cont_img3 {
	background: url("/resources/image/mypage_arrow.png") no-repeat 0 0;

}
</style>

<div id="mpmWrap">

<!-- 왼쪽 영역 -->
<div id="mpmLeft">
	<!-- 유저 정보 영역 -->
	<div id="userInfo">
		<ul id="ul_left">
			<li><div id="userImg"></div></li>
			<li class="info_left"><a><%=mpMain.getNick() %></a></li>
			<li class="info_left" style="font-size: 15px;"><%=mpMain.getGradename() %></li>
		</ul>
	</div>
	<!-- 중간 이미지 -->
	<div id="ropeImg"></div>
	<div class="rope1"></div>
	<div class="rope2"></div>
</div>

<!-- 오른쪽 영역 -->
<div id="mpmRight">
	<!-- 상단 카테고리 버튼 -->
	<div class="mount_img" id="mi1"></div>
	<a href=""><button class="btnCateg" id="btnCateg1">주문목록</button></a>
	<div class="mount_img" id="mi2"></div>
	<a href=""><button class="btnCateg" id="btnCateg2">반품/교환/취소</button></a>
	<div class="mount_img" id="mi3"></div>
	<a href=""><button class="btnCateg" id="btnCateg3">장바구니</button></a>
	<!-- contents 영역 -->
	<div id="contents">
		<div class="cont_img1"></div>
		<div class="cont_img2"></div>
		<div class="cont_img3"></div>
	</div>
	
</div>

</div><!-- End of #mpmWrap -->

<jsp:include page="../../layout/footer.jsp"/>









