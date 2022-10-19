<%@page import="daun.dto.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%	Board viewBoard = (Board) request.getAttribute("viewBoard"); %>

<%@ include file="../layout/header.jsp" %>

<script type="text/javascript">
$(document).ready(function() {
	
	$("#btnList").click(function() {
		$(location).attr("href", "./list")
	})
	
})
</script>

<h1>게시글 상세보기</h1>
<hr>

<table class="table table-bordered">

<tr>
	<td class="info">글번호</td>
	<td><%=viewBoard.getBoardno() %></td>
	
	<td class="info">작성일</td>
	<td><%=viewBoard.getBoarddate() %></td>
</tr>

<tr>
	<td class="info">아이디</td>
	<td><%=viewBoard.getUserno() %></td>
	
	<td class="info">닉네임</td>
	<td>[추후 추가]</td>
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

<%@ include file="../layout/footer.jsp" %>


