<%@page import="minjae.dto.MpMain"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	MpMain mpMain = (MpMain)request.getAttribute("mpMain"); %>
 
<%@	include file="../../layout/header.jsp" %>

<!-- 다음 주소 API -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<!-- + jQuery UI 1.13.2 CDN -->
<script type="text/javascript" src="https://code.jquery.com/ui/1.13.2/jquery-ui.min.js"></script>

<!-- + jQuery UI Base Theme CDN -->
<link type="text/css" rel="stylesheet" href="https://code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">

<script>
$(document).ready(function () {
	
// 	$("form").submit(function() {
// 		$("#addressAll").val( $("#postcode").val() + " " + $("#address").val() + " " + $("#detailAddress").val() )
// // 		return false;
// 	})

	//hidden 변경 폼 띄우기
	showHiddenForm($("#btnChgName"), $("#btnCencelName"), $("#currName"), $("#hidName"), $("#name_msg"));
	showHiddenForm($("#btnChgNick"), $("#btnCencelNick"), $("#currNick"), $("#hidNick"), $("#nick_msg"));
	showHiddenForm($("#btnChgPhone"), $("#btnCencelPhone"), $("#currPhone"), $("#hidPhone"), $("#phone_msg"));
	showHiddenForm($("#btnChgAddr"), $("#btnCencelAddr"), $("#currAddr"), $(".addr"), $("#address_msg"));
	
	//이름 변경 확인 버튼 클릭
	$("#btnNameUdt").click(function() {
		if($("#name").val() != "" ) {

			if( confirm("이름을 변경하시겠습니까?") ) {
				updateUserInfo($("#btnNameUdt").val(), $("#name").val());
			} else {
				location.reload();
			}
			
		} else {
			$("#name_msg").html("변경된 내용이 없습니다.")
		}
	})
	
	//닉네임 변경 확인 버튼 클릭
	$("#btnNickUdt").click(function() {
		existNick();
	})

	//전화번호 변경 확인 버튼 클릭
	$("#btnPhoneUdt").click(function() {
		existPhone();
	})
	
	//주소 변경 확인 버튼 클릭
	$("#btnAddrUdt").click(function() {
		//입력된 주소값 문자열 하나로 합치기
		$("#addressAll").val( $("#postcode").val() + " " + $("#address").val() + " " + $("#detailAddress").val() )
		
		if($("#addressAll").val() != "" && $("#addressAll").val() != "  " ) { //주소를 입력한 경우
			if($("#detailAddress").val() != "") { //상세주소까지 입력했는지 확인

				if( confirm("주소을 변경하시겠습니까?") ) {
					updateUserInfo($("#btnAddrUdt").val(), $("#addressAll").val());
				} else {
					location.reload();
				}
			} else {
				$("#address_msg").html("상세주소를 입력해 주세요.")
			}
		} else { //주소를 입력하지 않은 경우
			$("#address_msg").html("변경된 내용이 없습니다.")
		}
	})
	
	//회원 탈퇴 버튼 클릭 시 다이얼로그 open
	$("#btnDialog").click(function() {
		$("#pwcheck").dialog( "open" );
	})
	
	//다이얼로그 옵션 설정하기
	$("#pwcheck").dialog({
		autoOpen: false 	//기본 모습 숨기기 설정
		, draggable: false 	//이동 불가 설정
		, width: 360		//너비 지정
		, height: 240		//높이 지정
		, title: "본인확인"
		, modal: true
		, buttons: [
			{
				text:"확인"
				, icon: "ui-icon-check"
				, click: function() {
					
					$.ajax({
						type: "post"					//요청 메소드
						, url: "/mypage/pwcheck"			//요청 URL
						, data: {						//요청 파라미터
							pw: $("#pw").val()
						}
						, dataType: "html"				//응답 데이터 형식
						, success: function( res ) {
							console.log("AJAX 성공")
							console.log(res)
							
							if( $.trim(res) == "true" ) {
								//true일 때 회원 탈퇴 페이지로 이동
								alert("확인 되었습니다.")
								location.href = "/mypage/delete";
								
							} else {
								//아닐 때 확인 메시지 띄우기
								$("#check_msg").html(res);
							}
							
						}
						
					})
					
				}
			}
		]
	})
	
})

//변경 폼 띄우는 메소드
function showHiddenForm(btnChg, btnCencel, curr, hidden, msg) {
	btnChg.click(function() {
		curr.attr("style", "display: none")
		hidden.attr("style", "")
	})
	btnCencel.click(function() {
		curr.attr("style", "")
		hidden.attr("style", "display: none")
		msg.html("");
	})
}

//닉네임 중복 검사 메소드
function existNick() {
	
	if($("#nick").val() != "") {
		
		//전화번호 중복 검사 & update수행
		existVal($("#btnNickUdt").val(), $("#nick").val(), $("#nick_msg"), "닉네임");
		
	} else {
		$("#nick_msg").html("변경된 내용이 없습니다.")
	} 
	
}

//전화번호 중복 검사 메소드
function existPhone() {
	
	if($("#phone").val() != "") { //입력한 값이 존재할 때
		if( /^[0-9]{11}$/.test($("#phone").val()) ) { //입력한 값이 숫자일 때
			
			//전화번호 중복 검사 & update수행
			existVal($("#btnPhoneUdt").val(), $("#phone").val(), $("#phone_msg"), "전화번호");
			
		} else { //입력한 값이 숫자가 아닐때
			$("#phone_msg").html("숫자 11자리만 입력하세요.");
		}
	} else { //입력한 전화번호가 없을 때
		$("#phone_msg").html("변경된 내용이 없습니다.");
	}
	
}

//중복검사 메소드
function existVal(btnName, info, msg, text) {
	
	$.ajax({
		type: "post"					
		, url: "/mypage/upcheck"			
		, data: {						 
			btnName: btnName
			, info: info
		}
		, dataType: "html"				
		, success: function( res ) {
			console.log("AJAX 성공")
			console.log(res)
			
			if( $.trim(res) == "true" ) {// 중복이 아닐 경우
				console.log("update 메소드 실행");
				
				if( confirm("사용 가능한 " + text + "입니다. 변경하시겠습니까?") ) {
					updateUserInfo(btnName, info);
				} else {
					location.reload();
				}
				
			} else {//중복되는 닉네임일 경우
				msg.html(res);
			}
			
		}
		
	})
	
}

//업데이트 시키는 메소드
function updateUserInfo(btnName, info) {
	
	$.ajax({
		type: "post"					
		, url: "/mypage/update"			
		, data: {						
			btnName: btnName
			, info: info
		}
		, dataType: "html"				
		, success: function( res ) {
			console.log("update AJAX 성공")
			console.log(res)
		
			if( $.trim(res) == "true" ) {
				alert("변경 되었습니다.")
				location.reload();
			} else {
				alert("변경에 실패하였습니다.")
				location.reload();
			}
		
		}
	})
}

//주소 API 메소드
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

<script type="text/javascript">
$(document).ready(function() {
	
	
	
})
</script>

<style type="text/css">
#mpuWrap {
	width: 1100px;
    height: 705px;
    margin: 0px auto;
    text-align: center;
    position: relative;
}
#mpuContents {
	width: 851px;
	height: 754px;
    margin: 0px auto;
    background: #fcffb282;
    border: 1px solid #ccc;
}
#f p {
	display: inline-block;
}
.msg {
	font-size: 12px;
	color: red;
	width: 287px;
}
.tr_msg {
	margin: -21px 0 0 231px !important;
	border: none !important;
}
#mpuTable {
	text-align: left;
	margin: 37px 0 0 55px;
	font-size: 18px;
	font-weight: bold;	
}
#mpuTable tr {
	display: block;
    margin: 15px 0 15px 51px;
    border-bottom: 1px solid #2d954d5c;
    width: 644px;
}
#mpuTable tr td:first-child {
	width: 103px;
	margin-right: 65px;
}
#mpuTable tr td {
    display: inline-block;
}
.addr {
	margin: 0 0 0 51px !important;
}
.ad {
	margin: 15px 0 0 51px !important;
}
input {
	height: 20px;
    font-size: 18px;
    border-radius: 4px;
    border: 1px solid #777;
}
#pc {
	font-size: 13px;
    height: 25px;
}
#goMp {
	text-decoration: none;
    color: #555;
    float: left;
    position: relative;
    top: -60px;
    left: 29px;
	font-weight: bold;
}
#goMp:hover {
	cursor: pointer;
	color: #222;
}
#goImg {
	background: url("/resources/image/left_arrow.png") no-repeat 0 0;
	width: 20px;
    height: 20px;
    display: inline-block;
    float: left;
    position: relative;
    top: -59px;
    left: 26px;
}
#btnDialog {
    float: right;
	position: relative;
    right: 22px;
    bottom: -69px;
}
</style>

<div id="mpuWrap">

<div id="mpuContents">

<h1>회원정보 수정</h1>
<div id="goImg"></div>
<a href="/mypage/main" id="goMp">마이페이지</a>

<table id="mpuTable">
<tr>
	<td>아이디</td>
	<td><%=mpMain.getUserid() %></td>
</tr>
<tr>
	<td>비밀번호</td>
	<td>***********</td>
</tr>
<!-- 현재 이름 -->
<tr id="currName">
	<td>이름</td>
	<td><%=mpMain.getUsername() %></td>
	<td style="margin-left: 184px;"><button id="btnChgName">변 경</button></td>
</tr>
<!-- 변경 이름 -->
<tr id="hidName" style="display: none;">
	<td><label for="name">이름</label></td>
	<td><input type="text" id="name" name="name" placeholder="<%=mpMain.getUsername() %>" onFocus="this.value=''; return true;"></td>
	<td><button id="btnNameUdt" value="name" type="button">확 인</button></td>
	<td><button id="btnCencelName" type="button">취 소</button></td>
</tr>
<tr class="tr_msg">
	<td><div id="name_msg" class="msg"></div></td>
</tr>
<!-- 현재 닉네임 -->
<tr id="currNick">
	<td>닉네임</td>
	<td><%=mpMain.getNick() %></td>
	<td style="margin-left: 146px;"><button id="btnChgNick">변 경</button></td>
</tr>
<!-- 변경 닉네임 -->
<tr id="hidNick" style="display: none;">
	<td><label for="nick">닉네임</label></td>
	<td><input type="text" id="nick" name="nick" placeholder="<%=mpMain.getNick() %>" onFocus="this.value=''; return true;"></td>
	<td><button id="btnNickUdt" value="nick" type="button">확 인</button></td>
	<td><button id="btnCencelNick" type="button">취 소</button></td>
</tr>
<tr class="tr_msg">
	<td><div id="nick_msg" class="msg"></div></td>
</tr>
<tr>
	<td>생년월일</td>
	<td><%=mpMain.getBirth() %></td>
</tr>
<tr>
	<td>성별</td>
	<td><%=mpMain.getGender() %></td>
</tr>
<tr>
	<td>이메일</td>
	<td><%=mpMain.getEmail() %></td>
</tr>
<tr>
	<td>가입일</td>
	<td><%=mpMain.getJoinday() %></td>
</tr>
<!-- 현재 전화번호 -->
<tr id="currPhone">
	<td>전화번호</td>
	<td><%=mpMain.getPhone() %></td>
	<td style="margin-left: 111px;"><button id="btnChgPhone">변 경</button></td>
</tr>
<!-- 변경 전화번호 -->
<tr id="hidPhone" style="display: none;">
	<td><label for="phone">전화번호</label></td>
	<td><input type="text" id="phone" name="phone" placeholder="<%=mpMain.getPhone() %>" onFocus="this.value=''; return true;"></td>
	<td><button id="btnPhoneUdt" value="phone" type="button">확 인</button></td>
	<td><button id="btnCencelPhone" type="button">취 소</button></td>
</tr>
<tr class="tr_msg">
	<td><div id="phone_msg" class="msg"></div></td>
</tr>
<!-- 현재 주소 -->
<tr id="currAddr">
	<td>주소</td>
	<td><%=mpMain.getAddress() %></td>
	<td class="btnChg"  style="margin-left: 111px;"><button id="btnChgAddr">변 경</button></td>
</tr>
<!-- 변경 주소 -->
<tr class="addr ad" style="display: none; margin: 15px 0 0 51px !important;">
	<td><label for="address">주소</label></td>
	<td><input type="text" id="postcode" placeholder="우편번호"></td>
	<td><input type="button" onclick="execDaumPostcode()" value="우편번호 찾기" id="pc"></td>
</tr>
<tr class="addr" style="display: none;">
	<td><label for="address"></label></td><!-- 여백용 -->
	<td><input type="text" id="address" placeholder="주소"></td>
</tr>
<tr class="addr" style="display: none;">
	<td><label for="address"></label></td><!-- 여백용 -->
	<td><input type="text" id="detailAddress" placeholder="상세주소"></td>
	<td><input type="text" id="extraAddress" placeholder="참고항목"></td>
</tr>
<tr class="addr" style="display: none;">
	<td><label for="address"></label></td><!-- 여백용 -->
	<td><button id="btnAddrUdt" value="address" type="button">확 인</button></td>
	<td><button id="btnCencelAddr" type="button">취 소</button></td>
</tr>
<tr class="tr_msg" style="margin: -9px 0 0 231px !important;">
	<td style="width: 200px;"><span id="address_msg" class="msg"></span></td>
	<!-- 따로 받아지는 주소를 하나로 DB에 저장하기 위한 태그 -->
	<td><input type="hidden" name="address" id="addressAll"></td>
</tr>

</table>

<button id="btnDialog">회원 탈퇴</button>

<!-- dialog DIV -->
<div id="pwcheck" title="dialog test">

	<p style="font-size: 14px;">회원정보 수정을 위해 본인확인을 해주세요.</p>
	<label for="pw">비밀번호 : </label>
	<input type="text" id="pw" name="pw" onFocus="this.value=''; return true;">
	<input type="text"  hidden="">
	<!-- 확인 메시지 태그 -->
	<p id="check_msg" style="color: red; font-size: 12px; margin: 3px 0 0 74px;"></p>
	
</div>

</div>

</div>

<jsp:include page="../../layout/footer.jsp"/>












