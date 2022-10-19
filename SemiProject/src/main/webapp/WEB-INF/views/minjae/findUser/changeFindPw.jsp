<%@page import="minjae.dto.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@	include file="../../layout/header.jsp" %>

<script type="text/javascript">
$(document).ready(function() {
	
	$("#form").submit(function() {
		
		//true = submit
		return validatePW( $("#upw").val() );
		
	})
	
	//비밀번호 확인 입력 keyup 이벤트
	$("#upw_check").keyup(function() {
		
		if( $("#upw_check").val() == $("#upw").val() ) {
			$("#agreeMsgS").html("<div id='checkMark'></div>");
			$("#upw_check_msg").html("")
			
		} else {
			$("#agreeMsgS").html("");
			$("#upw_check_msg").html("비밀번호 확인 입력이 동일하지 않습니다!")
		}
		
	})
	
})

function validatePW( pw ) {
	
	//비밀번호를 입력하지 않았을 때
	if( pw == '' ) {
		$("#upw_msg").html("비밀번호를 입력해주세요!")
		
		return false;
	}
	
	//비밀번호 입력값 검증
	if( !/^[a-zA-Z0-9]{6,12}$/.test( pw ) ) {
		$("#upw_msg").html("비밀번호는 영어대소문자, 숫자 6~12자만 입력하세요!")
		return false;
	} else {
		$("#upw_msg").html("")
	}
	
	//비밀번호와 확인 입력값이 같은 지 검증
	if( pw != $("#upw_check").val() ) {
		$("#upw_check_msg").html("비밀번호 확인 입력이 동일하지 않습니다!")
		return false;
	}
	
	//PW 유효성 검증 완료
	return true;
}

</script>
    
<style type="text/css">
.sfPWrap {
	width: 400px;
    height: 500px;
    margin: 100px auto 0;
    text-align: center;
    position: relative;
}

input {
	width: 288px;
    height: 32px;
    padding-left: 10px;
    margin-top: 4px;
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

.msg {
	color: red;
	font-size: 7px;
}
h4 {
	margin: 44px 117px 0 0;
    font-size: 12px;
    color: #555;
}

#btnChangePw {
	width: 304px;
    height: 35px;
    background-color: #555;
    border: none;
    color: #fff;
    position: relative;
    top: -16px;
    cursor: pointer;
    border-radius: 7px;
}
#btnChangePw:hover {
	background-color: #333;
}
#checkMark {
	background: url("/resources/image/check-mark.png") no-repeat 0 0;
	width: 20px;
    height: 20px;
}
#agreeMsgS {
	position: absolute;
    top: 202px;
    right: 54px;
}
</style>

<div class="sfPWrap">

<h1>비밀번호 변경</h1>
<hr>

<div id="fromInsideOut">
	<a href="<%=request.getContextPath() %>/find/findid" class="findId" style="text-decoration: none;">아이디 찾기</a>
</div>

<h4>변경할 비밀번호를 입력해 주세요</h4>

<form action="/find/update_pw" method="post" id="form">

<input type="text" id="upw" name="upw" placeholder="비밀번호"><br>
<span id="upw_msg" class="msg"></span><br>

<input type="password" id="upw_check" placeholder="비밀번호 확인"><br>
<span id="upw_check_msg" class="msg"></span><br><br>
<div id="agreeMsgS"></div>

<!-- 비밀번호를 변경하는 유저의 아이디 전달용 input -->
<input type="text" hidden="" name="id" value="<%=request.getParameter("id") %>">

<button id="btnChangePw">비밀번호 변경</button>

</form>

</div><!-- End of .sfPWrap -->

<jsp:include page="../../layout/footer.jsp"/>
<%-- <%@	include file="../../layout/footer.jsp" %> --%>












