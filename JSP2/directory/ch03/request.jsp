<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="/jsp/ch03_servlet/request.do">
		이름 : <input name="name"><br>
		나이 : <input name="age"><br>
		성별 : <input type="radio" name="gender" value="m">남
			<input type="radio" name="gender" value="f">여<br>
		취미 : <select name="hobby">
				<option value="health">헬스</option>
				<option value="cook">요리</option>
				<option value="sleep">잠</option>
			</select>
		<input type="submit" value="확인">
	</form>
</body>
</html>