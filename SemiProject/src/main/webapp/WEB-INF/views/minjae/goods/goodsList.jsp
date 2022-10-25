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
	
	$("#default").click(function() { //기본 순
		$("#hide").attr("value", "prodno");
		$("#cateWrap").submit();
	})
	
	$("#_prodList").click(function() { //상품 목록 클릭 시 기본 순
		$("#hide").attr("value", "prodno");
		$("#cateWrap").submit();
	})
	
	$("#row").click(function() { //가격 낮은 순
		$("#hide").attr("value", "prodprice");
		$("#cateWrap").submit();
	})
	
	$("#high").click(function() { //가격 높은 순
		$("#hide").attr("value", "prodprice DESC");
		$("#cateWrap").submit()
	})
	
	$("#sal").click(function() { //판매량 순
		$("#hide").attr("value", "prodpop DESC");
		$("#cateWrap").submit()
	})
	
// 	$("#date").click(function() { //최신 등록일 순
// 		$("#hide").attr("value", "proddate");
// 		$("#cateWrap").submit()
// 	})
	
	$("#btnSearch").click(function() { //상품 검색
		if($("#search").val() == "") {
			$("#search").attr("value", "null")	
			$("#searchWrap").submit()
		}
	})
	
})

</script>

<style type="text/css">
#goodsWrap {
    height: 786px;
    margin: 18px auto 0;
    text-align: center;
    position: relative;
    top: 0px;
    left: -149px;
    font-family: 'GmarketSansMedium';
}
#goodsContents {
	width: 1004px;
	height: 911px;
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
#prodImg {
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
#cateWrap {
	width: 305px;
    margin: 0 215px 0 284px;
    position: absolute;
    top: 109px;
    right: 113px;
}
#searchWrap {
	position: relative;
    top: -26px;
    right: -379px;
    width: 291px;
    margin: 10px;
    display: inline-block;
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
.gsStrong {
	color: ##747474;
	display: inline-block;
}
.gss {
	margin: 98px 0 0px;
}
#_prodList {
	color: #444;
	text-decoration: none;
	cursor: pointer;
	margin-top: 41px;
	font-family: 'dalseo';
	font-size: 54px;
}
#_prodList:hover {
	color: #222;
}
</style>

<div id="goodsWrap" class="container text-center">

<div id="goodsContents">

<h1><a id="_prodList">상품 목록</a></h1>
<hr>

<form action="/goods/cate" method="get" id="cateWrap">
<a class="ct" id="default">기본 순 </a>| 
<a class="ct" id="row">가격 낮은 순 </a>| 
<a class="ct" id="high">가격 높은 순 </a>|
<a class="ct" id="sal">판매량 순 </a>
<!-- <a class="ct" id="date">최신 등록일 순 </a> -->

<input type="text" hidden="" id="hide" name="value" value="">
</form>

<form action="/goods/cate" method="get" id="searchWrap">
<input type="text" id="search" name="search" value="" placeholder="상품 검색">
<button id="btnSearch">검색</button>
</form>
<div id="inner-list">
<%	if( list.size() > 0 ) { %> 
<%		for(int i=0; i<list.size(); i++) { %>
		<a id="goodsImg" href="/goods/detail?prodno=<%=list.get(i).getProdno() %>">
			<img id="prodImg" alt="" src="/resources/image/<%=list.get(i).getProdimage() %>">
		</a>
		<ul id="goodsList">
			<li><%=list.get(i).getProdname() %></li>
			<li><%=list.get(i).getProdprice() %>원</li>
			<li>판매량 : <%=list.get(i).getProdpop() %></li>
		</ul>
<%		} %>
<%	} else { %>
		<strong class="gsStrong gss">검색된 상품이 없습니다.</strong><br>
		<strong class="gsStrong">'상품 검색하기'에서 상품을 검색해주세요.</strong>
<%	} %>
</div>

</div>

</div>

<jsp:include page="../../layout/paging.jsp"/>

<jsp:include page="../../layout/footer.jsp"/>