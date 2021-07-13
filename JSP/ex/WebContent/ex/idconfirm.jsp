
<%@page import="ex.IdPw"%>
<%@page import="ex.IIdPw"%>
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
 	String id=request.getParameter("id");
 	IIdPw ip = IdPw.getInstance();
 	int result = ip.idConfirm(id);
 	if(result == 0){%>
 		<b>중복된 ID입니다.</b>
 	<%}else{%>
 		<b>사용 가능한 아이디 입니다.</b>
 	<%}%>
 
 
 
</body>
</html>