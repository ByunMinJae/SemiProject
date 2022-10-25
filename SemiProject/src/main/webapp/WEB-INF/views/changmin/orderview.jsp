<%@page import="changmin.dto.Order"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	List<Order> orderView = (List) request.getAttribute("orderView"); %>
<%@ include file="../layout/header.jsp"%>
<style type="text/css">
.myContainer {
	margin: 0 auto;
	min-height: 600px;
	position: relative;
	top: 80px;
	left: -100px;
}

th,td {
	font-family: 'GmarketSansMedium';
}

#wrapper {
	background-color: #BFDCFB;
}

#listhead{
	font-family: 'dalseo';
	font-weight: bold;
}
</style>
<div class="myContainer">
	<h1 id="listhead">주문목록</h1>
	<table class="table table-hover">
		<tr class="success">
			<td>주문번호</td>
			<td>주문일자</td>
		</tr>
		
		<tr class="success">
			<td>상품명</td>
			<td>결제금액</td>
		</tr>
		
		<tr class="success">
			<td colspan=2>배송지</td>
		</tr>
		
		<tr>
			<% for(int i=0; i<orderView.size(); i++) { %>
			<td><%= orderView.get(i).getAmount() %></td>
			<td><%= orderView.get(i).getBuyeraddr() %></td>
			<% } %>
		</tr>
	</table>
</div>
<%@ include file="../layout/footer.jsp" %>