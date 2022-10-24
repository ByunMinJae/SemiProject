<%@page import="java.text.DecimalFormat"%>
<%@page import="sharon.dto.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../layout/header.jsp" %>
<%
request.setCharacterEncoding("UTF-8");
ArrayList<Cart> cartList = null;
 
Object obj = session.getAttribute("cartList");	//세션 객체에서 cart 값을 가져온다.
 
if(obj == null) {	//세션 정보가 없으면 배열을 생성 : 주문한 제품이 없다
	cartList = new ArrayList<Cart>();	
} else {			//세션 정보가 있으면 강제로 캐스팅 : 주문한 제품이 있다
	cartList = (ArrayList<Cart>) obj;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
 
<style type="text/css">

body{
margin-top: 16%;
margin-bottom: 30%;
}

</style>
 
<script type="text/javascript">
 
 
function fnPay(){
	alert("결제 기능을 지원하지 않습니다.");
}
 
function fnClear(){
	if(confirm("장바구니를 비우시겠습니까?")) {
		location.href = "./CartClear.jsp";	
	}
}
 
function fnGo(){
	location.href ="./UserMain.jsp";
}
</script>
</head>
<body>
<div align="center">
	<h2>[장바구니]</h2>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>가격</th>
			<th>수량</th>
			<th>가격</th>
		</tr>
<%
		if(cartList.size() == 0) {
%>
		<tr align='center'>
			<td colspan= '5'>
				장바구니에 담긴 상품이 없습니다.
				<a href= '/UserMain.jsp'>주문하기</a>
			</td>
		</tr>
<%
		} else {
			int totalSum = 0, total = 0;
			DecimalFormat df = new DecimalFormat("￦#,##0");
			for(int i = 0; i < cartList.size(); i++) {
				Cart dto = cartList.get(i);
		%>
		<tr align= 'center'>
			<td><%=(i + 1) %></td>
			<td><%=dto.getProdname() %></td>
			<td><%=df.format(dto.getProdprice()) %></td>
			<td><%=dto.getCartcount() %></td>
			<% 
				total = dto.getProdprice() * dto.getCartcount();
			%>
			<td><%=df.format(total) %></td>
		</tr>
		<% 
			totalSum += total;
		}
		%>
		<tr align = 'center'>
			<td colspan= '4'>
				<input type='button' value='결제하기' onclick='fnPay()' />
				<input type='button' value='장바구니 비우기' onclick='fnClear()' />
				<input type='button' value='쇼핑 계속하기' onclick='fnGo()' />
			</td>
		<td>
		 <%=df.format(totalSum) %>
		 </td>
			</tr>
		<% 
			}
		%>
	</table>
</div>
</body>
</html>
<%@ include file="../../layout/footer.jsp" %>