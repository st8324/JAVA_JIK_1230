package homework.ex2.v3.manager;

import java.util.ArrayList;
import java.util.List;

import homework.ex2.v3.vo.Subject;
import lombok.Data;

@Data
public class SubjectManager {

	private List<Subject> list;
	
	public SubjectManager(List<Subject> list) {
		if(list != null) {
			this.list = list;
		}else {
			this.list = new ArrayList<Subject>();
		}
	}
	
	public SubjectManager() {
		this.list = new ArrayList<Subject>();
	}

	public boolean insert(Subject subject) {
		if(subject == null || list == null) {
			return false;
		}
		if(list.contains(subject)) {
			return false;
		}
		return list.add(subject);
	}

	public boolean update(Subject oldSubject, Subject newSubject) {
		//기존 과목이 등록된 과목이 아니거나 새 과목이 null이면
		if( !contains(oldSubject) || newSubject == null) {
			return false;
		}
		//기존 과목 삭제
		list.remove(oldSubject);
			
		//수정할 과목이 이미 등록됐으면
		if(list.contains(newSubject)) {
			//기존 과목 다시 추가
			list.add(oldSubject);
			return false;
		}
		//새 과목 추가
		list.add(newSubject);
		return true;
	}

	public boolean contains(Subject oldSubject) {
		if(list == null || oldSubject == null) {
			return false;
		}
		return list.contains(oldSubject);
	}

	public boolean delete(Subject subject) {
		if(list == null || subject == null) {
			return false;
		}
		return list.remove(subject);
	}

	public void print() {
		System.out.println("---------------------");
		if(list == null || list.size() == 0) {
			System.out.println("등록된 과목이 없습니다.");
			System.out.println("---------------------");
			return;
		}
		for(Subject tmp : list) {
			System.out.println(tmp);
		}
		System.out.println("---------------------");
	}
}
