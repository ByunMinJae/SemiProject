<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@	include file="../../layout/header.jsp" %>


<style type="text/css">
.gtlWrap {
	width: 436px;
    height: 500px;
    margin: 100px auto 0;
    text-align: center;
    position: relative;
}
#goToFindPw {
	width: 304px;
    height: 35px;
    background-color: #555;
    border: none;
    color: #fff;
    position: relative;
    top: 34px;
    cursor: pointer;
    border-radius: 7px;
}
#goToFindPw:hover {
	background-color: #333;
}
</style>

<div class="gtlWrap">
	<h1>패스워드 변경 실패</h1>
	<hr><br>
	<strong style="color: red;">프로그램 오류로 인하여 패스워드 변경에 실패하였습니다. 다시 시도해 주세요</strong>
	<a href="/find/findpw"><button id="goToFindPw">비밀번호 찾기</button></a>
</div>

<jsp:include page="../../layout/footer.jsp"/>