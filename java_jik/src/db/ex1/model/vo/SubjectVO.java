package db.ex1.model.vo;

import lombok.Data;

@Data
public class SubjectVO {
	//SubjectVO의 필드명은 subject 테이블의 속성 이름과 반드시 같아야 한다? 
	// => X. 
	// 같게 하는 이유는 Mapper에서 추가 작업을 하지 않기 위해서 
	private int sj_num;
	private int sj_grade;
	private int sj_semester;
	private String sj_name;
	@Override
	public String toString() {
		return sj_grade + "학년 " + sj_semester + "학기 " + sj_name;
	}
	
	
}
