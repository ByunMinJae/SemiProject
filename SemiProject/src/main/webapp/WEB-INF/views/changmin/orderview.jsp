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
	float: right;
}

.text-center {
	position: relative;
	top: 50px;
	padding-left: 150px;
	left: 30px;
} 
</style>
 

<div class="myContainer">
	<h1 id="listhead"><a href="/orderafterlist" id="listhead">결제목록</a></h1>
		<form name="frm" method="GET" action="./orderafterlist">
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
			<% } %>
				<div class="search">
				<input type="text" name="word" value="" placeholder="상품이름을 입력해주세요">
				<button type="submit">검색</button>
				</div>
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