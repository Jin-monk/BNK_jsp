package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.MemberDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Member;

@WebServlet("/MemberServiceSelectAll")
public class MemberServiceSelectAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDao memberdao = new MemberDao();
		List<Member> mList = null ;
		try {
			mList = memberdao.selectAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("memberAll", mList);
		request.getRequestDispatcher("printmember.jsp").forward(request, response);
	
	}

}
