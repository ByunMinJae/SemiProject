<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<h1>&ensp;&emsp;게시판 목록</h1>
<style type="text/css">
.left {
	float: left;
	width: 18%;
}

.right {
	float: right;
	width: 80%;
}

.menu img{
	width: 80%;
	height: 80%;
}
</style>


<script type="text/javascript">
	//웹 페이지가 화면에 로드되었을 때
	$(document).ready(function() {

		//a태그의 0번째요소에 클릭이벤트 발생시키기
		$("a").eq(0).click();
		$("a").eq(1).click();
		$("a").eq(2).click();
		$("a").eq(3).click();
		$("a").eq(4).click();
		

		// <a>태그가 클릭되었을 때
		$("a").click(function() {

			//요청을 보낸 후 응답 데이터를 div.right에 반영한다.
			$(".right").load($(this).attr("href"))

			//<a>태그의 페이지 이동(기본 동작) 막기
			return false;
		})

	})
</script>

<body>
<form>
<hr>
	<div style="min-height: 500px;">
		<div class="left">

			<!-- 게시판 목록 -->		
			<ul class="menu">
				<li><a href="/board/notice"><img src="/resources/image/notice.png"></a>
				<li><a href="/board/free"><img src="/resources/image/free.png"></a>
				<li><a href="/board/food"><img src="/resources/image/food.png"></a>
				<li><a href="/board/gathering"><img src="/resources/image/gathering.png"></a>
				<li><a href="/board/question"><img src="/resources/image/question.png"></a>
			</ul>
		
		</div>
		
		<div class="right"></div>
	</div>
</form>

</body> 
<%@ include file="../layout/footer.jsp"%>