<%@page import="sharon.dto.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	List<User> uList = (List) request.getAttribute("userList");%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>

<style type="text/css">

table {
	border: 1px solid #ccc;
	border-collapse: collapse;
	
	width: 1100px;
	margin: 0 auto;
}

td {
	border-top: 1px solid #ccc;
	
	text-align: center;
	
	padding: 5px 10px;
}

/* tr:hover {
	background-color: #FAFAD2;
}

td:hover {
	background-color: #F3F3C2;
}
 */
</style>

</head>
<body>

<h1>회원 목록</h1>
<hr>

<table>

<thead>
<tr>
	<th style="width: 5%;">회원번호</th>
	<th style="width: 10%;">이름</th>
	<th style="width: 10%;">아이디</th>
	<th style="width: 10%;">닉네임</th>
	<th style="width: 5%;">성별</th>
	<th style="width: 10%;">주소</th>
	<th style="width: 10%;">전화번호</th>
	<th style="width: 10%;">생년월일</th>
	<th style="width: 10%;">이메일</th>
	<th style="width: 10%;">가입날짜</th>
	<th style="width: 10%;">회원정보수정일</th>
</tr>
</thead>

<tbody>

<%	for(int i=0; i<uList.size(); i++) { %>
<tr>
	<td><%=uList.get(i).getUserno() %></td>
	
	<td>
		<a href="/user/detail?userno=<%=uList.get(i).getUserno() %>">
			<%=uList.get(i).getUsername() %>
		</a>
	</td>

	<td><%=uList.get(i).getUserid() %></td>
	<td><%=uList.get(i).getNick() %></td>
	<td><%=uList.get(i).getGender() %></td>
	<td><%=uList.get(i).getAddress() %></td>
	<td><%=uList.get(i).getPhone() %></td>
	<td><%=uList.get(i).getBirth() %></td>
	<td><%=uList.get(i).getEmail() %></td>
	<td><%=uList.get(i).getJoinday() %></td>
	<td><%=uList.get(i).getUserupdate() %></td>
	<td><%=uList.get(i).getGradeno() %></td>
</tr>
<%	} %>

</tbody>

</table>

</body>
</html>