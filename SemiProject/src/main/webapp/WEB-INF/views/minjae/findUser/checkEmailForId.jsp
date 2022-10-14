<%@page import="minjae.dto.UserFind"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	UserFind userFind = (UserFind)request.getAttribute("userFind"); %>

<script type="text/javascript">
$(document).ready(function() {

	//입력중인 인증번호 확인
	$("#authno").keyup(function() {
		
		//입력중인 인증번호가 일치할 때
		if($("#authno").val() == <%=userFind.getAuthno() %>) {
			$("#agreeMsg").html("<div id='checkMark'></div>");
			$("#result2").html("<p>&nbsp;</p>"); //틀렸을때 나오는 메시지 지우기
		} else {
			$("#agreeMsg").html('');
		}
		
	})
	
	//아이디 찾기 버튼 클릭시 이벤트
	$("#btnFindId").click(function() {
		
		if($("#authno").val() == <%=userFind.getAuthno() %>) { //입력한 인증번호가 일치할 때
			location.href = "/find/checkid?id=" + $("#hiddenId").val()
// 			$(location).attr("href", "/find/checkid?id=" + $("#hiddenId").val())
		} else { //입력한 인증번호가 불일치 할 때
			$("#result2").html("<p id='disAuth' >인증번호가 틀렸습니다 다시 확인해 주세요</p>")
		}
		
	})
	
})
</script>

<style type="text/css">
#result2 {
    font-size: 5px;
    color: blue;
}

p#disAuth {
    color: red;
}

#btnReqAuth {
	display: none;
}

#authno {
	width: 296px;
    height: 38px;
    padding-left: 10px;
    margin: 9px 0 5px
}

#btnFindId {
	width: 304px;
    height: 35px;
    background-color: #555;
    border: none;
    color: #fff;
}

#agreeMsg {
    position: absolute;
    color: lime;
    top: 171px;
    right: 62px;
}

#checkMark {
	background: url("/resources/image/check-mark.png") no-repeat 0 0;
	width: 20px;
    height: 20px;
}
</style>

<input type="text" style="display: none;">
<input type="text" id="authno" name="authno" placeholder="인증 번호">
<div id="agreeMsg"></div>

<div id="result2"><p>이메일로 인증번호를 발송했습니다. 인증번호를 입력해 주세요!</p></div>

<button id="btnFindId">아이디 찾기</button>

<!-- 아이디 찾기 버튼 클릭시 넘겨줄 아이디저장 input -->
<input type="hidden" id="hiddenId" value="<%=userFind.getId() %>"> 