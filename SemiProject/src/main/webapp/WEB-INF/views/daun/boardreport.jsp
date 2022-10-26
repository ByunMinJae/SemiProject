<%@page import="daun.dto.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	Board updateBoard = (Board) request.getAttribute("updateBoard");  %>

<%@ include file="../layout/header.jsp" %>

<script type="text/javascript">
$(document).ready(function() {

	//작성버튼
	$("#btnreport").click(function() {
		
		//작성된 내용을 <textarea>에 적용하기
		reportContents()

		$("form").submit();
	})
	
	//취소버튼
	$("#btnCancel").click(function() {
		history.go(-1)
	})

})

</script>

<style type="text/css">

.title {
	font-family: 'GmarketSansMedium';
	text-align: center;
	margin-bottom: 20px;
}

table {
	width: 1000px;
}

.report {
	margin: 10% auto;
	width: 100%;
	height: 100%;
}

#reportcon {
	width: 100%;
	height: 200px;
}

#btnreport {
	float: right;
}

</style>



<body>
<div class="report">

<form action="/board/report" method="post" id="reportform">

<h1 class="title">게시글 신고</h1>

<table class="table table-bordered">
	<tr>
		<td style="width: 15%" class="info">게시글 글 제목</td>
		<td style="width: 85%"><%=updateBoard.getBoardtitle() %></td>
	</tr>
	
	<tr>
		<td style="height: 200px;" class="info">신고 내용</td>
		<td><input id="reportcon" type="text" name="reportcon"></td>
	</tr>
	
	<tr>
		<td class="info">작성자 아이디</td>
		<td>아이디</td>
	</tr>
	
	<tr>
		<td class="info">작성 일자</td>
		<td>날짜</td>
	</tr>
</table>	

</form>
	
</div>

<div class="butt">
	<button id="btnreport">전송</button>
	<button id="btnCancel">취소</button>
</div>

</body>


<%@ include file="../layout/footer.jsp" %>