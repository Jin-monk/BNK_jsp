package test04_service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import test04_dao.AccountDAO;

public class Service {

	public static Connection getConnection() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:testdb";
		String id = "green";
		String pw = "1234";

		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);

			if (conn != null) {
				System.out.println("DB 연결성공 !");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return conn;

	}

	public void transfer(String fromAccountId, String toAccountId, double amount) throws SQLException {
		AccountDAO accountDAO = new AccountDAO();
		Connection conn = null;
		try {
		conn = getConnection();
		conn.setAutoCommit(false);
		
		accountDAO.withdraw(conn, fromAccountId , amount);
		accountDAO.deposit(conn, toAccountId,amount);
		conn.commit();
		
		} catch (SQLException e) {
			if(conn != null) {
				conn.rollback();
			}
			throw e ; 
		}	finally {
			if(conn != null) {
				conn.setAutoCommit(true);
				conn.close();
			}
		}
		
		
	}

}
