package kr.kh.shoppingmall.model.vo;

import lombok.Data;

@Data
public class ProductVO {
	String pr_code;
	String pr_title;
	String pr_content;
	int pr_price;
	String pr_thumb;
	String pr_del;
	int pr_amount;
	int pr_ca_num;
}
