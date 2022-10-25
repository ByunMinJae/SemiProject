<%@page import="donghyun.dto.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% Board viewBoard = (Board) request.getAttribute("viewBoard"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>



<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#back").click(function(){
		history.back();
	})
	
	$("#deleteBtn").click(function(){
		$(location).attr("href", './boarddelete?boardno=<%=viewBoard.getBoardno() %>')
	})
	
	
})

</script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style type="text/css">
h1{
	text-align: center;
	margin-top: 100px;
}

table{
	margin: 0 auto;
}

.table{
	width:40%; 
	margin-top: 100px;
}

tr{
	border: 1px solid #ccc;
}
div{
	width: 5%;
	margin: 0 auto;
}

#content{
	height: 270px;
}

.colored{
	background-color: #E1FFB1;
}

.btn{
	padding: 8px;
}
</style>
</head>
<body>

<h1>상세내용</h1>

<table class="table">

<tr class="colored">
	
	<td colspan="4" style="text-align: center"><%= viewBoard.getBoardtitle() %></td>
</tr>
<tr>
	<td>
	<span>작성일:</span>
	<span><%= viewBoard.getBoarddate() %></span>
	
	<br>


	
	<span>작성자:</span>
	<span><%=viewBoard.getNick() %></span>
	</td>
</tr>

<tr class="colored">
	<td colspan="4" style="text-align: center">내용</td>
</tr>

<tr id="content">
	<td colspan="4" style="text-align: center"><%=viewBoard.getBoardcon() %></td>
</tr>
	

</table>
<div>
<button id="back" class="btn btn-primary">목록</button>
<button id="deleteBtn" class="btn btn-danger">삭제</button>
</div>
</body>
</html>