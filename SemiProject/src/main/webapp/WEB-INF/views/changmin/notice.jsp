<%@page import="daun.dto.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<Board> list = (List) request.getAttribute("list"); %>
<style type="text/css">
th, td {
	text-align: center;
}

td:nth-child(2) {
	text-align: justify;
}

table {
	margin: 20px auto 0 auto;
	width: 1400px;
}
</style>
<table border="1">
	<tr>
		<th width="8%">번호</th>
		<th width="60%">제목</th>
		<th width="18%">글쓴이</th>
		<th width="8%">등록일</th>
		<th width="8%">조회수</th>
	</tr>

<% for(int i=0; i<list.size(); i++) {%>
	<tr>
		<td>1</td>
		<td><%= list.get(i).getBoardcon() %></td>
		<td>3</td>
		<td>4</td>
		<td>5</td>
	</tr>
<% } %>

<%-- <% for(int i=0; i<board.size(); i++) { %>
<tr>

	<td><%=board.get(i).getBoardno() %></td>
	<td>
		<a href="/board/view?boardno=<%=board.get(i).getBoardno() %>" id="#click">
			<%=board.get(i).getTitle() %>
		</a>
	</td>

	<td><%=board.get(i).getUserid() %></td>
	<td><%=board.get(i).getHit() %></td>
	<td><%=board.get(i).getWrite_date() %></td>
</tr>
<% } %> --%>


</table>