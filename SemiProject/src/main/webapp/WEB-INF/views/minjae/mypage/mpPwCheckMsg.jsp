<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	boolean res = (boolean)request.getAttribute("res"); %>

<%	if( res ) { %>
true
<%	} else { %>
틀렸습니다. 비밀번호를 확인해 주세요!
<%	} %>