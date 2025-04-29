package ex09_controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet("/CheckResult")
public class CheckResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Random rd = new Random();
		int com = rd.nextInt(3) + 1;
		String userStr = request.getParameter("choice");
		int user = Integer.parseInt(userStr);
		String result = null;

		// 1: 가위 2: 바위 3: 보
			if (user == 1 && com == 3) {
				result = "승";
			} else if (user == 2 && com == 1) {
				result = "승";
			} else if (user == 3 && com == 2) {
				result = "승";
			} else if (user == 1 && com == 2) {
				result = "패";
			} else if (user == 2 && com == 3) {
				result = "패";
			} else if (user == 3 && com == 1) {
				result = "패";
			} else if (user == com) {
				result = "무";
			}
			
			String userImg = "";
			if( user == 1 ) {
				userImg="가위.png";
			}
			else if( user == 2 ) {
				userImg="바위.png";
			}
			else if( user == 3 ) {
				userImg="보.png";
			}
			
			String comImg = "";
			if( com == 1 ) {
				comImg="가위.png";
			}
			else if( com == 2 ) {
				comImg="바위.png";
			}
			else if( com == 3 ) {
				comImg="보.png";
			}
			
			request.setAttribute("userImg", userImg);
			request.setAttribute("comImg", comImg);
			request.setAttribute("result", result);
			
			request.getRequestDispatcher("gameResult.jsp").forward(request, response);
			
			
		

	}

}
