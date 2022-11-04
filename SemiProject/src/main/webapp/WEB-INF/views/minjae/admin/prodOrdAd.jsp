<%@page import="minjae.dto.ProdOrdAd"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	List<ProdOrdAd> POAIList = (List) request.getAttribute("prodOrdAd"); %>
<%@	include file="../../layout/adminheader.jsp" %>

<script type="text/javascript">
$(document).ready(function() {
	
	//기본 순 클릭
	$("#btnDef").click(function() {
		$("#catename").attr("value", "orderafterno");
		$("#f").submit();
	})
	
	//오래된 순 클릭
	$("#btnDate").click(function() {
		$("#catename").attr("value", "orderdate");
		$("#f").submit();
	})
	
	//최신 순 클릭
	$("#btnDateDESC").click(function() {
		$("#catename").attr("value", "orderdate DESC");
		$("#f").submit();
	})
	
	//가나다 순 클릭
	$("#btnName").click(function() {
		$("#catename").attr("value", "prodname");
		$("#f").submit();
	})
	
})

//진행상태 수정 메소드
function change(i) {
	console.log('현재 수정하려는 상품번호' + $("#oano" + i).text())
	
	$.ajax({
		type: "post"					
		, url: "/prodOrdAd/list"			
		, data: {
			orderafterno: $("#oano" + i).text()
			, select: $("#selectid" + i).val()
		}
		, dataType: "html"				
		, success: function( res ) {
			console.log("AJAX 성공")
			$("#result").html(res);
			location.reload();
		}
	})
}
</script>

<style type="text/css">
@font-face {
    font-family: 'GmarketSansMedium';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansMedium.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
#mh1 {
	text-align: center;
}
#tbWrap { 
	width: 1100px;
	margin: 66px auto 0;
	font-family: 'GmarketSansMedium';
}
#poaTable {
	width: 1100px;
	border-collapse: collapse; 
	text-align: center;
}
#thead_tr {
	background-color: #fff39b;
	font-weight: bold;
	border-bottom: 2px solid #777 !important;
}
#thead_tr, #poaTable td {
	border: 1px solid #ccc;
	height: 32px; 
}
#poaTable td:hover {
	background-color: #ccc;
}
#btn_chg{
    cursor: pointer;
    width: 48px;
    height: 27px;
    position: relative;
    top: -15px;
    right: -74px;
}
.sel {
	width: 143px;
    height: 27px;
    position: relative;
    top: 12px;
    right: 28px;
    margin: 0 52px;
}
#selectWrap {
	width: 194px;
}
#selectid {
	height: 26px;
    width: 127px;
    text-align: center;
    font-family: 'GmarketSansMedium';
    border-color: #777;
}
.btnCate {
	cursor: pointer;
}
#f {
	margin: 0 !important;
}
p{
   display: inline-block; 
    margin-top: 29px !important;
    font-size: xx-large; 
    font-weight: bolder; 
}
form{
   width:50%;
   margin: 0 auto;
}
</style>
</head>
<body>


<div id="tbWrap">
<h1 id="mh1">상품 주문 관리</h1>
<hr>

<form action="/prodOrdAdCate/list" method="get" id="f">
<a id="btnDef" class="btnCate">기본 순</a> |
<a id="btnDate" class="btnCate">오래된 순</a> |
<a id="btnDateDESC" class="btnCate">최신 순</a> |
<a id="btnName" class="btnCate">가나다 순</a>
<input type="hidden" id="catename" name="cate" value="">
</form>

<table id="poaTable">
<thead>
	<tr id="thead_tr">
		<td>주문번호</td>
		<td>주문일자</td>
		<td>상품</td>
		<td>진행상태</td>
		<td>상태수정</td>
		<td>수량</td>
		<td>가격</td>
	</tr>
</thead>
<tbody id="result">
	<%	for(int i=0; i<POAIList.size(); i++) { %>
	<tr>
		<td id="oano<%=i%>"><%=POAIList.get(i).getOrderafterno() %></td>
		<td><%=POAIList.get(i).getOrderdate() %></td>
		<td><%=POAIList.get(i).getProdname() %></td>
		<td><%=POAIList.get(i).getOrderprocess() %></td>
		<td id="selectWrap">
		<select id="selectid<%=i%>" class="sel">
			  <option id="op1" value="none" selected>=== 선택 ===</option>
			  <option id="op2" value="결제완료">결제 완료</option>
			  <option id="op3" value="배송완료">배송 완료</option>
			  <option id="op4" value="교환/반품/취소">교환/반품/취소</option>
		</select>
		<button id="btn_chg" name="btn_chg" onclick="change(<%=i%>)">수정</button>
		</td>
		<td><%=POAIList.get(i).getOrdercnt() %></td>
		<td><%=POAIList.get(i).getAmount() %></td>
	</tr>
	<%	} %>
</tbody>
</table>

</div>

<jsp:include page="../../layout/paging.jsp"/>

<jsp:include page="../../layout/footer.jsp"/>













