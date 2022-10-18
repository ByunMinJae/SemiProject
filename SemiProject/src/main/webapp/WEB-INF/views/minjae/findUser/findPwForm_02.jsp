<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@	include file="../../layout/header.jsp"%>

<!-- iamport.payment.js -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js"></script>

<script type="text/javascript">
$(document).ready(function() {

	var IMP = window.IMP; // 생략 가능
	IMP.init("imp68865366"); // 예: imp00000000

	$(".btnReqAuth").click(function() {
		console.log("IMP 실행")
		
		//입력 아이디 값이 공백일 경우 처리
		if ($("#userid").val() == "") {
			console.log("stop")
			return;
		}
		
		// "/find/findpw"에 POST로 아이디값 넘겨주고 유효한 아이디 인지 확인 
		$.ajax({
			type : "post",
			url : "/find/findpw",
			data : {
				userid : $("#userid").val()
			},
			dataType : "html",
			success : function(res) { // id - 아이디 확인됨, "" - 아이디 미확인
				console.log("AJAX 성공")

				if (res != "") {

					//KG이니시스 통합인증
					IMP.certification({

					}, function(rsp) { // callback
						if (rsp.success) { // 인증 성공 시
							
							//form태그 submit 시키기
							$("#f").html("<input type='text' name='id' value='" + res + "'>");
							$("#f").trigger("submit");
						
						} else {
							alert("인증에 실패하였습니다. 에러 내용: " + rsp.error_msg);
						}
					});

					//msg 지우기
					$("#resid").html("")

				} else {
					$("#resid").html("<p>해당 아이디로 가입된 유저가 없습니다</p>")
				}
			}

		})

	})/* End of click event */

})
</script>

<style type="text/css">
.fupWrap {
	width: 400px;
	height: 500px;
	margin: 100px auto 0;
	text-align: center;
	position: relative;
}

#userid {
	width: 288px;
	height: 32px;
	padding-left: 10px;
	margin-top: 30px;
}

.btnReqAuth {
	float: right;
	position: relative;
	top: -31px;
	right: 54px;
}

.findId {
	color: #777;
	font-size: 14px;
	position: absolute;
	top: 71px;
	right: 10px;
	font-weight: bold;
}

.findId:hover {
	color: #444;
}

#fromInsideOut a::after {
	position: absolute;
	content: "";
	display: block;
	border-bottom: 2px solid #444;
	transition: all 250ms ease-out;
	left: 50%;
	width: 0;
}

#fromInsideOut a:hover::after {
	transition: all 250ms ease-out;
	left: 0%;
	width: 100%;
}

#resid {
	color: red;
	font-size: 7px;
	padding-left: 61px;
}
</style>

<div class="fupWrap">

<h1>비밀번호 찾기</h1>
<hr>

<div id="fromInsideOut">
	<a href="<%=request.getContextPath()%>/find/findid" class="findId" style="text-decoration: none;">아이디 찾기</a>
</div>

<!-- email 인증 -->
<div id="emailType">
	<input type="text" id="userid" name="userid" placeholder="아이디"><br>
	<button class="btnReqAuth">인증 요청</button>
	<div id="resid"></div>
</div>

<!-- 입력받은 id를 넘겨주기 위한 form태그 -->
<form action="/find/change_pw" method="post" id="f"></form> 

</div><!-- End of .fupWrap -->

<jsp:include page="../../layout/footer.jsp" />











