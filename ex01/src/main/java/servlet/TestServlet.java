package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/test1")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//객체 직렬화 , 번호  
       
    public TestServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGET 실행");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("<title>Insert title here</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>EX1 Page</h1>");
		out.print("<hr>");
		out.print("<p>Servlet을 배우고 있습니다.</p>");
		out.print("</body>");
		out.print("</html>");
		
		
		
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		System.out.println("doPOST 실행");
//		String param1 = request.getParameter("name");
//		response.getWriter().append("name: " + param1);
//		
//	}
//동적인 홈페이지의 서버는 와스다 웹어플리케이션서버이다. WAS
}
