<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layout/header.jsp" %>

<script type="text/javascript" src="/resources/se2/js/service/HuskyEZCreator.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	
	//작성 버튼 클릭
	$("#btnWrite").click(function() {
		
		//스마트 에디터에 작성된 내용을 <textarea>에 적용하기
		oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", [])
		
		//폼 제출
		$("form").submit()
		
		$(location).attr("href", "./list")
		
	})
		
	$("#btnList").click(function() {
		$(location).attr("href", "../changmin/board")
	})
	
	
})
</script>

<style>
table {

	width: 1000px;
	margin-bottom: 100px;
}

tr {
	text-align: center;
}

td {
	text-align: left;
}

#title {
	width: 700px;
	margin-bottom: 0;
}

#content {
	width: 700px;
	min-height: 700px;
}

.bottom {

}

.btn {
	float: right;
	margin-bottom: 100px;
}
</style>

<body>
<h1>글쓰기</h1>

<form action="./create" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td style="width: 10%">게시판 선택</td>
			<td style="width: 90%">
				<select>
					<option value="category" disabled>게시판 선택</option>
					<option value="notice">공지사항</option>
					<option value="free">자유 게시판</option>
					<option value="food">맛집 정보</option>
					<option value="gathering">소모임</option>
					<option value="question">질문 게시판</option>
				</select>
			</td>
		</tr>
			
		<tr>
			<td>제목</td>
			<td><input type="text" id="title" name="title"></td>
		</tr>
		
		<tr>
			<td>내용</td>
			<td><textarea id="content" name="data"></textarea></td>
		</tr>
	</table>

	<label>파일 <input type="file" name="upfile"></label><br><br>

	<button id="btnWrite" class="btn">작성</button>

</form>
	<div class="btn">
		<button id="btnlist">목록</button>
	</div>


</body>

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