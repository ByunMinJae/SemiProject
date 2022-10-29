<%@page import="minjae.dto.BoardInfoCate"%>
<%@page import="java.util.List"%>
<%@page import="minjae.dto.MpMain"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%	MpMain mpMain = (MpMain)request.getAttribute("mpMain"); %>
<%	List<BoardInfoCate> bicList  = (List)request.getAttribute("boardICList"); %>

<%@	include file="../../layout/header.jsp" %>

<!-- + jQuery UI 1.13.2 CDN -->
<script type="text/javascript" src="https://code.jquery.com/ui/1.13.2/jquery-ui.min.js"></script>

<!-- + jQuery UI Base Theme CDN -->
<link type="text/css" rel="stylesheet" href="https://code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">

<script type="text/javascript">
$(document).ready(function() {
	
	//회원정보 수정 버튼 클릭 시 다이얼로그 open
	$("#btnDialog").click(function() {
		$("#pwcheck").dialog( "open" );
	})
	
	//다이얼로그 옵션 설정하기
	$("#pwcheck").dialog({
		autoOpen: false 	//기본 모습 숨기기 설정
		, draggable: false 	//이동 불가 설정
		, width: 360		//너비 지정
		, height: 240		//높이 지정
		, title: "본인확인"
		, modal: true
		, buttons: [
			{
				text:"확인"
				, icon: "ui-icon-check"
				, click: function() {
					
					$.ajax({
						type: "post"					//요청 메소드
						, url: "/mypage/pwcheck"			//요청 URL
						, data: {						//요청 파라미터
							pw: $("#pw").val()
						}
						, dataType: "html"				//응답 데이터 형식
						, success: function( res ) {
							console.log("AJAX 성공")
							console.log(res)
							
							if( $.trim(res) == "true" ) {
								//true일 때 회원정보 수정 페이지로 이동
								alert("확인 되었습니다.")
								location.href = "/mypage/update";
								
							} else {
								//아닐 때 확인 메시지 띄우기
								$("#check_msg").html(res);
							}
							
						}
						
					})
					
				}
			}
		]
	})
	
})
</script>

<style type="text/css">
#wrapper {
	background-color: #BFDCFB;
}
#mpmWrap {
	width: 1100px;
    height: 597px;
    margin: 18px auto;
    text-align: center;
    position: relative;
    font-family: 'GmarketSansMedium';
}
#mpmLeft {
	width: 40%;
	height: 665px;
	float: left;
	background: #e0fdc9;
	position: absolute;
}
#userInfo {
	padding-top: 54px;
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
	color: #36871b;
}
ul#ul_left {
	list-style: none;
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
    border-radius: 20px;
	text-align: left;
	background: #fcffbe;
}
#userDetail {
	height: 200px;
}
#gradeDetail {
	height: 290px;
	margin-top:  24px;
}
#userUpdate {
	float: right;
    margin: 10px 17px 0 0;
}
#userUpdate a {
    text-decoration: none;
    color: #000;
}
#userUpdate a:hover {
    color: #3fbf28;
}
.rContant {
	list-style: none;
	margin: 0 auto;
	font-size: 18px;
    font-weight: bold;
}
.rContant li {
	margin: 7px 0 0 18px;
}
.rContant li.b {
	display: inline-block;
}
.rc {
	margin-top: 26px;
}
#boardcon {
	width: 230px;
	overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
}
#rTable {
    margin: 4px auto 0;
    width: 571px;
    height: 160px;
    font-size: 14px;
    font-weight: bold;
    border: 1px solid #cfcfcf;
    border-collapse: collapse;
    background: #fff;
}
.b {
	border-right: 1px solid #cfcfcf;
}
.ib {
	display: inline-block;
}
#btnDialog {
	width: 110px;
    font-weight: bold;
    background: #fff;
    border-radius: 5px;
    border: 1px solid #cfcfcf;
    cursor: pointer;
    box-shadow: 0 2px 2px rgba(0, 0, 0, 0.2);
}
#btnDialog:hover {
	background: linear-gradient(#d7e1cf, #b3b3b3);
}
#back {
	float: left;
    position: relative;
	top: -62px;
    left: 35px;
    text-decoration: none;
    font-weight: bold;
    color: #555;
}
#back:hover {
	color: #000;
}
#arrow {
	background: url("/resources/image/left_arrow.png") no-repeat 0 0;
	width: 20px;
    height: 20px;
    position: relative;
    top: -43px;
    left: 15px;
}
</style>

<div id="mpmWrap">

<!-- 왼쪽 영역 -->
<div id="mpmLeft">
	<!-- 유저 정보 영역 -->
	<div id="userInfo">
		<div id="arrow"></div>
		<a id="back" href="/mypage/main">뒤로가기</a>
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
		<div id="userUpdate">
			<button id="btnDialog">회원정보 수정</button>
		</div>
		<ul class="rContant rc">
			<li>아이디 : <%=mpMain.getUserid() %></li>
			<li>닉네임 : <%=mpMain.getNick() %></li>
			<li>전화번호 : <%=mpMain.getPhone() %></li>
			<li>이메일 : <%=mpMain.getEmail() %></li>
			<li>주소 : <%=mpMain.getAddress() %></li>
		</ul>
	</div>
	<div id="gradeDetail">
		<ul class="rContant rc">
			<li class="ib" style="margin-left: 73px;">등급 : <%=mpMain.getGradename() %></li>
			<li class="ib" style="margin-left: 110px;">게시글 수 : <%=bicList.size() %></li>
			<li style="margin: 28px 0 0 -18px;">최근 게시글</li>
		</ul>
		<table id="rTable">
		<%	for(int i=0; i<bicList.size(); i++) { %>
		<tr class="rTd">
			<td class="b"><%=bicList.get(i).getBoardno() %></td>
			<td class="b"><%=bicList.get(i).getBoardtitle() %></td>
			<td class="b"><div id="boardcon"><%=bicList.get(i).getBoardcon() %></div></td>
			<td class="b"><%=bicList.get(i).getCategoryname() %></td>
			<td class="b"><%=bicList.get(i).getBoarddate() %></td>
		</tr>
			<%	if( i == 4 ) break; %>			
		<%	} %>
		</table>
	</div>
</div>

</div>

<!-- dialog DIV -->
<div id="pwcheck" title="dialog test">

	<p style="font-size: 14px;">회원정보 수정을 위해 본인확인을 해주세요.</p>
	<label for="pw">비밀번호 : </label>
	<input type="text" id="pw" name="pw" onFocus="this.value=''; return true;">
	<input type="text"  hidden="">
	<!-- 확인 메시지 태그 -->
	<p id="check_msg" style="color: red; font-size: 12px; margin: 3px 0 0 74px;"></p>
	
</div>

<jsp:include page="../../layout/footer.jsp"/>











