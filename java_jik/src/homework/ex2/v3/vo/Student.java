package homework.ex2.v3.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

//getter, setter, toString, equals등을 제공
@Data
@RequiredArgsConstructor //@NonNull을 가진 필드 또는 상수(final)이 붙은 필드로만 생성자를 만들어줌
@AllArgsConstructor
public class Student implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NonNull
	private int grade, classNum, num;
	@NonNull
	private String name;
	
	//학생 개인의 성적을 담고 있는 배열
	public List<SubjectScore> list;

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
	//학생 정보 출력하는 메소드
	public void print() {
		System.out.println("---------------------");
		System.out.println(grade + "학년 " + classNum + "반 " + num + "번 " + name);
		System.out.println("---------------------");
		if(list == null || list.size() == 0) {
			System.out.println("등록된 성적이 없습니다.");
			System.out.println("---------------------");
			return;
		}
		for(SubjectScore score : list) {
			System.out.println(score);
		}
		System.out.println("---------------------");
	}
	//학생 정보를 수정하는 메소드
	public void update(Student newInfo) {
		this.grade = newInfo.grade;
		this.classNum = newInfo.classNum;
		this.num = newInfo.num;
		this.name = newInfo.name;
	}
	
}
