<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<style type="text/css">
.nf {
    font-size: 5px;
    color: red;
    position: relative;
    left: 38px;
}
</style>

<%	if( "".equals(request.getParameter("userName")) ) { %>
		<p class="nf">이름을 입력해 주세요.</p>
<%	} else { %>
		<p class="nf">해당 정보로 가입된 아이디가 없습니다. 다시 확인해 주세요.</p>
<%	} %>