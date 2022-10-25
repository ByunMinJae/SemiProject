<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<style type="text/css">
p.nfe {
    font-size: 13px;
    color: red;
    position: relative;
    left: 3px;
    top: -21px;
    display: inline-block;
}
</style>

<%	if( "".equals(request.getParameter("userEmail")) ) { %>
		<p class="nfe">이메일을 입력해 주세요.</p>
<%	} else { %>
		<p class="nfe">해당 이메일로 가입된 아이디가 없습니다. 다시 확인해 주세요.</p>
<%	} %>