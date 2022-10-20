<%@page import="daun.dto.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>

<%-- 모델값 전달받기 --%>
<%	List<Board> boardList = (List) request.getAttribute("boardList"); %>

<style type="text/css">
.table {
	height: 1000px;
	margin-bottom: 100px;

}

th, td {
	text-align: center;
}
td:nth-child(2) {
	text-align: justify;
}
</style>

<h1>게시글 목록</h1>
<hr>

<div class="table">
<table>

<tr>
	<th style="width: 15%;">글번호</th>
	<th style="width: 40%;">제목</th>
	<th style="width: 25%;">아이디</th>
	<th style="width: 20%;">작성일</th>
</tr>

<%	for(int i=0; i<boardList.size(); i++) { %>
<tr>
	<td><%=boardList.get(i).getBoardno() %></td>
	<td>
		<a href="./view?boardno=<%=boardList.get(i).getBoardno() %>">
			<%=boardList.get(i).getBoardtitle() %>
		</a>
	</td>
	<td><%=boardList.get(i).getUserno() %></td>
	<td><%=boardList.get(i).getBoarddate() %></td>
</tr>
<%	} %>

</table>
</div>


<jsp:include page="./paging.jsp" flush="true"/>

<%@ include file="../layout/footer.jsp" %>


