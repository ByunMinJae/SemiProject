<%@page import="donghyun.dto.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% List<Board> noticeBoard = (List) request.getAttribute("noticeBoard"); %>
<%@ include file="../layout/adminheader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
@font-face {
   font-family: 'dalseo';
   src: url('/resources/css/DalseoHealingBold.ttf') format('truetype');
}
@font-face {
    font-family: 'GmarketSansMedium';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansMedium.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
h1{
	text-align: center;
	font-family : 'dalseo' !important;
}
table{
	font-family: 'GmarketSansMedium';
	border: 1px solid #ccc;
}
button{
	font-family: 'GmarketSansMedium' !important;
}
</style>
<script type="text/javascript">
$(document).ready(function(){
	$("#goCategory").click(function(){
		$(location).attr("href", "/manager/board")
	})
})

</script>

<!-- 부트스트랩 Bootstrap 3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>
<h1>공지사항</h1>
<button id="goCategory">&lt;-카테고리</button>
<hr>

<table class="table table-striped table-hover">

<tr class="thead">
	<th>글번호</th>
	<th>제목</th>
	<th>작성날짜</th>
	<th>작성회원번호</th>
	
</tr>

<% for(int i=0; i<noticeBoard.size(); i++){ %>
<tr>
	<td><%= noticeBoard.get(i).getBoardno() %></td>
	<td><a href="./boardview?boardno=<%=noticeBoard.get(i).getBoardno() %>"><%= noticeBoard.get(i).getBoardtitle() %></a></td>
	<td><%= noticeBoard.get(i).getBoarddate() %></td>
	<td><%= noticeBoard.get(i).getUserno() %>
</tr>
<% } %>

</table>

<%@ include file="./paging.jsp" %>
</body>
</html>