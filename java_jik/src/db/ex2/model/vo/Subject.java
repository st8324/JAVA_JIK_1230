package db.ex2.model.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data	
@RequiredArgsConstructor
public class Subject implements Serializable {

	private static final long serialVersionUID = -487127771190336145L;
	
	private int num;//sj_num
	@NonNull
	private int grade;//sj_grade
	@NonNull
	private int semester;//sj_semester
	@NonNull
	private String name;//sj_name
	
	@Override
	public String toString() {
		return grade +"학년 " + semester + "학기 " + name;
	}

}
