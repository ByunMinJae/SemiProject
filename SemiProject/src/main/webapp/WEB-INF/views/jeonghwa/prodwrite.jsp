<%@page import="jeonghwa.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      
<%@ include file="../layout/adminheader.jsp" %>

<!-- 스마트 에디터2 설치 -->
<script type="text/javascript" src="/resources/se2/js/service/HuskyEZCreator.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	
	//작성버튼
	$("#btnWrite").click(function() {
		
		//작성된 내용을 <textarea>에 적용하기
		updateContents()

		$("form").submit();
	})
	
	//취소버튼
	$("#btnCancel").click(function() {
		history.go(-1)
	})
	
})

function updateContents() {
	
	//스마트 에디터에 작성된 내용을 #content에 반영한다
	oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", [])
	
}

</script>

<style>
.write {
	margin-top: 50px;
}
</style>



<div class="write">

	<h1>상품 정보 작성</h1>
	<hr>
	    
	<form action="./write" method="post" enctype="multipart/form-data">
	
	<table class="table table-bordered">
	<tr><td class="info">상품 번호</td><td><%=session.getAttribute("prodno") %></td></tr>
	<tr><td class="info">상품 이름</td><td><input type="text" name="prodname" style="width:100%;"></td></tr>
	<tr><td class="info">가격</td><td><input type="text" name="prodprice" style="width:100%;"></td></tr>
	<tr><td class="info" colspan="2">상품설명</td></tr>
	<tr><td colspan="2"><textarea id="content" name="prodcon" style="width: 100%;"></textarea></td></tr>
	</table>
	
	첨부파일 <input type="file" name="file">
	
	</form>   
	
	<div class="text-center">
		<button id="btnWrite" class="btn btn-primary">작성</button>
		<button id="btnCancel" class="btn btn-danger">취소</button>
	</div> 

</div>
    
<script type="text/javascript">
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
	oAppRef: oEditors,
	elPlaceHolder: "content", //에디터가 적용될 <textarea>의 id 적기
	sSkinURI: "/resources/se2/SmartEditor2Skin.html",
	fCreator: "createSEditor2"
})
</script>

<%@ include file="../layout/footer.jsp" %>













