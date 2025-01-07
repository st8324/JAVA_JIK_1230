package day06;

import java.util.Scanner;

public class Ex09_ProgramScore {

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		/* 학생의 국어 성적을 관리하는 프로그램을 작성해보세요.
		 * 
		 * 메뉴
		 * 1. 학생 국어 성적 추가
		 * 2. 학생 국어 성적 전체 조회
		 * 3. 종료
		 * 메뉴 선택 : 1
		 * 이름 : 홍길동
		 * 성적 : 100
		 * 메뉴
		 * 1. 학생 국어 성적 추가
		 * 2. 학생 국어 성적 전체 조회
		 * 3. 종료
		 * 메뉴 선택 : 1
		 * 이름 : 임꺽정
		 * 성적 : 90
		 * 메뉴
		 * 1. 학생 국어 성적 추가
		 * 2. 학생 국어 성적 전체 조회
		 * 3. 종료
		 * 메뉴 선택 : 2
		 * 홍길동 : 100
		 * 임꺽정 : 90
		 * 평균 : 95
		 * 메뉴
		 * 1. 학생 국어 성적 추가
		 * 2. 학생 국어 성적 전체 조회
		 * 3. 종료
		 * 메뉴 선택 : 3
		 * */
		Student [] std = new Student[5];
		char menu;
		int count = 0;//저장된 학생 수
		//반복
		do {
			//메뉴 출력
			printMenu();
			
			//메뉴 선택
			menu = scan.next().charAt(0);
			
			//기능 실행
			count = runMenu(menu, std, count);
			//학생 배열이 꽉 차면 늘려주는 기능
			std = expend(std, count);
		}while(menu != '3');
	}

	
	private static void printMenu() {
		System.out.println("-----------메뉴-----------");
		System.out.println("1. 학생 국어 성적 추가");
		System.out.println("2. 학생 국어 성적 전체 조회");
		System.out.println("3. 종료");
		System.out.println("-------------------------");
		System.out.print("메뉴 선택 : ");
	}

	private static int runMenu(char menu, Student[] std, int count) {
		System.out.println("-------------------------");
		switch(menu) {
		case '1':
			count = insertStudent(std, count);
			break;
		case '2':
			printStudent(std, count);
			break;
		case '3':
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("올바른 메뉴가 아닙니다.");
		}
		System.out.println("-------------------------");
		return count;
	}
	
	private static int insertStudent(Student[] std, int count) {
		//학생 정보를 입력(이름과 성적)
		System.out.print("이름 : ");
		scan.nextLine();//앞에 남아있는 엔터를 처리
		String name = scan.nextLine();
		
		System.out.print("성적 : ");
		int score = scan.nextInt();
		
		//학생 정보를 이용해서 Student의 객체를 생성
		Student student = new Student(name, score);
		//배열에 추가 
		std[count] = student;
		return count+1;
	}


	private static void printStudent(Student[] std, int count) {
		int sum = 0;
		for(int i = 0; i<count; i++) {
			//학생 정보를 출력
			std[i].print();
			sum += std[i].getScore();
		}
		double avg = sum / (double)count;
		System.out.println("평균 : " + avg);
	}


	private static Student[] expend(Student[] std, int count) {
		if(std == null) {
			return new Student[5];
		}
		if(count < std.length) {
			return std;
		}
		//확장
		Student tmp[] = new Student[std.length + 5];
		//복사 
		System.arraycopy(std, 0, tmp, 0, std.length);
		
		return tmp;
	}

}

class Student{
	private String name;
	private int score;

	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	public int getScore() {
		return score;
	}
	public void print() {
		System.out.println(name + " : " + score);
	}
}


