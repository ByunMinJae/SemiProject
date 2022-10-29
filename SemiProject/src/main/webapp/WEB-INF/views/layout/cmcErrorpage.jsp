<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@	page isErrorPage="true" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
@font-face {
    font-family: 'GmarketSansMedium';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansMedium.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
#errorWrap {
	width: 1000px;
    height: 600px;
    margin: 0 auto;
    text-align: center;
}
#errorImg {
	margin: 194px 0 0;
}
#errorText {
	width: 600px;
    margin: 0 auto;
    font-family: 'GmarketSansMedium'
}
</style>
</head>
<body>
<div id="errorWrap">

<div id="errorImg">
<img alt="" src="/resources/image/logo.png">
</div>
<div id="errorText">
<h1 style="color: red;">웹페이지를 찾을 수 없습니다.</h1>
<hr>

<h3>에러 내용</h3>

<%=exception %>
</div>

</div>

</body>
</html>