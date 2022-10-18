<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@	include file="../../layout/header.jsp" %>


<style type="text/css">
.gtlWrap {
	width: 400px;
    height: 500px;
    margin: 100px auto 0;
    text-align: center;
    position: relative;
}
#goToLoginPage {
	width: 304px;
    height: 35px;
    background-color: #555;
    border: none;
    color: #fff;
    position: relative;
    top: 34px;
}
</style>

<div class="gtlWrap">
	<h1>완료!!</h1>
	<hr>
	<a href="{로그인 페이지 url 추후 수정}"><button id="goToLoginPage">로그인하러 가기</button></a>
</div>

<jsp:include page="../../layout/footer.jsp"/>