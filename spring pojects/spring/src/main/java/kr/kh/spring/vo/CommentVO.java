package kr.kh.spring.vo;

import lombok.Data;

@Data
public class CommentVO {

	int co_num, co_ori_num,co_bo_num;
	String co_contents,co_me_id;
}
