package homework.ex2.v2;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class SubjectManager {

	private List<Subject> list;
	
	public SubjectManager(List<Subject> list) {
		this.list = list;
	}
	
	public SubjectManager() {
		this.list = new ArrayList<Subject>();
	}
}
