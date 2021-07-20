package com.lect.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Helloworld
 */
@WebServlet(urlPatterns= {"/Hworld"}, initParams = {@WebInitParam(name="id", value="aaaaa"), @WebInitParam(name="pw", value="99999")}) 
//이거 쓰려면 web.xml가서 고쳐라. post는 Hworld 씀. 
public class Helloworld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Helloworld() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	System.out.println("init");
    }
    
    @Override
    public void destroy() {
    	System.out.println("destroy");
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = getInitParameter("id");
		String pw = getInitParameter("pw");
		String path = getInitParameter("path");
		
		response.setContentType("text/html; charset=euc-kr");//응답처리를 html형식으로 하겠다. server.xml에서 connector에 URIEncoding="EUC-KR"
		PrintWriter writer = response.getWriter(); //웹브라우저에 출력하기 위한 스트림
		writer.println("<html>");
		writer.println("<head>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("아이디 : " + id + "<br/>");
		writer.println("비밀번호 : " + pw + "<br/>");
		writer.println("path : " + path);
		writer.println("</body>");
		writer.println("</html>");
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("EUC-KR");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String[] hobbys = request.getParameterValues("hobby");
		String major = request.getParameter("major");
		String protocol = request.getParameter("protocol");
		
		response.setContentType("text/html; charset=euc-kr");//응답처리를 html형식으로 하겠다.
		PrintWriter writer = response.getWriter(); //웹브라우저에 출력하기 위한 스트림
		
		writer.println("<html><head></head><body>");
		writer.println("아이디 : " + id + "<br/>");
		writer.println("비밀번호 : " + pw + "<br/>");
		writer.println("취미 : " + Arrays.toString(hobbys) + "<br/>");
		writer.println("전공 : " + major + "<br/>");
		writer.println("프로토콜 : " + protocol);
		writer.println("</body>");
		writer.println("</html>");
		writer.close();
	}
	
	@PostConstruct
	private void initPostConstruct() {
		System.out.println("postconstruct");
	}
	
	@PreDestroy
	private void destroyPreDestroy() {
		System.out.println("predistroy");

	}
}
