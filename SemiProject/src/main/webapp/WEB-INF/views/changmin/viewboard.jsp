<%@page import="sharon.dto.User"%>
<%@page import="changmin.dto.Category"%>
<%@page import="util.Paging"%>
<%@page import="daun.dto.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Board viewBoard = (Board) request.getAttribute("viewBoard"); %>
<% Category category = (Category) request.getAttribute("category"); %>
<% List<User> userList = (List) request.getAttribute("userList"); %>
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

@font-face {
    font-family: 'MonoplexKR-Regular';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_Monoplex-kr@1.0/MonoplexKR-Regular.woff2') format('woff2');
    font-weight: 400;
    font-style: normal;
}

#wrapper {
	background-color: #BFDCFB;
}


th, td {
	text-align: center;
}
td {
	background-color: white;
}

td:nth-child(2) {
	text-align: justify;
}

.right {
	position: relative;
	float: right;
	width: 900px;
	left: 100px;
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

#contentHead {
	font-size: 34px; 
	font-family: 'dalseo';
} 

#category {
	color: #6478FF;
}

.smalltext { 
	font-family: 'MonoplexKR-Regular';
	font-size: 10px; 
	font-weight: bold;
}

.normalt {
	font-family: 'MonoplexKR-Regular';
	font-size: 20px;
	font-weight: bold;
}

#content-detail {
	min-height: 300px;
}

.cotainer-wrap {
	min-height: 1000px;
}

.myContainer {
	min-height: 1000px;
}

.footer {
	max-height:0;
	border: none;
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
		<td colspan="4" class="text-left success" id="contentHead">
		<span id="category">[<%=category.getCategoryname()%>]</span>
		<span id="title"><%=viewBoard.getBoardtitle() %></span></td>
	</tr>
	
	<tr>
	</tr>
 	 
	<tr>
		<td class="text-left">
			<span class="smalltext">닉네임&ensp;</span><span class="normalt"><%=viewBoard.getNick() %></span><br>
			<span class="smalltext">등록일&ensp;</span><span class="normalt"><%=viewBoard.getBoarddate() %></span>
			<span class="smalltext">&emsp;조회&ensp;</span><span class="normalt"><%=viewBoard.getHit() %></span>
		</td>
	</tr> 

	<tr>
		<td class="success" style="font-family: 'MonoplexKR-Regular';">본문</td>
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