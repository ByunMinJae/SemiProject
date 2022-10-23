<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@	include file="../../layout/header.jsp" %>

<script type="text/javascript">
$(document).ready(function() {
	
	$(".btnReqAuth").click(function() {
		console.log("#btnReqAuth 클릭")
// 		console.log($("#year").val() + $("#month").val() + $("#day").val())
		var checkVal = $('input[name=type]:checked').val();
		
		if( checkVal == 'sms' ) {
			
			$.ajax({
				type: "post"					//요청 메소드
				, url: "/find/findid"			//요청 URL
				, data: {						//요청 파라미터
					userName: $("#userName").val()
					, userBirth: $("#year").val() + "/" + $("#month").val() + "/" + $("#day").val()
					, userPhone: $("#userPhone").val()
				}
				, dataType: "html"				//응답 데이터 형식
				, success: function( res ) {
					console.log("AJAX 성공")
					
					//응답 데이터 반영
					$("#resSms").html( res )
				}
				
			})
			
		} else {
			
			$.ajax({
				type: "post"					
				, url: "/find/findid"			
				, data: {						
					userEmail: $("#userEmail").val()
				}
				, dataType: "html"				
				, success: function( res ) {
					console.log("AJAX 성공")
					
					//응답 데이터 반영
					$("#resEmail").html( res )
				}
				
			})
		}
		
	})
	
	/* 생년월일 Select Box 만들기 */
	var now = new Date();
    var year = now.getFullYear();
    var mon = (now.getMonth() + 1) > 9 ? ''+(now.getMonth() + 1) : '0'+(now.getMonth() + 1); 
    var day = (now.getDate()) > 9 ? ''+(now.getDate()) : '0'+(now.getDate());           
    //년도 selectbox만들기               
    for(var i = 1900 ; i <= year ; i++) {
        $('#year').append('<option value="' + i + '">' + i + '년</option>');    
    }

    // 월별 selectbox 만들기            
    for(var i=1; i <= 12; i++) {
        var mm = i > 9 ? i : "0"+i ;            
        $('#month').append('<option value="' + mm + '">' + mm + '월</option>');    
    }
    
    // 일별 selectbox 만들기
    for(var i=1; i <= 31; i++) {
        var dd = i > 9 ? i : "0"+i ;            
        $('#day').append('<option value="' + dd + '">' + dd + '일</option>');    
    }
    $("#year  > option[value="+year+"]").attr("selected", "true");        
    $("#month  > option[value="+mon+"]").attr("selected", "true");    
    $("#day  > option[value="+day+"]").attr("selected", "true"); 
	
})

/*  */
function hiddenForm() {
	
	if ( $("#hid1").is(":checked") ) {
		
		 $("#emailType").attr("hidden", "")
		 $("#smsType").removeAttr("hidden")
		 
	} else if( $("#hid2").is(":checked") ) {
		
		 $("#smsType").attr("hidden", "")
		 $("#emailType").removeAttr("hidden")
		 
	}
	
}
</script>

<style type="text/css">
.fuiWrap {
	width: 400px;
    height: 500px;
    margin: 200px auto 0;
    text-align: center;
    position: relative;
}

#userEmail, #userName,
#userPhone, #authnoS, #authnoE {
	width: 288px;
    height: 32px;
    padding-left: 10px;
    margin-top: 30px;
}

.btnReqAuth {
	float: right;
	position: relative;
   	top: -31px;
    right: 54px;
}

.findPw {
 	color: #777;
	font-size: 14px;
    position: absolute;
    top: 71px;
    right: 10px;
    font-weight: bold;
}
.findPw:hover {
	color: #444; 
}

#fromInsideOut a::after {
	position: absolute; 
	content:""; 
	display: block; 
	border-bottom: 2px solid #444; 
	transition: all 250ms ease-out; 
	left: 50%; 
	width: 0;
}

#fromInsideOut a:hover::after {
	transition: all 250ms ease-out; 
	left: 0%; 
	width: 100%;
}

#hid1, #hid2 {
    margin-left: 53px;
}
.radioDiv {
	text-align: left;
	font-size: 14px;
}
input[type='radio'],
input[type='radio']:checked {
  appearance: none;
  width: 0.9rem;
  height: 0.9rem;
  border-radius: 30%;
  margin-right: 0.1rem;
}
input[type='radio'] {
  background-color: #fff;
  border: 2px solid #ccc;
}
input[type='radio']:checked {
  background-color: #4c6ae7;
}

#selectBox {
	width: 330px;
	margin: 13px 0px 4px 36px;
}
select {
	height: 30px;
}
</style> 

<div class="fuiWrap">

<h1>아이디 찾기</h1>
<hr>

<div id="fromInsideOut">
	<a href="<%=request.getContextPath() %>/find/findpw" class="findPw" style="text-decoration: none;">비밀번호 찾기</a>
</div>

<div class="radioDiv" style="margin-top: 35px;">
	<input type="radio" name="type" value="sms" id="hid1" checked onclick="hiddenForm();">전화번호
</div>
<div class="radioDiv">
	<input type="radio" name="type" value="email" id="hid2" onclick="hiddenForm();">이메일
</div>

<!-- sms 인증 -->
<div id="smsType" >
	<input type="text" id="userName" name="userName" placeholder="이름"><br>
	
	<div id="selectBox">
		생년월일
		<select name="yy" id="year"></select>년
		<select name="mm" id="month"></select>월
		<select name="dd" id="day"></select>일
	</div>
	
	<input type="text" id="userPhone" name="userPhone" placeholder="휴대전화(-없이)" style="margin-top: 11px;"><br>
	<button class="btnReqAuth">인증 요청</button>
	<div id="resSms"></div>
</div>


<!-- email 인증 -->
<div id="emailType" hidden="">
	<input type="text" id="userEmail" name="userEmail" placeholder="이메일"><br>
	<button class="btnReqAuth">인증 요청</button>
	<div id="resEmail"></div>
</div>

</div><!-- End of .fuiWrap -->

<jsp:include page="../../layout/footer.jsp"/>
<%-- <%@	include file="../../layout/footer.jsp" %> --%>


