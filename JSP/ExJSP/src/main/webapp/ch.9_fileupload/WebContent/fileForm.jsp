<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 이곳의 WebContent의 fileFolder가 아닌 tomcat의 fileFolder에 파일이 올라간다. -->
	<form action="fileFormOk.jsp" method="post" enctype="multipart/form-data">
		파일 : <input type="file" name="file"><br/>
		<input type="submit" value="File Upload">
	</form>
</body>
</html>