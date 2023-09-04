package kr.kh.study.vo;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class BoardVO {
	private int bo_num, bo_views, bo_ori_num, bo_up, bo_down,bo_comment, bo_bt_num;
	private String bo_title, bo_content, bo_me_id;
	private Date bo_reg_date, bo_up_date;
	
	//private List<FileVO> files;
	
}
