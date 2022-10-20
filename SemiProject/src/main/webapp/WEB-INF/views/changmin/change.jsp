<%@page import="changmin.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% User loginUser = (User) request.getAttribute("loginUser"); %>
<%=loginUser.getAddress() %>
test
