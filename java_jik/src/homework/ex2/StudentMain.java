package homework.ex2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class StudentMain {

	/* 학생 성적 관리 프로그램을 작성하세요.
	 * 1. 학생 등록
	 * 	- 학년, 반, 번호, 이름을 입력받아 등록
	 * 	- 이미 등록된 학생 정보(학년, 반, 번호가 같은 경우)라면 등록하지 않음
	 * 2. 학생 수정
	 * 	- 학년, 반, 번호를 입력받아 학생이 있는지 찾고, 있으면 수정
	 * 	- 수정하는 정보는 학년, 반, 번호, 이름을 수정
	 * 	- 이미 등록된 학생 정보로 수정하려고 하면 수정하지 않음
	 * 3. 학생 삭제
	 * 	- 학년, 반, 번호를 입력받아 학생이 있는지 찾고 있으면 삭제
	 * 4. 과목 등록
	 * 	- 학년, 학기, 과목명을 입력받아 없으면 등록
	 * 5. 과목 수정
	 * 	- 학년, 학기, 과목을 입력받아 있으면 학년, 학기, 과목을 입력받아 수정
	 * 	- 수정하려는 과목이 이미 등록된 과목이라면 수정하지 않음
	 * 6. 과목 삭제
	 * 	- 학년, 학기, 과목을 입력받아 있으면 삭제
	 * 7. 성적 등록
	 * 	- 학년, 반, 번호를 입력받아 학생을 찾음
	 * 	- 있으면 과목을 출력
	 * 	- 과목을 선택
	 * 	- 성적을 입력해서 학생 성적을 등록
	 * 8. 성적 수정
	 * 	- 학년, 반, 번호를 입력받아 학생을 찾음
	 * 	- 있으면 학년, 학기, 과목명을 입력받고 있으면 성적을 입력받아 수정
	 * 9. 성적 삭제
	 * 	- 학년, 반, 번호를 입력받아 학생을 찾음
	 * 	- 있으면 학년, 학기, 과목명을 입력받고 있으면 삭제
	 * 10. 학생 조회
	 * 	- 학년, 반을 입력하면 학생들을 조회
	 * 11. 과목 조회
	 * 	- 등록된 과목 전체를 조회
	 * 12. 성적 조회
	 * 	- 학년, 반, 번호를 입력하면 학생 있으면 학생 성적을 조회
	 * */
	//등록된 과목을 관리할 과목 리스트
	static ArrayList<Subject> subjectList = new ArrayList<Subject>();
	//등록된 학생을 관리할 학생 리스트
	static ArrayList<Student> studentList = new ArrayList<Student>();
	//입력을 위한 Scanner
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int menu = 0; //예외처리 때문에 초기화를 해야 함.
		final int EXIT = 13;
		do {
			//메뉴 출력
			printMenu();
			
			try {
				//메뉴 선택
				menu = scan.nextInt();
				
				//앞에서 입력한 엔터를 처리
				removeBuffer();
				
				//메뉴 실행
				runMenu(menu);
			}
			//잘못된 타입의 메뉴를 입력한 경우
			catch(InputMismatchException e) {
				System.out.println("올바른 입력이 아닙니다!");
				removeBuffer();
			}
			
		}while(menu != EXIT);

	}
	//입력 버퍼에 남아 있는 문자열(엔터)을 제거하는 메소드
	private static void removeBuffer() {
		scan.nextLine();
	}

	private static void printMenu() {

		System.out.println("1. 학생 등록");
		System.out.println("2. 학생 수정");
		System.out.println("3. 학생 삭제");
		System.out.println("4. 과목 등록");
		System.out.println("5. 과목 수정");
		System.out.println("6. 과목 삭제");
		System.out.println("7. 성적 등록");
		System.out.println("8. 성적 수정");
		System.out.println("9. 성적 석제");
		System.out.println("10.학생 조회");
		System.out.println("11.과목 조회");
		System.out.println("12.성적 조회");
		System.out.println("13.종료");
		System.out.print("메뉴 선택 : ");
		
	}
	
	private static void runMenu(int menu) {

		switch(menu) {
		case 1:
			insertStudent();
			break;
		case 2:
			updateStudent();
			break;
		case 3:
			deleteStudent();
			break;
		case 4:
			insertSubject();
			break;
		case 5:
			updateSubject();
			break;
		case 6:
			deleteSubject();
			break;
		case 7:
			insertScore();
			break;
		case 8:
			updateScore();
			break;
		case 9:
			deleteScore();
			break;
		case 10:
			searchStudent();
			break;
		case 11:
			searchSubject();
			break;
		case 12:
			searchScore();
			break;
		case 13:
			System.out.println("프로그램 종료");
			break;
		default:
			System.out.println("올바른 메뉴가 아닙니다.");
			break;
		}
		
	}

	private static void searchScore() {
		// TODO Auto-generated method stub
		
	}
	private static void searchSubject() {
		// TODO Auto-generated method stub
		
	}
	private static void searchStudent() {
		// TODO Auto-generated method stub
		
	}
	private static void deleteScore() {
		// TODO Auto-generated method stub
		
	}
	private static void updateScore() {
		// TODO Auto-generated method stub
		
	}
	private static void insertScore() {
		// TODO Auto-generated method stub
		
	}
	private static void deleteSubject() {
		// TODO Auto-generated method stub
		
	}
	private static void updateSubject() {
		/* 
		 * 1 1 국어
		 * 1 2 국어
		 * 2 1 영어
		 * 2 2 영어
		 * 1 3 국어 
		 * */
		//학년, 학기, 과목명을 입력
		
		//등록된 과목이 아니면 알림 후 종료 => indexOf로 번지를 가져와서 사용
		
		//새 과목 정보를 입력(학년, 학기, 과목)
		
		//등록된 과목이면 알림 후 종료
		//리스트에서 index 번지에 있는 값을 제거 후 제거된 객체를 저장
		
		//아니면 수정
		
	}
	private static void insertSubject() {
		//학년, 학기, 과목명을 입력
		
		//이미 등록된 과목이면 알림 후 종료 => Subject클래스의 equals를 오버라이딩
		
		//과목을 추가 후 알림
		
	}
	private static void deleteStudent() {
		//학년, 반, 번호를 입력
		
		//입력받은 정보로 객체 생성
		
		//생성한 객체를 이용하여 리스트에서 삭제
		//삭제에 성공하면 성공알림문구
		
		
		//실패하면 실패 알림문구 출력
		
	}

	private static void updateStudent() {
		//학년, 반, 번호 입력
		
		//입력한 학생 정보를 객체 생성
		
		//생성한 객체가 리스트에 있으면 번지를 가져옴
		
		//번지가 음수이면(없으면) 안내문구 출력 후 종료
		
		//아니면(학생이 있으면) 수정할 학년, 반, 번호, 이름을 입력
		
		//입력받은 정보로 객체를 생성
		
		//번지에 있는 객체를 위에서 생성한 객체로 변경
		
	}

	private static void insertStudent() {
		//학년, 반, 번호, 이름 입력
		
		//입력 받은 학년, 반, 번호, 이름을 이용하여 객체 생성 => 리스트에 있는 기능을 활용하기 위해
		
		//생성한 객체가 리스트에 있는지 확인하여 있으면 종료 => Student클래스의 equals를 오버라이딩
		//리스트.indexOf(객체2) => Objects.equals(객체1, 객체2) => 객체1.equals(객체2)
		
		//없으면 리스트에 추가 후 안내 문구
		
	}
}







