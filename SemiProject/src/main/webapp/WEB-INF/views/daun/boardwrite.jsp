<%@page import="sharon.dto.User"%>
<%@page import="changmin.dto.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layout/header.jsp" %>

<% User loginUser = (User) request.getAttribute("loginUser"); %>

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
	
	//스마트 에디터에 작성된 내용을 #boardcon에 반영한다
	oEditors.getById["boardcon"].exec("UPDATE_CONTENTS_FIELD", [])
	
}
</script>

<style>

#boardcon {
	width: 700px;
	min-height: 700px;
	
	
}


</style>

<body>
<h1>글쓰기</h1>

<form action="./write" method="post" enctype="multipart/form-data">
	<table class="table table-bordered">
		<tr>
			<td class="info" style="width: 12%">게시판 선택</td>
			<td style="width: 88%">
				<select name="categoryno">
					<option value="0" disabled>게시판 선택</option>
					<option value="1">공지사항</option>
					<option value="2">자유게시판</option>
					<option value="3">맛집정보</option>
					<option value="4">소모임게시판</option>
					<option value="5">질문게시판</option>
				</select>
			</td>
		</tr>
		
<%-- 		<tr><td class="info">닉네임</td><td id="nick" name="nick"><%=session.getAttribute("nick") %></td></tr> --%>
		<tr><td class="info">닉네임</td><td id="userid" name="userid"><%=loginUser.getNick()%></td></tr>
		<%-- <tr><td class="info">아이디</td><td id="userid" name="userid"><%=session.getAttribute("userid") %></td></tr> --%>
		<tr><td class="info">제목</td><td><input type="text" id="boardtitle" name="boardtitle" style="width:100%;"></td></tr>
		<tr><td class="info" colspan="2">본문</td></tr>
		<tr><td colspan="2"><textarea id="boardcon" name="boardcon" style="width: 100%;"></textarea></td></tr>
		</table>

	첨부파일 <input type="file" name="file">
</form>


	<div class="text-center">
		<button id="btnWrite" class="btn">작성</button>
		<button id="btnCancel" class="btn">취소</button>
	</div>


</body>

<script type="text/javascript">
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
	oAppRef: oEditors,
	elPlaceHolder: "boardcon", //에디터가 적용될 <textarea>의 id 적기
	sSkinURI: "/resources/se2/SmartEditor2Skin.html",
	fCreator: "createSEditor2"
})
</script>




<%@ include file="../layout/footer.jsp" %>