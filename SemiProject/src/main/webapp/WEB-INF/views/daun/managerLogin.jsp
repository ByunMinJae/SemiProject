<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ include file="../layout/adminheader.jsp"%>

<script type="text/javascript">

$(document).ready(function(){
	
	console.log(document.cookie);
	
	var cookieValue = getCookieValue("cookie"); //이름이 "cookie"인 쿠키의 value 가져오기
	
	console.log(cookieValue); //확인
	s
	$("#userid").val(cookieValue); //아이디에 쿠키value넣기
	
	if($("#userid").val() !=""){//아이디가 빈칸이 아니라면 아이디 저장 체크상태로 두기
		$("#saveid").attr("checked", true);
	}
	
	$("#loginForm").submit(function(){//로그인 버튼 클릭 시 함수

		if($("#saveid").is(":checked")){//아이디 저장이 체크되어있다면
			var userInputId = $("#userid").val(); //userInputId = 입력한 아이디 값
			createCookie("cookie", userInputId,7); // "cookie =" userInputId 인 쿠키 생성
			
		} else{//아이디 저장 체크 해제 시 쿠키 삭제
			deleteCookie("cookie");
		}
		
		return emptyAlert(); //아이디 비밀번호 미입력 처리 함수 호출
		
		document.form.submit();
	})
	
	
	
})
//쿠키 생성 함수
//쿠키는 'name=value'; 'expires=만기일'로 구성되어 있고 ;로 구분한다
function createCookie(name, value, exdays){//exdays : 쿠키 만기일
	var date = new Date();
	date.setTime(date.getTime()+ exdays*24*60*60*1000); // 24*60*60*1000 = 하루
	document.cookie = name + "=" + value +";" + "expires =" + date;
} 

//쿠키 이름을 통해 value값 가져오는 함수
function getCookieValue(name){
	var cookieName = name + "=";  //name=value로 이루어진 쿠키에서 name= 까지만 설정
	var cookie = document.cookie;
	
	var cookieNameLength = cookieName.length; //쿠키이름(name=) 의 길이
	var cookieLength = cookie.length; //쿠키(name=value)의 길이
	
	var cookieValue = cookie.substring(cookieNameLength, cookieLength); //쿠키이름(name=)의 길이부터 쿠키(name=value)의 길이까지의 문자열 추출 --> value
	
	return cookieValue; //value 반환
	
	console.log(cookieValue);
	
	
}

//쿠키 삭제 함수 -> 이미 지난 시간을 만기일로 설정하면 쿠키는 삭제 된다
function deleteCookie(name){
	document.cookie = name + '=; expires=Tue, 20 Feb 1996 00:00:10 GMT;'; 
	
}


function emptyAlert(){ //아이디, 비밀번호 미입력시 처리
	var id = document.getElementById('userid');
	var pw = document.getElementById('userpw');
	
	if(id.value==""){
		alert("아이디를 입력하세요!");
		id.focus();
		return false;
		
	} else if(pw.value==""){
		alert("비밀번호를 입력하세요!");
		pw.focus();
		return false;
	}

}

</script>

<style type="text/css">

.loginwrap {
	width: 0 50%;
	margin-top: 125px;
}

h1 {
	font-family: 'GmarketSansMedium';
	margin-left: 230px;

}

label {
	font-family: 'GmarketSansMedium';
	width: 50px;
	margin-left: 140px;
}

input {
	width: 300px;
	height: 40px;
	border: none;
	border-bottom: 1px solid;
}

button {
	width: 300px;
	height: 50px;
	margin-left: 140px;
	border: none;
	border-radius: 0.5em;
	font-family: 'GmarketSansMedium';
	background-color: #C7F2A4;
}

.container {
 background-color: white;
 margin-bottom: 0;
}

.container-wrap {
    height: 500px;
}

</style>

<body>


<%-- 비로그인 상태 --%>
<%	if( null == session.getAttribute("login") || !(Boolean) session.getAttribute("login") ) { %>
<form action="<%=request.getContextPath() %>/manager/login" method="post">

<div class="loginwrap">
	
	<h1>로그인</h1>
	
	<label>ID <input type="text" name="userid"></label><br>
	<label>PASS <input type="text" name="userpw"></label><br><br>
	
	<button>로그인</button>
</div>


</form>
<%	} %>

<%-- 로그인 상태 --%>
<%	if( null != session.getAttribute("login") && (Boolean) session.getAttribute("login") ) { %>
<%=session.getAttribute("loginid") %>님, 환영합니다!<br><br>
<button onclick="location.href='/manager/logout'">로그아웃</button>
<%	} %>

</body>

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











