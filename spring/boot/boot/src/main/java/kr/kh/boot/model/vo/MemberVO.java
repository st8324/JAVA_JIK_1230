package kr.kh.boot.model.vo;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
	
	String me_id;
	String me_pw;
	String me_email;
	String me_authority;
	String me_cookie;
	String me_limit;
	Date date = new Date();
}
