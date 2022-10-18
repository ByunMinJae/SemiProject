<%@page import="changmin.dto.User"%>
<%@page import="java.util.List"%>
<%@page import="changmin.dto.Pay"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<% Pay pay = (Pay) request.getAttribute("pay"); %>
<%-- <% List<User> list = (List<User>) request.getAttribute("list"); %> --%>
<% User loginUser = (User) request.getAttribute("loginUser"); %>

<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>

<style type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/css.jsp">
</style>

<script>
	var IMP = window.iMP;
	
	IMP.init('imp88224386');
	   IMP.request_pay({
	   	pg : "kakaopay", 
	       pay_method : 'card',
	       merchant_uid : 'merchant_' + new Date().getTime(),
	       name : '결제',
	       amount : 주문개수,
	       buyer_email : '구매자 이메일',
	       buyer_name : '구매자 이름',
	       buyer_tel : '구매자 번호',
	       buyer_addr : '구매자 주소',
	       buyer_postcode : '구매자 주소',
	       m_redirect_url : 'redirect url'
	   }, function(rsp) {
	       if ( rsp.success ) {
		       $(".paydo").submit();
	           var msg = '결제가 완료되었습니다.';
	           location.href='결제완료후 갈 url';
	       } else {
	           var msg = '결제에 실패하였습니다.';
	           rsp.error_msg;
	           
	       }
	   });
   
	
	
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
		<p>상품 가격 : </p>
		<p>결제 방법 : </p>
		<button>신용카드</button>
		<button>계좌이체</button>	
	</div>
	<br>
	<hr>
	<br>
	
	<button id="paydo">결제하기</button>
	<br><br><br>
</form>
<%@ include file="../layout/footer.jsp" %>
