<%@page import="jeonghwa.dto.Product"%>
<%@page import="sharon.dto.User"%>
<%@page import="java.util.List"%>
<%@page import="changmin.dto.Pay"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<% Pay pay = (Pay) request.getAttribute("pay"); %>
<% User loginUser = (User) request.getAttribute("loginUser"); %>
<% Product prod = (Product) request.getAttribute("prod"); %>
<% User updateUser = (User) request.getAttribute("updateUser"); %>

<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<style type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/css.jsp">
</style>

<script type="text/javascript">
//카카오 결제 API
/* var IMP = window.IMP; // 생략가능
IMP.init('imp88224386');  // 가맹점 식별코드
// IMP.request_pay(param, callback) 결제창 호출
function payDo(){
    IMP.request_pay({ // param
 
    pg: "html5_inicis",
    pay_method: "card",
    merchant_uid: "ORD20180131-01234",
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
                url: "/orderafterlist", // 예: https://www.myservice.com/payments/complete
                method: "POST",
                headers: { "Content-Type": "application/json" },
                dataType: "json",
                data: { pay_method: rsp.pay_method }
            }).done(function (data) {
                	console.log(rsp.pay_method);
              // 가맹점 서버 결제 API 성공시 로직
            })
          } else {
            alert("결제에 실패하였습니다. 에러 내용: " +  rsp.error_msg);
          }
     });
    
} */

function payDo(){
	$.ajax({
		url: "/orderafterlist",//(action url),
		type: "POST",//(get, post 방식),
		data: {
		    pg: "html5_inicis",
		    pay_method: "card",
		    merchant_uid: "ORD20180131-01234",
		    name: $("#prodnamevalue").val(),
		    amount: $("#prodpricevalue").val(),
		    buyer_email: $("#emailvalue").val(),
		    buyer_name: $("#prodpricevalue").val(),
		    buyer_tel: $("#phonevalue").val(),
		    buyer_addr: $("#addressvalue").val(),	
		},
		dataType: "text",
		success: function(result){
			alert("success");
		},
		error: function(){
			console.log(JSON.stringify(error));
		}
	});
}


$(document).ready(function() {
	
	$("#addressSubmitButton").click(function(){
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
      
      $('#info_addressdetail').html($("#postcode").val() + " " + $("#address").val() + " " + $("#detailAddress").val())
      
	}); //funciton End
	
}); //ready End  */

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

.addressChange {
	float:left;
}
button {
	margin: 10px;
}

#paydo {
	position: relative;
	left: 500px;
	border: none;
	background-color: white;
	cursor: pointer;
}

.info {
	background-color: #EEEEEE;
	border-collapse: collapse;
	padding: 10px;
}

#pay {
	display:table;
	width:90%;
	border:1px solid #DDD;
}

#addressChange {
	height: 155px;
}

#addressChange input {
	float: left;
	position: relative;
	top: -35px;
	left: 80px; 
}

#addressChange input:not(#postbutton){
	height: 18px;
}

#address {
	width: 345px;
}


li {
   display: list-item;
   list-style-type: none;
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
					<input type="button" id="postbutton" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
				<ul class="address_B"> 
					<li><input type="text" id="address" placeholder="주소"><br></li>
				</ul>
				<ul class="address_C">
					<li><input type="text" id="detailAddress" placeholder="상세주소"></li>
					<li><input type="text" id="extraAddress" placeholder="참고항목"></li>
				</ul>
				<input type="hidden" name="address" id="addressSubmit">
	
				<button type="button" id="addressSubmitButton">주소변경</button>
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
			<span class="info">&nbsp;총결제금액</span>
			<input type="hidden" id="prodnamevalue" value="<%=prod.getProdname() %>">
			<input type="hidden" id="prodpricevalue" value="<%=prod.getProdprice()%>">
			<span class="info_detail"><%=prod.getProdprice() %></span>
		</div> 
		<br>
		<hr>
		<br>
		<div>
			<button id="paydo" type="button" onclick="payDo();"><img src="/resources/image/btn_payment.gif"></button>
		</div>
	</form>
	<br><br><br>
</div>
<%@ include file="../layout/footer.jsp" %>
