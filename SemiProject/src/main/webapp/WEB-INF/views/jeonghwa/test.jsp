<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<style>
.container {
	height: 700px;
}
table {
	border: 1px solid black;
	width: 60%;
	right: 200px;
	text-align: center;
	
}
tr, th, td {
	border: 1px solid black;
	height: 30%;
}

.updatebtn {
	
}
</style>

<h3>게시글 목록</h3>


<table>
  <tr>
	<th style="width: 15%;">사진</th>
	<th style="width: 15%;">상품명</th>
	<th style="width: 15%;">가격</th>
	<th style="width: 15%;">재고</th>
	<th style="width: 15%;">기능</th>
  </tr>
  <tr>
    <td><img alt="" src=""></td>
    <td>어쩌고등산화</td>
    <td>2000원</td>
    <td>3개</td>
    <td>
		<button class="btn" onclick="location.href=''">수정</button>
		<button class="btn" onclick="location.href=''">삭제</button>
    </td>
  </tr>
  
</table>

<button class="updatebtn" onclick="location.href=''">상품 추가</button>



<%@ include file="../layout/footer.jsp" %>