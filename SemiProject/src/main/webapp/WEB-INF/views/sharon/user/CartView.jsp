<%@page import="sharon.dto.Cart"%>
<%@page import="sharon.dto.Product"%>
<%@page import="sharon.dto.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../layout/header.jsp" %>
<%
Product prod = (Product) request.getAttribute("product");

List<Cart> cartList =(List) request.getAttribute("cartList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>

 
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
	width: 900px;
	margin: 0 auto;
	font-family: 'GmarketSansMedium';
	font-size:15px;
	text-align:center;
}

h2{
	font-family:'dalseo';
	text-align:center;
	margin-top: 5%;
	margin-bottom: 3%;
	
}

th{
text-align:center;
	background-color: #B6E388;
	height:60px;
}

td{
height:60px;
}


#cartouter{

margin-bottom: 20%;

}

#btn3{
height:50px;
}
</style>
 
<script type="text/javascript">
/*체크박스 값 가져오기 -prodname,prodprice*cartcount=totalprice(총합) */
/* function check(){
	var frm=document.getElementById("form");
	var found=null;
	for(i=0; i<cartList.size(); i++){
		if(frm.cart_list[i].checkd==true){
			found=frm.cart_list[i].value;
		}
	}
	if(found==null){
		alert("하나 이상 체크해주세요");
		return false;
		
	}
} */


/* $(document).ready(function() {
 //장바구니->결제
$("#paybtn").click(function() {
	
	var cartCnt = parseInt($("#cartcount").val());
	var prodPrice = parseInt($("#prodprice").val());
	var totalamount = cartCnt*prodPrice;
	
	location.href = "/cart/order?buyprodname=" + $('#prodname').val() + "&totalamount=" + totalamount + "&prodno=" + $("#prodno").val(); 
}  */

 function fnPay(){
	if(confirm("결제하시겠습니까?")){
		var cartCnt = parseInt($("#cartcount").val());
		var prodPrice = parseInt($("#prodprice").val());
		var totalamount = cartCnt*prodPrice;
		
		location.href = "/cart/order?buyprodname=" + $('#prodname').val()+ "&totalamount=" + totalamount+ "&prodno=" + $("#prodno").val();/*  + "&totalamount=" + totalamount  */
	}
	}
	
  
function fnClear(){
	if(confirm("장바구니를 비우시겠습니까?")) {
		location.href = "/cart/delete?prodno="+ $('#prodno').val() + "&prodprice=" + $('#prodprice').val();;	
	}
}
 
function fnGo(){
	location.href ="/goods/list";
}
</script>
</head>
<body>
<div id="cartouter">
	<h2>장바구니🛒</h2>
	<form action="/cart/order" method="post" id="form"></form>
	<table border="1">
		<tr>
			<th style="width: 6%;"><input type="checkbox" value="[i+1]" id="chkall"></th>
			<th style="width: 7%;">번호</th>
			<th style="width: 24%;">상품명</th>
			<th style="width: 16%;">상품번호</th>
			<th style="width: 17%;">가격</th>
			<th style="width: 8%;">수량</th>
			<th style="width: 17%;">합계</th>
			<!-- <th>회원번호</th> -->
		</tr>

<%	for(int i=0; i<cartList.size(); i++) { %>

		<tr>
			<td><input type="checkbox" id="cart_list"name="cart_list"></td>
 			<td id="cartno"><%=(i+1) %></td>	
			<td><%=cartList.get(i).getProdname()%></td> 
			<td><%=cartList.get(i).getProdno()%></td>
			<td><%=cartList.get(i).getProdprice()%>원</td> 
			<td><%=cartList.get(i).getCartcount() %>개</td>
			<td><%=cartList.get(i).getProdprice()*cartList.get(i).getCartcount()%>원</td> 
			<%-- <td><%=cartList.get(i).getUserno() %></td> --%>
			<input type="text" hidden="" name="prodname"  id="prodname" value="<%=cartList.get(i).getProdname() %>">
			<input type="text" hidden="" name="prodno"  id="prodno" value="<%=cartList.get(i).getProdno() %>">
			<input type="text" hidden="" name="cartcount"  id="cartcount" value="<%=cartList.get(i).getCartcount() %>">
			<input type="text" hidden="" name="prodprice"  id="prodprice" value="<%=cartList.get(i).getProdprice() %>">
			<input type="text" hidden="" name="userno"  id="userno" value="<%=cartList.get(i).getUserno() %>">
		</tr>
		<%	} %>
		<tr>
			<td colspan= '7' id="btn3">
				<input type='button' class="Cartbtn" id="paybtn" value='결제하기' onclick='fnPay()'/><!-- onclick='fnPay()' -->
				<input type='button' class="Cartbtn" value='장바구니 비우기' onclick='fnClear()' />
				<input type='button' class="Cartbtn" value='쇼핑 계속하기' onclick='fnGo()' />
			</td>
			</tr>
			
	</table>
</div>
</body>
</html>
<jsp:include page="../../layout/footer.jsp"/>