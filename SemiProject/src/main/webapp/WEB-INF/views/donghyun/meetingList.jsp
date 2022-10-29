<%@page import="donghyun.dto.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% List<Board> meetingBoard = (List) request.getAttribute("meetingBoard"); %>

<%@ include file="../layout/adminheader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">
h1{
	text-align: center;
}
th{
	text-align: center;
}
td{
	text-align: center;
}
</style>
</head>
<body>
<h1>소모임 게시판 </h1>
<hr>

<table class="table table-striped table-hover">

<tr class="thead">
	<th>글번호</th>
	<th>제목</th>
	<th>작성날짜</th>
	

</tr>

<% for(int i=0; i<meetingBoard.size(); i++){ %>
<tr>
	<td><%= meetingBoard.get(i).getBoardno() %></td>
	<td><a href="./boardview?boardno=<%=meetingBoard.get(i).getBoardno() %>"><%= meetingBoard.get(i).getBoardtitle() %></a></td>
	<td><%= meetingBoard.get(i).getBoarddate() %></td>
	
</tr>
<% } %>

</table>
<%@ include file="./paging.jsp" %>
</body>
</html>