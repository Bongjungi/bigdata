<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="student" class="ex.Student" scope="page"/>
<jsp:setProperty name="student" property="name" value="홍길동"/>
<jsp:setProperty name="student" property="age" value="20"/>
<jsp:setProperty name="student" property="grade" value="4"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%= 1+2 %><br/>
	${1+2}<br/>
	이름 : <jsp:getProperty name="student" property="name"/><br/>
	나이 : <jsp:getProperty name="student" property="age"/><br/>
	학년 : <jsp:getProperty name="student" property="grade"/><br/>
	<hr/>
	이름 : ${student.name}<br/>
	나이 : ${student.age}<br/>
	학년 : ${student.grade}<br/>
	
	
	
</body>
</html>