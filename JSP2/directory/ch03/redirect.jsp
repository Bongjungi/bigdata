<%@page import="java.net.URLEncoder"%>
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
		String name = URLEncoder.encode("김철수","euc-kr");
		//이걸로 하면 쿼리스트링 가져가야할듯.String name = URLEncoder.encode("김철수","utf-8");
		System.out.println(name);
		response.sendRedirect("redirect_result.jsp?name="+name+"&age=20");
		//잘못된것 - response.sendRedirect("redirect_result.jsp?name=김철수&age=20");
	%>
</body>
</html>