package ex03.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/p5-2")
public class P5_2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String num1= request.getParameter("num1");
		String num2= request.getParameter("num2");
		
		int iNum1 = Integer.parseInt(num1);
		int iNum2 = Integer.parseInt(num2);
		int mul = iNum1 * iNum2 ;
		
		request.setAttribute("mul", mul);
		
		request.getRequestDispatcher("p5.jsp").forward(request, response);
	}


}
