package ex04.controller;

import java.io.IOException;
import java.sql.SQLException;

import ex04.dao.BoardDAO;
import ex04.vo.Board;
import ex04.vo.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/BoardServlet")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member member = new Member();
		Board board = new Board();
		BoardDAO boarddao = null;
		try {
			boarddao = new BoardDAO();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String bno = null ; 
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Member writer = (Member)session.getAttribute("loginInfo");
		String date = request.getParameter("date");
		
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer.getId());
		board.setRegdate(date);
		
		try {
			boarddao.insert(board);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("boardList.jsp");
		
		
	}

}
