package ex08_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ex08_dto.MemberDTO;

public class DBUtilTest {

	public static void main(String[] args) throws SQLException {
		
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;

		DBUtil.close(conn,stmt,rs);
		
	}
}
