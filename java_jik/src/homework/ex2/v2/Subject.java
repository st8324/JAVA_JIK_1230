package homework.ex2.v2;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data	
@AllArgsConstructor
public class Subject implements Serializable {

	private static final long serialVersionUID = -487127771190336145L;
	
	private int grade;
	private int semester;
	private String name;
	
	@Override
	public String toString() {
		return grade +"학년 " + semester + "학기 " + name;
	}

}
