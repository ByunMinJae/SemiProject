<%@page import="minjae.dto.UserFind"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	UserFind userFind = (UserFind)request.getAttribute("userFind"); %>

<script type="text/javascript">
$(document).ready(function() {
	
	$("#authnoE").keyup(function() {
		
		//입력중인 인증번호가 일치할 때
		if($("#authnoE").val() == <%=userFind.getAuthno() %>) {
			$("#agreeMsgE").html("<div id='checkMark'></div>");
			$("#checkEmail").html("<p>&nbsp;</p>"); //틀렸을때 나오는 메시지 지우기
		} else {
			$("#agreeMsgE").html('');
		}
		
	})
	
	//아이디 찾기 버튼 클릭시 이벤트
	$("#btnFindIdByEmail").click(function() {
		
		if($("#authnoE").val() == <%=userFind.getAuthno() %>) { //입력한 인증번호가 일치할 때
			location.href = "/find/checkid?id=" + $("#hiddenIdForEmail").val()

		} else { //입력한 인증번호가 불일치 할 때
			$("#checkEmail").html("<p id='disEmailAuth' >인증번호가 틀렸습니다 다시 확인해 주세요.</p>")
		
		}
		
	})
	
})
</script>

<style type="text/css">
#checkEmail {
    font-size: 13px;
    color: blue;
    margin-top: 5px;
}

#disEmailAuth {
    color: red;
}

#btnFindIdByEmail {
	width: 304px;
    height: 35px;
    background-color: #555;
    border: none;
    color: #fff;
    border-radius: 7px;
}

#agreeMsgE {
    position: absolute;
    color: lime;
    top: 254px;
    right: 62px;
}
#checkMark {
	background: url("/resources/image/check-mark.png") no-repeat 0 0;
	width: 20px;
    height: 20px;
}
</style>

<!-- <input type="text" style="display: none;"> -->
<input type="text" id="authnoE" name="authnoE" placeholder="인증 번호" style="margin: 10px -73px 0 0;">
<div id="agreeMsgE"></div>

<div id="checkEmail"><p>이메일로 인증번호를 발송했습니다 인증번호를 확인해 주세요.</p></div>

<button id="btnFindIdByEmail">아이디 찾기</button>

<!-- 아이디 찾기 버튼 클릭시 넘겨줄 아이디저장 input -->
<input type="hidden" id="hiddenIdForEmail" value="<%=userFind.getId() %>"> 