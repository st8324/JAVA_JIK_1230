package day23;

import lombok.Data;

public class Ex06_Class {

	public static void main(String[] args) {
		/* 다음 예제에서 잘못된 부분을 찾아 수정하세요. */
		/* 1. 객체를 생성해서 전달 하던지 
		 * 2. print 메소드에 null인 경우를 처리하면 됨*/
		MyStudent std = null;
		print(std);
	}

	public static void print(MyStudent std) {
		System.out.print(std.getGrade() + "학년");
		System.out.print(std.getClassNum() + "반");
		System.out.print(std.getNum() + "번호");
		System.out.println(std.getName());
	}
}

@Data
class MyStudent{
	int grade, classNum, num;
	String name;
}