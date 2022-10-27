<%@page import="sharon.dto.Cart"%>
<%@page import="sharon.dto.Product"%>
<%@page import="sharon.dto.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../layout/header.jsp" %>
<%
Product p = (Product) request.getAttribute("product");

List<Cart> cartList =(List) request.getAttribute("cartList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>

<script type="text/javascript">
/* $(document).ready(function () {

	$("form").submit(function() {
		$("#").val( $("#").val() + " " + $("#").val() + " " + $("#").val() )
// 		return false;
	})
	
}) */

</script>
 
<style type="text/css">
.Cartbtn { 
   border: none;
    border-radius: 5px;
    box-shadow: 0 2px 2px rgba(0, 0, 0, 0.2);
    font-weight: 600;
    cursor: pointer;
    background-color: #B6E388;
    font-family: 'GmarketSansMedium';
}

body{
margin-top: 2%;
margin-bottom: 30%;
text-align:center;
}

table{
	border: 1px solid #ccc;
	border-collapse: collapse;
	width: 600px;
	margin: 0 auto;
	font-family: 'GmarketSansMedium';
	font-size:15px;
	text-align:center;
}

h2{
	font-family:'dalseo';
	text-align:center;
}

th{
text-align:center;
	background-color: #B6E388;
	height:40px;
}

td{
height:30px;
}

</style>
 
<script type="text/javascript">
 
 
function fnPay(){
	if(confirm("결제하시겠습니까?")){
		location.href = "/pay/do";
	}
}
 
function fnClear(){
	if(confirm("장바구니를 비우시겠습니까?")) {
		location.href = "/cart/delete";	
	}
}
 
function fnGo(){
	location.href ="/goods/list";
}
</script>
</head>
<body>
<div>
	<h2>장바구니🛒</h2>
	<table border="1">
		<tr>
			<th style="width: 10%;">선택</th>
			<th style="width: 10%;">번호</th>
			<th style="width: 20%;">회원번호</th>
			<th style="width: 20%;">상품번호</th>
			<th style="width: 20%;">수량</th>
			<th style="width: 20%;">가격</th>
		</tr>

<%	for(int i=0; i<cartList.size(); i++) { %>
		<tr>
			<td><input type="checkbox"></td>
 			<td><%=(i+1) %></td>	
			<td><%=cartList.get(i).getUserno() %></td>
			<td><%=cartList.get(i).getProdno()%></td>
			<td><%=cartList.get(i).getCartcount() %></td>
			<td><%=cartList.get(i).getProdprice()%></td> 
		</tr>
		<%	} %>
		<tr>
			<td colspan= '6' id="btn3">
				<input type='button' class="Cartbtn" value='결제하기' onclick='fnPay()' />
				<input type='button' class="Cartbtn" value='장바구니 비우기' onclick='fnClear()' />
				<input type='button' class="Cartbtn" value='쇼핑 계속하기' onclick='fnGo()' />
			</td>
			</tr>
	</table>
</div>
</body>
</html>
<jsp:include page="../../layout/footer.jsp"/>