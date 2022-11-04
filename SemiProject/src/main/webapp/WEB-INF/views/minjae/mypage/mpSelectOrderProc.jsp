<%@page import="minjae.dto.MpMainRight"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	MpMainRight mpMRselect = (MpMainRight)request.getAttribute("mpMR"); %>

<div class="cnt_no" style="right: 408px;"><p><%=mpMRselect.getDelCnt() %></p></div>
<div class="cnt_no" style="right: 239px;"><p><%=mpMRselect.getDelComCnt() %></p></div>
<div class="cnt_no" style="right: 73px;"><p><%=mpMRselect.getExchanCnt() %></p></div>

