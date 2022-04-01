<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String str="hello jsp";
	%>
	<h2>message : <%=str%></h2>
	<%
		for(int i=1;i<4;i++){
			out.println("<h"+i+">"+str+" 쿠</h"+i+">");
		}
	%>
	<%
		Date nowDate = new Date();
		out.println(nowDate+"<br>");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 a HH:mm:ss");
		String formatDate = sdf.format(nowDate); 
	%>
	현재 날짜는 <%=formatDate%>입니다.
</body>
</html>