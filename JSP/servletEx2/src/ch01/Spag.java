package ch01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/spag")
public class Spag extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num=0;
		String num_ = request.getParameter("num");
		if(num_!=null&&!num_.equals("")) {
			num = Integer.parseInt(num_);
		}
		String result;
		if(num%2 != 0) {
			result = "홀";
		}else {
			result = "짝";
		}
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("new");
		list.add("old");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 1);
		map.put("title","EL");
		
		request.setAttribute("result", result);
		request.setAttribute("list", list);
		request.setAttribute("map", map);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("spag.jsp");
		dispatcher.forward(request, response);
	}
}
