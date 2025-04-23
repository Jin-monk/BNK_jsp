package ex04.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import ex04.dao.MemberDAO;
import ex04.vo.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member member = new Member();
		MemberDAO memberdao = null;
		try {
			memberdao = new MemberDAO();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String grade = "일반" ; 
		
		member.setId(id);
		member.setPw(pw);
		member.setName(name);
		member.setGrade(grade);
		
		try {
			memberdao.insert(member);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		결과값 request가 아닌 DB에서 받아오기
//		request.setAttribute("id", id);
//		request.setAttribute("pw", pw );
//		request.setAttribute("name", name);
//		request.setAttribute("grade", grade);
		
		try {
			request.setAttribute("mList", memberdao.select(member));
//			List<Member> mList = memberdao.select(member);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//			request.setAttribute("mList", mList);
		
		request.getRequestDispatcher("seccessjoin.jsp").forward(request, response);
		
		
	}

}
