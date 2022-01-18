<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	pageContext.setAttribute("result", "이건");
%>
<body>
	<%=request.getAttribute("result") %>입니다.<br>
	${result}<br>
	${requestScope.result}<br>
	${list[0]}<br>
	${map.title}<br>
	${param.n gt 3}<br>
	${not empty param.n} <!-- empty는 'null이거나 빈문자열 '-->
	${header.accept}
	
</body>
</html>