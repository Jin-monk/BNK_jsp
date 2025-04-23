package ex04.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ex04.vo.Board;

public class BoardDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	DBConn dbconn = new DBConn();
	
	public BoardDAO () throws ClassNotFoundException, SQLException {
		conn= dbconn.DBconn();
	}
	
	public void insert(Board board) throws SQLException {
		conn = dbconn.DBconn();
		String query = "INSERT INTO BOARD9 VALUES(SEQ_BNO.nextval, ?, ?, ?, ?) ";
		
		pstmt = conn.prepareStatement(query);
		
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getContent());
		pstmt.setString(3, board.getWriter());
		pstmt.setString(4, board.getRegdate());
		
		pstmt.executeUpdate();
		
		
		
		
	}
	
}
