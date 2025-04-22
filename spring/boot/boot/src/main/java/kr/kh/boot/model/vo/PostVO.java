package kr.kh.boot.model.vo;

import java.util.List;

import lombok.Data;

@Data
public class PostVO {
	int po_num;
	String po_title;
	String po_content;
	String po_me_id;
	int po_view;
	int po_up,po_down;
	int po_bo_num;
	String po_del;
	String po_date;
	List<CommentVO> list;
}
