<%@page import="minjae.dto.MpMainRight"%>
<%@page import="minjae.dto.MpMain"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%	MpMain mpMain = (MpMain)request.getAttribute("mpMain"); %>
<%	MpMainRight mpMR = (MpMainRight)request.getAttribute("mpMR"); %>

<%@	include file="../../layout/header.jsp" %>

<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script>
$( function() {
	//datepicker 설정
	$( "#startDate" ).datepicker({
		 showMonthAfterYear: true
		 , dateFormat: "yy/mm/dd"
		 , dayNamesMin: ['월', '화', '수', '목', '금', '토', '일']
		 , monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
		 , monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
	});
	$( "#endDate" ).datepicker({
		 showMonthAfterYear: true
		 , dateFormat: "yy/mm/dd"
		 , dayNamesMin: ['월', '화', '수', '목', '금', '토', '일']
		 , monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
		 , monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
	});
} );
</script>

<script type="text/javascript">
$(document).ready(function() {
	
	//우측 카테고리에 이미지 띄우기
	hiddenImg("#btnCateg1", "#mi1")
	hiddenImg("#btnCateg2", "#mi2")
	hiddenImg("#btnCateg3", "#mi3")
	
	//기간별 조회 기능
	$("#btnSelect").click(function() {
		
		if( $("#startDate").val() == "" || $("#endDate").val() == "" ) {
			$("#checkMsg").html("기간을 선택해 주세요.")
		} else if( $("#startDate").val() > $("#endDate").val() ) {
			$("#checkMsg").html("시작 날짜가 더 클 수 없습니다.")
		} else {
			
			$("#checkMsg").html("")
			
			$.ajax({
				type: "post"					//요청 메소드
				, url: "/mypage/main"			//요청 URL
				, data: {						//요청 파라미터
					userno: <%=mpMain.getUserno() %>
					, startDate: $("#startDate").val()
					, endDate: $("#endDate").val()
				}
				, dataType: "html"				//응답 데이터 형식
				, success: function( res ) {
					console.log("AJAX 성공")
					
					//응답 데이터 반영
					$("#result").html( res )
				}
			})
			
		}
		
	})/* end of click event */
	
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
#wrapper {
	background-color: #BFDCFB;
}
#mpmWrap {
	width: 1100px;
    height: 600px;
    margin: 0px auto;
    text-align: center;
    position: relative;
    font-family: 'GmarketSansMedium';
}
#mpmLeft {
	width: 40%;
	height: 651px;
	float: left;
	background: #e0fdc9;
	position: absolute;
}
#userInfo {
	padding-top: 92px;
}
#mpmRight {
	margin-top: 104px;
	width: 55%;
	float: right;
	position: relative;
    top: -28px;
}
#userImg {
	width: 300px;
	height: 200px;
	background: url("/resources/image/user_profile.png") no-repeat 0 0;
}
.md {
	text-decoration: none;
	color: #555;
}
.md:hover {
	text-decoration: none;
	cursor: pointer;
	color: #36871b;
}
ul#ul_left {
	list-style: none;
	margin: 68px 71px;
    padding: 0;
    text-align: -webkit-center;
}
li.info_left {
	font-size: 40px;
	font-weight: bold;
	color: #555;
}
#ropeImg {
	background: url(/resources/image/rope.png) no-repeat 0 0;
    width: 40px;
    height: 150px;
    position: absolute;
    top: 107px;
    left: 447px;
}
.rope1, .rope2 {
	border-right: 2px solid #444;
    position: absolute;
}
.rope1 {
    width: 5px;
    height: 215px;
    top: -22px;
    left: 458px;
}
.rope2 {
	width: 5px;
    height: 204px;
    top: 215px;
    left: 451px;
}
.btnCateg {
	width: 245px;
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
    height: 336px;
    background: #fcffbe;
    border: 1px solid #ccc;
    margin-left: 53px;
    border-radius: 14px;
}
.cir_img {
	margin: 88px 19px;
    width: 123px;
    height: 123px; 
	background: linear-gradient(#d169eb6b, #b717dfb0);
	border-radius: 60px; 
	display: inline-block;
}
.ci {
	display: inline-block;
	margin: 100px 29px;
    position: absolute;
}
.cont_img1 {
	width: 100px;
	height: 100px;	
	background: url("/resources/image/mypage_car.png") no-repeat 0 0;
}
.cont_img2 {
	width: 100px;
	height: 100px;
	background: url("/resources/image/mypage_box.png") no-repeat 0 0;
}
.cont_img3 {
	width: 100px;
	height: 100px;
	background: url("/resources/image/mypage_arrow.png") no-repeat 0 0;
}
.con_text {
	background: linear-gradient(#d169ebd9, #b717dfb0);
	color: transparent;
	-webkit-background-clip: text;
	position: absolute;
    font-size: 20px;
    font-weight: bold;
}
.cnt_no {
	display: inline-block;
    position: absolute;
    top: 287px;
    font-size: 50px;
    color: #b321d7eb;
    width: 122px;
}
#datepicker {
	font-weight: bold;
    margin: 0 auto;
    position: relative;
    bottom: 34px;
}
#startDate, #endDate {
	width: 100px;
	height: 24px;
    font-size: 15px;
    border: 1px solid #ccc;
    border-radius: 15px;
    padding-left: 10px;
    background-color: #fff;
}
#btnSelect {
	width: 71px;
    font-weight: bold;
    background: #fff;
    border-radius: 5px;
    border: 1px solid #cfcfcf;
    cursor: pointer;
}
#btnSelect:hover {
    background: linear-gradient(#c7f2a4, #88eb38);
}
#checkMsg {
	color: red;
    font-size: 11px;
    position: relative;
    bottom: 55px;
}
</style>

<div id="mpmWrap">

<!-- 왼쪽 영역 -->
<div id="mpmLeft">
	<!-- 유저 정보 영역 -->
	<div id="userInfo">
		<ul id="ul_left">
			<li><div id="userImg"></div></li>
			<li class="info_left"><a class="md" href="/mypage/detail"><%=mpMain.getNick() %></a></li>
			<li class="info_left" style="font-size: 15px;"><%=mpMain.getGradename() %></li>
		</ul>
	</div>
</div>

<!-- 오른쪽 영역 -->
<div id="mpmRight">
	<!-- 상단 카테고리 버튼 -->
	<div class="mount_img" id="mi1"></div>
	<a href="/orderafterlist"><button class="btnCateg" id="btnCateg1">결제내역</button></a>
<!-- 	<div class="mount_img" id="mi2"></div> -->
<!-- 	<a href=""><button class="btnCateg" id="btnCateg2">반품/교환/취소</button></a> -->
	<div class="mount_img" id="mi3"></div>
	<a href="/cart/list"><button class="btnCateg" id="btnCateg3">장바구니</button></a>
	<!-- contents 영역 -->
	<div id="contents">
		<!-- delivery -->
		<span class="con_text" style="margin: 55px 0 0 41px;">결제완료</span>
		<div class="cont_img1 ci"></div>
		<div class="cir_img"></div>
		
		<!-- delivery complete -->
		<span class="con_text" style="margin: 55px 0 0 41px;">배송완료</span>
		<div class="cont_img2 ci"></div>
		<div class="cir_img"></div>
		
		<!-- exchange -->
		<span class="con_text" style="margin: 55px 0 0 13px;">교환/반품/취소</span>
		<div class="cont_img3 ci"></div>
		<div class="cir_img"></div>
		<div id="result">
			<div class="cnt_no" style="right: 406px;"><p><%=mpMR.getDelCnt() %></p></div>
			<div class="cnt_no" style="right: 241px;"><p><%=mpMR.getDelComCnt() %></p></div>
			<div class="cnt_no" style="right: 74px;"><p><%=mpMR.getExchanCnt() %></p></div>
		</div>
	</div>
	<!-- datepicker API -->
	<div id="datepicker">
		기간별 조회: <input type="text" id="startDate" name="startDate"> ~ <input type="text" id="endDate" name="endDate">
		<button id="btnSelect">조 회</button>
		<p id="checkMsg"></p>
	</div>
	
</div>

</div><!-- End of #mpmWrap -->

<jsp:include page="../../layout/footer.jsp"/>









