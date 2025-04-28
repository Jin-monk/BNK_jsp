package ex08_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ex08_dto.MemberDTO;
import ex08_test.A;

public class MemberDAO {
	
	private static MemberDAO instance = new MemberDAO();
	private MemberDAO () {}
	public static MemberDAO getInstance() {
		return instance;
	}	

	
	
	
	public List<MemberDTO> selectAll() {
		List<MemberDTO> list = new ArrayList<>();

		Connection conn = DBUtil.getConnection();
		String query = "SELECT * FROM TBl_MEMBER";
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;

		try(PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery();) {
			

			while (rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String grade = rs.getString("grade");
				
				MemberDTO member = new MemberDTO(id,pw,name,phone, grade);

				list.add(member);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} /*finally {
			DBUtil.close(conn, pstmt, rs);
		}*/

		return list;
	}

	public void insert() {
		Connection conn = DBUtil.getConnection();
		String query = "INSERT INTO TBL_MEMBER VALUES(?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update() {
		Connection conn = DBUtil.getConnection();
		String query = "UPDATE TBL_MEMBER SET GRADE = ? WHERE ID = ? ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete() {
		Connection conn = DBUtil.getConnection();
		String query = "DELETE FROM TBL_MEMBER WHERE ID = ? ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
