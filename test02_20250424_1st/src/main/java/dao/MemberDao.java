package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Member;
import vo.MemberSales;

public class MemberDao {
	
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Connection conn; 
	DBConn dbconn = new DBConn();
	
	public MemberDao() {
		conn = dbconn.getConnection();
		
	}
	
	//회원 정보 등록 
	public void insert(Member member) throws SQLException {
		String query = "INSERT INTO member_tbl_02 VALUES(seq_member.nextval,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(query);
		
		pstmt.setString(1, member.getCustName());
		pstmt.setString(2, member.getPhone());
		pstmt.setString(3, member.getAddress());
		pstmt.setString(4, member.getJoinDate());
		pstmt.setString(5, member.getGrade());
		pstmt.setString(6, member.getCity());
		
		pstmt.executeUpdate();
		
	}

	public void select() {

	}
	
	//전체 회원 정보 조회
	public List<Member> selectAll() throws SQLException {
		List<Member> mList = new ArrayList<>();
		String query = "SELECT custno, custname, phone,address, TO_CHAR(joinDate,'YYYY-MM-DD') as joinDate, replace(grade,'A','VIP') as grade, city FROM member_tbl_02 ORDER BY CUSTNO";
		pstmt = conn.prepareStatement(query);
		rs = pstmt.executeQuery();
		Member memberAll = null ;
		
		while(rs.next()) {
			memberAll= new Member();
			memberAll.setCustNo(rs.getString("custNo"));
			memberAll.setCustName(rs.getString("custName"));
			memberAll.setPhone(rs.getString("phone"));
			memberAll.setAddress(rs.getString("address"));
			memberAll.setJoinDate(rs.getString("joinDate"));
			memberAll.setGrade(rs.getString("grade"));
			memberAll.setCity(rs.getString("city"));
			
			mList.add(memberAll);
			
		}
		return mList;
		
	}

	//매출순 회원 조회
	public List<MemberSales> selectSales() throws SQLException {
		List<MemberSales> msList = new ArrayList<>(); 
		String query = "SELECT MB.CUSTNO, CUSTNAME, GRADE, SUM(PRICE) as sales FROM MEMBER_TBL_02 MB JOIN MONEY_TBL_02 MN ON MB.CUSTNO = MN.CUSTNO GROUP BY MB.CUSTNO,CUSTNAME,GRADE ORDER BY SALES DESC";
		pstmt = conn.prepareStatement(query);
		rs = pstmt.executeQuery();
		MemberSales memberSales = null;
		
		while(rs.next()) {
			memberSales = new MemberSales();
			memberSales.setCustNo(rs.getString("custNo"));
			memberSales.setCustName(rs.getString("custName"));
			memberSales.setGrade(rs.getString("grade"));
			memberSales.setSales(rs.getString("sales"));
			
			msList.add(memberSales);
		}
		return msList;
	}
	
	
	
	
	
	public void update(Member member) throws SQLException {
		String query = "UPDATE MEMBER_TBL_02 SET CUSTNAME = ?, PHONE = ?, ADDRESS = ?, GRADE = ?, CITY = ? WHERE CUSTNO = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, member.getCustName());
		pstmt.setString(2, member.getPhone());
		pstmt.setString(3, member.getAddress());
		pstmt.setString(4, member.getGrade());
		pstmt.setString(5, member.getCity());
		pstmt.setString(6,member.getCustNo());
		System.out.println("고객번호: "+member.getCustNo());
		int result = pstmt.executeUpdate();
		System.out.println("업데이트 행수 "+result);
		
		
	}
}
