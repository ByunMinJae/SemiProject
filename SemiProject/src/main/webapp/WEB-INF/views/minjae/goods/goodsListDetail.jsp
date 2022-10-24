<%@page import="minjae.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%	Product prod = (Product)request.getAttribute("pordDetail"); %>

<%@	include file="../../layout/header.jsp" %>

<script type="text/javascript">
$(document).ready(function() {
	
	//장바구니 버튼
	$("#btnCart").click(function() {
		location.href = "/cart/list?cartcount=" + $('#cartcount').val() + "&prodname=" + $('#prodname').val() 
	})

	//구매하기 버튼
	$("#btnBuy").click(function() {
		location.href = "/pay/do?prodname=" + $('#prodname').val() + "&prodprice=<%=prod.getProdprice() %>&cartcount=" + $('#cartcount').val()
	})
	
})
</script>

<style type="text/css">
#detailWrap {
	width: 900px;
    height: 100%;
    margin: 18px auto 0;
    text-align: center;
}
#detail_table {
	border-collapse: collapse;
	margin: 75px 0 20px;
	width: 600px;
    display: inline-block;
}
#detail_table tr:first-child, #detail_table tr:last-child {
	background: #B6E388;
}
#detail_table td {
	border: 1px solid #7cad4b;
	height: 46px;
	font-size: 18px;
	font-weight: bold;
}
img {
	width: 600px;
	height: 600px; 
}
#back {
    color: #777;
    float: left;
    left: 225px;
    top: 42px;
    font-size: 17px;
    font-weight: bold;
    position: relative;
    text-decoration: none;
}
#back:hover {
	color: #444;
}
#arrow {
	background: url("/resources/image/left_arrow.png") no-repeat 0 0;
	width: 20px;
    height: 20px;
	position: relative;
    left: 202px;
    top: 65px;
}
form {
	width: 583px;
    margin: 0 223px;
}
#cartcount {
	width: 86px;
	height: 30px;
	font-size: 18px;
}
.btnType {
	width: 200px;
    height: 43px;
    font-size: 19px;
    font-weight: bold;
    border-radius: 9px;
}
.btnType:hover {
	background: #ccc;
}
</style>

<div id="detailWrap">

<div id="arrow"></div>
<a id="back" href="/goods/list">목록으로</a>

<table id="detail_table">
	<tr>
		<td>상품명</td>
		<td><%=prod.getProdname() %></td>
		<td>가격</td>
		<td><%=prod.getProdprice() %></td>
	</tr>
	<tr>
		<td colspan="4"><img alt="" src="/resources/image/<%=prod.getProdimage() %>"></td>
	</tr>
	<tr>
		<td colspan="4"><%=prod.getProdcon() %></td>
	</tr>
	<tr>
		<td>상품 주문수</td>
		<td><%=prod.getProdpop() %></td>
		<td>상품 등록일</td>
		<td><%=prod.getProddate() %></td>
	</tr>
</table>

<form action="" method="get">

<label for="cartcount">수량 : </label>
<select id="cartcount" name="cartcount">
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
</select>
<input type="text" hidden="" name="prodname"  id="prodname" value="<%=prod.getProdname() %>">

<button type="button" id="btnCart" class="btnType">장바구니</button>
<button type="button" id="btnBuy" class="btnType">구매하기</button>

</form>

</div>

<jsp:include page="../../layout/footer.jsp"/>










