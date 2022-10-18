<%@page import="minjae.dto.UserFind"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	UserFind userFind = (UserFind)request.getAttribute("userFind"); %>

<script type="text/javascript">
$(document).ready(function() {
	
	//입력중인 인증번호 확인
	$("#authnoS").keyup(function() {
		
		//입력중인 인증번호가 일치할 때
		if($("#authnoS").val() == <%=userFind.getAuthno() %>) {
			$("#agreeMsgS").html("<div id='checkMark'></div>");
			$("#checkSms").html("<p>&nbsp;</p>"); //틀렸을때 나오는 메시지 지우기
		} else {
			$("#agreeMsgS").html('');
		}
		
	})
	
	//아이디 찾기 버튼 클릭시 이벤트
	$("#btnFindIdBySms").click(function() {
		
		if($("#authnoS").val() == <%=userFind.getAuthno() %>) { //입력한 인증번호가 일치할 때
			location.href = "/find/checkid?id=" + $("#hiddenIdForSms").val()
					
		} else { //입력한 인증번호가 불일치 할 때
			$("#checkSms").html("<p id='disSmsAuth' >인증번호가 틀렸습니다 다시 확인해 주세요</p>")
			
		}
		
	})
	
})
</script>

<style type="text/css">
#checkSms {
    font-size: 5px;
    color: blue;
}

#disSmsAuth {
    color: red;
}

/* #btnReqAuth { */
/* 	display: none; */
/* } */

#btnFindIdBySms {
	width: 304px;
    height: 35px;
    background-color: #555;
    border: none;
    color: #fff;
}

#agreeMsgS {
    position: absolute;
    color: lime;
    top: 325px;
    right: 54px;
}
#checkMark {
	background: url("/resources/image/check-mark.png") no-repeat 0 0;
	width: 20px;
    height: 20px;
}
</style>

<!-- <input type="text" style="display: none;"> -->
<input type="text" id="authnoS" name="authnoS" placeholder="인증 번호" style="margin: 10px -73px 0 0;">
<div id="agreeMsgS"></div>

<div id="checkSms"><p>문자로 인증번호를 발송했습니다. 인증번호를 확인해 주세요!</p></div>

<button id="btnFindIdBySms">아이디 찾기</button>

<!-- 아이디 찾기 버튼 클릭시 넘겨줄 아이디저장 input -->
<input type="hidden" id="hiddenIdForSms" value="<%=userFind.getId() %>"> 