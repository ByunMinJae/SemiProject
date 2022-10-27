<%@page import="java.util.List"%>
<%@page import="sharon.dto.User"%>
<%@page import="daun.dto.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	Board infoboard = (Board) request.getAttribute("infoboard");  %>
<%	User loginUser = (User) request.getAttribute("loginUser"); %>


<%@ include file="../layout/header.jsp" %>

<script type="text/javascript">
$(document).ready(function() {

	//작성버튼
	$("#btnreport").click(function() {

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
		<td style="width: 85%" id="boardtitle"><%=infoboard.getBoardtitle() %></td>
	</tr>
	
	<tr>
		<td style="height: 200px;" class="info">신고 내용</td>
		<td><input id="reportcon" type="text" name="reportcon"></td>
	</tr>
	
	<tr>
		<td class="info">신고자 닉네임</td>
		<td id="nick"><%=loginUser.getNick()%></td>
	</tr>
	
</table>	
<div class="butt">
	<input type="submit" id="btnreport" value="전송">
	<button id="btnCancel">취소</button>
</div>

<input type="hidden" name="boardno" value="<%=infoboard.getBoardno() %>">
<input type="hidden" name="userno" value="<%=infoboard.getUserno() %>">
</form>

	
</div>




</body>


<%@ include file="../layout/footer.jsp" %>