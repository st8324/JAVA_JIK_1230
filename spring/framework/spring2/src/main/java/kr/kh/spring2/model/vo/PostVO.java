package kr.kh.spring2.model.vo;

import java.util.Date;

import lombok.Data;

@Data
public class PostVO {

	int po_num;
	String po_title, po_content, po_me_id;
	Date po_date;
	int po_view;
	int po_up, po_down;
	int po_bo_num;
	String po_bo_name;
	String po_del;
	String po_fi_name;
	
}
