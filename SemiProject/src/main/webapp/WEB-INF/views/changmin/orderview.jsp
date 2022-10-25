<%@page import="changmin.dto.Order"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	List<Order> orderView = (List) request.getAttribute("orderView"); %>
<%@ include file="../layout/header.jsp"%>

<script>
</script>


<style type="text/css">
.myContainer {
	margin: 0 auto;
	min-height: 600px;
	position: relative;
	top: 30px;
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
	<h1 id="listhead">결제목록</h1>
	<% for(int i=0; i<orderView.size(); i++) { %>
	<table class="table table-hover">
		<tr class="success">
			<td>결제번호 : <%= orderView.get(i).getOrderafterno() %></td>
			<td>결제시간 : <%= orderView.get(i).getOrderdate() %></td>
		</tr>
		
		<tr class="success">
			<td>상품이름 : <%= orderView.get(i).getProdname() %></td>
			<td>결제금액 : <%= orderView.get(i).getAmount() %></td>
		</tr>
		
		<tr class="success">
			<td colspan=2>배송주소 : <%= orderView.get(i).getBuyeraddr() %></td>
		</tr>
		
		<tr>
			
			
			
		</tr>
	</table>
	<% } %>
</div>
<%@ include file="../layout/footer.jsp" %>