<%@page import="minjae.dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%	List<Product> list = (List)request.getAttribute("goodsCateList"); %>
    
<%	for(int i=0; i<list.size(); i++) { %>
<a id="goodsImg" href="/goods/detail?prodno=<%=list.get(i).getProdno() %>">
	<img id="prodImg" alt="" src="/resources/image/<%=list.get(i).getProdimage() %>">
</a>
<ul id="goodsList">
	<li><%=list.get(i).getProdname() %></li>
	<li><%=list.get(i).getProdprice() %>์</li>
	<li>ํ๋งค๋ : <%=list.get(i).getProdpop() %></li>
</ul>
<%	} %>