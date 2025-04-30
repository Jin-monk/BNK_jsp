package test04_controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test04_dao.AccountDAO;
import test04_service.Service;

@WebServlet("/transfer")
public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AccountDAO accountDAO = new AccountDAO();
	private Service service = new Service();

	public void init(ServletConfig config) throws ServletException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		String fromAccountId = request.getParameter("fromAccount");
		String toAccountId = request.getParameter("toAccount");
		String amountStr = request.getParameter("amount");

		try {
			double amount = Double.parseDouble(amountStr);

			// 트랜잭션 실행
			service.transfer(fromAccountId, toAccountId, amount);

			request.setAttribute("message",
					"이체성공: " + fromAccountId + "에서" + toAccountId + "로 " + amount + "원 이체되었습니다.");

		} catch (SQLException e) {
			request.setAttribute("errorMessage", "이체실패: " + e.getMessage());
		} catch (NumberFormatException e) {
			request.setAttribute("errorMessage", "유효하지 않은 금액입니다.");
		}
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

}
