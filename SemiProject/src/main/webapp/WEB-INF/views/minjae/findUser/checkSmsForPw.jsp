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
	$("#btnFindPwBySms").click(function() {
		
		if($("#authnoS").val() == <%=userFind.getAuthno() %>) { //입력한 인증번호가 일치할 때
			//form태그 submit 시키기
			$("#f").trigger("submit");				
		} else { //입력한 인증번호가 불일치 할 때
			$("#checkSms").html("<p id='disSmsAuth' >인증번호가 틀렸습니다 다시 확인해 주세요.</p>")
			
		}
		
	})
	
})
</script>

<style type="text/css">
#checkSms {
    font-size: 13px;
    color: blue;
    margin-top: 4px;
}

#disSmsAuth {
    color: red;
}

#btnFindPwBySms {
	width: 304px;
    height: 35px;
    background-color: #555;
    border: none;
    color: #fff;
    cursor: pointer;
    border-radius: 7px;
}
#btnFindPwBySms:hover {
	background-color: #333;
}

#agreeMsgS {
    position: absolute;
    color: lime;
    top: 208px;
    right: 62px;
}
#checkMark {
	background: url("/resources/image/check-mark.png") no-repeat 0 0;
	width: 20px;
    height: 20px;
}
#authnoS {
	width: 288px;
    height: 32px;
    padding-left: 10px;
    margin-top: 30px;
}
</style>

<!-- <input type="text" style="display: none;"> -->
<input type="text" id="authnoS" name="authnoS" placeholder="인증 번호" style="margin: 10px -73px 0 0;">
<div id="agreeMsgS"></div>

<div id="checkSms"><p>문자로 인증번호를 발송했습니다 인증번호를 확인해 주세요.</p></div>

<button id="btnFindPwBySms">비밀번호 찾기</button>

<!-- 아이디 찾기 버튼 클릭시 넘겨줄 아이디저장 -->
<form action="/find/change_pw" method="post" id="f">
<input type="hidden" id="hiddenIdForSms" name="id" value="<%=userFind.getId() %>"> 
</form> 