<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%!
		String id, pw;
	%>
	<%
		id = request.getParameter("id");
		pw = request.getParameter("pw");
	%>
	<%=id %>
	<%=pw %>
	<h1>������</h1>
	<jsp:include page="sub2.jsp" flush="true"/> <!-- sub2.jsp�� ���� -->
</body>
</html>