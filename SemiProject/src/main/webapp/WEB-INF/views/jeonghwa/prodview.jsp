<%@page import="jeonghwa.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 서블릿(Controller)이 전달한 데이터 꺼내기 --> 
<%	Product viewProduct = (Product) request.getAttribute("viewProduct"); %>     
    
<%@ include file="../layout/header.jsp" %>    
    


<script type="text/javascript">
$(document).ready(function() {
	
	$("#btnList").click(function() {
		$(location).attr("href", "/prod/list")
	})
	
	//수정 버튼
	$("#btnUpdate").click(function() {
		$(location).attr('href', '/prod/update?prodno=<%=viewProduct.getProdno() %>')
	})

	//삭제버튼
	$("#btnDelete").click(function() {
		$(location).attr('href', '/prod/delete?prodno=<%=viewProduct.getProdno() %>')
	})

})
</script>    
<style>
.container {
	height: 700px;
}

.view {
	margin-top: 150px;
}
</style>    

<div class="view">

	<h3>상품 정보 상세보기</h3>
	<hr>
	<br>
	
	<p>상품번호 : <%=viewProduct.getProdno() %></p>
	<p>상품이름 : <%=viewProduct.getProdname() %></p>
	<p>가격 : <%=viewProduct.getProdprice() %></p>
	<p>이미지 : <%=viewProduct.getProdimage() %></p>
	
	<p>상품설명 : <%=viewProduct.getProdcon() %></p>
	<p>상품등록날짜 : <%=viewProduct.getProdDate() %></p>
	<p>주문횟수 : <%=viewProduct.getProdpop() %></p>
	
	
	
	
	<br>
	<div class="text-center">
		<button id="btnList" class="btn btn-primary">목록</button>
		<button id="btnUpdate" class="btn btn-info">수정</button>
		<button id="btnDelete" class="btn btn-danger">삭제</button>
	</div>


</div>




<%@ include file="../layout/footer.jsp" %>>