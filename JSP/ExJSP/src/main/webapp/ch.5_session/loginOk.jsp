<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		if(id.equals("abcde")&&pw.equals("12345")){
			session.setAttribute("id",id);
			response.sendRedirect("welcome.jsp");
		}else{
			response.sendRedirect("login.html");
		}
	%>
</body>
</html>