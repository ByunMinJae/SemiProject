<%@page import="donghyun.dto.Report"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/adminheader.jsp" %>
<% List<Report> reportBoard = (List) request.getAttribute("reportBoard"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function(){
	
	$("#btnPunish").click(function(){
		$(location).attr("href", "/cmc/punish?userno="+ $("#userno").text());
	})
})

</script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
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
	font-family : 'dalseo';
}
table{
	font-family: 'GmarketSansMedium';
	border: 1px solid #ccc;
}
button{
	font-family: 'GmarketSansMedium';
}
</style>
<script type="text/javascript">
$(document).ready(function(){
	$("#goCategory").click(function(){
		$(location).attr("href", "/manager/board")
	})
})

</script>
</head>
<body>
<h1>신고글 목록</h1>
<button id="goCategory">&lt;-카테고리</button>
<hr>
<table class="table">
<tr>
	<th>신고번호</th>
	<th>신고내용</th>
	<th>신고날짜</th>
	<th>회원번호</th>
	<th>글번호</th>
	<th></th>
</tr>

<%for(int i=0; i<reportBoard.size(); i++){ %>
<tr>
	<td><%=reportBoard.get(i).getReportno() %></td>
	<td><%=reportBoard.get(i).getReportcon() %></td>
	<td><%=reportBoard.get(i).getReportdate() %></td>
	<td id="userno"><%=reportBoard.get(i).getUserno() %></td>
	<td><a href="./boardview?boardno=<%=reportBoard.get(i).getBoardno() %>"><%=reportBoard.get(i).getBoardno() %></a></td>
	<td><button id="btnPunish">제재</button></td>
</tr>
<%} %>
</table>

<%@ include file="../layout/paging.jsp" %>
</body>
</html>