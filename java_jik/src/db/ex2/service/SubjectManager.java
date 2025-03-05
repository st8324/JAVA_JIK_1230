package db.ex2.service;

import java.util.ArrayList;
import java.util.List;

import db.ex2.model.vo.Subject;
import lombok.Data;

@Data
public class SubjectManager {

	private List<Subject> list;
	
	public SubjectManager(List<Subject> list) {
		if(list == null) {
			this.list = new ArrayList<Subject>();
		}
		else {
			this.list = list;
		}
	}
	
	public SubjectManager() {
		this.list = new ArrayList<Subject>();
	}

	public boolean insertSubject(Subject subject) {
		if(subject == null || list == null) {
			return false;
		}
		if(list.contains(subject)) {
			return false;
		}
		return list.add(subject);
	}

	public boolean contains(Subject subject) {
		return list != null && list.contains(subject);
	}

	public boolean updateSubject(Subject subject, Subject newSubject) {
		if(list == null || subject == null || newSubject == null) {
			return false;
		}
		//등록 안된 과목을 수정하려고 함
		if(!list.contains(subject)) {
			return false;
		}
		//수정할 과목이 등록되지 않으면 수정
		if(!list.contains(newSubject)) {
			list.add(newSubject);
			list.remove(subject);
			return true;
		}
		return false;
	}

	public boolean deleteSubject(Subject subject) {
		if(list == null) {
			return false;
		}
		return list.remove(subject);
	}

	public void print() {
		if(list == null || list.size() == 0) {
			System.out.println("등록된 과목이 없습니다.");
			return;
		}
		for(Subject tmp : list) {
			System.out.println(tmp);
		}
		
	}
}
