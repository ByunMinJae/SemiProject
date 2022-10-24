<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<style>
.container{
	top: 205px !important;
	margin-bottom: 395px !important;
	
}

#login-wrap{
	width:50%;
	margin: 0 auto;

}

#login_letter {
	display: flex;
	justify-content: center;
}

form {
	padding: 10px;
	width: 50%;
	margin: 0 auto;
}

.input-box {
	position: relative;
	margin: 10px 0;
}

.input-box>input {
	background: transparent;
	border: none;
	border-bottom: solid 1px #ccc;
	padding: 20px 0px 5px 0px;
	font-size: 14pt;
	width: 100%;
}

input::placeholder {
	color: transparent;
}

input:placeholder-shown+label {
	color: #aaa;
	font-size: 14pt;
	top: 15px;
}

input:focus+label, label {
	color: #8aa1a1;
	font-size: 10pt;
	pointer-events: none;
	position: absolute;
	left: 0px;
	top: 0px;
	transition: all 0.2s ease;
	-webkit-transition: all 0.2s ease;
	-moz-transition: all 0.2s ease;
	-o-transition: all 0.2s ease;
}

input:focus, input:not(:placeholder-shown) {
	border-bottom: solid 1px #8aa1a1;
	outline: none;
}

input[type=submit] {
	
	background-color: #E1FFB1;
	border: none;
	color: black;
	border-radius: 5px;
	width: 84%;
	height: 35px;
	font-size: 13pt;
	margin-top: 50px;
	margin-left: 46px;
	font-weight: bolder;
}

#forgot {
	text-align: right;
	font-size: 12pt;
	margin: 10px 0px;
}

#remember{
	float: left;
}

#forgot > a{
	text-decoration: none;
}

#findid::after {
	padding-left:5px;
	content: "|";
}

#kakao-wrap{
	margin-left: 331px;
}


</style>


<%-- include header --%>
<%@ include file="../layout/header.jsp" %> 

<%-- jquery --%>

<script type="text/javascript">

$(document).ready(function(){
	
	console.log(document.cookie);
	
	var cookieValue = getCookieValue("cookie"); //이름이 "cookie"인 쿠키의 value 가져오기
	
	console.log(cookieValue); //확인
	
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

<%-- 카카오 로그인 script --%>
<script type="text/javascript" src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script type="text/javascript">
	Kakao.init('47e41ad73741ecf726fae8911f475fd9'); //발급받은 키 중 javascript키를 사용해준다.
	console.log(Kakao.isInitialized()); // sdk초기화여부판단
	//카카오로그인
	function kakaoLogin() {
		 //1. 로그인 시도
	    Kakao.Auth.login({
	        success: function(authObj) {
	         
	          //2. 로그인 성공시, API 호출
	          Kakao.API.request({
	            url: '/v2/user/me',
	            success: function(res) {
	              console.log(res);
	              var id = res.id;
				  scope : 'profile, account_email';
				  alert('환영합니다');
	              location.href="/cmc/kakao";
			
			
	              
	        }
	          })
	          console.log(authObj);
	          var token = authObj.access_token;
	        },
	        fail: function(err) {
	          alert(JSON.stringify(err));
	        }
	      });
	        
	} //
	

	//function kakaoLogout() {
		//if (Kakao.Auth.getAccessToken()) {
		//	Kakao.API.request({
			//	url : '/v1/user/unlink',
			//	success : function(response) {
			//		console.log(response)
			//	},
			//	fail : function(error) {
			//		console.log(error)
			//	},
			//})
			//Kakao.Auth.setAccessToken(undefined)
	//	}
//	} 
</script>


<%-- body --%>
<div id="login-wrap">
<div id="login_letter">
	<h2>Login</h2>
</div>

<form action="/cmc/login" method="post" id="loginForm">

		<div class="input-box">
			<input id="userid" type="text" name="userid" placeholder="아이디">
			<label for="username">아이디</label>
		</div>

		<div class="input-box">
			<input id="userpw" type="password" name="userpw"
				placeholder="비밀번호"> <label for="password">비밀번호</label>
		</div>
		
		<div id="remember">
		<input type="checkbox" id="saveid" name="saveid">
		아이디 저장
		</div>
		
		<div id="forgot"><a href="/find/findid" id="findid">아이디 찾기</a> <a href="/find/findpw">비밀번호 찾기</a></div>
		<input type="submit" value="로그인"  >


</form>
		<div id="kakao-wrap">
		<a href="javascript:kakaoLogin()"><img src="/resources/image/kakao_login.png"></a>
		</div>
</div>


<%-- include footer --%>
<%@ include file="../layout/footer.jsp" %>