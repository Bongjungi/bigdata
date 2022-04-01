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
		String car = request.getParameter("car");
		String tel = request.getParameter("tel");
	%>
	차량 : <%=car%>
	전화 : <%=tel%>
	<!-- ==은 주소 equals()는 내용 -->
	<%if(car=="bmw"){%>
		<%="==가능"%>
	<%}else{%>
		<%="==불가능"%>
	<%} %>
	<%if(car.equals("bmw")){%>
		<%="equals()가능"%>
	<%}else{%>
		<%="equals()불가능"%>
	<%} %>
</body>
</html>