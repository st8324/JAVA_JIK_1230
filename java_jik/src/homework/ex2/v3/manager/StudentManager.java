package homework.ex2.v3.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import homework.ex2.v3.vo.Student;
import lombok.Data;

@Data
public class StudentManager {

	private List<Student> list;
	
	public StudentManager(List<Student> list) {
		if(list != null) {
			this.list = list;
		}else {
			this.list = new ArrayList<Student>();
		}
	}
	
	public StudentManager() {
		list = new ArrayList<Student>();
	}
	
	//학년, 반, 번호를 입력받아 객체를 생성하여 반환하는 메소드
	public Student inputBaseStudent(Scanner scan) {
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("학급 : ");//2자로 표현하기 위해 반 대신 사용
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		scan.nextLine();
		
		
		return new Student(grade, classNum, num, "");
	}
	
	//학년, 반, 번호, 이름을 입력받아 객체를 생성하여 반환하는 메소드 
	public Student inputStudent(Scanner scan) {
		Student tmp = inputBaseStudent(scan);
		
		System.out.print("이름 : ");
		String name = scan.nextLine();
		
		tmp.setName(name);
		return tmp;
	}

	public boolean insertStudent(Student student) {
		if(student == null) {
			return false;
		}
		if(list.contains(student)) {
			return false;
		}
		list.add(student);
		return true;
	}

	public void printStudent(Student student) {

		//일치하는 학생 정보를 찾음
		int index = list.indexOf(student);
		
		//찾은 학생 정보를 출력
		if(index < 0) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		
		list.get(index).print();
		
	}

	public boolean contains(Student student) {
		if(student == null || list == null) {
			return false;
		}
		return list.contains(student);
	}

	public boolean updateStudent(Student oldInfo, Student newInfo) {
		if(oldInfo == null || newInfo == null) {
			return false;
		}
		int index = list.indexOf(oldInfo);
		if(index < 0) {
			return false;
		}
		//삭제
		oldInfo = list.remove(index);
		if(list.contains(newInfo)) {
			list.add(index, oldInfo);
			return false;
		}
		//수정
		oldInfo.update(newInfo);
		//원래 위치에 추가
		list.add(index, oldInfo);
		return true;
	}

	public boolean deleteStudent(Student student) {
		if(list == null || student == null) {
			return false;
		}
		
		return list.remove(student);
	}
	
	
}
