package homework.ex2.v1;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

//getter, setter, toString, equals등을 제공
@Data
@RequiredArgsConstructor //상수나 @NonNull이 붙은 필드만을 이용한 생성자를 추가
public class Student {

	@NonNull
	private int grade, classNum, num;
	@NonNull
	private String name;
	
	//학생 개인의 성적을 담고 있는 배열
	public List<SubjectScore> list = new ArrayList<SubjectScore>();

	//equals를 오버라이딩, 학년, 반, 번호를 이용
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

	public void print() {
		System.out.println("-----------------");
		System.out.println(grade + "학년 " + classNum + "반 " + num + "번 " + name);
		System.out.println("-----------------");
		if(list.size() == 0) {
			System.out.println("등록된 성적이 없습니다.");
			return;
		}
		for(SubjectScore score : list) {
			System.out.println(score);
		}
	}

	public void update(Student newStd) {
		if(newStd == null) {
			return;
		}
		
		grade = newStd.grade;
		classNum = newStd.classNum;
		num = newStd.num;
		name = newStd.name;
	}
}
