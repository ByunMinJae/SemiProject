<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style type="text/css">
th, td {
	text-align: center;
}

td:nth-child(2) {
	text-align: justify;
}
</style>
<table border="1">
	<tr>
		<th width="5%">번호</th>
		<th width="64%">제목</th>
		<th width="16%">글쓴이</th>
		<th width="10%">등록일</th>
		<th width="5%">조회수</th>
	</tr>
	<tr>
		<td>1</td>
		<td>2</td>
		<td>3</td>
		<td>4</td>
		<td>5</td>
	</tr>

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