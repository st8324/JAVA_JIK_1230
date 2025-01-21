package day15.socket5;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int grade, classNum, num;
	private String name;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return classNum == other.classNum && grade == other.grade && num == other.num;
	}

	@Override
	public String toString() {
		return grade + "학년 " + classNum +"반 " + num + "번 " + name;
	}

	

}
