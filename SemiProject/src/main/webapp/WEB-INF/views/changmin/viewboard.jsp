<%@page import="util.Paging"%>
<%@page import="daun.dto.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Board viewBoard = (Board) request.getAttribute("viewBoard"); %>
<%@include file="../layout/header.jsp" %>
<!-- 부트스트랩 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	
	$('#btnList').click(function() {
		window.history.back(); // 목록 버튼 클릭시 뒤로가기
	})
	

})

function deleteboard(){
   $.ajax({
        url:"./deleteboard?boardno=<%=viewBoard.getBoardno() %>",
        type:'POST',
        data: {boardno:<%=viewBoard.getBoardno()%>},
        success:function(data){
            location.href=('/board/notice'); //게시글 삭제시 default 게시글목록으로 이동
            alert("삭제 완료!");
        },
        error:function(jqXHR, textStatus, errorThrown){
            alert("에러 발생 \n" + textStatus + " : " + errorThrown);
        }
   });
}
</script>
<style type="text/css">

@font-face {
	font-family: 'dalseo';
	src: url('/resources/css/DalseoHealingBold.ttf') format('truetype');
}

#wrapper {
	background-color: #BFDCFB;
}

#footer {
	background-color: #BFDCFB;
	border: none;
	
}

th, td {
	text-align: center;
}
td {
	padding: 5 5 5 5;
	background-color: white;
}

td:nth-child(2) {
	text-align: justify;
}

.right {
	position: relative;
	float: right;
	width: 800px;
	top: -380px;
	
	
}

.left{
	position: absolute;
	top: 150px;
	left: -100px;
}

img {
	margin: 0 0 20px 0;
}

#writeButton {
	float: right;
}

#title {
	font-size: 34px; 
}

#boarddate, #boardhit {
	font-size: 6px;
}

#content-detail {
	min-height: 300px;
}

 
 
</style>
<div class="myContainer">
	<hr>
		<div style="min-height: 500px;">
			<div class="left">
	
				<!-- 게시판 목록 -->		
				<p><a href="/board/notice"><img src="/resources/image/notice.png"></a></p>
				<p><a href="/board/free"><img src="/resources/image/free.png"></a></p>
				<p><a href="/board/food"><img src="/resources/image/food.png"></a></p>
				<p><a href="/board/gathering"><img src="/resources/image/gathering.png"></a></p>
				<p><a href="/board/question"><img src="/resources/image/question.png"></a></p>
			
			</div>
			
		</div>

<div class="right" >
	<table class="table">
	<tr>
		<td colspan="4" class="text-left success" id="title">제목 : <%=viewBoard.getBoardtitle() %></td>
	</tr>
	
	<tr>
	</tr>
	 
	<tr>
		<td class="text-left">
		<span id="user">작성자 : <%=viewBoard.getUserno() %></span><br>
		<span id="boarddate"><%=viewBoard.getBoarddate() %></span>
		<span id="boardhit">&emsp;조회&nbsp;<%=viewBoard.getHit() %></span>
		</td>
	</tr> 
	
	<tr>
		<td class="success">본문</td>
	</tr>
	<tr>
		<td colspan="4" class="text-left"><p id="content-detail"><%=viewBoard.getBoardcon() %></p></td>
	</tr>
	
	</table>
	<div class="text-center">
		<button id="btnList" class="btn btn-primary">목록</button>
		<button id="btnUpdate" class="btn btn-info">수정</button>
		<button id="btnDelete" class="btn btn-danger" onClick="deleteboard();">삭제</button>
	</div>
</div>

	
	

	
<%@ include file="../layout/footer.jsp"%>