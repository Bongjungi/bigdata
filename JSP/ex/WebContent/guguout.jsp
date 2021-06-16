<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% int su = Integer.parseInt(request.getParameter("su")); %>
	<h1>원하시는 <%=su %>단 구구단 출력</h1>
	<% for(int i=1;i<=9;i++){%>
		<%=su %>*<%=i %>=<%=su*i%><br>
	<%}%>

</body>
</html>