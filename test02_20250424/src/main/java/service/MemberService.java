package service;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Member;

@WebServlet("/MemberService")
public class MemberService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

// 사용자가 입력한 회원정보 null값 확인 후 MemberServlet 으로 데이터 넘겨줌 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member member = new Member();
		
//		String custNo = request.getParameter("custno");
		String custName = request.getParameter("custname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String joinDate = request.getParameter("joinDate");
		String grade = request.getParameter("grade");
		String city = request.getParameter("city");
		
//		member.setCustNo(custNo);
		member.setCustName(custName);
		member.setPhone(phone);
		member.setAddress(address);
		member.setJoinDate(joinDate);
		member.setGrade(grade);
		member.setCity(city);
		
		request.setAttribute("member", member);
		
		if( member != null ) {
			request.getRequestDispatcher("MemberServlet").forward(request, response);
			
		}else {
			response.sendRedirect("index.jsp");
		}
		
	}

}
