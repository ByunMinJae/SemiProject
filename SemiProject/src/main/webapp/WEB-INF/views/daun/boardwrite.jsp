<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layout/header.jsp" %>

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
    border: none;
    border-radius: 10px;
    font-family: "paybooc-Light", sans-serif;
    box-shadow: 0 2px 2px rgba(0, 0, 0, 0.2);
    font-weight: 600;
    cursor: pointer;
}
</style>

<body>
<h1>글쓰기</h1>

<form action="./write" method="post" enctype="multipart/form-data">
	<table class="table table-bordered">
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
		
		
		<tr><td class="info">아이디</td><td><%=session.getAttribute("userid") %></td></tr>
		<tr><td class="info">닉네임</td><td><%=session.getAttribute("nick") %></td></tr>
		<tr><td class="info">제목</td><td><input type="text" name="title" style="width:100%;"></td></tr>
		<tr><td class="info" colspan="2">본문</td></tr>
		<tr><td colspan="2"><textarea id="content" name="content" style="width: 100%;"></textarea></td></tr>
		</table>
	

	첨부파일 <input type="file" name="file">
</form>


	<div class="text-center">
		<button id="btnWrite" class="btn btn-primary">작성</button>
		<button id="btnCancel" class="btn btn-danger">취소</button>
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