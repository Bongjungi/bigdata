<!-- 
	%@ include file="페이지 주소" - 1개의 클래스로 컴파일됨(변수 공유 가능)
	jsp:include page="페이지 주소" - 2개의 클래스로 컴파일됨(변수 공유 불가)		
 -->
<%@page import="ch01.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file = "sub.jsp"%>
<style>
	body{
		background : <%=background%>
	}
</style>
</head>
<body>
	<h2>max : <%=Constants.MAX %></h2>
	<h2>msg : <%=msg%></h2>
</body>
</html>