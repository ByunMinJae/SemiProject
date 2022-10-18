<%@page import="changmin.dto.Product"%>
<%@page import="changmin.dto.User"%>
<%@page import="java.util.List"%>
<%@page import="changmin.dto.Pay"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<% Pay pay = (Pay) request.getAttribute("pay"); %>
<%-- <% List<User> list = (List<User>) request.getAttribute("list"); %> --%>
<% User loginUser = (User) request.getAttribute("loginUser"); %>
<% Product prod = (Product) request.getAttribute("prod"); %>

<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>

<style type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/css.jsp">
</style>

<script> 
//카카오 결제 API
var IMP = window.IMP; // 생략가능
IMP.init('imp88224386');  // 가맹점 식별코드
// IMP.request_pay(param, callback) 결제창 호출
function payDo(){
    IMP.request_pay({ // param

    pg: "html5_inicis",
    pay_method: "card",
    merchant_uid: "ORD20180131-0000011",
    name: "노르웨이 회전 의자",
    amount: 1,
    buyer_email: "gildong@gmail.com",
    buyer_name: "홍길동",
    buyer_tel: "010-4242-4242",
    buyer_addr: "서울특별시 강남구 신사동",
    buyer_postcode: "01181"
	}, function(rsp) { //callback
	    if ( rsp.success ) {
	      console.log('빌링키 발급 성공', rsp)
	      //빌링키 발급이 완료되었으므로, 서버에 결제 요청
	      alert('예약 결제가 완료되었습니다!');
	    } else {
	      var msg = '결제에 실패하였습니다.\n';
	      msg += rsp.error_msg;
	      alert(msg);
	      return false;
	    }
	});
}	
	 
	
</script>

<style type="text/css">
body {
	position:relative;
	top: 170px;
}

button {
	margin: 10px;
}

#paydo {
	text-align: center;
	width: 300px;
	height: 50px;
}

.info {
	background-color: #EEEEEE;
	border-collapse: collapse;
	padding: 10px;
}

.info_detail{
}

#pay {
	display:table;
	width:90%;
	border:1px solid #DDD;
}

</style>



<h1>주문 / 결제</h1>
<hr>
<!-- 구매자 정보 -->
<form class="pay">
	<div id="buy_info">
		<h3>구매자 정보</h3>
		
		<span class="info">&ensp;&emsp;&emsp;&emsp;이름</span>
		<span class="info_detail"> <%=loginUser.getUsername() %></span><br><br>
		
		<span class="info">&ensp;&emsp;&emsp;이메일</span>
		<span class="info_detail"> <%=loginUser.getEmail() %></span><br><br>
		
		<span class="info">&ensp;&emsp;&emsp;연락처</span>
		<span class="info_detail"> <%=loginUser.getPhone() %> </span><br>
	</div>
	<br>
	<hr>
	
	<!-- 받는사람 정보 -->
	<div id="receivcer_info">
		<h3>받는사람 정보<button>배송지 변경</button></h3>
		
		<span class="info">&ensp;&emsp;&emsp;&emsp;이름</span>
		<span class="info_detail"><%=loginUser.getUsername() %></span><br><br>
		 
		<span class="info">&ensp;&emsp;배송주소</span>
		<span class="info_detail"><%=loginUser.getAddress() %></span><br><br>
		
		<span class="info">&ensp;&emsp;&emsp;연락처</span>
		<span class="info_detail"><%=loginUser.getPhone() %></span><br>
	</div>
	<br>
	<hr>
	<br>
	<!-- 결제정보 -->
	<div id="pay_info">
		<p>상품 가격 : <%=prod.getProdprice() %> </p>
		<p>결제 방법 : </p>
		<button>신용카드</button>
		<button>계좌이체</button>	
	</div> 
	<br>
	<hr>
	<br>
	<div>
		<button id="paydo" type="button" onclick="payDo();">결제하기</button>
	</div>
</form>
<br><br><br>
<%@ include file="../layout/footer.jsp" %>
