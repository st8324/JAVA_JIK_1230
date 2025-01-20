package homework.ex2.v1;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data	
@AllArgsConstructor
public class Subject {

	private int grade;
	private int semester;
	private String name;
	
	@Override
	public String toString() {
		return grade +"학년 " + semester + "학기 " + name;
	}

}
