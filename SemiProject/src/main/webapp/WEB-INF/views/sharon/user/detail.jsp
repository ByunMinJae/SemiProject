<%@page import="sharon.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../layout/adminheader.jsp" %>
<%	User user= (User) request.getAttribute("user");%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원상세정보</title>
<script type="text/javascript">
/* $(document).ready(function() {
	$("#btndelete").click(function() {
		if(confirm("회원정보를 삭제하시겠습니까?")) {
		         location.href = "/user/delete";/*?userno=";  */
		}
	})
}) */

</script>



<style type="text/css">
@font-face {
    font-family: 'GmarketSansMedium';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansMedium.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
@font-face {
	font-family: 'dalseo';
	src: url('/resources/css/DalseoHealingBold.ttf') format('truetype');
}

.btndiv{
	width:190px;
	margin: 0 auto;

}
#detail{
	font-family: 'GmarketSansMedium';
	margin-left:15%;
	width:400px;
	font-size: 15px;
	background-color: :#BFDCFB;
}

h1{
	font-family:'dalseo';
	margin-top: 9%;
	 margin-left:35%; 
	width:500px;
	font-family:'dalseo';

}

button { 
    border: none;
    border-radius: 5px;
    box-shadow: 0 2px 2px rgba(0, 0, 0, 0.2);
    font-weight: 600;
    cursor: pointer;
    background-color: #E1FFB1;
    font-family: 'GmarketSansMedium';
    margin-left: 70px;
    padding:5px;
}

#userfont{
font-size: 18px;
    font-family: 'GmarketSansMedium';
}
.line{
width:500px;
margin:0 auto;
background-color:#fff;
border-radius:50px;
border: 1px solid #B6E388;
background-color:#BFDCFB; 
padding: 10px;
}

</style>

</head>
<body>
<div class="line">
<h1>회원 정보</h1>
<hr>
<div id="detail">
<p id="userfont">회원번호 : <%=user.getUserno() %></p>
<p id="userfont">이름 : <%=user.getUsername() %></p>
<p id="userfont">아이디: <%=user.getUserid() %></p>
<p id="userfont">비밀번호: <%=user.getUserpw() %></p>
<p id="userfont">닉네임 : <%=user.getNick() %></p>
<p id="userfont">성별 : <%=user.getGender() %></p>
<p id="userfont">주소 : <%=user.getAddress() %></p>
<p id="userfont">전화번호 : <%=user.getPhone() %></p>
<p id="userfont">생년월일 : <%=user.getBirth() %></p>
<p id="userfont">이메일 : <%=user.getEmail() %></p>
<p id="userfont">가입날짜 : <%=user.getJoinday() %></p>
<%-- <p id="userfont">회원정보수정일 : <%=user.getUserupdate() %></p> --%>
<p id="userfont">등급 : <%=user.getGradeno() %></p>


<br>
</div>
<div class="btndiv">
	<a href="/user/list"><button id="btnList">목록</button></a>
	<!-- <a href="/mypage/update"><button id="btnupdate">수정</button></a> -->
	<!-- <button id="btndelete">삭제</button> -->
</div>
</div>
</body>
</html>
<jsp:include page="../../layout/footer.jsp"/>