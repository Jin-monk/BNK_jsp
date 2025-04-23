package ex04.controller;

import java.io.IOException;
import java.sql.SQLException;

import ex04.dao.MemberDAO;
import ex04.vo.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO memberdao = null ; 
		
		try {
			memberdao = new MemberDAO();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		
		Member member = new Member();
		
		try {
			member = memberdao.selectById(id);
			
			if( member != null && member.getPw().equals(pw)) {
				HttpSession session = request.getSession();
				session.setAttribute("loginInfo", member);
				
				response.sendRedirect("successlogin.jsp");
				//request.getRequestDispatcher("successlogin.jsp").forward(request, response);
				
			}
			else {
				response.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
