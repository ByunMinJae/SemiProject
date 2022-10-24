<%@page import="donghyun.dto.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% Board viewBoard = (Board) request.getAttribute("viewBoard"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#back").click(function(){
		history.back();
	})
})

</script>
</head>
<body>

<h1>상세내용</h1>

<table>

<tr>
	<td>글번호</td>
	<td><%= viewBoard.getBoardno() %></td>
</tr>
<tr>	
	<td>작성일</td>
	<td><%= viewBoard.getBoarddate() %></td>
</tr>

<tr>
	<td>회원번호</td>
	<td><%=viewBoard.getUserno() %></td>

</tr>


<tr>
	<td>제목</td>
	<td><%= viewBoard.getBoardtitle() %></td>
</tr>

<tr>
	<td>내용</td>
</tr>

<tr>
	<td><%=viewBoard.getBoardcon() %></td>
</tr>
	

</table>

<button id="back">목록</button>
</body>
</html>