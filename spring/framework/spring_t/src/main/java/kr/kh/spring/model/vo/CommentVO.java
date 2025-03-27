package kr.kh.spring.model.vo;

import java.util.Date;

import lombok.Data;

@Data
public class CommentVO {

	int co_num; 
	String co_content; 
	Date co_date; 
	int co_ori_num; 
	String co_del;
	String co_me_id; 
	int co_po_num;
}
