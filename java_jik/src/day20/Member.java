package day20;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Member {
	
	private String id;
	private String pw;
	private String authority;//사용자, 관리자3
	
	public Member(String id, String pw) {
		this.id = id;
		this.pw = pw;
		this.authority = "사용자";
	}
	
	
}
