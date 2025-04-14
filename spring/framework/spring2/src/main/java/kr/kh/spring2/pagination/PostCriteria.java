package kr.kh.spring2.pagination;

import lombok.Data;

@Data
public class PostCriteria extends Criteria {

	int po_bo_num;
	String orderBy;
}
