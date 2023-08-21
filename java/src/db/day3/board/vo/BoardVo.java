package db.day3.board.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class BoardVo {
	
	private int bo_number;
	private String bo_title;
	private String bo_me_id;
	
	public BoardVo(String bo_title, String bo_me_id) {
		this.bo_title = bo_title;
		this.bo_me_id = bo_me_id;
	}

	public BoardVo(int num, String title, String me_id) {
		this.bo_number = num;
		this.bo_title = title;
		this.bo_me_id = me_id;
	}

	@Override
	public String toString() {
		return "[" + bo_number + "]"  + "[" + bo_title + "]"  + "[" + bo_me_id + "]";
	}
	
	
}
