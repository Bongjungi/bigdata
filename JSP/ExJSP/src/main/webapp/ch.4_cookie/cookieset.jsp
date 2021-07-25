<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3c//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		Cookie cookie = new Cookie("cookieN","cookieV");
		cookie.setMaxAge(60*60); //쿠키 1시간 유지
		response.addCookie(cookie);
	%>
	<a href="cookieget.jsp">cookie get</a>
</body>
</html>