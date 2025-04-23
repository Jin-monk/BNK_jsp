package ex04.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ex04.vo.Member;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	DBConn dbconn = new DBConn();
	
	public MemberDAO () throws ClassNotFoundException, SQLException {
		conn= dbconn.DBconn();
	}
	
	
	public void insert(Member member) throws SQLException, ClassNotFoundException {
		
		conn= dbconn.DBconn();
		String query = "INSERT INTO MEMBER9 VALUES (?, ?, ?, ?)";
		pstmt = conn.prepareStatement(query);
		
		pstmt.setString(1, member.getId());
		pstmt.setString(2, member.getPw());
		pstmt.setString(3, member.getName());
		pstmt.setString(4, member.getGrade());
		
		pstmt.executeUpdate();
		
	}
	
	
	
	public List<Member> select(Member member) throws ClassNotFoundException, SQLException {
		List<Member> mList = new ArrayList<>();
		
		conn= dbconn.DBconn();
		String query = "SELECT * FROM MEMBER9 WHERE ID = ? ";
		pstmt = conn.prepareStatement(query);
		
		pstmt.setString(1, member.getId());
		
		ResultSet rs = pstmt.executeQuery();
		
		rs.next();
		String id = rs.getString("id");
		String pw = rs.getString("pw");
		String name = rs.getString("name");
		String grade = rs.getString("grade");
		
		member.setId(id);
		member.setPw(pw);
		member.setName(name);
		member.setGrade(grade);
		
		mList.add(member);
		return mList;
		
		
	}
	
	public Member selectById(String id) throws Exception {
	    Member member = null;
	    conn = dbconn.DBconn();

	    String query = "SELECT * FROM MEMBER9 WHERE ID = ?";
	    pstmt = conn.prepareStatement(query);
	    pstmt.setString(1, id);
	    ResultSet rs = pstmt.executeQuery();

	    if (rs.next()) {
	        member = new Member();
	        member.setId(rs.getString("id"));
	        member.setPw(rs.getString("pw"));
	        member.setName(rs.getString("name"));
	        member.setGrade(rs.getString("grade"));
	    }

	    rs.close(); pstmt.close(); conn.close();
	    return member;
	}

}
