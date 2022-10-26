<%@page import="minjae.dto.ProdOrdAd"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	List<ProdOrdAd> POAIList = (List) request.getAttribute("prodOrdAdInfo"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	
// 	$("#btn_Up").click(function() {
// 		$("#hid_td2").removeAttr("hidden");
// 		$("#hid_td1").attr("hidden", "");
// 	})

// 	$("#btn_ok").click(function() {
// 		$("#hid_td1").removeAttr("hidden");
// 		$("#hid_td2").attr("hidden", "");
// 	})
	
})
</script>

<style type="text/css">
#tbWrap { 
	width: 1100px;
	margin: 200px auto 0;
}
#poaTable {
	width: 1100px;
	border-collapse: collapse; 
	text-align: center;
}
#poaTable th, #poaTable td {
	border: 1px solid #ccc;
	height: 32px; 
}
#poaTable td:hover {
	background-color: #ccc;
}
#btn_ok{
    cursor: pointer;
}
#selectWrap {
	width: 243px;
}
#selectid {
	height: 26px;
    width: 178px;
    text-align: center;
}
</style>
</head>
<body>

<div id="tbWrap">

<table id="poaTable">
<thead>
	<tr>
		<th>주문번호</th>
		<th>주문일자</th>
		<th>상품</th>
		<th>진행상태</th>
		<th>수량</th>
		<th>가격</th>
	</tr>
</thead>
<tbody>
	<%	for(int i=0; i<POAIList.size(); i++) { %>
	<tr>
		<td><%=POAIList.get(i).getOrderafterno() %></td>
		<td><%=POAIList.get(i).getOrderdate() %></td>
		<td><%=POAIList.get(i).getProdname() %></td>
		<td id="selectWrap">
		<select id="selectid">
			  <option id="op1" value="<%=POAIList.get(i).getOrderprocess() %>" selected>현재상태 : <%=POAIList.get(i).getOrderprocess() %></option>
			  <option id="op2" value="결제완료">결제완료</option>
			  <option id="op3" value="배송완료">배송완료</option>
			  <option id="op4" value="교환/반품/취소">현재상태 : 교환/반품/취소</option>
		</select>
		<button id="btn_ok">수정</button>
		</td>
		<td><%=POAIList.get(i).getOrdercnt() %></td>
		<td><%=POAIList.get(i).getAmount() %></td>
	</tr>
	<%	} %>
</tbody>
</table>

</div>

</body>
</html>














