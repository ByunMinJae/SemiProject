<%@page import="util.Paging2"%>
<%@page import="changmin.dto.Order"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	List<Order> orderView = (List) request.getAttribute("orderView"); %>
<%  Paging2 paging = (Paging2) request.getAttribute("paging"); %>
<%  String wordParam = (String) request.getAttribute("word"); %>
<%@ include file="../layout/header.jsp"%>

<script>
$(document).ready(function(){
	$('#cancelButton').click(function(){
		alert('취소를 원하실 경우 관리자에게 문의해주세요 ﻿( ´•̥̥̥ω•̥̥̥` )\n\n코딩산악회 [ 010-1234-1234 ]');
	})
})
</script>


<style type="text/css">
.myContainer {
	margin: 0 auto;
	min-height: 600px;
	position: relative;
	top: 30px;
}

td {
	font-family: 'GmarketSansMedium';
	background-color: white;
}


#wrapper {
	background-color: #BFDCFB;
}

#listhead {
	font-family: 'dalseo';
	font-weight: bold;
	color: black;
	text-decoration: none;
}

.orderTitle {
	position: relative;
	left: -8px; 
	background-color: #E1FFB1;
	padding:10px 50px 10px 50px;
	 
}

.orderDetail {
	padding: 10px 10px 10px 20px;
}

.search {
	position: relative;
	float: left;
	margin: 10px 10px 10px 0;
}

.text-center {
	position: relative;
	top: 40px;
	padding-left: 100px;
	margin: 50px;
} 

.right {
	position: relative;
	float: right;
	font-family: 'GmarketSansMedium';
}

#cancelButton {
	margin: 0 0 0 20px;
    border: 0.5px solid silver; 
    border-radius: 5px;
	font-family: 'GmarketSansMedium';
    box-shadow: 0 2px 2px rgba(0, 0, 0, 0.2);
    font-weight: 600;
    cursor: pointer;
}

#searchText {
	width: 300px; 
}
</style>
 

<div class="myContainer">
	<h1 id="listhead"><a href="/orderafterlist" id="listhead">결제목록</a></h1>
		<form name="frm" method="GET" action="./orderafterlist">
		<div class="search">
			<input type="text" name="word" id="searchText" value="" placeholder="상품이름으로 검색할 수 있어요 !">
			<button type="submit">검색</button>
		</div>

			<% for(int i=0; i<orderView.size(); i++) { %>
			<table class="table">
				<tr>
					<td>
						<span class="orderTitle">결제번호</span>
						<span class="orderDetail"><%= orderView.get(i).getOrderafterno() %></span>
					</td>
				</tr>
				<tr>
					<td>
						<span class="orderTitle">결제시간</span>
						<span class="orderDetail"><%= orderView.get(i).getOrderdate() %></span>
					</td>
				</tr>
				
				<tr>
					<td>
						<span class="orderTitle">상품이름</span>
						<span class="orderDetail"><%= orderView.get(i).getProdname() %></span>
					</td>
				</tr>
				
				<tr>
					<td>
						<span class="orderTitle">결제금액</span>
						<span class="orderDetail"><%= orderView.get(i).getAmount() %></span>
					</td>
				</tr>
				
				<tr>
					<td>
						<span class="orderTitle">배송주소</span>
						<span class="orderDetail"><%= orderView.get(i).getBuyeraddr() %></span>
					</td>
				</tr>
				
				<tr>
					
				</tr>
			</table>
				<div class="right">
					<p>굿즈는 이벤트성 상품으로, 결제이후 취소가 어려울수 있습니다.<button id="cancelButton">결제취소</button></p>
					
				</div>
			<% } %>

		</form>
	
	<div class="text-center">
		<ul class="pagination">
			<%  if( wordParam==null) {%>
				<%	paging.setListCount(1); %>	
				<%	if( paging.getCurPage() != 1) { %>
				<li><a href="./orderafterlist?curPage=<%=paging.getCurPage() - 1 %>">&lt;</a></li>
				<%	} %>
				
				<%	for(int i=paging.getStartPage(); i<=paging.getEndPage(); i++) { %>
				<%		if( i == paging.getCurPage() ) { %>
				<li class="active"><a href="./orderafterlist?curPage=<%=i %>"><%=i %></a></li>
				<%		} else { %>
				<li><a href="./orderafterlist?curPage=<%=i %>"><%=i %></a></li>
				<%		} %>
				<%	} %>
		
				<%	if( paging.getCurPage() != paging.getTotalPage() ) { %>
				<li><a href="./orderafterlist?curPage=<%=paging.getCurPage() + 1 %>">&gt;</a></li>
				<%	} %>
			<%  } else { %>
				<%	paging.setListCount(1); %>	
				<%	if( paging.getCurPage() != 1) { %>
				<li><a href="./orderafterlist?curPage=<%=paging.getCurPage() - 1 %>&word=<%=wordParam%>">&lt;</a></li>
				<%	} %>
				
				<%	for(int i=paging.getStartPage(); i<=paging.getEndPage(); i++) { %>
				<%		if( i == paging.getCurPage() ) { %>
				<li class="active"><a href="./orderafterlist?curPage=<%=i %>&word=<%=wordParam%>"><%=i %></a></li>
				<%		} else { %>
				<li><a href="./orderafterlist?curPage=<%=i %>&word=<%=wordParam%>"><%=i %></a></li>
				<%		} %>
				<%	} %>
		
				<%	if( paging.getCurPage() != paging.getTotalPage() ) { %>
				<li><a href="./orderafterlist?curPage=<%=paging.getCurPage() + 1 %>&word=<%=wordParam%>">&gt;</a></li>
				<%	} %>
			<%  } %>
		</ul> 
	</div>
</div>
<%@ include file="../layout/footer.jsp" %>