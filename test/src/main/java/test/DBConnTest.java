package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBConnTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		List<Member> mList = new ArrayList<>();
		DBConn dbconn = new DBConn();
		Connection conn = dbconn.DBconn1();
		Statement stmt = conn.createStatement();

		String query = "SELECT * FROM TBL_MEMBER";

		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {
			
			Member member = new Member();
			String id = rs.getString("id");
			String pw = rs.getString("pw");
			String name = rs.getString("name");
			String phone = rs.getString("phone");

			member.setId(id);
			member.setPw(pw);
			member.setName(name);
			member.setPhone(phone);

			mList.add(member);

		}
		
		for(Member m : mList) {
			System.out.println(m);
		}
	}

}
