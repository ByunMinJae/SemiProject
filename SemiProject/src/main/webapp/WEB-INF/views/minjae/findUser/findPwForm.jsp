<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@	include file="../../layout/header.jsp" %>

<script type="text/javascript">
$(document).ready(function() {
	
	$(".btnReqAuth").click(function() {
		console.log(".btnReqAuth 클릭")
		
		$.ajax({
			type: "post"					
			, url: "/find/findpw"			
			, data: {						
				userId: $("#userId").val(),
				userPhone: $("#userPhone").val()
			}
			, dataType: "html"				
			, success: function( res ) {
				console.log("AJAX 성공")
				
				//응답 데이터 반영
				$("#resSms").html( res )
			}
			
		})
		
	})
	
})
</script>

<style type="text/css">
#wrapper {
	background-color: #BFDCFB;
}
.fupWrap {
	width: 400px;
    height: 500px;
    margin: 200px auto 0;
    text-align: center;
    position: relative;
    font-family: 'GmarketSansMedium';
}

#userId {
	width: 288px;
    height: 32px;
    padding-left: 10px;
    margin-top: 30px;
}
#userPhone {
	width: 288px;
    height: 32px;
    padding-left: 10px;
    margin-top: 17px;
}

.btnReqAuth {
	float: right;
    position: relative;
    top: -29px;
    right: 59px;
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
	content:""; 
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
</style>

<div class="fupWrap">

<h1>비밀번호 찾기</h1>
<hr>

<div id="fromInsideOut">
	<a href="<%=request.getContextPath() %>/find/findid" class="findId" style="text-decoration: none;">아이디 찾기</a>
</div>

<!-- email 인증 -->
<div id="emailType">
	<input type="text" id="userId" name="userId" placeholder="아이디"><br>
	<input type="text" id="userPhone" name="userPhone" placeholder="휴대전화(-없이)"><br>
	<button class="btnReqAuth">인증 요청</button>
	<div id="resSms"></div>
</div>

</div><!-- End of .fupWrap -->

<jsp:include page="../../layout/footer.jsp"/>



