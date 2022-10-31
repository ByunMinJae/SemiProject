<%@page import="minjae.dto.ProductFile"%>
<%@page import="minjae.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%	Product prod = (Product)request.getAttribute("pordDetail"); %>
<%	ProductFile prodFile = (ProductFile)request.getAttribute("prodFile"); %>

<%@	include file="../../layout/header.jsp" %>

<script type="text/javascript">
$(document).ready(function() {
	
	//장바구니 버튼
	$("#btnCart").click(function() {
		
		if(confirm("장바구니에 담으시겠습니까?")) {
				console.log($('#cartcount').val())
		         location.href = "/cart/add?cartcount=" + $('#cartcount').val() + "&prodno=" + $('#prodno').val();
		}
		
	})

	//구매하기 버튼
	$("#btnBuy").click(function() {
		
			var cartCnt = parseInt($("#cartcount").val());
			var prodPrice = parseInt(<%=prod.getProdprice() %>);
			var totalamount = cartCnt*prodPrice;
			
			location.href = "/goods/buy?buyprodname=" + $('#prodname').val() + "&totalamount=" + totalamount + "&prodno=" + $("#prodno").val();
			
	})
	
})
</script>

<style type="text/css">
#wrapper {
	background-color: #BFDCFB;
}
#detailWrap {
	width: 900px;
    height: 100%;
    margin: 18px auto 0;
    text-align: center;
    font-family: 'GmarketSansMedium';
    position: relative;
    left: -51px;
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
#prodImg {
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
#f {
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
#noMsg {
	margin: 7px 0px 10px 69px;
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
<%	if(prodFile.getStoredname() == null) { %>
	<tr>
		<td colspan="4"><img id="prodImg" alt="" src="/resources/image/<%=prod.getProdimage() %>"></td>
	</tr>
<%	} else { %>
	<tr>
		<td colspan="4"><img alt="none" src="<%=request.getContextPath() %>/upload/<%=prodFile.getStoredname() %>"></td>
	</tr>
<%	} %>
	<tr>
		<td colspan="4" style="text-align: left;"><%=prod.getProdcon() %></td>
	</tr>
	<tr>
		<td>상품 판매량</td>
		<td><%=prod.getProdpop() %></td>
		<td>상품 등록일</td>
		<td><%=prod.getProddate() %></td>
	</tr>
</table>

<form action="" method="get" id="f">

<label for="cartcount">수량 : </label>
<select id="cartcount" name="cartcount">
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
</select>
<input type="text" hidden="" name="prodno"  id="prodno" value="<%=prod.getProdno() %>"> 
<input type="text" hidden="" name="prodname"  id="prodname" value="<%=prod.getProdname() %>">

<button type="button" id="btnCart" class="btnType">장바구니</button>
<button type="button" id="btnBuy" class="btnType">구매하기</button>
<p id="noMsg">굿즈는 이벤트성으로 판매하는 상품 특성상 취소, 반품이 어려울 수 있습니다.</p>
</form>

<!-- 첨부파일 다운로드 -->
<%-- <div id="file">
<%	if( prodFile != null ) { %>
<a href="<%=request.getContextPath() %>/upload/<%=prodFile.getStoredname() %>"
 download="<%=prodFile.getOriginname() %>">
	<%=prodFile.getOriginname() %>
</a>
<%	} %>
</div> --%>



</div>

<jsp:include page="../../layout/footer.jsp"/>










