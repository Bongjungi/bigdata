package ch01;

import java.io.IOException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Add
 */
@WebServlet("/add3")
public class Add3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String value = request.getParameter("value");
		String op = request.getParameter("operator");
		String dot = request.getParameter("dot");
		
		Cookie[] cookies = request.getCookies();
		
		String exp ="";
		
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
			}
		}
		if(op!=null&&op.equals("=")) {
			exp="OK";
		}else if(op!=null && op.equals("C")) {
			exp = "";
		}else {
			exp += (value==null)?"":value;
			exp += (op==null)?"":op;
			exp += (dot==null)?"":dot;
		}
		
			Cookie expCookie = new Cookie("exp", exp);
			if(op!=null && op.equals("C")) {
				expCookie.setMaxAge(0);
			}
			expCookie.setPath("/");
			response.addCookie(expCookie);
			response.sendRedirect("addpage");
			
		
		
			
		
	
		
		
	}

}
