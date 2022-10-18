<%@page import="sharon.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%	User u = (User)request.getAttribute("result"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>회원가입 결과</h1>
<hr>

<%-- 번호 : <%=u.getUserno() %><br> --%>
아이디 : <%=u.getUserid() %><br>
닉네임 : <%=u.getNick() %><br>
생년월일 : <%=u.getBirth() %><br>
성별 : <%=u.getGender() %><br>
이메일 : <%=u.getEmail() %><br>
전화번호 : <%=u.getPhone() %><br>
주소 : <%=u.getAddress() %><br><br>

<a href="/user/join"><button>신규 회원 가입</button></a>

</body>
</html>