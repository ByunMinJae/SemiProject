<%@page import="changmin.dto.Order"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	List<Order> orderView = (List) request.getAttribute("orderView"); %>
<%@ include file="../layout/header.jsp"%>
<style type="text/css">
.myContainer {
	margin: 0 auto;
}
</style>
<div class="myContainer">

<h1>주문목록</h1>
구매자 : <%= orderView.get(0).getBuyername() %>
금액 : <%= orderView.get(0).getAmount() %>
</div>
<%@ include file="../layout/footer.jsp" %>