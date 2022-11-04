<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<style type="text/css">
p.nfe {
    font-size: 13px;
    color: red;
    position: relative;
    left: 3px;
/*     top: 3px; */
    display: inline-block;
}
</style>

<%	if( "".equals(request.getParameter("userEmail")) ) { %>
		<p class="nfe" style="top: 3px; left: 30px;">이메일을 입력해 주세요.</p>
<%	} else { %>
		<p class="nfe" style="top: -21px; left: 3px;">해당 이메일로 가입된 아이디가 없습니다. 다시 확인해 주세요.</p>
<%	} %>