<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@	include file="../../layout/header.jsp" %>
    
<style type="text/css">
.sfiWrap {
	width: 400px;
    height: 500px;
    margin: 100px auto 0;
    text-align: center;
    position: relative;
}

#btnLogin {
	width: 304px;
    height: 35px;
    background-color: #555;
    border: none;
    color: #fff;
    border-radius: 7px
}

h3 {
	background: #ccf5cc;
    width: 304px;
    display: inline-block;
	margin: 50px 0 30px;
	border-radius: 4px
}
.findPw {
 	color: #777;
	font-size: 14px;
    position: absolute;
    top: 71px;
    right: 10px;
    font-weight: bold;
}
.findPw:hover {
	color: #444; 
}
#fromInsideOut a::after {
	position: absolute; 
	content:""; 
	display: block; 
	border-bottom: 2px solid #444; 
	transition: all 250ms ease-out; 
	left: 50%; 
	width: 0;
}

#fromInsideOut a:hover::after {
	transition: all 250ms ease-out; 
	left: 0%; 
	width: 100%;
}
</style>

<div class="sfiWrap">
<h1>아이디 확인</h1>
<hr>

<div id="fromInsideOut">
	<a href="<%=request.getContextPath() %>/find/findpw" class="findPw" style="text-decoration: none;">비밀번호 찾기</a>
</div>

<h3><%=request.getParameter("id") %></h3>

<a href=""><button id="btnLogin">로그인</button></a>
</div>

<jsp:include page="../../layout/footer.jsp"/>
<%-- <%@	include file="../../layout/footer.jsp" %> --%>