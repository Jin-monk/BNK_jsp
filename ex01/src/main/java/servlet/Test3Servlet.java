package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/test3")
public class Test3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Test3Servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//클라이언트가 수많은 요청 중에서 각각 요청에 대응하며 이 요청에 서버자원이 뭐가 있나 ? 있으면 ???
		
		//"ex1.jsp"에 request,response 객체를 들고서 간다. 페이지를 이동하는 과정이며
		//응답이 끝난것이 아닌 ex1.jsp에 가서 끝낸다.
		request.getRequestDispatcher("ex1.jsp").forward(request,response);
		//ex1.jsp로 가는 것으로 해당 응답이 끝난것이다 . 
//		response.sendRedirect("ex1.jsp");
	}


}
