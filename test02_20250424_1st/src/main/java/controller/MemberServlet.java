package controller;

import java.io.IOException;
import java.sql.SQLException;

import dao.MemberDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Member;

//MemberService 에게서 사용자에게 입력받은 회원정보를 받아 db에 인서트 해주고 초기화면으로 돌아감. 

@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDao memberdao = new MemberDao();
		
		Member member = (Member)request.getAttribute("member");
		
		try {
			memberdao.insert(member);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
		
		
		

		
	}

}
