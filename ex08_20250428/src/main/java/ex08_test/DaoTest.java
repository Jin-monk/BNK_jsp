package ex08_test;

import ex08_dao.MemberDAO;

public class DaoTest {
	
	public static void main (String[] args) {

	
	MemberDAO m1 = MemberDAO.getInstance();
	MemberDAO m2 = MemberDAO.getInstance();
	System.out.println(m1 == m2 );
	System.out.println("============");
	
	}
}
