<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%-- 주석
	<%@ 지시자 : page(페이지 속성 지정), include(별도의 페이지를 현재 페이지에 삽입), taglib(태그라이브러리의 태그 사용)  %>
	 ex) <%@ include file="include1.jsp" %>, 
	<%! 선언 : 변수, 메소드 선언 %>
	<%= 표현식 : 결과값 출력 %>
	<% 스크립트릿 : JAVA 코드 %>
	<jsp:action> 액션태그 : 자바빈 연결 </jsp:action>
jsp 동작 원리 : 웹브라우저 요청 -> jsp를 servlet으로 -> servlet을 class로 -> 웹브라우저 응답

getContextPath() : 웹어플리케이션의 컨텍스트 패스를 얻습니다.
getMethod() : get방식과 post방식을 구분할 수 있습니다.
getSession() : 세션 객체를 얻습니다.
getProtocol() : 해당 프로토콜을 얻습니다.
getRequestURL() : 요청 URL를 얻습니다.
getRequestURI() : 요청 URI를 얻습니다.
getQueryString() : 쿼리스트링을 얻습니다.

request.setCharacterEncoding("EUC-KR")
request.getParameter(String name) : name에 해당하는 파라미터 값을 구함
request.getParameterNames() : 모든 파라미터 이름을 구함
request.getParameterValues(String name) : name에 해당하는 파라미터 값들을 구함.(ex. String[] hobbys = re.get(String hobby)

response.getCharacterEncoding() :응답할때 문자의 인코딩 형태를 구함
response.addCookie(Cookie) : 쿠키를 지정합니다.
response.sendRedirect(URL) :지정한 URL로 이동합니다.

액션태그 - forward, include, param
<jsp:forward page="sub.jsp">
	<jsp:param name="a" value="b"/>
</jsp:forward>
<jsp:include page="sub2.jsp/>

쿠키 : 연결이 끊겼을 때 정보를 지속적으로 유지하기 위한 수단. 서버에서 생성되어 클라이언트 측에 저장. 서버에 요청할 때마다 쿠키의 속성값을 참조 또는 변경할 수 있음
  setMaxAge() : 쿠키의 유효기간 설정
  setPath() : 쿠키사용의 유효디렉토리를 설정
  setValue() : 쿠키의 값을 설정 *********
  setVersion() : 쿠키의 버전을 설정
  get .. () : .. 얻음

세션: 쿠키처럼 서버와의 관계를 유지하기 위한 수단. 서버상에 객체로 존재
  setAttribute() : 세션에 데이터를 저장합니다.
  getAttribute() : 세션에서 데이터를 얻습니다.
  getAttributeNames() : 세션에 저장되어 있는 모든 데이터의 이름(유니크한 키값)을 얻습니다.
  getId() : 자동 생성된 세션의 유니크한 아이디를 얻습니다.
  isNew() : 세션이 최초 생성되었는지, 이전에 생성된 세션인지를 구분합니다.
  getMaxInactiveInterval() : 세션의 유효시간을 얻습니다. 가장 최근 요청시점을 기준으로 카운트됩니다.
  removeAttribute() : 세션에서 특정 데이터 제거합니다.
  invalidate() : 세션의 모든 데이터를 삭제합니다.
  
 예외 페이지 처리 : 
 	1.<%@page errorPage="errorPage.jsp"%>
 	2.<%@page isErrorPage="true"%>
 		<% response.setStatus(200);%>
 		<%=exception.getMessage()%>
 자바 빈: useBean, setProperty, getProperty
 	<jsp:useBean id="student" class="com.javalec.ex.student" scope="page"/> 
	scope - page : 생성된 페이지 내에서만 사용 가능
	request : 요청된 페이지 내에서만 사용 가능
	session : 웹브라우저의 생명주기와 동일하게 사용 가능
	application : 웹 어플리케이션 생명주기와 동일하게 사용 가능
	<jsp:setProperty name="student" property="name" value="홍길동"/>
	<jsp:getProperty name="student" property="name"/>
커넥션 풀 : 데이터베이스 부하를 막기 위해 커넥션을 미리 만들어 놈
	tomcat의 context.xml의 <context></context>에
	<Resource
	 auth="Container"
	 driverClassName = "oracle.jdbc.driver.OracleDriver"
	 url = "jdbc:oracle:thin:@localhost:1521:xe"
	 username = "scott"
	 password = "tiger"
	 name = "jdbc/Oracle11g"
	 type = "javax.sql.DataSource"
	 maxActive = "50"
	 maxWait = "1000"
	 />
	 DAO에서 
	 //1.Class.forName("oracle.jdbc....)
	 //2.conn=DriverManager.getConnection(url,uid,upw)                 이것들 대신에
	 
	   private DataSource dataSource;
	 1.Context context = new InitialContext(); 
	   dataSource = (DataSource)context.lookup("javax:comp/env/jdbc/Oracle11g"); 
	 2.conn=dataSource.getConnection();                                  이것들 사용
	 
파일 업로드 :
	1. www.servlets.com에 가서 cos.jar를 다운받아 webcontent의 web-inf에 넣고, filefolder를 생성한 뒤에 작업을 수행한다.
	2. 업로드된 파일은 webcontent의 filefolder가 아닌 tomcat의 filefolder에 있다.
 --%>
 <%!
 	int i = 10;
 	public int sum(int a, int b){
 		return a+b;
 	}
 	
 	//public static void main(String[] args) {
 	//	System.out.println("1");
 	//}
 %>
 <%
 	out.println("i = "+i+ "<br/>");
 	out.println("sum = "+sum(1,5)+ "<br/>");
 	int i=0;
 	out.println(i);
 	%><%=i%><%=sum(1,6)%><%
 %>
 <%
 	out.println("서버 : "+ request.getServerName()+"<br/>");
 	out.println("포트번호 : "+ request.getServerPort()+"<br/>");
 	out.println("요청방식 : "+ request.getMethod()+"<br/>");
 	out.println("프로토콜 : "+ request.getProtocol()+"<br/>");
 	out.println("URL : "+ request.getRequestURL()+"<br/>");
 	out.println("URI : "+ request.getRequestURI()+"<br/>");
 	
 %>
</body>
</html>
