<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/adminheader.jsp"%>
<style>
.container{
	margin-top: 150px;
}
</style>



<h1 style="text-align: center">카테고리 설정</h1>
<form action="/manager/board" method="post">


	<select name="category" multiple class="form-control">
		<option id="notice" value="notice">공지사항</option>
		<option value="free">자유게시판</option>
		<option value="food">맛집게시판</option>
		<option value="meeting">소모임 게시판</option>
		<option value="qna">질문게시판</option>
		<option value="report">신고글</option>

	</select> <br>
	<button class="btn btn-primary">검색</button>
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