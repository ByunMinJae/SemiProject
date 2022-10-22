<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%	int res = (int)request.getAttribute("res"); %>

<%	if( res > 0 ) { %>
이미 존재하는 비밀번호 입니다.
<%	} else { %>
true
<%	} %>