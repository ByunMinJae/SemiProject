<%@page import="sharon.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../layout/header.jsp" %>
<%	User user= (User) request.getAttribute("user");%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원상세정보</title>
<script type="text/javascript">
$(document).ready(function() {
	
	$("#btndelete").click(function() {
		
		if(confirm("회원정보를 삭제하시겠습니까?")) {
		         location.href = "/user/delete";/*?userno=";  */
		}
	})
})

</script>



<style type="text/css">


#detail,.text-center{
	font-family: 'GmarketSansMedium';
	margin-top: 5%;
	margin-left:30%;
	width:500px;
	font-size: 15px;
}

h1{
	font-family:'dalseo';
	margin-top: 5%;
	 margin-left:30%; 
	width:500px;

}

button { 
    border: none;
    border-radius: 5px;
    box-shadow: 0 2px 2px rgba(0, 0, 0, 0.2);
    font-weight: 600;
    cursor: pointer;
    background-color: #E1FFB1;
    font-family: 'GmarketSansMedium';
}


</style>

</head>
<body>

<h1>회원 정보</h1>
<hr>
<div id="detail">
<p>회원번호 : <%=user.getUserno() %></p>
<p>이름 : <%=user.getUsername() %></p>
<p>아이디: <%=user.getUserid() %></p>
<p>닉네임 : <%=user.getNick() %></p>
<p>성별 : <%=user.getGender() %></p>
<p>주소 : <%=user.getAddress() %></p>
<p>전화번호 : <%=user.getPhone() %></p>
<p>생년월일 : <%=user.getBirth() %></p>
<p>이메일 : <%=user.getEmail() %></p>
<p>가입날짜 : <%=user.getJoinday() %></p>
<p>회원정보수정일 : <%=user.getUserupdate() %></p>
<p>등급 : <%=user.getGradeno() %></p>


<br>
</div>
<div class="text-center">
	<a href="/user/list"><button id="btnList">목록</button></a>
	<a href="/mypage/update"><button id="btnupdate">수정</button></a>
	<!-- <a href="/mypage/delete"> --><button id="btndelete">삭제</button>
</div>

</body>
</html>
<jsp:include page="../../layout/footer.jsp"/>