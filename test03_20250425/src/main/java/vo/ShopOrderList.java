package vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ShopOrderList {

	private String sCode;
	private String pCode;
	private String pName;
	private String allAmount;
	
}
