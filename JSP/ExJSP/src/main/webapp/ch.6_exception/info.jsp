<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ page errorPage="errorPage.jsp" %>
<!-- web.xml에 작성하는 방법

<error-page>
	<error-code>404</error-code>
	<location>/error404.jsp</location>
</error-page>
<error-page>
	<error-code>500</error-code>
	<location>/error500.jsp</location>
</error-page>

 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<% int i = 40/0;%>
</body>
</html>