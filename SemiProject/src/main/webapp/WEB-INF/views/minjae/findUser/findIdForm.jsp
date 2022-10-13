<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@	include file="../../layout/header.jsp" %>

<script type="text/javascript">
$(document).ready(function() {
	
	//인증번호 요청 버튼 클릭 시 이벤트
	$("#btnReqAuth").click(function() {
		
		$("#result").load( "/find/findid", {"userEmail":$("#userEmail").val()} )
		
	})
	
})
</script>

<style type="text/css">
.fuiWrap {
	width: 400px;
    height: 500px;
    margin: 100px auto 0;
    text-align: center;
    position: relative;
}

#userEmail {
	width: 296px;
    height: 38px;
    padding-left: 10px;
    margin-top: 30px;
}

#btnReqAuth {
	float: right;
	position: relative;
   	top: -32px;
    right: 58px;
}

.findPw {
	font-size: 14px;
    position: absolute;
    top: 71px;
    right: 10px;
    text-decoration: none;
    color: #777;
    font-weight: bold;
}
</style> 

<div class="fuiWrap">

<h1>아이디 찾기</h1>
<hr>

<a href="<%=request.getContextPath() %>/find/findpw" class="findPw">비밀번호 찾기</a>

<input type="text" style="display: none;">
<input type="text" id="userEmail" name="userEmail" placeholder="이메일"><br>
<button id="btnReqAuth">인증 요청</button>

<div id="result"></div>

</div>

<jsp:include page="../../layout/footer.jsp"/>
<%-- <%@	include file="../../layout/footer.jsp" %> --%>


