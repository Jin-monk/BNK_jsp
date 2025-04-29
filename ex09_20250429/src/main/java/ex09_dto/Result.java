package ex09_dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Result {
	private int total;
	private int win;
	private int draw;
	private int lose;
	
}
