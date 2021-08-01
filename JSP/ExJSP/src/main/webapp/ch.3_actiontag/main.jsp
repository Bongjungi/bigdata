<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	main.jsp 페이지입니다.
	<jsp:forward page="sub.jsp"> <!-- sub.jsp로 전환 -->
		<jsp:param name="id" value="abc"/>
		<jsp:param name="pw" value="123"/>
	</jsp:forward>
</body>
</html>