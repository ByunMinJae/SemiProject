<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../layout/header.jsp" %>
<style type="text/css">

h1{
    font-family: 'GmarketSansMedium';
    text-align:center;
}

button { 
   border: none;
    border-radius: 5px;
    box-shadow: 0 2px 2px rgba(0, 0, 0, 0.2);
    font-weight: 600;
    cursor: pointer;
    background-color: #B6E388;
    font-family: 'GmarketSansMedium';
    height:25px;
    margin-left:43%;
    margin-bottom: 5%
}

.outer{
	margin: 0 auto;
	margin-top: 15%;
	margin-bottom: 30%
	text-align:center;
}

h5{
	font-family: 'GmarketSansMedium';
	text-align:center;
	font-size: 16px;
}


h2{
font-size: 30px;
text-align: center;
}

</style>
<div class="outer">

<h2>✅</h2><br>
<h1>코딩산악회 회원가입이 완료되었습니다.</h1><br>
<h5>회원님은 코딩산악회의 모든 기능을 사용하실 수 있습니다. 로그인 후 이용가능합니다.</h5><br><br>

<a href="/cmc/login"><button>로그인 페이지로 이동</button></a>
</div>
<jsp:include page="../../layout/footer.jsp"/>