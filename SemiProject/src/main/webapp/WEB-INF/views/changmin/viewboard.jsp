<%@page import="util.Paging"%>
<%@page import="daun.dto.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Board viewBoard = (Board) request.getAttribute("viewBoard"); %>
<%@include file="../layout/header.jsp" %>
<!-- 부트스트랩 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	
	$('#btnList').click(function() {
		window.history.back();
	})
})
</script>
<style type="text/css">

#wrapper {
	margin: 0 20px 0 0;
}
th, td {
	text-align: center;
}

td:nth-child(2) {
	text-align: justify;
}

.right {
	position: relative;
	float: right;
	width: 800px;
	top: -500px;
	
}

.left{
	position: absolute;
	left: -100px;
}

img {
	margin: 0 0 20px 0;
}

#writeButton {
	float: right;
}


</style>
<div class="myContainer">
	<form method="get">
	<hr>
		<div style="min-height: 500px;">
			<div class="left">
	
				<!-- 게시판 목록 -->		
				<p><a href="/board/notice"><img src="/resources/image/notice.png"></a></p>
				<p><a href="/board/free"><img src="/resources/image/free.png"></a></p>
				<p><a href="/board/food"><img src="/resources/image/food.png"></a></p>
				<p><a href="/board/gathering"><img src="/resources/image/gathering.png"></a></p>
				<p><a href="/board/question"><img src="/resources/image/question.png"></a></p>
			
			</div>
			
		</div>
	</form>

<div class="right">
	<table class="table table-bordered">
	<tr>
		<td class="info">글번호</td>
		<td><%=viewBoard.getBoardno() %></td>
		
		<td class="info">작성일</td>
		<td><%=viewBoard.getBoarddate() %></td>
	</tr>
	
	<tr>
		<td class="info">회원번호</td>
		<td><%=viewBoard.getUserno() %></td>
		
		<td class="info">닉네임</td>
		<td>[추후 추가]</td>
	</tr>
	
	<tr>
		<td class="info">조회수</td>
		<td colspan="4"><%=viewBoard.getHit() %>
	</tr>
	<tr>
		<td class="info">제목</td>
		<td colspan="3"><%=viewBoard.getBoardtitle() %></td>
	</tr>
	
	<tr>
		<td class="info" colspan="4">본문</td>
	</tr>
	
	<tr>
		<td colspan="4"><%=viewBoard.getBoardcon() %></td>
	</tr>
	
	</table>
	<div class="text-center">
		<button id="btnList" class="btn btn-primary">목록</button>
		<button id="btnUpdate" class="btn btn-info">수정</button>
		<button id="btnDelete" class="btn btn-danger">삭제</button>
	</div>
</div>

	
	

	
<%@ include file="../layout/footer.jsp"%>