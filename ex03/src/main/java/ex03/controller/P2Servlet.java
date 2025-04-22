package ex03.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/p2")
public class P2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name =request.getParameter("name");
		String age = request.getParameter("age");
		
		//x에 name 넣기
		request.setAttribute("x", name);
		request.setAttribute("y", age);
		
		request.getRequestDispatcher("p2.jsp").forward(request, response);
//		response.sendRedirect("p2.jsp");
		
		
	}

}
