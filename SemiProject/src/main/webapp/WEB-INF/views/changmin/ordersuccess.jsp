<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<script type="text/javascript">


</script>
<style type="text/css">

@font-face {	
   font-family: 'dalseo';
   src: url('/resources/css/DalseoHealingBold.ttf') format('truetype');
}
#ordersuccess {
	width: 75%;
	height: 800px;
	margin: auto;
	text-align: center;
	display: table;
}


#wrapper {
	background-color: #BFDCFB;
}
#table {
	display: table-cell;
	vertical-align: middle;
}

#success {
	font-family: 'dalseo';
	font-size: 40px;
}

button {
    border: none;
    border-radius: 5px;
    font-family: "paybooc-Light", sans-serif;
    box-shadow: 0 2px 2px rgba(0, 0, 0, 0.2);
    font-weight: 600;
    cursor: pointer;
    padding: 15px 30px;
}

</style>
	<div id="ordersuccess">
		<div id="table">
			<img src="/resources/image/ok.png">
			<p id="success">결제가 완료되었어요 !</p>
			<p><a href="/orderafterlist"><button>주문목록</button></a></p>
		</div>
	</div>

<%@ include file="../layout/footer.jsp" %>