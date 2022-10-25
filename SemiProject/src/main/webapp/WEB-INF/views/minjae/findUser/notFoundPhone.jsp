<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style type="text/css">
.n {
 	font-size: 13px;
    color: red;
    position: relative;
    left: 38px;
    top: 4px;
}
.nf {
    font-size: 13px;
    color: red;
    position: relative;
    left: 38px;
    display: inline-block;
    top: -22px;
    left: 3px;
}
</style>   

<%	if( "".equals(request.getParameter("userPhone")) ) { %>
		<p class="n">전화번호를 입력해 주세요.</p>
<%	} else { %>
		<p class="nf">해당 정보로 가입된 아이디가 없습니다. 다시 확인해 주세요.</p>
<%	} %>