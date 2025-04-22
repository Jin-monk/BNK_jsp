package ex02.service;

import java.util.List;

import ex02.dao.MemberDao;
import ex02.vo.MemberVO;

public class MemberService {
	
	MemberDao memberdao = new MemberDao();
	public void f() {
		//파라미터로 받은 데이터 가지고 해 볼만 한 것들
		// 유효성 검사 (데이터가 유효한 성질인지 확인 ( 데이터길이, 데이터형태))
		//
		
		memberdao.insert(null);
			
		
	}
	
	
	public List<MemberVO> selectAll() {
		//DB에 요청
		List<MemberVO> list = memberdao.selectAll();
		return list;
	}
}
