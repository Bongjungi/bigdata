package ch01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add
 */
@WebServlet("/add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String x_ = request.getParameter("x");
		String y_ = request.getParameter("y");
		String[] z_ = request.getParameterValues("z");
		String op = request.getParameter("op");
		int x = 0;
		int y = 0;
		int result = 0;
		if(!x_.equals("")) {
			x=Integer.parseInt(x_);
		}
		if(!y_.equals("")) {
			y=Integer.parseInt(y_);
		}
		if(op.equals("덧셈")) {
			result= x+y;
		}else{
			result=x-y;
		}
		int result2=0;
		for(int i=0;i<z_.length; i++) {
			 int num = Integer.parseInt(z_[i]);
			 result2=result2+num;
		}
		response.getWriter().printf("result is %d\n<br>",result);
		response.getWriter().printf("z들의 합은 : %d\n", result2);
		
	}

}
