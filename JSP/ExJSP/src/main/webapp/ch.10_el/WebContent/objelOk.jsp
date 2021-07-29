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
		String pw = request.getParameter("pw");
	%>
	<%=id %><br/>
	<%=pw %><br/>
	${param.id}<br/>
	${param.pw}<br/>
	<hr/>
	applicationScope : ${applicationScope.application_name}<br/>
	sessionScope : ${sessionScope.session_name}<br/>
	requestScope(여기서  request를 set하지 않았기 때문에 안 나올 것) : ${requestScope.request_name}<br/>
	pageScope(같은 이유) : ${pageScope.page_name}<br/>
	<hr/>
	context 초기화 파라미터<br/>
	${initParam.con_name}<br/>
	${initParam.con_id}<br/>
	${initParam.con_pw}<br/>
	
</body>
</html>