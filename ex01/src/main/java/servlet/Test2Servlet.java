package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Test2Servlet
 */
@WebServlet("/test2")
public class Test2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Test2Servlet() {
        super();
    }

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPOST 실행");
		String param1 = request.getParameter("name");
		response.getWriter().append("name: " + param1);
	}

}
