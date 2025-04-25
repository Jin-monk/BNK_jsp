package vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PCodeList {
	
	private String pCode;
	private String pName;
	private String cost;
	private String discount10;
	private String discount15;
	
}
