<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%-- �ּ�
	<%@ ������ : page(������ �Ӽ� ����), include(������ �������� ���� �������� ����), taglib(�±׶��̺귯���� �±� ���)  %>
	 ex) <%@ include file="include1.jsp" %>, 
	<%! ���� : ����, �޼ҵ� ���� %>
	<%= ǥ���� : ����� ��� %>
	<% ��ũ��Ʈ�� : JAVA �ڵ� %>
	<jsp:action> �׼��±� : �ڹٺ� ���� </jsp:action>
jsp ���� ���� : �������� ��û -> jsp�� servlet���� -> servlet�� class�� -> �������� ����

getContextPath() : �����ø����̼��� ���ؽ�Ʈ �н��� ����ϴ�.
getMethod() : get��İ� post����� ������ �� �ֽ��ϴ�.
getSession() : ���� ��ü�� ����ϴ�.
getProtocol() : �ش� ���������� ����ϴ�.
getRequestURL() : ��û URL�� ����ϴ�.
getRequestURI() : ��û URI�� ����ϴ�.
getQueryString() : ������Ʈ���� ����ϴ�.

request.setCharacterEncoding("EUC-KR")
request.getParameter(String name) : name�� �ش��ϴ� �Ķ���� ���� ����
request.getParameterNames() : ��� �Ķ���� �̸��� ����
request.getParameterValues(String name) : name�� �ش��ϴ� �Ķ���� ������ ����.(ex. String[] hobbys = re.get(String hobby)

response.getCharacterEncoding() :�����Ҷ� ������ ���ڵ� ���¸� ����
response.addCookie(Cookie) : ��Ű�� �����մϴ�.
response.sendRedirect(URL) :������ URL�� �̵��մϴ�.

�׼��±� - forward, include, param
<jsp:forward page="sub.jsp">
	<jsp:param name="a" value="b"/>
</jsp:forward>
<jsp:include page="sub2.jsp/>

��Ű : ������ ������ �� ������ ���������� �����ϱ� ���� ����. �������� �����Ǿ� Ŭ���̾�Ʈ ���� ����. ������ ��û�� ������ ��Ű�� �Ӽ����� ���� �Ǵ� ������ �� ����
  setMaxAge() : ��Ű�� ��ȿ�Ⱓ ����
  setPath() : ��Ű����� ��ȿ���丮�� ����
  setValue() : ��Ű�� ���� ���� *********
  setVersion() : ��Ű�� ������ ����
  get .. () : .. ����

����: ��Űó�� �������� ���踦 �����ϱ� ���� ����. ������ ��ü�� ����
  setAttribute() : ���ǿ� �����͸� �����մϴ�.
  getAttribute() : ���ǿ��� �����͸� ����ϴ�.
  getAttributeNames() : ���ǿ� ����Ǿ� �ִ� ��� �������� �̸�(����ũ�� Ű��)�� ����ϴ�.
  getId() : �ڵ� ������ ������ ����ũ�� ���̵� ����ϴ�.
  isNew() : ������ ���� �����Ǿ�����, ������ ������ ���������� �����մϴ�.
  getMaxInactiveInterval() : ������ ��ȿ�ð��� ����ϴ�. ���� �ֱ� ��û������ �������� ī��Ʈ�˴ϴ�.
  removeAttribute() : ���ǿ��� Ư�� ������ �����մϴ�.
  invalidate() : ������ ��� �����͸� �����մϴ�.
  
 ���� ������ ó�� : 
 	1.<%@page errorPage="errorPage.jsp"%>
 	2.<%@page isErrorPage="true"%>
 		<% response.setStatus(200);%>
 		<%=exception.getMessage()%>
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
 	out.println("���� : "+ request.getServerName()+"<br/>");
 	out.println("��Ʈ��ȣ : "+ request.getServerPort()+"<br/>");
 	out.println("��û��� : "+ request.getMethod()+"<br/>");
 	out.println("�������� : "+ request.getProtocol()+"<br/>");
 	out.println("URL : "+ request.getRequestURL()+"<br/>");
 	out.println("URI : "+ request.getRequestURI()+"<br/>");
 	
 %>
</body>
</html>