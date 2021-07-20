<%@page import="ex.ReturnChar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% int p = Integer.parseInt(request.getParameter("p"));%>
<% int q = Integer.parseInt(request.getParameter("q"));%>
<% int e = Integer.parseInt(request.getParameter("e"));%>
<% String m = request.getParameter("message").trim().replaceAll(" ", ""); %>
<%
	ReturnChar rc = ReturnChar.getInstance();
	String result = rc.reChar(p, q, e, m);
%>
<%=result %>
</body>
</html>