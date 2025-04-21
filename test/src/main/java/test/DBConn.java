package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {

	public Connection DBconn1() throws ClassNotFoundException, SQLException {

		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = ("jdbc:oracle:thin:@localhost:1521:testdb");
			String id = "green";
			String pw = "1234";

			conn = DriverManager.getConnection(url, id, pw);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;

	}
}
