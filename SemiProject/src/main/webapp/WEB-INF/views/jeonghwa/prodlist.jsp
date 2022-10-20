<%@page import="jeonghwa.dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layout/header.jsp" %>

<%	List<Product> list = (List) request.getAttribute("productList"); %>

<style>
.container {
	height: 700px;
}
table {
	border: 1px solid black;
	border-collapse: collapse;
	
	width: 60%;
	right: 200px;
	text-align: center;
	
}
tr, th, td {
	border: 1px solid black;
	height: 30%;
}

.updatebtn {
	
}
</style>

<h3>게시글 목록</h3>


<table>

  <tr>
	<th style="width: 15%;">사진</th>
	<th style="width: 15%;">상품명</th>
	<th style="width: 15%;">가격</th>
	<th style="width: 15%;">재고</th>
	<th style="width: 15%;">기능</th>
  </tr>
  
  <%	for(int i=0; i<list.size(); i++) { %>
  <tr>
    <td><%=list.get(i).getProdimage() %></td>
    <td>
    	<a href="/WEB-INF/views/jeonghwa/prodview.jsp">
    		<%=list.get(i).getProdname() %>
    	</a>	
    </td>
    <td><%=list.get(i).getProdprice() %></td>
    <td><%=list.get(i).getProdpop() %></td>
    <td>
		<button class="btn" onclick="location.href=''">수정</button>
		<button class="btn" onclick="location.href=''">삭제</button>
    </td>
  </tr>
  <% } %>
  
</table>

<button class="updatebtn" onclick="location.href=''">상품 추가</button>



<%@ include file="../layout/footer.jsp" %>