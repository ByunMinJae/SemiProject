<%@page import="changmin.dto.OrderBefore"%>
<%@page import="sharon.dto.User"%>
<%@page import="java.util.List"%>
<%@page import="changmin.dto.Pay"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<% Pay pay = (Pay) request.getAttribute("pay"); %>
<% User loginUser = (User) request.getAttribute("loginUser"); %>
<% OrderBefore orderInfo = (OrderBefore) request.getAttribute("orderInfo"); %>
<% User updateUser = (User) request.getAttribute("updateUser"); %>
<% String prodno = (String) request.getAttribute("prodno"); %>

<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<style type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/css.jsp">
</style>

<script type="text/javascript">
//카카오 결제 API
var IMP = window.IMP; // 생략가능
IMP.init('imp88224386');  // 가맹점 식별코드

// IMP.request_pay(param, callback) 결제창 호출
$(document).ready(function(){
	$("#paydo").click(function(){
	    IMP.request_pay({ // param
	 
	    pg: "html5_inicis",
	    pay_method: "card",
	    merchant_uid: <%=loginUser.getUserno()%> + new Date().getTime(),
	    name: $("#prodnamevalue").val(),
	    amount: $("#prodpricevalue").val(),
	    buyer_email: $("#emailvalue").val(),
	    buyer_name: $("#prodpricevalue").val(),
	    buyer_tel: $("#phonevalue").val(),
	    buyer_addr: $("#addressvalue").val(),
	    buyer_postcode: "01181" 
		}, function (rsp) { // callback
	        if (rsp.success) { // 결제 성공 시: 결제 승인 또는 가상계좌 발급에 성공한 경우
	            // jQuery로 HTTP 요청
	            console.log(rsp.pay_method);
	            $.ajax({
	                url: "/ordersuccess",
	                method: "POST",
	                headers: { "Content-Type": "application/x-www-form-urlencoded" },
	                dataType: "html",
	                data: { 
	                	imp_uid: rsp.imp_uid,
	                	pay_method: rsp.pay_method,
	                	merchant_uid: rsp.merchant_uid,
	                	name: rsp.name,
	                	amount: <%=orderInfo.getTotalamount()%>,
	                	userno: <%=loginUser.getUserno()%>,
		                buyer_email: '<%=loginUser.getEmail()%>',
		                buyer_name: '<%=loginUser.getUsername()%>',
		                buyer_tel: '<%=loginUser.getPhone()%>',
		                buyer_addr: $("#addressvalue").val(),
		                orderno: <%=orderInfo.getOrderno()%>,
		                prodno: <%=prodno%>
	               	}
	            }).done(function (data) {
	                	console.log(rsp.orderprocess);
	                	console.log("결제성공");
	              // 가맹점 서버 결제 API 성공시 로직
	              	 	window.location.href = "/ordersuccess";	
	            })
	          } else {
	            alert("결제에 실패하였습니다. 에러 내용: " +  rsp.error_msg);
	          }
	     });
	    
	});
});



$(document).ready(function() {
	
	$("#addressSubmitButton").click(function(){
		
	      $('#info_addressdetail').html($("#postcode").val() + " " + $("#address").val() + " " + $("#detailAddress").val())
	      $('#addressvalue').val($("#postcode").val() + " " + $("#address").val() + " " + $("#detailAddress").val())
	      
	}); //funciton End
	
}); //ready End  */
	
// 	    $.ajax({
// 	      type: "POST",
// 	      url: "/address/change",
// 	      dataType: "text",
//  	      data: {
	    	  
// 	      },
// //  	      data: {
// // 	    	  postcode: $("#postcode").value
// // 	      },
// 	      contentType : "application/x-www-form-urlencoded;charset=UTF-8",
// 	      error: function() {
// 	        console.log('통신실패!!');
// 	      },
// 	      success: function(data) {
// 	        console.log("통신데이터 값 : " + data);
// 	        $("#info_addressdetail").html(data);
	        
// 	      }
// 	    });
	    
//       return false;//화면이동 막기
      


/* $(document).ready(function () {

	   $("#addressSubmitButton").click(function() {
   			$("#info_addressdetail").val( $("#postcode").val() + " " + $("#address").val() + " " + $("#detailAddress").val() )
	      	$("#info_addressdetail").html();
//	       return false;
	   })
	   
}) */


//배송지 변경
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

button {
	margin: 10px;
}


#paydo {
	position: relative;
	left: 160px;
	top: 50px;
	margin: 0 auto;
	border: none;
	padding: 0;
	background-color: white;
	cursor: pointer;
	
}
#wrapper {
	background-color: #BFDCFB;
}

h1{
	font-family: 'dalseo';
}

h3{
	font-family: 'GmarketSansMedium';
}
.container {
	background-color: #BFDCFB;
	height: 1150px; 
}

.container-wrap{
	position: relative;
	top: 100px; 
	background-color: white;
} 

.info {
	font-family: 'GmarketSansMedium';
	font-weight: bold;
	background-color: #E1FFB1;
	border-collapse: collapse;
	padding: 10px;
	
}

.info_detail {
	font-family: 'GmarketSansMedium';
}

#onechance {
	font-family: 'GmarketSansMedium';
	float: right;
}
#buttonposition {
	position: relative;
	top: -13px;
	left: 6px;
}

#pay {
	display:table;
	width:90%;
}

#addressChange {
	height: 170px;
}

#addressChange input {
	float: left;
	position: relative;
	top: -15px;
	left: 80px; 
}

input[type=text] {
	min-height: 20px;
}

#addressChange input:not(#postbutton){
	height: 18px;
}

#address {
	width: 355px;
} 


li {
   display: list-item;
   list-style-type: none;
}

.widthcontainer {
	position: relative;
	top: 100px;
	width: 70%;
	margin: 0 auto;	 
}
 
.w-button { 
    border: 0.5px solid silver; 
    border-radius: 5px;
	font-family: 'GmarketSansMedium';
    box-shadow: 0 2px 2px rgba(0, 0, 0, 0.2);
    font-weight: 600;
    cursor: pointer;
}

 
</style>

<div class="widthcontainer">
	<h1>주문 / 결제</h1>
	<hr>
	<!-- 구매자 정보 -->
	<form class="pay" method="post">
		<div id="buy_info">
			<h3>구매자 정보</h3>
			
			<span class="info">&ensp;&emsp;&emsp;&emsp;이름</span>
			<span class="info_detail"> <%=loginUser.getUsername() %></span><br><br>
			
			<span class="info">&ensp;&emsp;&emsp;이메일</span>
			<input type="hidden" id="emailvalue" value="<%=loginUser.getEmail()%>">
			<span class="info_detail"> <%=loginUser.getEmail() %></span><br><br>
			
			<span class="info">&ensp;&emsp;&emsp;연락처</span>
			<span class="info_detail"> <%=loginUser.getPhone() %> </span><br>
		</div>
		<br>
		<hr>
		
		<!-- 받는사람 정보 -->
		<div id="receivcer_info">
			<h3>받는사람 정보</h3>
			<span class="info">&ensp;&emsp;&emsp;&emsp;이름</span>
			<input type="hidden" id="usernamevalue" value="<%=loginUser.getUsername()%>">
			<span class="info_detail"><%=loginUser.getUsername() %></span><br><br>
			
			<div id="addressChange">
				<label for="postcode"><span class="info" id="change">&ensp;배송지변경</span></label>
				<ul class="address_A">
					<li><input type="text" name="postcode" id="postcode" placeholder="우편번호"></li>
				</ul>
				<div id="buttonposition">
					<input type="button" id="postbutton" class="w-button" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
				</div>
				<ul class="address_B"> 
					<li><input type="text" id="address" placeholder="주소"><br></li>
				</ul>
				<ul class="address_C">
					<li><input type="text" id="detailAddress" placeholder="상세주소"></li>
					<li><input type="text" id="extraAddress" placeholder="참고항목"></li>
				</ul>
				<input type="hidden" name="address" id="addressSubmit">
	
				<button type="button" id="addressSubmitButton" class="w-button">주소변경</button>
				<p id="onechance"> * 이번만 다른주소로 받기</p>
				<span id="address_msg" class="msg"></span><br>
			</div>
		</div>
			
		<div> 
			 
			<span class="info">&ensp;&emsp;배송주소</span>
			<input type="hidden" id="addressvalue" value="<%=loginUser.getAddress()%>">
			<span class="info_detail" id="info_addressdetail"><%=loginUser.getAddress() %></span><br><br>
			
			<span class="info">&ensp;&emsp;&emsp;연락처</span>
			<input type="hidden" id="phonevalue" value="<%=loginUser.getAddress()%>">
			<span class="info_detail"><%=loginUser.getPhone() %></span><br>
		</div>
		<br>
		<hr>
		<!-- 결제정보 -->
		<div id="pay_info">
			<h3>결제 정보</h3>
			<span class="info">&ensp;&emsp;상품이름</span>
			<input type="hidden" id="prodnamevalue" value="<%=orderInfo.getBuyprodname() %>">
			<span class="info_detail"><%=orderInfo.getBuyprodname() %></span><br><br>
			<span class="info">&nbsp;총결제금액</span>
			<input type="hidden" id="prodpricevalue" value="<%=orderInfo.getTotalamount() %>">
			<span class="info_detail"><%=orderInfo.getTotalamount() %></span>
		</div> 
		<br>
		<hr>
		<br>
		<div>
			<button id="paydo" type="button"><img src="/resources/image/btn_payment.gif"></button>
		</div>
	</form>
	<br><br><br>
</div>
<%@ include file="../layout/footer.jsp" %>
