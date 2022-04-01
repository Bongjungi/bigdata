<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
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
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String qs = request.getQueryString();
	%>
	<%
		String name1 = qs.substring(qs.indexOf("%"), qs.indexOf("&"));
		String name2 = URLDecoder.decode(name1,"euc-kr");
	%>
		이름 : <%=name%><br>
		이름 : <%=name1%><br>
		이름 : <%=URLDecoder.decode(name1,"ISO-8859-1")%><br>
		이름 : <%=name2%><br>
		이름 : <%=URLDecoder.decode(name1,"utf-8")%><br>
		나이: <%=age%><br>
		쿼리스트링 : <%=qs %><br>
		name과name2는 같나 : <%=name.equals(name2)%><br>
		
</body>
</html>