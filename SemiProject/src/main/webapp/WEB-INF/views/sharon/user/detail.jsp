<%@page import="sharon.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../layout/header.jsp" %>
<%	User user= (User) request.getAttribute("user");%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원상세정보</title>
</head>
<body>

<h1>회원 정보</h1>
<hr>

<p>회원번호 : <%=user.getUserno() %></p>
<p>이름 : <%=user.getUsername() %></p>
<p>아이디: <%=user.getUserid() %></p>
<p>닉네임 : <%=user.getNick() %></p>
<p>성별 : <%=user.getGender() %></p>
<p>주소 : <%=user.getAddress() %></p>
<p>전화번호 : <%=user.getPhone() %></p>
<p>생년월일 : <%=user.getBirth() %></p>
<p>이메일 : <%=user.getEmail() %></p>
<p>가입날짜 : <%=user.getJoinday() %></p>
<p>회원정보수정일 : <%=user.getUserupdate() %></p>
<p>등급 : <%=user.getGradeno() %></p>


<br>

<div class="text-center">
	<a href="/user/list"><button id="btnList">목록</button></a>
	<a href=""><button>수정</button></a>
	<a href=""><button>삭제</button></a>
</div>

</body>
</html>
<%@ include file="../../layout/footer.jsp" %>