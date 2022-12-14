<%@page import="sharon.dto.User"%>
<%@page import="daun.dto.BoardFile"%>
<%@page import="daun.dto.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layout/header.jsp" %>

<%	Board updateBoard = (Board) request.getAttribute("updateBoard");  %>
<%	BoardFile boardFile = (BoardFile) request.getAttribute("boardFile"); %>
<% User loginUser = (User) request.getAttribute("loginUser"); %>


<script type="text/javascript" src="/resources/se2/js/service/HuskyEZCreator.js"></script>

<script type="text/javascript">
$(document).ready(function() {

	//작성버튼
	$("#btnUpdate").click(function() {
		
		//작성된 내용을 <textarea>에 적용하기
//		updateContents()
		console.log($("#boardcon").val());

		$("#f").submit();
		
		
	});
	

	
	//취소버튼
	$("#btnCancel").click(function() {
		history.go(-1)
	})
	
	//파일이 없을 경우
	if(<%=boardFile != null %>) {
		$("#beforeFile").show();
		$("#afterFile").hide();
	}
	
	//파일이 있을 경우
	if(<%=boardFile == null %>) {
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
	oEditors.getById["boardcon"].exec("UPDATE_CONTENTS_FIELD", [])
	
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

#boardcon {
	width: 700px;
	min-height: 700px;
}

.btn {
	float: right;
	margin-bottom: 100px;
}
</style>

<body>
<h1>글쓰기</h1>

<!-- <form action="/board/update" method="post" enctype="multipart/form-data"> -->
<form action="/board/update" method="post" id="f">
	<table class="table table-bordered">
		<tr>
			<td style="width: 12%" class="info">게시판 선택</td>
			<td style="width: 88%">
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
			<td class="info">닉네임</td>
			<td id="nick" name="nick"><%=loginUser.getNick()%></td>
		</tr>
		
		<tr><td class="info">제목</td>
			<td><input type="text" id="boardtitle" name="boardtitle" style="width:100%;" value="<%=updateBoard.getBoardtitle() %>"></td>
		</tr>
		
		<tr><td class="info" colspan="2">본문</td></tr>
		
		<tr><td colspan="2"><textarea id="boardcon" name="boardcon" style="width: 100%;" value=""><%=updateBoard.getBoardcon() %></textarea></td></tr>
		</table>
</form>		
			
<%-- <form action="/board/update" method="post" enctype="multipart/form-data">
	<div id="beforeFile">
		<%	if( boardFile != null ) { %>
		<a href="<%=request.getContextPath() %>/upload/<%=boardFile.getStoredname() %>"
		 download="<%=boardFile.getOriginname() %>">
			<%=boardFile.getOriginname() %>
		</a>
		<span id="delFile" style="color: red; font-weight: bold; cursor: pointer;">X</span>
		<%	} %>
	</div>
	
	<div id="afterFile">
		새 첨부파일 <input type="file" name="file">
	</div>

</form> --%>

	<div class="text-center">
		<button id="btnUpdate" class="btn">수정</button> 
		<button id="btnCancel" class="btn">취소</button>
	</div>


</body>

<script type="text/javascript">
/* var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
	oAppRef: oEditors,
	elPlaceHolder: "boardcon", //에디터가 적용될 <textarea>의 id 적기
	sSkinURI: "/resources/se2/SmartEditor2Skin.html",
	fCreator: "createSEditor2"
}) */
</script>


<%@ include file="../layout/footer.jsp" %>