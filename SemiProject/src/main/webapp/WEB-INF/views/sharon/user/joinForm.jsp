<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../layout/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">

//유효성 검사
function validate() {

	if( !validateID( $("#userid").val() ) ) { //ID유효성 검증 실패
		return false; //submit 중단
	}
	
	if( !validatePW( $("#userpw").val() ) ) { //PW유효성 검증 실패
		return false; //submit 중단
	}

	//모든 유효성 검증 성공	
	return true; //submit 허용하기
}


function validateID( id ) {
	
	//아이디를 입력했는 지 검증
	if( id == '' ) {
		$('#uid_msg').html("아이디를 입력해주세요!");
		
		return false;
	}

	//아이디 입력값 검증
	if( !/^[a-zA-Z0-9]{4,12}$/.test( id ) ) {
		$('#uid_msg').html("아이디는 4~12의 영문자, 숫자가 가능합니다")
		
		return false;
	}

	//ID 유효성 검증 완료
	return true;
}

function validatePW( pw ) {
	//패스워드를 입력하지 않았을 때
	if( pw == '' ) {
		$("#upw_msg").html("패스워드를 입력해주세요!")
		
		return false;
	}
	
	//패스워드 입력값 검증
	if( !/^[a-zA-Z]{4,8}$/.test( pw ) ) {
		$("#upw_msg").html("패스워드는 영어 대소문자 4~8자만 입력하세요!")
		
		return false;
	}
	
	//패스워드와 확인 입력값이 같은 지 검증
	if( pw != $("#pwCk").val() ) {
		$("#pwCk_msg").html("비밀번호가 일치하지 않습니다!")
		
		return false;
	}

	//PW 유효성 검증 완료
	return true;
}


//postcode, addredss, detailadress가 합쳐져서 sql에 하나의 데이터로 들어감(10/19 선생님께 확인)
$(document).ready(function () {

	$("form").submit(function() {
		$("#addressSubmit").val( $("#postcode").val() + " " + $("#address").val() + " " + $("#detailAddress").val() )
// 		return false;
	})
	
})

//테스트데이터
function data() {
	userid.value = 'abcd';
	userpw.value = 'Abc1234';
	pwCk.value = 'Abc1234';
	username.value = 'testname';
	nick.value = 'testnick';
	birth.value = '2022-10-11';
	$("input[name='gender'][value='남자']").prop('checked', true);
	email.value = 'asdf@naver.com';
	phone.value = '01012345678';
	postcode.value = '12345';
	address.value = '테스트 주소';
	detailAddress.value = '테스트 주소2';
	extraAddress.value = '테스트 주소3';
}

//-----------------10/13추가 메시지 삭제가 안되고 그대로 남아있음

//--- 유효성 검증 에러 메시지 초기화 ---
/* 
//아이디 입력 시도할 때 아이디메시지 삭제
$("#userid").focus(function() {
	$('#uid_msg').html("")
})

//패스워드 입력 시도할 때 패스워드메시지 삭제
$("#userpw").focus(function() {
	$("#upw_msg").html("")
})

//패스워드 확인 입력 시도할 때 패스워드체크 메시지 삭제
$("#pwCk").focus(function() {
	$("#pwCk_msg").html("")
}) */

</script>


<style type="text/css">

.outer{
	width:400px;
	margin: 0 auto;
	margin-top: 20%;
}

.msg {
	font-size: 0.5em;
	color: red;
	margin-left: 55px;
	
} 


</style>



</head>
<body>
<div class="outer">
<h1>회원가입 페이지</h1>
<hr>

<form action="/user/join" method="post" onsubmit="return validate();">

<label for="userid">아이디</label>
<input type="text" name="userid" id="userid" >
<button id="idCheck" type="button">중복확인</button><br>
<span id="uid_msg" class="msg"></span><br>

<label for="userpw">비밀번호</label>
<input type="password" name="userpw" id="userpw" ><br>
<span id="upw_msg" class="msg"></span><br>

<label for="pwCk">비밀번호 확인</label>
<input type="password" name="pwCk" id="pwCk" ><br>
<span id="pwCk_msg" class="msg"></span><br>

<label for="username">이름</label>
<input type="text" name="username" id="username" ><br>
<span id="name_msg" class="msg"></span><br>

<label for="nick">닉네임</label>
<input type="text" name="nick" id="nick" ><br>
<span id="nick_msg" class="msg"></span><br>

<label for="birth">생년월일</label>
<input type="date" name="birth" id="birth" ><br>
<span id="birth_msg" class="msg"></span><br>
<!-- <select id="mm" class="sel" aria-label="월"></select><br> -->

<label for="gender">성별</label>
<input type="radio" name="gender" value="남자">남
<input type="radio" name="gender" id="여자">여<br>
<span id="gender_msg" class="msg"></span><br>

<label for="email">이메일</label>
<span class="box">
<input type="text" name="email" id="email" ><br><br>
<span id="email_msg" class="msg"></span><br>
</span>

<label for="phone">전화번호</label>
<input type="text" name="phone" id="phone" placeholder="(-)없이 입력" ><br>
<span id="phone_msg" class="msg"></span><br>

<label for="address">주소</label>
<input type="text" id="postcode" placeholder="우편번호">
<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
<input type="text" id="address" placeholder="주소"><br>
<input type="text" id="detailAddress" placeholder="상세주소">
<input type="text" id="extraAddress" placeholder="참고항목">
<span id="address_msg" class="msg"></span><br>

<input type="hidden" name="address" id="addressSubmit">

<span id="address_msg" class="msg"></span><br>

<button>가입</button>
</form>

</div>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode;
                document.getElementById("address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("detailAddress").focus();
            }
        }).open();
    }
</script>






</body>
</html>
<%@ include file="../../layout/footer.jsp" %>