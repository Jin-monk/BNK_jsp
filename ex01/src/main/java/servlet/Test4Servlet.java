package servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/test4")
public class Test4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//서버 최초 실행 시에 실행.
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 실행");
	}

	//서버가 중지될 때 실행. 
	public void destroy() {
		System.out.println("destory 실행");
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGET 실행");
		
	}

}
