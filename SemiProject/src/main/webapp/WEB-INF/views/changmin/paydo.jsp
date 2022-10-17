<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
            var msg = '결제가 완료되었습니다.';
            location.href='결제완료후 갈 url';
        } else {
            var msg = '결제에 실패하였습니다.';
            rsp.error_msg;
            
        }
    });
    


	
	
</script>
</head>
<body style="position: relative; top: 150px;">

<h1>주문 / 결제</h1>
<hr>
<!-- 구매자 정보 -->
<form class="pay">
	<div id="buy_info">
		<p>이름 : </p>
		<p>이메일 : </p>
		<p>휴대폰 번호 : </p>
	</div>
	<br>
	<hr>
	<br>
	
	<!-- 받는사람 정보 -->
	<div id="receivcer_info">
		<p>이름 : </p>
		<p>배송주소 : </p>
		<p>연락처 : </p>
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
	
	<button id="paydo" onclick()="">결제하기</button>
	<br><br><br>
</form>
</body>
<%@ include file="../layout/footer.jsp" %>
</html>