package day20;

import java.util.Objects;

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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return Objects.equals(id, other.id);
	}
	
}
