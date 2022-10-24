<%@page import="util.Paging"%>
<%@page import="jeonghwa.dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    


<!-- 서블릿(Controller)이 전달한 데이터 꺼내기 -->
<%	List<Product> pList = (List)request.getAttribute("productList"); %>

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
</style>

<h3>상품 목록</h3>


<table class="table table-striped table-hover">

  <tr>
	<th style="width: 40%;">사진</th>
	<th style="width: 20%;">상품명</th>
	<th style="width: 10%;">가격</th>
	<th style="width: 10%;">재고</th>
	<th style="width: 40%;">기능</th>
  </tr>
  
  <%	for(int i=0; i<pList.size(); i++) { %>
  <tr>
    <td><%=pList.get(i).getProdimage() %></td>
    
    <td>
    	<a href="/prod/detail?prodno=<%=pList.get(i).getProdno() %>">
    		<%=pList.get(i).getProdname() %>
    	</a>	
    </td>
    
    <td><%=pList.get(i).getProdprice() %></td>
    <td><%=pList.get(i).getProdpop() %></td>
    <td>
		<button class="btn" onclick="location.href=''">수정</button>
		<button class="btn" onclick="location.href=''">삭제</button>
    </td>
  </tr>
  <% } %>
  
</table>

<button class="updatebtn" onclick="location.href=''">상품 추가</button>

<%@	include file="paging.jsp"%>

<%@ include file="../layout/footer.jsp" %>
