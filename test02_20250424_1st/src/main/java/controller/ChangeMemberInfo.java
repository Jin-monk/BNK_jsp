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

@WebServlet("/ChangeMemberInfo")
public class ChangeMemberInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Member member = new Member();
		MemberDao memberdao = new MemberDao();
		String custNo = request.getParameter("custno");
		String custName = request.getParameter("custname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String joinDate = request.getParameter("joinDate");
		String grade = request.getParameter("grade");
		String city = request.getParameter("city");
		
		//인스턴스 생성 시 변수 넣기 . 
		member.setCustNo(custNo);
		member.setCustName(custName);
		member.setPhone(phone);
		member.setAddress(address);
		member.setJoinDate(joinDate);
		member.setGrade(grade);
		member.setCity(city);


		if (member != null) {
			try {
				memberdao.update(member);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			request.setAttribute("member", member);
//			request.getRequestDispatcher("").forward(request, response);
			response.sendRedirect("index.jsp");

		} else {
			
		}
	}

}
