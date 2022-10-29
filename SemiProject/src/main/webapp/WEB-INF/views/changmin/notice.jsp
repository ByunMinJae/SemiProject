<%@page import="changmin.dto.Board"%>
<%@page import="util.Paging"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<Board> boardList = (List) request.getAttribute("boardList"); %>
<% Paging paging = (Paging) request.getAttribute("paging"); %>
<% String wordParam = (String) request.getAttribute("word"); %>
<% String searchList = (String) request.getAttribute("searchList"); %>
<%@include file="../layout/header.jsp" %>
<!-- 부트스트랩 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript">

/* $(document).ready(function(){

    $.ajax({
        type: "GET",
        url: "/board/notice",
        dataType: "html",
        data: {
        	searchList:$(".searchList").val()
        	},
            success: function(data) {
                console.log("통신데이터 값 : " + data);
              },
      	  error: function() {
          console.log('통신실패!!');
        }

      });

	
}); */

</script>

<style type="text/css">
@font-face {
	font-family: 'dalseo';
	src: url('/resources/css/DalseoHealingBold.ttf') format('truetype');
}

h1 {
	font-family: 'dalseo';
}
#wrapper {
	background-color: #BFDCFB; 
}

th, td {
	text-align: center;
	font-family: 'GmarketSansMedium';
}

td:nth-child(2) {
	text-align: justify;
	font-family: 'GmarketSansMedium';
}

.right {
	position: relative;
	float: right;
	top: -360px;  
	
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

.search {
	float: right;
}

.searchListHead {
	width: 100px;
	height: 30px;
	background-size: 20px;
	padding: 5px; 
	border-radius: 5px;
}
 
.text-center {
	position: relative;
	top: 50px;
	left: 150px;
} 
</style>
<div class="myContainer">
	<form method="get">
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
	</form>
	
	<div class="right">
		<h1>공지사항</h1>
			<form name="frm" method="GET" action="./notice">
				<table class="table table-hover">
					<tr class="success">
						<th width="8%">번호</th>
						<th width="54%">제목</th>
						<th width="15%">글쓴이</th>
						<th width="15%">등록일</th>
						<th width="8%">조회수</th>
					</tr>
					<% for(int i=0; i<boardList.size(); i++) {%>
					<tr class="active">
						<% if(boardList.get(i).getCategoryno()==1){ %>
								<td><%= boardList.get(i).getBoardno() %>
								<td>
					 				<a href="/board/view?boardno=<%=boardList.get(i).getBoardno() %>&cateno=<%=boardList.get(i).getCategoryno()%>">
										<%=boardList.get(i).getBoardtitle() %>
									</a>
									
								<td><%= boardList.get(i).getNick() %></td>
								<td><%= boardList.get(i).getBoarddate() %></td>
								<td><%= boardList.get(i).getHit() %></td>
						<% } %>
					</tr> 
			 		<% } %>
				</table>
				<div class="search">
				<select class="searchListHead" name="searchList">
					<!-- <option value="0">선택</option> -->
					<option class="searchList" value="boardtitle" id="option1" >제목</option>
					<option class="searchList" value="nick" id="option2">닉네임</option>
				</select>
				<input type="text" name="word" value="" placeholder="검색어를 입력해주세요">
				<button type="submit">검색</button>
				</div>
			</form>
			<div class="text-center">
				<ul class="pagination">
				
<%-- 					<%	if( paging.getCurPage() != 1) { %>
					<li><a href="./notice">&larr; 처음</a></li>
					<%	} %> --%>
				
				<% if( wordParam ==null ) { %>
					<%	if( paging.getCurPage() != 1) { %>
					<li><a href="./notice?curPage=<%=paging.getCurPage() - 1 %>">&lt;</a></li>
					<%	} %>
					
					<%	for(int i=paging.getStartPage(); i<=paging.getEndPage(); i++) { %>
					<%		if( i == paging.getCurPage() ) { %>
					<li class="active"><a href="./notice?curPage=<%=i %>"><%=i %></a></li>
					<%		} else { %>
					<li><a href="./notice?curPage=<%=i %>"><%=i %></a></li>
					<%		} %>
					<%	} %>
			
					<%	if( paging.getCurPage() != paging.getTotalPage() ) { %>
					<li><a href="./notice?curPage=<%=paging.getCurPage() + 1 %>">&gt;</a></li>
					<%	} %>
				<% } else {%>
					<%	if( paging.getCurPage() != 1) { %>
					<li><a href="./notice?curPage=<%=paging.getCurPage() - 1 %>&searchList=<%=request.getParameter("searchList")%>&word=<%=wordParam%>">&lt;</a></li>
					<%	} %>
					
					<%	for(int i=paging.getStartPage(); i<=paging.getEndPage(); i++) { %>
					<%		if( i == paging.getCurPage() ) { %>
					<li class="active"><a href="./notice?curPage=<%=i %>&searchList=<%=request.getParameter("searchList")%>&word=<%=wordParam%>"><%=i %></a></li>
					<%		} else { %>
					<li><a href="./notice?curPage=<%=i %>&searchList=<%=request.getParameter("searchList")%>&word=<%=wordParam%>"><%=i %></a></li>
					<%		} %>
					<%	} %>
			
					<%	if( paging.getCurPage() != paging.getTotalPage() ) { %>
					<li><a href="./notice?curPage=<%=paging.getCurPage() + 1 %>&searchList=<%=request.getParameter("searchList")%>&word=<%=wordParam%>">&gt;</a></li>
					<%	} %>				
				<% } %>
					
					
<%-- 					<%	if( paging.getCurPage() != paging.getTotalPage() ) { %>
					<li><a href="./notice?curPage=<%=paging.getTotalPage() %>">&rarr; 끝</a></li>
					<%	} %> --%>
					<a href="/board/write"><button role="button" class="btn btn-success">글쓰기</button></a>
				</ul>
			</div>
	</div>
	

</div>
<%@ include file="../layout/footer.jsp"%>