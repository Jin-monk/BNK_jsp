package ex03.controller;

import java.io.IOException;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/rsp")
public class RSPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Random rd = new Random();
		int com = rd.nextInt(3) + 1; // 상대방 난수 값 (컴퓨터)

		// 1: 가위, 2: 바위, 3: 보
		int card = 0;

		String turn = request.getParameter("turn");
		if (turn.equals("가위")) {
			card = 1;
		} else if (turn.equals("바위")) {
			card = 2;
		} else if (turn.equals("보")) {
			card = 3;
		}

		// 결과 비교
		// 1: 승 , 2: 무, 3:패
		int result = 0;
		if (card == 1 && com == 3) {
			result = 1;
		} else if (card == 2 && com == 1) {
			result = 1;
		} else if (card == 3 && com == 2) {
			result = 1;
		} else if (card == 1 && com == 2) {
			result = 3;
		} else if (card == 2 && com == 3) {
			result = 3;
		} else if (card == 3 && com == 1) {
			result = 3;
		} else if (card == 1 && com == 1) {
			result = 2;
		} else if (card == 2 && com == 2) {
			result = 2;
		} else if (card == 3 && com == 3) {
			result = 2;
		}

		request.setAttribute("result",result);

		request.getRequestDispatcher("rsp.jsp").forward(request, response);

	}

}
