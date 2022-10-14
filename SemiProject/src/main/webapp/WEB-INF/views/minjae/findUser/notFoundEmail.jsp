<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<style type="text/css">
p {
    font-size: 5px;
    color: red;
    position: relative;
    left: 38px;
}
</style>

<%	if( "".equals(request.getParameter("userEmail")) ) { %>
		<p>이메일을 입력해 주세요!</p>
<%	} else { %>
		<p>해당 이메일로 가입된 아이디가 없습니다. 다시 확인해 주세요!</p>
<%	} %>