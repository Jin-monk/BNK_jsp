package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.MemberSales;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.MemberDao;

@WebServlet("/SalesList")
public class SalesList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDao memberdao = new MemberDao();
		List<MemberSales> msList = null ;
		
		try {
			msList = memberdao.selectSales();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("msList", msList);
		request.getRequestDispatcher("printsales.jsp").forward(request, response);
		
		
	}

}
