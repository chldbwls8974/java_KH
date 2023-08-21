package db.day3.board.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberVo {
	
	private String me_id;
	private String me_pw;
	private int me_board_count;
	
	public MemberVo(String id, String pw) {
		this.me_id = id;
		this.me_pw = pw;
	}
}
