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
	color: white;
	border-radius: 5px;
	width: 100%;
	height: 35px;
	font-size: 14pt;
	margin-top: 100px;
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

</style>


<%-- include header --%>
<%@ include file="../layout/header.jsp" %> 

<%-- jquery --%>
<script type="text/javascript">

$(document).ready(function(){
	
	var userInputId = getCookie("userInputId");
    var setCookieYN = getCookie("setCookieYN");
    
    if(setCookieYN == 'Y') {
        $("#saveid").attr("checked", true);
    } else {
        $("#saveid").attr("checked", false);
    }
    
    $("#userid").val(userInputId); 
	
	$("#loginForm").submit(function(){
		
//		if($("#saveid").is(":checked")){
//			alert("아이디 저장 체크")
//		}else{
//			alert("아이디 저장 미체크")
//		}
		
		if($("#saveid").is(":checked")){
			var userInputId = $("#userid").val();
			setCookie("userInputId", userInputId, 60);
			setCookie("setCookieYN", "Y", 60);
		}else{
			deleteCookie("userInputId");
			deleteCookie("setCookieYN");
		}
		
		return emptyAlert();
		
		document.form.submit();
	})
	
	
	
})

//쿠키값 Set
function setCookie(cookieName, value, exdays){
    var exdate = new Date();
    exdate.setDate(exdate.getDate() + exdays);
    var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + 
    exdate.toGMTString());
    document.cookie = cookieName + "=" + cookieValue;
}

//쿠키값 Delete
function deleteCookie(cookieName){
    var expireDate = new Date();
    expireDate.setDate(expireDate.getDate() - 1);
    document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
}

//쿠키값 가져오기
function getCookie(cookie_name) {
    var x, y;
    var val = document.cookie.split(';');
    
    for (var i = 0; i < val.length; i++) {
        x = val[i].substr(0, val[i].indexOf('='));
        y = val[i].substr(val[i].indexOf('=') + 1);
        x = x.replace(/^\s+|\s+$/g, ''); // 앞과 뒤의 공백 제거하기
        
        if (x == cookie_name) {
          return unescape(y); // unescape로 디코딩 후 값 리턴
        }
    }
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
<%--  <script type="text/javascript" src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script type="text/javascript">
	Kakao.init('47e41ad73741ecf726fae8911f475fd9'); //발급받은 키 중 javascript키를 사용해준다.
	console.log(Kakao.isInitialized()); // sdk초기화여부판단
	//카카오로그인
	function kakaoLogin() {
		Kakao.Auth.login({
			success : function(response) {
				Kakao.API.request({
					url : '/v2/user/me',
					success : function(response) {
						console.log(response)
					},
					fail : function(error) {
						console.log(error)
					},
				})
			},
			fail : function(error) {
				console.log(error)
			},
		})
	}

	function kakaoLogout() {
		if (Kakao.Auth.getAccessToken()) {
			Kakao.API.request({
				url : '/v1/user/unlink',
				success : function(response) {
					console.log(response)
				},
				fail : function(error) {
					console.log(error)
				},
			})
			Kakao.Auth.setAccessToken(undefined)
		}
	} 
</script> --%>


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
		
		<div id="forgot"><a href="" id="findid">아이디 찾기</a> <a href="">비밀번호 찾기</a></div>
		<input type="submit" value="로그인"  >


</form>
		<div id="kakao-wrap">
		<a href="javascript:kakaoLogin()"><img src="/resources/image/kakao_login.png"></a>
		</div>
</div>


<%-- include footer --%>
<%@ include file="../layout/footer.jsp" %>