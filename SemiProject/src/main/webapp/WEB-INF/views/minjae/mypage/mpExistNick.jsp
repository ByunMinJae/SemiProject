<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	int resNick = (int)request.getAttribute("resNick"); %>

<%	if( resNick > 0 ) { %>
이미 사용중인 닉네임 입니다.
<%	} else { %>
true
<%	} %>