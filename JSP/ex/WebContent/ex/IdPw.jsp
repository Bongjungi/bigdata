<%@page import="ex.ChangeChar"%>
<%@page import="ex.IdPw"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% String id = request.getParameter("id").trim().replaceAll(" ", ""); %>
	<% String pw = request.getParameter("pw").trim().replaceAll(" ", ""); %>
	<%
		IdPw ip = IdPw.getInstance();
		ChangeChar cc = ChangeChar.getInstance();
		String cpw= cc.chChar(13, 2537, pw);
		ip.idpwinsert(id, cpw);
	%>
</body>
</html>