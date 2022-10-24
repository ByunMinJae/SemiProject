<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../layout/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
 <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="crossorigin="anonymous">
</script>
<script type="text/javascript">
function checkId(){
	var userid=$("#userid").val();
	
	$.ajax({
		type:'post',
		url:'${pageContext.request.contextPath}/user/idCheck',
		data:{userid:userid},
		success:function(result){
			console.log(result)
			
			if(result.result ==1){
				$("#uid_msg").text("사용 가능한 아이디 입니다");
				$("#uid_msg").css("color","blue");
			}
			else{
				$("#uid_msg").text("아이디가 중복되었습니다.");
				$("#uid_msg").css("color","red");
			}
		},
		error:function(a,b,c){
			console.log("상태코드:"+a);
			console.log("메시지:"+b);
			console.log("에러설명:"+c);
		}
	});
	
}
</script>

<script type="text/javascript">

//유효성 검사
function validate() {

	if( !validateID( $("#userid").val() ) ) { //ID유효성 검증 실패
		return false; //submit 중단
	}
	
	if( !validatePW( $("#userpw").val() ) ) { //PW유효성 검증 실패
		return false; //submit 중단
	}
	
	if( !validateNAME( $("#username").val() ) ) { //PW유효성 검증 실패
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

//1023 아이디중복


//----------------------10/20 아이디중복
/* let idCheck = false;

function useridCheck(){
	
	var userid = $("#userid").val();
	
	$.ajax({
		type:"POST",
		url:"/user/idCheck",
		data:{userid:userid},
		contentType:"application/json:charset=utf-8",
		dataType:"text"
		
	}).done(function(result){
		if(result== 1){
			$("uid_msg").html("아이디가 중복되었습니다.");
			idCheck=false;
			
		}else{
			$("uid_msg").html("사용 가능한 아이디입니다.");
			isChecking=true;
		}
	});
	
}  */


/* $(document).ready(function() {
	
 	$("#idCheckbtn").click(function() {
 		
 		$.ajax({
 			type:"POST",
 			url:"/user/idCheck",
 			data:{userid:userid},
 //			contentType:"application/json:charset=utf-8",
 			dataType:"html",
 			success: function( res ) {
 				console.log("AJAX 성공")
 				console.log(res)
 				
 				if( $.trim(res) == "true" ) {
 					console.log('사용 가능한 아이디입니다.')
 					
 				if( validateID( $("#userid").val() ) ) {
 					$("#form").submit();
 				} else {	
 					console.log('중복된 아이디입니다.')
 					$("#uid_msg").html(res);
 				}
 			}
 		}
	})
})})

 */
//----아이디중복끝

function validatePW( pw ) {
	//패스워드를 입력하지 않았을 때
	if( pw == '' ) {
		$("#upw_msg").html("패스워드를 입력해주세요!")
		
		return false;
	}
	
	//패스워드 입력값 검증
	if( !/^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{6,12}$/.test( pw ) ) {
	      $("#upw_msg").html("비밀번호는 영어대소문자, 숫자 6~12자만 입력하세요!")
	      return   false;
	   }
	
	//패스워드와 확인 입력값이 같은 지 검증
	if( pw != $("#pwCk").val() ) {
		$("#pwCk_msg").html("비밀번호가 일치하지 않습니다!")
		
		return false;
	}

	//PW 유효성 검증 완료
	return true;
}

function validateNAME( name ) {
	//패스워드를 입력하지 않았을 때
	if( name == '' ) {
		$("#username_msg").html("이름을 입력해주세요!")
		
		return false;
	}
	return true;
}



//-----------------10/13추가 메시지 삭제가 안되고 그대로 남아있음

//--- 유효성 검증 에러 메시지 초기화 ---

//아이디 입력 시도할 때 아이디메시지 삭제
/*  $("#userid").focus(function() {
	$('#uid_msg').html("")
})

//패스워드 입력 시도할 때 패스워드메시지 삭제
$("#userpw").focus(function() {
	$("#upw_msg").html("")
})

//패스워드 확인 입력 시도할 때 패스워드체크 메시지 삭제
$("#pwCk").focus(function() {
	$("#pwCk_msg").html("")
})  */

$(document).ready(function () {

	$("form").submit(function() {
		$("#addressSubmit").val( $("#postcode").val() + " " + $("#address").val() + " " + $("#detailAddress").val() )
// 		return false;
	})
	
})

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

</script>


<style type="text/css">

.outer{
	width:450px;
	margin: 0 auto;
	margin-top: 17%;
	background-color: #f5f6f7;
}

.msg {
	font-size: 0.7em;
	color: red;
	font-weight:bold;
/* 	margin-left: 10px; */
	
} 

button,#btnadd { 
    border: none;
    border-radius: 10px;
    font-family: "paybooc-Light", sans-serif;
    box-shadow: 0 2px 2px rgba(0, 0, 0, 0.2);
    font-weight: 600;
    cursor: pointer;
}
body{
background-color: #f5f6f7; 
font-family: "paybooc-Light", sans-serif;

}

h1{
	text-align:center;
}

.ps_box.int_id, .ps_box.int_id input {
    background: #fff;
    outline: 0;
}

.ps_box, .ps_box_disable {
    display: block;
    position: relative;
    width: 100%;
    height: 51px;
    border: solid 1px #dadada;
    padding: 10px 110px 10px 14px;
    background: #fff;
    box-sizing: border-box;
    vertical-align: top;
}

.int {
    display: block;
    position: relative;
    width: 100%;
    height: 29px;
    padding-right: 25px;
    line-height: 29px;
    border: none;
    font-size: 15px;
    box-sizing: border-box;
    z-index: 10;
}



#form{
margin:0 auto;
}
</style>



</head>
<body>
<div class="outer">
<h1><center>회원가입</center></h1>
<hr>

<form action="/user/join" method="post" id="form" onsubmit="return validate();">

<label for="userid">아이디</label>
<button type="button" id="idCheckbtn" onclick="checkId();">중복확인</button>
<span class="ps_box int_id">
<input type="text" name="userid" id="userid" class="int" ></span>
<span id="uid_msg" class="msg"></span><br>

<label for="userpw">비밀번호</label>
<span class="ps_box int_id">
<input type="password" name="userpw" id="userpw" class="int"></span>
<span id="upw_msg" class="msg"></span><br>

<label for="pwCk">비밀번호 확인</label>
<span class="ps_box int_id">
<input type="password" name="pwCk" id="pwCk" class="int"></span>
<span id="pwCk_msg" class="msg"></span><br>

<label for="username">이름</label>
<span class="ps_box int_id">
<input type="text" name="username" id="username" class="int"></span>
<span id="username_msg" class="msg"></span><br>

<label for="nick">닉네임</label>
<span class="ps_box int_id">
<input type="text" name="nick" id="nick" class="int"></span>
<span id="nick_msg" class="msg"></span><br>


<label for="birth">생년월일</label>
<span class="ps_box int_id">
<input type="date" name="birth" id="birth" class="int"></span>
<span id="birth_msg" class="msg"></span><br>
<!-- <select id="mm" class="sel" aria-label="월"></select><br> -->

<label for="gender">성별</label>
<span class="ps_box int_id">
<input type="radio" name="gender" value="남자">남
<input type="radio" name="gender" value="여자">여</span>
<span id="gender_msg" class="msg"></span><br>

<label for="email">이메일</label>
<span class="ps_box int_id">
<input type="text" name="email" id="email"class="int" ></span>
<span id="email_msg" class="msg"></span><br>


<label for="phone">전화번호</label>
<span class="ps_box int_id">
<input type="text" name="phone" id="phone" class="int" placeholder="(-)없이 입력" ></span>
<span id="phone_msg" class="msg"></span><br>

<label for="address">주소</label>
<input type="button" id="btnadd" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
<span class="ps_box int_id">
<input type="text" id="postcode" placeholder="우편번호"class="int"></span>
<span class="ps_box int_id">
<input type="text" id="address" class="int"placeholder="주소"><br></span>
<span class="ps_box int_id">
<input type="text" id="detailAddress" class="int"placeholder="상세주소"></span>
<span class="ps_box int_id">
<input type="text" id="extraAddress" class="int"placeholder="참고항목"></span>

<input type="hidden" name="address" id="addressSubmit">

<span id="address_msg" class="msg"></span><br>

<!-- 	<button type="button" class="btn btn-primary" id="btnJoin">회원가입</button>
	<button type="button" class="btn btn-danger" id="btnCancel">취소</button>
 -->
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
<jsp:include page="../../layout/footer.jsp"/>
<%-- <%@ include file="../../layout/footer.jsp" %> --%>