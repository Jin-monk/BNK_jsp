package test04_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDAO {

	public void withdraw(Connection conn, String fromAccountId , double amount) throws SQLException {
		PreparedStatement withdrawStmt = null;

		try {
			conn = getConnection();

			// 출금 계좌에서 금액 차감
			String withdrawSql = "UPDATE accounts SET balance = balance - ? WHERE account_id = ? AND balance >= ?";
			withdrawStmt = conn.prepareStatement(withdrawSql);
			withdrawStmt.setDouble(1, amount);
			withdrawStmt.setString(2, fromAccountId);
			withdrawStmt.setDouble(3, amount);
			int withdrawResult = withdrawStmt.executeUpdate();

			if (withdrawResult == 0) {
				throw new SQLException("잔액 부족 또는 계좌 없음");
			}

		} catch (SQLException e) {
			throw e;

		}
	}

	public void deposit(Connection conn, String toAccountId, double amount) throws SQLException {
		PreparedStatement depositStmt = null;
		try {
			conn = getConnection();
		
		// 입금 계좌에 금액 추가

		String depositSql = "UPDATE accounts SET balance = balance + ? WHERE account_id = ? ";
		depositStmt = conn.prepareStatement(depositSql);
		depositStmt.setDouble(1, amount);
		depositStmt.setString(2, toAccountId);
		int depositResult = depositStmt.executeUpdate();

			if (depositResult == 0) {
			throw new SQLException("입금계좌없음");
			}
			
		}catch (SQLException e) {
			throw e;

		}
	}

//	public void transfer(String fromAccountId, String toAccountId, double amount) throws SQLException {
//		Connection conn = null;
//		PreparedStatement withdrawStmt = null;
//		PreparedStatement depositStmt = null;
//		
//		try {
//			conn = getConnection();
//			conn.setAutoCommit(false); // 트랜잭션 시작
//			
//			// 출금 계좌에서 금액 차감
//			String withdrawSql = "UPDATE accounts SET balance = balance - ? WHERE account_id = ? AND balance >= ?";
//			withdrawStmt = conn.prepareStatement(withdrawSql);
//			withdrawStmt.setDouble(1, amount);
//			withdrawStmt.setString(2, fromAccountId);
//			withdrawStmt.setDouble(3, amount);
//			int withdrawResult = withdrawStmt.executeUpdate();
//			
//			if (withdrawResult == 0) {
//				throw new SQLException("잔액 부족 또는 계좌 없음");
//			}
//			
//			// 입금 계좌에 금액 추가
//			String depositSql = "UPDATE accounts SET balance = balance + ? WHERE account_id = ? ";
//			depositStmt = conn.prepareStatement(depositSql);
//			depositStmt.setDouble(1, amount);
//			depositStmt.setString(2, toAccountId);
//			int depositResult = depositStmt.executeUpdate();
//			
//			if (depositResult == 0) {
//				throw new SQLException("입금계좌없음");
//			}
//			conn.commit(); // 트랜잭션 커밋
//			
//		} catch (SQLException e) {
//			if (conn != null) {
//				try {
//					conn.rollback(); // 오류 발생 시 롤백
//					
//				} catch (SQLException ex) {
//					ex.printStackTrace();
//				}
//			}
//			throw e;
//			
//		} finally {
//			// 리소스 해제
//			if (withdrawStmt != null)
//				withdrawStmt.close();
//			if (depositStmt != null)
//				depositStmt.close();
//			if (conn != null) {
//				conn.setAutoCommit(true); // 원래 상태로 복구
//				conn.close();
//				
//			}
//		}
//	}

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
}
