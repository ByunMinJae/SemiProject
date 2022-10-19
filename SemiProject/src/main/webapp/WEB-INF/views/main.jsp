<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ include file="./layout/header.jsp"%> --%>
<jsp:include page="./layout/header.jsp"/>
<style type="text/css">
.back {
	position: relative;
	top: -50px; 
	right: 270px;
	overflow: hidden;
	width:2000px;
}


.back img {
	width: 100%;
	height: 1000px;
}

.login {
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
}


</style>
		<div class="back">
			<img src="/resources/image/unit-sunrise-md.png">
		</div>
		<form class="login">
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
		</form>

<%@ include file="./layout/footer.jsp"%>

