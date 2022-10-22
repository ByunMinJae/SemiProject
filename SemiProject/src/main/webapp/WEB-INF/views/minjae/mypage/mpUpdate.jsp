<%@page import="minjae.dto.MpMain"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	MpMain mpMain = (MpMain)request.getAttribute("mpMain"); %>
 
<%@	include file="../../layout/header.jsp" %>

<!-- 다음 주소 API -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<script>
$(document).ready(function () {

	$("form").submit(function() {
		$("#addressSubmit").val( $("#postcode").val() + " " + $("#address").val() + " " + $("#detailAddress").val() )
// 		return false;
	})
	
	/* 닉네임 변경 시작 */
	$("#btnNickUdt").click(function() {
		
		existNick()
		
// 		if( $("#nickFlag").val() == 'true' ) {
// 			console.log("닉네임 검사 까지는 완료")
// 			$.ajax({
// 				type: "post"					//요청 메소드
// 				, url: "/mypage/update"			//요청 URL
// 				, data: {						//요청 파라미터
// 					btnName: $("#btnNickUdt").val()
// 					, nick: $("#nick").val()
// 				}
// 				, dataType: "html"				//응답 데이터 형식
// 				, success: function( res ) {
// 					console.log("AJAX 성공")
// 					console.log(res)
					
// 					if( $.trim(res) == "true" ) {
// 						alert("변경 완료!!")
// 					} else {
// 						alert("변경 실패!!")
// 					}
					
// 				}
				
// 			})
//  		}
	})
	/* 닉네임 변경 끝 */
	
})

/* 닉네임 검사 */
function existNick() {
	
	if($("#nick").val() != "") {
		//닉네임 중복검사
		$.ajax({
			type: "post"				
			, url: "/mypage/upcheck"		
			, data: {						
				btnName: $("#btnNickUdt").val()
				, nick: $("#nick").val()
			}
			, dataType: "html"			
			, success: function( res ) {
				console.log("AJAX 성공")
				console.log(res)
				
				if( $.trim(res) == "true" ) {// 중복이 아닐 경우
					console.log("update ajax 실행");
					//중첩 ajax
					$.ajax({
		 				type: "post"					
		 				, url: "/mypage/update"			
		 				, data: {						
		 					btnName: $("#btnNickUdt").val()
		 					, nick: $("#nick").val()
		 				}
		 				, dataType: "html"				
		 				, success: function( res ) {
		 					console.log("update AJAX 성공")
		 					console.log(res)
							
		 					if( $.trim(res) == "true" ) {
		 						alert("변경 완료!!")
		 					} else {
		 						alert("변경 실패!!")
		 					}
							
		 				}
		 			})//update ajax 끝
					
				} else {//중복되는 닉네임일 경우
					$("#nick_msg").html(res);
				}
				
			}
			
		})//닉네임 중복검사 ajax 끝
		
	} else {
		$("#nick_msg").html("변경된 내용이 없습니다!")
	} 
	
}

function existPhone() {
	
	if($("#phone").val() != "") {
		
		//전화번호 검사
		$.ajax({
			type: "post"					//요청 메소드
			, url: "/mypage/upcheck"			//요청 URL
			, data: {						//요청 파라미터
				btnName: $("#btnPhoneUdt").val()
				, phone: $("#phone").val()
			}
			, dataType: "html"				//응답 데이터 형식
			, success: function( res ) {
				console.log("AJAX 성공")
				console.log(res)
				
				if( $.trim(res) == "true" ) {
					if(confirm("전화번호를 변경 하시겠습니까?") == true) {
						console.log("완료되었습니다.");
						return true;
					} else {
						console.log("최소되었습니다.");
						return false;
					}				
				}
				
			}
			
		})
		
	} else {
		$("#phone_msg").html("전화번호 입력란이 비워져 있습니다!")
	}
	
}

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

<style type="text/css">
#mpuWrap {
	width: 1100px;
    height: 600px;
    margin: 0px auto;
    text-align: center;
    position: relative;
}
#mpuContents {
	width: 800px;
	height: 639px;
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
}
</style>

<div id="mpuWrap">

<div id="mpuContents">

<form action="/mypage/update" method="post" id="f">

<p>아이디</p>
<p><%=mpMain.getUserid() %></p><br>

<p>비밀번호</p>
<p>점으로 채우기</p><br>

<label for="name">이름</label>
<input type="text" id="name" name="name" placeholder="<%=mpMain.getUsername() %>"><br>

<!-- 중복검사 필요 -->
<label for="nick">닉네임</label>
<input type="text" id="nick" name="nick" placeholder="<%=mpMain.getNick() %>">
<div id="nick_msg" class="msg"></div>
<button id="btnNickUdt" value="nick" type="button">수정</button><br>
<input type="hidden" id="nickFlag" value="">

<p>생년월일</p>
<p><%=mpMain.getBirth() %></p><br>

<p>성별</p>
<p><%=mpMain.getGender() %></p><br>

<p>이메일</p>
<p><%=mpMain.getEmail() %></p><br>

<!-- 중복검사, 형식검사 필요 -->
<label for="phone">전화번호</label>
<input type="text" id="phone" name="phone" placeholder="<%=mpMain.getPhone() %>">
<div id="phone_msg" class="msg"></div><br>
<button id="btnPhoneUdt" value="phone" type="button">수정</button><br>


<!-- 형식검사 필요 -->
<label for="address">주소</label>
<input type="text" id="postcode" placeholder="우편번호">
<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
<input type="text" id="address" placeholder="주소"><br>
<input type="text" id="detailAddress" placeholder="상세주소">
<input type="text" id="extraAddress" placeholder="참고항목">
<span id="address_msg" class="msg"></span><br><br>
<button id="btnAddrUdt" value="address" type="button">수 정</button>

<!-- 따로 받아지는 주소를 하나로 DB에 저장하기 위한 태그 -->
<input type="hidden" name="address" id="addressSubmit">


</form>

</div>

</div>

<jsp:include page="../../layout/footer.jsp"/>












