<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@	include file="../../layout/header.jsp" %>


<style type="text/css">
#wrapper {
	background-color: #BFDCFB;
}
.gtlWrap {
	width: 539px;
    height: 500px;
    margin: 200px auto 0;
    text-align: center;
    position: relative;
    font-family: 'GmarketSansMedium';
}
#goToLoginPage {
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
#goToLoginPage:hover {
	background-color: #333;
}
</style>

<div class="gtlWrap">
	<h1>비밀번호 변경이 완료 되었습니다.</h1>
	<hr>
	<a href="/cmc/login"><button id="goToLoginPage">로그인하러 가기</button></a>
</div>

<jsp:include page="../../layout/footer.jsp"/>