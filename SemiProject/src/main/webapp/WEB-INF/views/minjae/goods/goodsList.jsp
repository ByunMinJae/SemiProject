<%@page import="minjae.dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%	List<Product> list = (List)request.getAttribute("goodsList"); %>

<!-- 부트스트랩 Bootstrap 3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<%@	include file="../../layout/header.jsp" %>

<script type="text/javascript">
$(document).ready(function() {
	
	$("#row").click(function() {
		console.log("asd");
		selectCateList("prodprice");
	})
	
	$("#high").click(function() {
		selectCateList("prodprice DESC");
	})
	
	$("#sal").click(function() {
		selectCateList("prodpop DESC");
	})
	
	$("#date").click(function() {
		selectCateList("prodprice");
	})
	
})


function selectCateList(cateVal) {
		
	$.ajax({
		type: "post"					
		, url: "/goods/list"			
		, data: {						
			value: cateVal
		}
		, dataType: "html"				
		, success: function( res ) {
			console.log("AJAX 성공")
			console.log(res)
			
			$("#inner-list").html(res);
			
		}
		
	})
	
}
</script>

<style type="text/css">
#goodsWrap {
    height: 741px;
    margin: 18px auto 0;
    text-align: center;
    position: relative;
    top: 0px;
    left: -149px;
}
#goodsContents {
	width: 1004px;
	height: 866px;
    margin: 0px auto;
    background: #fcffb282;
    border: 1px solid #ccc;
}
#goodsImg {
	width: 200px;
	height: 200px;
	display: inline-block;
	margin: 29px 0px 105px 144px;
	border: 2px solid #a3d99c;
}
#goodsImg:hover {
	border: 2px solid #7dab77;
}
#goodsList {
	display: inline-block;
    position: relative;
    top: 195px;
    left: -184px;
    width: 125px;
    list-style: none;
    font-weight: bold;
    font-size: 16px;
    padding: 0;
    margin: 12px 0 12px 12px;
}
img {
	width: 200px;
	height: 200px;
}
.text-center {
	position: relative;
    bottom: -51px;
}
#category {
	position: absolute;
    top: 109px;
}
#searchWrap {
	width: 607px;
    margin: 0 10px 0 376px;
    position: absolute;
    top: 109px;
    right: 66px;
}
.ct {
	color: #777  !important;
	font-weight: bold;
	text-decoration: none !important;
	cursor: pointer;
}
.ct:hover {
	color: #000 !important;
}
</style>

<div id="goodsWrap" class="container text-center">

<div id="goodsContents">

<h1 style="margin-top: 41px;">상품 목록</h1>
<hr>

<div id="searchWrap">
<a class="ct" id="row">가격 낮은 순 </a>| 
<a class="ct" id="high">가격 높은 순 </a>|
<a class="ct" id="sal">판매량 순 </a>|
<a class="ct" id="date">최신 등록일 순 </a>

<input type="text" id="search" placeholder="상품 검색">
<button id="btnSearch">검색</button>
</div>

<div id="inner-list">
<%	for(int i=0; i<list.size(); i++) { %>
<a id="goodsImg" href="/goods/detail?prodno=<%=list.get(i).getProdno() %>">
	<img alt="" src="/resources/image/<%=list.get(i).getProdimage() %>">
</a>
<ul id="goodsList">
	<li><%=list.get(i).getProdname() %></li>
	<li><%=list.get(i).getProdprice() %>원</li>
	<li>판매량 : <%=list.get(i).getProdpop() %></li>
</ul>
<%	} %>
</div>

</div>

</div>

<jsp:include page="../../layout/paging.jsp"/>

<jsp:include page="../../layout/footer.jsp"/>