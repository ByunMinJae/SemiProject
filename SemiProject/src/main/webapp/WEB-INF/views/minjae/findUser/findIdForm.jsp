<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@	include file="../../layout/header.jsp" %>

<script type="text/javascript">
$(document).ready(function() {
	
	//인증번호 요청 버튼 클릭 시 이벤트
// 	$("#btnReqAuth").click(function() {
		
// 		$("#result").load( "/find/findid", {"userEmail":$("#userEmail").val()} )
		
// 	})
	
	
	$("#btnReqAuth").click(function() {
		console.log("#btnReqAuth 클릭")
		
		$.ajax({
			type: "post"					//요청 메소드
			, url: "/find/findid"		//요청 URL
			, data: {						//요청 파라미터
				userEmail: $("#userEmail").val()
			}
			, dataType: "html"				//응답 데이터 형식
			, success: function( res ) {
				console.log("AJAX 성공")
				
				//응답 데이터 반영
				$("#result").html( res )
			}
			
		})
		
	})
	
})
</script>

<style type="text/css">
.fuiWrap {
	width: 400px;
    height: 500px;
    margin: 100px auto 0;
    text-align: center;
    position: relative;
}

#userEmail {
	width: 296px;
    height: 38px;
    padding-left: 10px;
    margin: 30px 0 5px
}

#btnReqAuth {
	float: right;
	position: relative;
   	top: -37px;
    right: 58px;
}

.findPw {
 	color: #777;
	font-size: 14px;
    position: absolute;
    top: 71px;
    right: 10px;
    font-weight: bold;
}
.findPw:hover {
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

<div class="fuiWrap">

<h1>아이디 찾기</h1>
<hr>

<div id="fromInsideOut">
	<a href="<%=request.getContextPath() %>/find/findpw" class="findPw" style="text-decoration: none;">비밀번호 찾기</a>
</div>

<input type="text" style="display: none;">
<input type="text" id="userEmail" name="userEmail" placeholder="이메일"><br>
<button id="btnReqAuth">인증 요청</button>

<div id="result"></div>

</div>

<jsp:include page="../../layout/footer.jsp"/>
<%-- <%@	include file="../../layout/footer.jsp" %> --%>


