<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>로그인 성공</h1>
<hr>

<h3>로그인 상태 : <%=session.getAttribute("login") %></h3>
<h3><%=session.getAttribute("loginid") %>님, 로그인되었습니다</h3>

<a href="./login">메인 화면</a>

</body>
</html>