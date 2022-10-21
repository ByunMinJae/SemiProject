<%@page import="minjae.dto.MpMain"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	MpMain mpMain = (MpMain)request.getAttribute("mpMain"); %>
 
<%@	include file="../../layout/header.jsp" %>



<style type="text/css">
#mpuWrap {
	width: 1100px;
    height: 600px;
    margin: 0px auto;
    text-align: center;
    position: relative;
}
#mpuContents {
	width: 800px;
	height: 639px;
    margin: 0px auto;
    background: #fcffb282;
    border: 1px solid #ccc;
}
</style>

<div id="mpuWrap">

<div id="mpuContents">



</div>

</div>

<jsp:include page="../../layout/footer.jsp"/>












