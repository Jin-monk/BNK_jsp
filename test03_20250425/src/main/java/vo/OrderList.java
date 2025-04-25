package vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderList {
	
	private String shopNo;
	private String shopName;
	private String orderNo;
	private String orderDate;
	private String pCode;
	private String pName;
	private String amount;
	private String cost;
	private String custPrice; // 소비자가격
	private String disPrice; //할인가격
	
}
