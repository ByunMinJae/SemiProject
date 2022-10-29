<%@page import="jeonghwa.dto.Product"%>
<%@page import="jeonghwa.dto.ProductFile"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layout/header.jsp" %>
    
<%	Product updateProduct = (Product) request.getAttribute("updateProduct"); %>
<%	ProductFile productFile = (ProductFile) request.getAttribute("productFile"); %>


    
<!-- 스마트 에디터2 설치 -->
<script type="text/javascript" src="/resources/se2/js/service/HuskyEZCreator.js"></script>


<script type="text/javascript">
$(document).ready(function() {
	
	//작성버튼
	$("#btnUpdate").click(function() {
		
		//작성된 내용을 <textarea>에 적용하기
		updateContents()

		$("form").submit();
	})
	
	//취소버튼
	$("#btnCancel").click(function() {
		history.go(-1)
	})
	
	//파일이 없을 경우
	if(<%=productFile != null %>) {
		$("#beforeFile").show();
		$("#afterFile").hide();
	}
	
	//파일이 있을 경우
	if(<%=productFile == null %>) {
		$("#beforeFile").hide();
		$("#afterFile").show();
	}
	
	//파일 삭제 버튼(X) 처리
	$("#delFile").click(function() {
		$("#beforeFile").toggle();
		$("#afterFile").toggle();
	})
	
})

function updateContents() {
	
	//스마트 에디터에 작성된 내용을 #content에 반영한다
	oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", [])
	
}

</script>



<h1>상품 정보 수정</h1>
<hr>

<form action="./update" method="post" enctype="multipart/form-data">

<input type="hidden" name="prodno" value="<%=updateProduct.getProdno() %>">

<table class="table table-bordered">
<tr><td class="info">상품 번호</td><td><%=updateProduct.getProdno() %></td></tr>
<tr><td class="info">상품 이름</td><td><input type="text" name="prodname" style="width:100%;"></td></tr>
<tr><td class="info">가격</td><td><input type="text" name="prodprice" style="width:100%;"></td></tr>
<tr><td class="info" colspan="2">성품설명</td></tr>
<tr><td colspan="2"><textarea id="content" name="prodcon" style="width: 100%;"></textarea></td></tr>
</table>


<!-- 첨부파일 -->

<div>

<div id="beforeFile">
	<%	if( productFile != null ) { %>
	<a href="<%=request.getContextPath() %>/upload/<%=productFile.getStoredname() %>"
	 download="<%=productFile.getOriginname() %>">
		<%=productFile.getOriginname() %>
	</a>
	<span id="delFile" style="color: red; font-weight: bold; cursor: pointer;">X</span>
	<%	} %>
</div>

<div id="afterFile">
	새 첨부파일 <input type="file" name="file">
</div>

</div>

</form>

<div class="text-center">
	<button id="btnUpdate" class="btn btn-primary">수정</button>
	<button id="btnCancel" class="btn btn-danger">취소</button>
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















