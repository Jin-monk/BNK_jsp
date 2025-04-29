package ex09_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ex09_dto.Member;

public class MemberDao {

	public void selectAll(Member member) throws SQLException {
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null ;
		ResultSet rs = null ; 
		String query = "INSERT INTO member9 VALUES(?, ?, ?, ?)";
		
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, member.getId());
		pstmt.setString(2, member.getPw());
		pstmt.setString(3, member.getName());
		pstmt.setString(4, member.getGrade());
		
		pstmt.executeUpdate();
		DBUtil.close(pstmt, conn);
	}
	
	
	
	
	public void insert() {
		
	}
	
	public void update() {
		
	}
	
	public void delete() {
		
	}
}
