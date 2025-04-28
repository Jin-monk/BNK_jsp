package ex08_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {

	// Util 클래스 할 일

	// 1. 접속 객체(Connection) 제공
	public static Connection getConnection() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jbdc:oracle:thin:@localhost:1521:testdb";
		String id = "green";
		String pw = "1234";

		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);

			if (conn != null) {
				System.out.println("접속 성공!");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}
	// 2. Dao에서 사용된 자원 해제 (Connection, Statement, ResultSet)

	public static void close(Connection conn, PreparedStatement stmt, ResultSet rs) {
		try {
			if(rs != null ) rs.close();
			close(conn,stmt);
			
			System.out.println("추가로 rs 자원해제");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection conn, PreparedStatement stmt) {
		try {
			if(stmt !=null) stmt.close();
			if(stmt !=null) conn.close();
			System.out.println("conn, stmt 자원해제");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
