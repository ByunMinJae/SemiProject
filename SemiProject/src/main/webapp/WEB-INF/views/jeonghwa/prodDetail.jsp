<%@page import="jeonghwa.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layout/header.jsp" %>    
    
<%	Product product = (Product) request.getAttribute("product"); %>    
    
<style>
.container {
	height: 700px;
}
</style>    


<p>상품번호 : <%=product.getProdno() %></p>
<p>상품이름 : <%=product.getProdname() %></p>
<p>가격 : <%=product.getProdprice() %></p>
<p>이미지 : <%=product.getProdimage() %></p>

<p>상품설명 : <%=product.getProdcon() %></p>
<p>상품등록날짜 : <%=product.getProdDate() %></p>
<p>주문횟수 : <%=product.getProdpop() %></p>




<br>
<a href="/prod/list"><button>목록</button></a>




<%@ include file="../layout/footer.jsp" %>