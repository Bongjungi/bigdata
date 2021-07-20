<%@page import="ex.IIdPw"%>
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
	<% String tel = request.getParameter("tel").trim().replaceAll(" ", ""); %>
	<% String address = request.getParameter("address").trim().replaceAll(" ", ""); %>
	<% String gender = request.getParameter("gender").trim().replaceAll(" ", ""); %>
	<% String email = request.getParameter("email").trim().replaceAll(" ", ""); %>
	<%
		IIdPw ip = IdPw.getInstance();
		String cpw= ip.chChar(13, 2537, pw);
		ip.idpwinsert(id, cpw, tel, address, gender, email);
	%>
	<b>회원가입 완료</b>
</body>
</html>