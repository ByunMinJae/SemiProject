<%@page import="donghyun.dto.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% List<Board> qnaBoard = (List) request.getAttribute("qnaBoard"); %>

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
h1 {
	text-align: center;
}
</style>
</head>
<body>
<h1>질문게시판</h1>
<hr>

<table class="table table-striped table-hover">

<tr class="thead">
	<th>글번호</th>
	<th>제목</th>
	<th>작성날짜</th>
	<th>작성회원번호</th>
	

</tr>

<% for(int i=0; i<qnaBoard.size(); i++){ %>
<tr>
	<td><%= qnaBoard.get(i).getBoardno() %></td>
	<td><a href="./boardview?boardno=<%=qnaBoard.get(i).getBoardno() %>"><%= qnaBoard.get(i).getBoardtitle() %></a></td>
	<td><%= qnaBoard.get(i).getBoarddate() %></td>
	<td><%= qnaBoard.get(i).getUserno() %>
	
</tr>
<% } %>

</table>
<%@ include file="./paging.jsp" %>
</body>
</html>