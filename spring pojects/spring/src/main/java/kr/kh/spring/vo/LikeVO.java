package kr.kh.spring.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LikeVO {
	private int li_num, li_state, li_bo_num;
	private String li_me_id;
	
	
	public LikeVO(int li_num, int li_state, int li_bo_num, String li_me_id) {
		this.li_num = li_num;
		this.li_state = li_state;
		this.li_bo_num = li_bo_num;
		this.li_me_id = li_me_id;
	}
}
