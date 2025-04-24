package vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MemberSales {

	private String custNo;
	private String custName;
	private String grade;
	private String sales;
	
}
