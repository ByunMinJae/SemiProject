<%@page import="minjae.dto.MpMain"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%	MpMain mpMain = (MpMain)request.getAttribute("mpMain"); %>

<%@	include file="../../layout/header.jsp" %>

<style type="text/css">
#mpmWrap {
	width: 1100px;
    height: 600px;
    margin: 0px auto;
    text-align: center;
    position: relative;
}
#mpmLeft {
	width: 40%;
	height: 100%;
	float: left;
	background: #ddd;
}
#userInfo {
	padding-top: 66px;
}
#mpmRight {
	margin-top: 88px;
	width: 55%;
	float: right;
	position: relative;
    top: -28px;
}
#userImg {
	width: 300px;
	height: 200px;
	background: url("/resources/image/user_profile.png") no-repeat 0 0;
}
#md {
	text-decoration: none;
	color: #555;
}
#md:hover {
	cursor: pointer;
	color: #54abdf;
}
ul#ul_left {
	margin: 68px 71px;
    padding: 0;
    text-align: -webkit-center;
}
li.info_left {
	font-size: 40px;
	font-weight: bold;
	color: #555;
}
#userDetail, #gradeDetail {
	border: 1px solid #ccc;
	height: 200px;
}
#gradeDetail {
	margin-top:  50px;
}
</style>

<div id="mpmWrap">

<!-- 왼쪽 영역 -->
<div id="mpmLeft">
	<!-- 유저 정보 영역 -->
	<div id="userInfo">
		<ul id="ul_left">
			<li><div id="userImg"></div></li>
			<li class="info_left"><a id="md" href="/mypage/detail"><%=mpMain.getNick() %></a></li>
			<li class="info_left" style="font-size: 15px;"><%=mpMain.getGradename() %></li>
		</ul>
	</div>
</div>
<!-- 오른쪽 영역 -->
<div id="mpmRight">
	<div id="userDetail">
		<ul>
			<li>아이디 : <%=mpMain.getUserid() %></li>
			<li>닉네임 : <%=mpMain.getNick() %></li>
			<li>전화번호 : <%=mpMain.getPhone() %></li>
			<li>이메일 : <%=mpMain.getEmail() %></li>
			<li>주소 : <%=mpMain.getAddress() %></li>
		</ul>
	</div>
	<div id="gradeDetail">
		<ul>
			<li>등급 : <%=mpMain.getGradename() %></li>
			<li>게시글 수</li>
			<li>최근 게시글</li>
		</ul>
	</div>
</div>

</div>

<jsp:include page="../../layout/footer.jsp"/>











