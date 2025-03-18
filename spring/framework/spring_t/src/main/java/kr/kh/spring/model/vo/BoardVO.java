package kr.kh.spring.model.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {

	int bo_num;
	String bo_title, bo_content, bo_me_id;
	Date bo_date;
	int bo_view;
	
	
}
