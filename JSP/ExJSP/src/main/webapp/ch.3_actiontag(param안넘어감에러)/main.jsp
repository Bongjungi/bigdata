<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	main.jsp �������Դϴ�.
	<jsp:forward page="sub.jsp"> <!-- sub.jsp�� ��ȯ -->
		<jsp:param name="id" value="abc"/>
		<jsp:param name="pw" value="123"/>
	</jsp:forward>
</body>
</html>