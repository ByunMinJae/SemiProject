<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%	int res = (int)request.getAttribute("res"); %>

<%@	include file="../../layout/header.jsp" %> 

<style type="text/css">
#deleteWrap {
	width: 423px;
	height: 406px;
	margin: 239px auto 0;
	text-align: center;
	position: relative;
	font-family: 'GmarketSansMedium';
}
a {
	text-decoration: none;
	font-size: 18px;
	color: #888;
	font-weight: bold;
}
a:hover {
	color: #444;
}
</style>   

<div id="deleteWrap">
<%	if( res > 0 ) { %>
<h1>회원 탈퇴가 완료되었습니다. 감사합니다.</h1>
<a href="/">메인 페이지로</a>
<%	} else { %>
<h1>회원 탈퇴를 실패하였습니다. 다시 시도해 주세요.</h1>
<a href="/">메인 페이지로</a>
<%	} %>
</div>   


<jsp:include page="../../layout/footer.jsp"/>