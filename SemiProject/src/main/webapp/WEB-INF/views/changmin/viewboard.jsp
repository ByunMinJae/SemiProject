<%@page import="daun.dto.BoardFile"%>
<%@page import="changmin.dto.Board"%>
<%@page import="sharon.dto.User"%>
<%@page import="changmin.dto.Category"%>
<%@page import="util.Paging"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Board viewBoard = (Board) request.getAttribute("viewBoard"); %>
<% Category category = (Category) request.getAttribute("category"); %>
<% List<User> userList = (List) request.getAttribute("userList"); %>
<% List<BoardFile> fileList = (List) request.getAttribute("fileList"); %>
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
	

	$('#fileDown').click(function() {
		alert('구현되지 않은 기능입니다.');
	})
})

function deleteboard(){
	 if (confirm("정말 삭제하시겠습니까?") == true){    //확인
		   $.ajax({
		        url:"./deleteboard?boardno=<%=viewBoard.getBoardno() %>",
		        type:'POST',
		        data: {
		        	boardno:<%=viewBoard.getBoardno()%>,
		        	userno:<%=viewBoard.getUserno()%>
		        	},
		        success:function(data){
		            location.href=('/board/notice'); //게시글 삭제시 default 게시글목록으로 이동
		            alert("삭제 완료!");
		        },
		        error:function(jqXHR, textStatus, errorThrown){
		            alert("삭제 권한이 없습니다.");
		        }
		   });
	 } else {
		 return false;
	 }
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

@font-face {
    font-family: 'GmarketSansMedium';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansMedium.woff') format('woff');
    font-weight: normal;
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
	top: -340px;
	
	
}
#content-detail {
	font-family: 'GmarketSansMedium';
	padding: 10px 10px 100px 10px;
}
#report {
	float: right;
	font-family: 'GmarketSansMedium';
	font-size: 10px;
	font-color: black;
    border: none;
    border-radius: 5px;
    box-shadow: 0 2px 2px rgba(0, 0, 0, 0.2);
    font-weight: 600;
    cursor: pointer;
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

#gmarketfont {
	font-family: 'GmarketSansMedium';
}

#file {
	font-family: 'GmarketSansMedium';
}

.smalltext { 
	font-family: 'GmarketSansMedium';
	font-size: 10px; 
	font-weight: bold;
}

.normalt {
	font-family: 'GmarketSansMedium';
	font-size: 20px;
	font-weight: bold; 
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

.file {
	float: left;
	
}


 
</style>
<div class="myContainer">
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
		<span id="title"><%=viewBoard.getBoardtitle() %></span>
		<span id="report"><a href="/board/report?boardno=<%=viewBoard.getBoardno()%>"><button>게시글 신고</button></a></span>
		</td>
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
		<td class="success" id="gmarketfont">본문</td>
	</tr>
	<tr>
		<div id="content">
			<td colspan="4" class="text-left" id="content-detail"><%=viewBoard.getBoardcon() %></td></a>
		</div> 
	</tr>
	<tr>
		<td class="success" id="file">첨부파일</td>
	</tr>
	
	<% if(fileList.size()>0) {%>
	<tr>
		<% for(int i=0; i<fileList.size(); i++) {%>
		<td colspan="4" class="text-left" id="fileDown"><a href='javascript:void(0);'><%=fileList.get(i).getOriginname() %></a>
		<% } %>
	</td>
	<% } else {%>
	<tr>
		<td class="text-left" id="file">없음</td>
	</tr>
	<% } %>
	</table>
	<div class="text-center">
		<button id="btnList" class="btn btn-primary">목록</button>
		<a href="/board/update?boardno=<%=viewBoard.getBoardno()%>"><button id="btnUpdate" class="btn btn-info">수정</button></a>
		<button id="btnDelete" class="btn btn-danger" onClick="deleteboard();">삭제</button>
	</div>
</div>

	
	

	
<%@ include file="../layout/footer.jsp"%>