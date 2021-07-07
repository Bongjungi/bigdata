<%@page import="ex.ChangeChar"%>
<%@page import="ex.IdPw"%>
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
		String id=request.getParameter("id").trim().replaceAll(" ", ""); 
		String pw=request.getParameter("password").trim().replaceAll(" ", "");
		IdPw ip = IdPw.getInstance();
		ChangeChar cc = ChangeChar.getInstance();
		String cpw=cc.chChar(13, 2537, pw);
	 	int result = ip.login(id,cpw);
	 	if(result == 0){%>
	 		<b>로그인 완료</b>
	 	<%}else{%>
	 		<b>아이디를 생성해 주세요.</b>
	 	<%}
	%>
	
</body>
</html>