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
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name"); 
		String gender = request.getParameter("gender");
		String[] hobbys = request.getParameterValues("hobby");
	%>
	이름 : <%=name%><br>
	성별 : <%=gender%><br>
	취미 : 
	<%
		if(hobbys!=null){
			for(String hobby : hobbys){
				out.println(hobby);
			}
		}else{
			out.println("없음");
		}
	%>
</body>
</html>