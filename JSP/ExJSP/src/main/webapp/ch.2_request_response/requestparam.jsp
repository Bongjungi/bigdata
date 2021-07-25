<%@page import="java.util.Arrays"%>
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
		request.setCharacterEncoding("EUC-KR");
		String str=request.getParameter("num");
		int num = Integer.parseInt(str);
		String[] hobbys=request.getParameterValues("hobby");
		
		if(num==30){
			response.sendRedirect("pass.jsp?num="+num);
		}else{
			response.sendRedirect("ng.jsp?num="+num);
		}
	%>
	<%=num%>
	<%=Arrays.toString(hobbys)%>
</body>
</html>