package kr.kh.spring2.model.vo;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
	
	private String me_id;
	private String me_pw;
	private String me_email;
	private String me_authority;
	private String me_cookie;
	private Date me_limit;
	private boolean auto;
	
}
