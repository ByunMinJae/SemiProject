<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/adminheader.jsp"%>
<style>
@font-face {
   font-family: 'dalseo';
   src: url('/resources/css/DalseoHealingBold.ttf') format('truetype');
}
@font-face {
    font-family: 'GmarketSansMedium';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansMedium.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
.container{
	margin-top: 150px;
}

h1{
	font-family: 'dalseo';
}
select{
	font-family: 'GmarketSansMedium';
}
button{
	font-family: 'GmarketSansMedium';
}
</style>



<h1 style="text-align: center">카테고리 설정</h1>
<form id="managerBoardForm" action="/manager/board" method="post">


	<select name="category" multiple class="form-control">
		<option id="managerBoardOption" value="notice">공지사항</option>
		<option id="managerBoardOption" value="free">자유게시판</option>
		<option id="managerBoardOption" value="food">맛집게시판</option>
		<option id="managerBoardOption" value="meeting">소모임 게시판</option>
		<option id="managerBoardOption" value="qna">질문게시판</option>
		<option id="managerBoardOption" value="report">신고글</option>

	</select> <br>
	<button id="managerBoardButton" class="btn btn-primary">검색</button>
</form>

</div>
<!-- .container-wrap end -->
</div>
<!-- .container end -->



<footer id="footer" class="footer">
	<div class="footer-wrap">
		<p class="footerlist-wrap">
			<span class="footerlist"> <span>(주)코딩산악회</span> <span>세미
					프로젝트</span> <span>팀원</span> <span>강창민 권정화 김다운 김동현 변민재 이샤론</span>
			</span> <br> <span class="footerlist"> <span>GIT :</span> <span><a
					href="https://github.com/ByunMinJae/SemiProject.git" id="git">https://github.com/ByunMinJae/SemiProject.git</a></span>
			</span> <br> <span class="copyright">
				COPYRIGHT©codingMountaineeringSociety.ALL RIGHTS RESERVED </span>
		</p>
	</div>
</footer>





</div>
<!-- .wrapper end -->

</body>
</html>