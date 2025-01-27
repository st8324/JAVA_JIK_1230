package day19;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex03_Student {

	private static Scanner scan = new Scanner(System.in);
	//여러날 출석 정보를 관리하는 출석부
	private static List<AttendanceList> list = new ArrayList<AttendanceList>();
	//학생 목록
	private static List<String> students = new ArrayList<String>();
	
	public static void main(String[] args) {
		/* 학생들의 출석을 관리하는 프로그램을 작성하세요.
		 * 1. 학생 등록
		 * 	- 이름만 입력해서 등록
		 * 2. 출석 체크
		 * 	- 날짜를 입력하면 등록된 학생들의 출석 여부를 체크
		 * 	  - 2025-01-27
		 * 	- 지각, 조퇴는 없다고 가정
		 * 	- 출석이면 O, 결석이면 X로 관리
		 *  - 예(등록된 학생이 홍길동, 임꺽정인 경우)
		 * 1. 홍길동 : O
		 * 2. 임꺽정 : X
		 * 3. 출석 확인
		 *  - 등록된 날짜들를 조회
		 *  - 조회된 날짜 중에서 선택해서 출석을 확인
		 * 4. 종료
		 * */
		int menu;
		
		do {
			printMenu();
			
			menu = scan.nextInt();
			scan.nextLine();
			
			runMenu(menu);
		}while(menu != 4);
	}

	private static void printMenu() {
		System.out.println("-----------------");
		System.out.println("1. 학생 등록");
		System.out.println("2. 출석 체크");
		System.out.println("3. 출석 확인");
		System.out.println("4. 종료");
		System.out.println("-----------------");
		System.out.print("메뉴 선택 : ");
	}

	private static void runMenu(int menu) {

		switch(menu) {
		case 1:
			insertStudent();
			break;
		case 2:
			check();
			break;
		case 3:
			print();
			break;
		case 4:
			System.out.println("[프로그램을 종료합니다.]");
			break;
		default:
			System.out.println("[올바른 메뉴가 아닙니다.]");
		}
		
	}

	private static void insertStudent() {
		System.out.print("이름 : ");
		String name = scan.nextLine();
		students.add(name);
		System.out.println("[학생을 등록했습니다.]");
	}

	private static void check() {
		System.out.print("날짜 입력 : ");
		String date = scan.nextLine();
		
		if(students.isEmpty()) {
			System.out.println("[등록된 학생이 없습니다.]");
			return;
		}
		
		//학생 이름 출력 후 출석 여부를 입력 받음.
		System.out.println("----------------------------------------------");
		System.out.println("[학생들의 출석 여부를 체크해주세요.(출석 : O, 결석 : X)]");
		System.out.println("----------------------------------------------");
		
		List<Attendance> attendances = new ArrayList<Attendance>();
		
		for(int i = 0; i < students.size(); i++) {
			System.out.print(i+1 + ". " + students.get(i) + " : ");
			char check = scan.next().charAt(0);
			//출석 객체를 생성
			Attendance attendance = new Attendance(students.get(i), check);
			//출석리스트에 추가
			attendances.add(attendance);
		}
		//출석부에 출석 리스트를 추가
		list.add(new AttendanceList(date, attendances));
	}

	private static void print() {
		
		if(!printDates()) {
			return;
		}
		
		System.out.print("조회하려는 날짜의 번호를 입력 : ");
		int index = scan.nextInt() - 1;
		
		if(index < 0 || index >= list.size()) {
			System.out.println("[입력을 잘못했습니다.]");
			return;
		}
		//출석부에서 날짜와 일치하는 출석리스트를 가져옴
		AttendanceList attendanceList = list.get(index);
		attendanceList.print();
		
	}

	private static boolean printDates() {
		if(list.isEmpty()) {
			System.out.println("등록된 출석부가 없습니다.");
			return false;
		}
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(i+1 + ". " + list.get(i).getDate());
		}
		return true;
	}
}
@Data
@AllArgsConstructor
class AttendanceList{
	private String date;
	private List<Attendance> list;

	public void print() {
		System.out.println("출석일 : " + date);
		for(Attendance attendance : list) {
			System.out.println(attendance);
		}
		
	}
}
@Data
@AllArgsConstructor
class Attendance{
	private String name;
	private char attendace;
	
	@Override
	public String toString() {
		return name + " : " + attendace;
	}
	
	
}
