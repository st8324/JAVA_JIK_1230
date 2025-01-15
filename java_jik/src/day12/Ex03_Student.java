package day12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
			System.out.println("삭제 구현 예정");
			break;
		default:
			System.out.println("올바른 메뉴가 아닙니다.");
		}
	}

	private static void insertStudent() {
		//학년, 반, 번호, 이름을 입력
		
		//입력받은 정보로 학생 객체를 생성
		
		//리스트에 추가
		
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
		
		//리스트에서 학년이 같은 학생들을 출력
		
	}

	private static void searchClassNum() {
		//학년, 반 입력
		
		//리스트에서 학년, 반이 같은 학생들을 출력
		
	}

	private static void searchNum() {
		//학년, 반, 번호 입력
		
		//리스트에서 학년, 반, 번호가 같은 학생을 출력
		
	}

	private static void searchAll() {
		//학생 전체를 출력
		
	}

	private static void print() {
		
	}
}

@Data
@AllArgsConstructor
class Student{
	
	private int grade, classNum, num;
	private String name;
	
}













