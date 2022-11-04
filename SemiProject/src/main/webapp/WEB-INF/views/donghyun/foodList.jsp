<%@page import="util.Paging"%>
<%@page import="donghyun.dto.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% List<Board> foodBoard = (List) request.getAttribute("foodBoard"); %>
<% Board boardno = (Board) request.getAttribute("boardno"); %>
<% Paging paging = (Paging) request.getAttribute("paging"); %>


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
</head>
<body>
<h1>맛집 게시판</h1>
<button id="goCategory">&lt;-카테고리</button>
<hr>

<table class="table table-striped table-hover">

<tr class="thead">
	<th>글번호</th>
	<th>제목</th>
	<th>작성날짜</th>
	<th>작성회원번호</th>
	

</tr>

<% for(int i=0; i<foodBoard.size(); i++){ %>
<tr>
	<td><%= foodBoard.get(i).getBoardno() %></td>
	<td><a href="./boardview?boardno=<%=foodBoard.get(i).getBoardno() %>"><%= foodBoard.get(i).getBoardtitle() %></a></td>
	<td><%= foodBoard.get(i).getBoarddate() %></td>
	<td><%= foodBoard.get(i).getUserno() %></td>
	
</tr>
<% } %>



</table>


<div class="text-center">
	<ul class="pagination">
	
		<%-- 첫 페이지로 이동 --%>
		<%-- <%	if( paging.getCurPage() != 1) { %>
		<li><a href="./board">&larr; 처음</a></li>
		<%	} %> --%>
	
	
		<%-- 이전 페이지로 이동 --%>
		<%	if( paging.getCurPage() != 1) { %>
		<li><a href="<%=paging.getCurPage() - 1 %>">&lt;</a></li>
		<%	} %>
		
	
		<%-- 페이지 번호 리스트 --%>
		<%	for(int i=paging.getStartPage(); i<=paging.getEndPage(); i++) { %>
		<%		if( i == paging.getCurPage() ) { %>
		<li class="active"><a href="./foodList/?curPage=<%=i %>"><%=i %></a></li>
		<%		} else { %>
		<li><a href="./foodList/?curPage=<%=i %>"><%=i %></a></li>
		<%		} %>
		<%	} %>


		<%-- 다음 페이지로 이동 --%>
		<%	if( paging.getCurPage() != paging.getTotalPage() ) { %>
		<li><a href="./?curPage=<%=paging.getCurPage() + 1 %>">&gt;</a></li>
		<%	} %>
		
		
		<%-- 마지막 페이지로 이동 --%>
		<%	if( paging.getCurPage() != paging.getTotalPage() ) { %>
		<li><a href="./?curPage=<%=paging.getTotalPage() %>">&rarr; 끝</a></li>
		<%	} %>
	</ul>
</div>
</body>
</html>