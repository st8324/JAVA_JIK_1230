package day12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex03_Student {

	
	/* 
	 * 다음 기능을 갖는 프로그램을 작성하세요.
	 * 1. 학생 추가
	 * 	- 학년, 반, 번호 이름 입력
	 * 2. 학생 조회
	 * 3. 종료
	 * 4. 학생 삭제
	 * 	- 이름을 입력받아 학생들을 출력하고, 그중 선택된 학생을 삭제
	 * 
	 * 2-1. 학년 조회 : 학년
	 * 2-2. 반 조회 : 학년, 반
	 * 2-3. 번호 조회 : 학년, 반, 번호
	 * 2-4. 전체 조회 : X
	 * 
	 * - 학생 클래스 추가
	 * - List를 이용해서 학생들을 관리
	 * - Stream과 람다식을 이용해서 출력을 구현
	 * */
	
	static Scanner scan = new Scanner(System.in);
	static List<Student> list = new ArrayList<Student>();
	
	public static void main(String[] args) {
		
		list.add(new Student(1, 1, 1, "홍길동"));
		list.add(new Student(1, 1, 2, "임꺽정"));
		list.add(new Student(2, 1, 1, "둘리"));
		list.add(new Student(3, 1, 1, "고길동"));
		list.add(new Student(3, 2, 1, "또치"));
		
		int menu;
		
		do {
			
			printMenu();
			
			menu = scan.nextInt();
			scan.nextLine();
			
			runMenu(menu);
			
		}while(menu != 3);

	}

	private static void printMenu() {
		System.out.print(
			"---------------\n" + 
			"1. 학생 추가\n" + 
			"2. 학생 조회\n" + 
			"3. 종료\n" + 
			"4. 학생 삭제\n" + 
			"---------------\n" +
			"메뉴 선택 : ");
	}

	private static void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertStudent();
			break;
		case 2:
			searchStudent();
			break;
		case 3:
			System.out.println("프로그램을 종료합니다.");
			break;
		case 4:
			deleteStudent();
			break;
		default:
			System.out.println("올바른 메뉴가 아닙니다.");
		}
	}

	private static void deleteStudent() {
		//이름 입력
		
		System.out.print("이름 : ");
		String name = scan.nextLine();
		
		//이름을 포함하는 학생들을 번호와 함께 출력
		List<Student> tmpList = 
			list
			.stream()
			.filter(s->s.getName().contains(name))
			.collect(Collectors.toList());
		print(tmpList, s->true, true);
		
		//삭제할 번호를 입력
		System.out.print("삭제할 학생 번호 : ");
		int count = scan.nextInt();
		
		//입력받은 번호에 맞는 개체를 가져옴
		Student tmp = tmpList.get(count-1);
		
		//리스트에서 삭제할 객체를 이용하여 제거
		list.remove(tmp);
		
	}

	private static void insertStudent() {
		//학년, 반, 번호, 이름을 입력
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		
		System.out.print("반 : ");
		int classNum = scan.nextInt();
		
		System.out.print("번호 : ");
		int num = scan.nextInt();
		
		scan.nextLine();
		
		System.out.print("이름 : ");
		String name = scan.nextLine();
		
		//입력받은 정보로 학생 객체를 생성
		Student std = new Student(grade, classNum, num, name);
		
		//리스트에 추가
		list.add(std);
		
	}

	private static void searchStudent() {

		//조회 메뉴 출력
		printSearchMenu();
		
		//조회 메뉴 선택
		int menu = scan.nextInt();
		scan.nextLine();
		
		//조회 기능을 실행
		runPrintMenu(menu);
	}

	private static void printSearchMenu() {
		System.out.print(
				"---------------\n" + 
				"1. 학년 조회\n" + 
				"2. 반 조회\n" + 
				"3. 번호 조회\n" + 
				"4. 전체 조회\n" + 
				"---------------\n" +
				"메뉴 선택 : ");
		
	}

	private static void runPrintMenu(int menu) {
		switch(menu) {
		case 1:
			searchGrade();
			break;
		case 2:
			searchClassNum();
			break;
		case 3:
			searchNum();
			break;
		case 4:
			searchAll();
			break;
		default:
			System.out.println("올바른 메뉴가 아닙니다.");
		}
		
	}

	private static void searchGrade() {
		//학년 입력
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		
		//리스트에서 학년이 같은 학생들을 출력
		print(list, s->s.getGrade() == grade);
	}

	private static void searchClassNum() {
		//학년, 반 입력
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		
		System.out.print("반 : ");
		int classNum = scan.nextInt();
		
		//리스트에서 학년, 반이 같은 학생들을 출력
		print(list, s->s.getGrade() == grade && s.getClassNum() == classNum);
	}

	private static void searchNum() {
		//학년, 반, 번호 입력
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		
		System.out.print("반 : ");
		int classNum = scan.nextInt();
		
		System.out.print("번호 : ");
		int num = scan.nextInt();
		
		//리스트에서 학년, 반, 번호가 같은 학생을 출력
		print(list, s->s.getGrade() == grade 
				&& s.getClassNum() == classNum
				&& s.getNum() == num);
	}

	private static void searchAll() {
		//학생 전체를 출력
		print(list, s->true);
	}

	private static void print(List<Student> list, Predicate<Student> p) {
		print(list, p, false);
	}
	
	private static void print(List<Student> list, Predicate<Student> p, boolean isCount) {
		Stream<Student> stream = list.stream();
		AtomicInteger index = new AtomicInteger(1);
		
		stream
			.filter(p)
			.forEach(s->{
				int num = index.getAndIncrement();
				System.out.println( (isCount? num + ". " : "") + s);
			});
	}
}

@Data
@AllArgsConstructor
class Student{
	
	private int grade, classNum, num;
	private String name;
	
	@Override
	public String toString() {
		return grade+"학년 " + classNum + "반 " + num + "번 " + name ;
	}
}













