package kr.kh.shoppingmall.model.vo;

import lombok.Data;

@Data
public class MemberVO {
	String me_id;
	String me_pw;
	String me_email;
	String me_number;
	String me_authority;
	String me_del;
	int me_fail;
}
