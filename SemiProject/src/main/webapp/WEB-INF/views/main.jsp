<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ include file="./layout/header.jsp"%> --%>
<jsp:include page="./layout/header.jsp"/>
<script type="text/javascript">



</script>
<style type="text/css">



@font-face {
	font-family: 'dalseo';
	src: url('/resources/css/DalseoHealingBold.ttf') format('truetype');
}

html {
	overflow-x: hidden;
}

.back {
	position: absolute;
	width:2000px;
	right: 1px;
	
}


.back img {
	width: 100%;
	height: 1000px;
	z-index: 1;
}

/* .login {
	text-align: center;
	position: absolute;
	top: 300px;
	left: 1300px;
	color: black;
	background-color: white;
	padding: 30px 30px;
	box-sizing: border-box;
	width: 400px;
	height: 300px;
	padding: 20px 30px;
	background-color: white;
	border-radius: 30px;
	border: 2px solid black;
}

input, button {
	width: 200px;
	height: 20px;
} */


.text-slide{
	position: relative;
	top: 55px;
	left: 200px;
}
 

.textst{
	font-family: 'dalseo';
	font-size: 60px;
	text-align: center;
	padding: 0;
	padding-left: 183px;
	margin: 0;
	margin-left: 50%;
	transform: translateX(-200%);
	opacity: 0;
	animation: slide-in-anim 0s ease-out forwards;
}
:is(.one, .two, .three, .four){
	color: white;
	font-family: 'dalseo';
	font-size: 60px;
	text-align: center;
	padding: 0;
	margin: 0;
	margin-left: 50%;
	transform: translateX(-200%);
	opacity: 0;
	animation: slide-in-anim 2s ease-out forwards;
}


.one {
  animation-delay: 1s;
}

.two {
  animation-delay: 3s;
}

.three {
  animation-delay: 5s;
}

.four {
  position: relative;
  animation-delay: 7s;
  left: -34px;
}

@keyframes slide-in-anim {
	20% {
		opacity: 0;
	}
	60% {
		transform: translateX(-45%);
	}
	75% {
		transform: translateX(-52%);
	}
	100% {
		opacity: 1;
		transform: translateX(-50%);
	}
}

.agent {
	color: #00CC88;
}


</style>
<div class="back">
	<img src="/resources/image/unit-sunrise-md.png">
</div>

<label>
	<div class="text-slide">
		<p class="one"><span class="agent">가족</span><span class="together">과 함께</span></p>
		<p class="two"><span class="agent">친구</span><span class="together">와 함께</span></p>
		<p class="three"><span class="agent">연인</span><span class="together">과 함께</span></p>
		<p class="four"><span class="agent">혼자</span><span class="together">서도</span></p>
		<p class="textst">즐길수 있는 스포츠</p>
	</div>
</label>


		
<!-- 		<form class="login">
			<p style="font-size:30px;">코딩 산악회</p>
			<div class="panel_inner" role="tabpanel" aria-controls="loinid">
				<div class="id_pw_wrap">
					<div class="input_row" id="id_line">
						<input type="text" id="id" name="id" placeholder="아이디" title="아이디"
							class="input_text" maxlength="41" value=""> <span
							role="button" class="btn_delete" id="id_clear"
							style="display: none;"> <span class="icon_delete">
								<span class="blind">삭제</span>
						</span>
						</span>
					</div>
						<input type="password" id="pw" name="pw" placeholder="비밀번호"
							title="비밀번호" class="input_text" maxlength="16"> <span
							role="button" class="btn_delete" id="pw_clear"
							style="display: none;"> <span class="icon_delete">
								<span class="blind">삭제</span>
						</span>
						</span>
					</div>
				</div>
				<br>
				<hr style="width: 200px;">
				<br>
				<div class="btn_login_wrap">

					<button type="submit" class="btn_login" id="log.login">
						<span class="btn_text">로그인</span>
					</button>

				</div>
		</form> -->

<%-- <%@ include file="./layout/footer.jsp"%> --%>
	</div> <!-- .container-wrap end -->
</div> <!-- .container end -->



<footer id="footer" class="footer" style="position:absolute; bottom:-210px;">
	<div class="footer-wrap">
		<p class="footerlist-wrap">
			<span class="footerlist">
				<span>(주)코딩산악회</span>
				<span>세미 프로젝트</span>
				<span>팀원</span>
				<span>강창민 권정화 김다운 김동현 변민재 이샤론</span>
			</span>
			<br>
			<span class="footerlist">
				<span>GIT :</span>
				<span><a href="https://github.com/ByunMinJae/SemiProject.git" id="git">https://github.com/ByunMinJae/SemiProject.git</a></span>
			</span>
			<br>
			<span class="copyright">
				COPYRIGHT©codingMountaineeringSociety.ALL RIGHTS RESERVED
			</span>
		</p>		
	</div>
</footer>





</div> <!-- .wrapper end -->	

</body>
</html>

