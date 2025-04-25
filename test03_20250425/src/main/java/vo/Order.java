package vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class Order {

	private String orderNo;
	private String shopNo;
	private String orderDate;
	private String pCode;
	private String amount;
	
	

}
