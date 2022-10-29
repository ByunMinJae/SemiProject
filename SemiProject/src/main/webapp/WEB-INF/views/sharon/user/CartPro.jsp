<%@page import="sharon.dto.Cart"%>
<%@page import="sharon.dto.Product"%>
<%@page import="sharon.dto.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Product prod = (Product) request.getAttribute("prod"); %>


 
<script>
	alert("<%=prod.getProdname()%>를 장바구니에 담았습니다."); 
	location.href = "/cart/list";
</script>