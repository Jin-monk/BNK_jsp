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

// 폼에서 입력받은 order 데이터를 insert 이후 주문등록이 확실히 insert 되었는지 확인하는 서블릿으로 이동.

@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Order order = new Order();
		OrderDao orderDao = new OrderDao();
		
		order.setOrderNo(request.getParameter("orderNo"));
		order.setShopNo(request.getParameter("shopNo"));
		order.setOrderDate(request.getParameter("orderDate"));
		order.setPCode(request.getParameter("pCode"));
		order.setAmount(request.getParameter("amount"));
		
		try {
			orderDao.insert(order);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("order",order);
		
		// 주문등록이 제대로 되었는지 확인하는 서블릿으로 가기.
		request.getRequestDispatcher("CheckRegist").forward(request, response);
		
		
		
	}

}
