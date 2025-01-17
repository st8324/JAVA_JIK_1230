package homework.ex2.v3.manager;

import java.util.ArrayList;
import java.util.List;

import homework.ex2.v3.vo.Subject;
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
