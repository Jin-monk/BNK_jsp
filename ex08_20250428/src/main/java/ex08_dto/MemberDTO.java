package ex08_dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
//계층 간 데이터 전송 
//서비스 -> 컨트롤 -> 서블릿 -> 컨트롤 - > 서브스 -> jsp 
public class MemberDTO {
	
	private final String id;
	private final String pw;
	private final String name;
	private final String phone;
	private String grade;
	
}
