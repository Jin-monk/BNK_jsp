package ex02.controller;

import java.io.IOException;
import java.util.List;

import ex02.dao.MemberDao;
import ex02.service.MemberService;
import ex02.vo.MemberVO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ExServlet")
public class ExServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDao dao = new MemberDao();
	MemberService memberService = new MemberService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 파라미터받기
		List<MemberVO> list = dao.selectAll();

		// map 처럼 이름과 값임 ""가 이름.
		
		// setAttribute 사용하여 request 객체에 저장.
		request.setAttribute("list", list);
		//링크 클래스에 전달. 
		request.getRequestDispatcher("memberList.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 파라미터받기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPw(pw);
		member.setName(name);
		member.setTel(tel);
		dao.insert(member);
		
		response.sendRedirect("memberList.jsp");
	}

}
