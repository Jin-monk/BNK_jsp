package ex10_dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBconnPool {

	Connection conn;

	public DBconnPool() {

		try {
			Context initCtx = new InitialContext();
			Context ctx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("dbcp_myoracle");

			conn = ds.getConnection();

			if (conn != null) {
				System.out.println("DB 커넥션 풀 연결 성공");
			}

		} catch (NamingException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void close() {
			try {
				if(conn!=null) conn.close();
				System.out.println("conn 자원 해제");
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	
	
	
}
