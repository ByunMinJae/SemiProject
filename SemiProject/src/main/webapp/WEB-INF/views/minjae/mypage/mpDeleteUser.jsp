<%@page import="minjae.dto.MpMain"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%	MpMain mpMain = (MpMain)request.getAttribute("mpMain"); %>

<%@	include file="../../layout/header.jsp" %>

<script type="text/javascript">
$(document).ready(function() {
	
	$("#btnDeleteUser").click(function() {
		if(confirm(" 회원 탈퇴를 진행하실 경우 회원 정보나 게시물은 다시 복구할 수 없습니다.\n\n그래도 진행하시겠다면 '확인'버튼을 클릭하세요.")) {
			$("form").submit();
		} else {
			alert("취소되었습니다!")
		}
	})
	
})
</script>

<style type="text/css">
#deleteWrap {
	width: 400px;
	height: 406px;
	margin: 183px auto 0;
	text-align: center;
	position: relative;
}
#btnDeleteUser {
    margin: 56px 0;
    width: 200px;
    height: 36px;
    font-size: 18px;
    background: #777;
    color: #fff;
    border: 2px solid #444;
    border-radius: 4px
}
#btnDeleteUser:hover {
    background: #444;
    cursor: pointer;
}
</style>

<div id="deleteWrap">

<h1>회원 탈퇴</h1>
<hr>
<form action="/mypage/delete" method="post">

<input type="button" id="btnDeleteUser" value="회원 탈퇴">
<input type="text" hidden=""  name="deleteUser" value="<%=mpMain.getUserno() %>">

</form>

</div>
<jsp:include page="../../layout/footer.jsp"/>