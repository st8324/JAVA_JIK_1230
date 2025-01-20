package homework.ex2.v2;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class StudentManager {

	private List<Student> list;
	
	public StudentManager(List<Student> list) {
		if(list == null) {
			this.list = new ArrayList<Student>();
		}
		else {
			this.list = list;
		}
	}
	
	public StudentManager() {
		list = new ArrayList<Student>();
	}

	public boolean insertStudent(Student std) {
		if(std == null || list == null) {
			return false;
		}
		if(list.contains(std)) {
			return false;
		}
		return list.add(std);
	}

	public Student getStudent(Student std) {
		int index = list.indexOf(std);
		
		return index < 0 ? null : list.get(index);
	}
	//1 1 1 => 1 1 1
	public boolean updateStudent(Student selStd, Student newStd) {
		if(selStd == null || newStd == null || list == null) {
			return false;
		}
		if(!list.contains(selStd)) {
			return false;
		}
		Student tmp = getStudent(newStd);
		//수정될 정보가 업거나 이전 학생 정보이면 수정 
		if(tmp == null || tmp == getStudent(selStd)) {
			getStudent(selStd).update(newStd);
			return true;
		}
		return false;
	}

	public boolean deleteStudent(Student std) {
		if(std == null || list == null) {
			return false;
		}
		return list.remove(std);
	}

	public void printStudent(Student std) {
		if(std == null) {
			System.out.println("학생 정보가 없습니다.");
			return;
		}	
		if(list == null) {
			System.out.println("학생 리스트가 없습니다.");
			return;
		}
		Student tmp = getStudent(std);
		if(tmp == null) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		tmp.print();
	}

	public boolean insertScore(Student std, SubjectScore subjectScore) {
		if(list == null || std == null || subjectScore == null) {
			return false;
		}
		std = getStudent(std);
		if(std == null) {
			return false;
		}
		return std.insertScore(subjectScore);
	}

	public boolean updateScore(Student std, Subject subject, SubjectScore subjectScore) {
		if(list == null || std == null || subject == null || subjectScore == null) {
			return false;
		}
		std = getStudent(std);
		if(std == null) {
			return false;
		}
		return std.updateScore(subject, subjectScore);
	}

	public boolean deleteScore(Student std, Subject subject) {
		if (std == null || subject == null || list == null) {
			return false;
		}
		std = getStudent(std);
		if(std == null) {
			return false;
		}
		return std.deleteScore(subject);
	}

	public void printScore(Student std, Subject subject) {
		if(std == null || subject == null || list == null) {
			System.out.println("출력할 수 없습니다.");
			return ;
		}
		std = getStudent(std);
		if(std == null) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		std.printScore(subject);
	}
}










