<%@page import="com.lec.dao.Member2Dao"%>
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
		String id = request.getParameter("id");
		Member2Dao dao = Member2Dao.getInstance();
		int result = dao.idConfirm(id);
		if(result == Member2Dao.EXISTENT){
	%>		<b>중복된 ID입니다.</b>
	
		<%}else{%>
			<b>사용 가능한 아이디입니다.</b>
		<%}
	%>
		<!-- <b>파라미터로 온 ID : <%=id %></b> -->
</body>
</html>