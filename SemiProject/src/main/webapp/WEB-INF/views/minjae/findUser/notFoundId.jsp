<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style type="text/css">
p.nfmsg {
    font-size: 5px;
    color: red;
    position: relative;
    left: 38px;
}
</style>

<%	if( "".equals(request.getAttribute("userId")) ) { %>
		<p class="nfmsg">아이디를 입력해 주세요!</p>
<%	} else { %>
		<p class="nfmsg">해당 정보로 가입된 회원이 없습니다. 다시 확인해 주세요!</p>
<%	} %>