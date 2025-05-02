package kr.kh.shoppingmall.model.vo;

import lombok.Data;

@Data
public class CartVO {
	int ct_num;
	int ct_amount;
	String ct_me_id;
	String ct_pr_code;
	ProductVO product;
}
