<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function winclose(){
		//opener - 이 팝업창을 열게 한 것
		opener.document.form1.num.value = document.form1.num.value;
		window.close();
	}
</script>
</head>
<body>
	<%
		int num = Integer.parseInt(request.getParameter("num"));
	%>
	<h2><%=num%>단</h2>	
	<%
		for(int i=1;i<10;i++){%>
			<!-- out.println(num+"*"+i+"="+num*i+"<br>") -->
			<%=num + "*" + i + "=" + num*i%><br>
		<%} %>
	<form name="form1">
		메인창에 전달할 값
		<input type="text" name="num">
		<input type="button" value="닫기" onclick="winclose()">
	</form>
</body>
</html>