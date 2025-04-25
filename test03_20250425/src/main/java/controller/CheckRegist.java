package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.OrderDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Order;

// 주문등록이 똑바로 되었는지 확인하는 서블릿

@WebServlet("/CheckRegist")
public class CheckRegist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		OrderDao orderDao = new OrderDao();
		List<Order> oList = null;
		Order order = (Order) request.getAttribute("order");
		try {
			oList = orderDao.selectByONo(order);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("index.jsp");
		
		
		
	}

}
