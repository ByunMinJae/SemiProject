<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	int resPhone = (int)request.getAttribute("resPhone"); %>

<%	if( resPhone > 0 ) { %>
이미 사용중인 전화번호 입니다.
<%	} else { %>
true
<%	} %>