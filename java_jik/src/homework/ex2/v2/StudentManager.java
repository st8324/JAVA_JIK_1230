package homework.ex2.v2;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class StudentManager {

	private List<Student> list;
	
	public StudentManager(List<Student> list) {
		this.list = list;
	}
	
	public StudentManager() {
		list = new ArrayList<Student>();
	}
}
