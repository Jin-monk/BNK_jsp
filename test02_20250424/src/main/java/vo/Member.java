package vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Member {
	private String custNo;
	private String custName;
	private String phone;
	private String address;
	private String joinDate;
	private String grade;
	private String city;
	
}
