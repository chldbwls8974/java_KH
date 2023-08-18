package db.self.board.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BoardVO {
	private int bo_number;
	private String bo_title;
	private String bo_me_id;
}
