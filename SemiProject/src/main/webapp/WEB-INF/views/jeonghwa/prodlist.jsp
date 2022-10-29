<%@page import="util.Paging"%>
<%@page import="jeonghwa.dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    


<!-- 서블릿(Controller)이 전달한 데이터 꺼내기 -->
<%	List<Product> productList = (List)request.getAttribute("productList"); %>



<%@ include file="../layout/header.jsp" %>

<!-- 부트스트랩3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style>

.container {
	height: 700px;
}

.updatebtn {
	
}

.list {
	margin-top: 50px;
}
</style>

<script type="text/javascript">
$(document).ready(function() {
	$("#btnWrite").click(function() {
		location.href = "./write"
	})
})


$(document).ready(function() {
	

	
	//수정 버튼
	$("#btnUpdate").click(function() {
		location.href = "./update"
	})

	//삭제버튼
	$("#btnDelete").click(function() {
		location.href = "./delete"	
		})

})



</script>

<div class="list">

	<h3>상품 목록</h3>
	
	
	<table class="table table-striped table-hover">
	
	  <tr>
		<th style="width: 40%;">사진</th>
		<th style="width: 20%;">상품명</th>
		<th style="width: 10%;">가격</th>
		<th style="width: 10%;">재고</th>
		<th style="width: 40%;">기능</th>
	  </tr>
	  
	  <%	for(int i=0; i<productList.size(); i++) { %>
	  <tr>
	    <td><%=productList.get(i).getProdimage() %></td>
	    
	    <td>
	    	<a href="/prod/view?prodno=<%=productList.get(i).getProdno() %>">
	    		<%=productList.get(i).getProdname() %>
	    	</a>	
	    </td>
	    
	    <td><%=productList.get(i).getProdprice() %></td>
	    <td><%=productList.get(i).getProdpop() %></td>
	    <td>
			<button id="btnUpdate" class="btn btn-info">수정</button>
			<button id="btnDelete" class="btn btn-danger">삭제</button>
	    </td>
	  </tr>
	  <% } %>
	  
	</table>
	
	<div id="btnBox" class="pull-right">
		<button id="btnWrite" class="btn btn-primary">상품 추가</button>
	</div>

</div>

<%@	include file="../layout/paging.jsp"%>

<%@ include file="../layout/footer.jsp" %>























