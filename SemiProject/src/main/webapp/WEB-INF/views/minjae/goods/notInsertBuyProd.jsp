<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@	include file="../../layout/header.jsp" %>

<style type="text/css">
#wrapper {
	background-color: #BFDCFB;
}
#nibpWrap {
	width: 900px;
    height: 100%;
    margin: 18px auto 0;
    text-align: center;
    font-family: 'GmarketSansMedium';
    position: relative;
    left: -51px;
}
</style>

<div id="nibpWrap">
<h1>상품 구매에 실패하였습니다. 다시 시도해 주세요.</h1>
<hr>

<a href="/goods/list">굿즈샵으로 가기</a>

<jsp:include page="../../layout/footer.jsp"/>
</div>



