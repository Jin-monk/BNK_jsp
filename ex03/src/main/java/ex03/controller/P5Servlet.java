package ex03.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/p5")

public class P5Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String rs = request.getParameter("더하기");
		System.out.println(rs);
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		
		int iNum1 = Integer.parseInt(num1);
		int iNum2 = Integer.parseInt(num2);
		int sum = iNum1 + iNum2 ;
		
		request.setAttribute("sum", sum);
		
		request.getRequestDispatcher("p5.jsp").forward(request, response);
	
	}


}
