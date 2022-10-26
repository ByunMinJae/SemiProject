<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<script>
//환불하기
function getToken() {
	$.ajax({
	    url: "https://api.iamport.kr/users/getToken",
	    method: "post", // POST method
	    headers: { "Content-Type": "application/json" }, // "Content-Type": "application/json"
	    data: {
	      imp_key: "5855168744050340", // REST API키
	      imp_secret: "QT3L7I2h24A9eF6SVtnDrOkzo5nwBvJYJZQCpcjc9aoLfHJBBRj3qyxXjPZshePvvNzgmTDxxMDnO4LP" // REST API Secret
	    }
	  });
	}
	  
function cancelPay() {
    jQuery.ajax({
      url: '/pay/cancel', // 예: http://www.myservice.com/payments/cancel
      type: "POST",
      contentType: 'application/x-www-form-urlencoded; charset = utf-8',
      data: JSON.stringify({
        merchant_uid: "1666766784581", // 예: ORD20180131-0000011
        cancel_request_amount: 1800, // 환불금액
        reason: "테스트 결제 환불" // 환불사유
//        refund_holder: "홍길동", // [가상계좌 환불시 필수입력] 환불 수령계좌 예금주
//        refund_bank: "88" // [가상계좌 환불시 필수입력] 환불 수령계좌 은행코드(예: KG이니시스의 경우 신한은행은 88번)
//        refund_account: "56211105948400" // [가상계좌 환불시 필수입력] 환불 수령계좌 번호
      }),
      dataType: "json"
    });
  }
  
</script>


<h1>
결제취소
</h1>
<button onclick="getToken();">토큰발급</button>
<button onclick="cancelPay();">환불하기</button>
<%@ include file="../layout/footer.jsp" %>