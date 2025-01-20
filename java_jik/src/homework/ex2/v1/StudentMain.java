package homework.ex2.v1;

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
		
		//불러오기
		
		
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
		
		//저장하기

	}
	//입력 버퍼에 남아 있는 문자열(엔터)을 제거하는 메소드
	private static void removeBuffer() {
		scan.nextLine();
	}

	private static void printMenu() {
		System.out.println("-----------------");
		System.out.println("1. 학생 등록");
		System.out.println("2. 학생 수정");
		System.out.println("3. 학생 삭제");
		System.out.println("4. 과목 등록");
		System.out.println("5. 과목 수정");
		System.out.println("6. 과목 삭제");
		System.out.println("7. 성적 등록");
		System.out.println("8. 성적 수정");
		System.out.println("9. 성적 삭제");
		System.out.println("10.학생 조회");
		System.out.println("11.과목 조회");
		System.out.println("12.성적 조회");
		System.out.println("13.종료");
		System.out.println("-----------------");
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
		//학년, 반, 번호를 입력
		
		//입력한 정보를 이용해서 객체를 생성
		
		//리스트에 학생이 없으면 알림 후 종료 => indexOf
		
		//학년, 학기, 과목명을 입력
		
		//과목정보로 객체를 생성
		
		//리스트에서 학생을 선택
		
		//선택한 학생에게 과목정보를 주면서 성적을 출력하고 요청
		
	}
	private static void searchSubject() {
		//등록된 과목 전체 출력
		
	}
	private static void searchStudent() {
		//학년, 반, 번호를 입력
		//입력한 정보를 이용해서 객체를 생성
		Student std = inputBaseStudent();
		
		//리스트에서 일치하는 학생이 있으면 정보를 출력
		int index = studentList.indexOf(std);
		if(index >= 0) {
			std.print();
			return;
		}
		//없으면 없다고 알림 출력
		System.out.println("일치하는 학생이 없습니다.");
		
	}
	private static void deleteScore() {
		//학년, 반, 번호를 입력
		
		//입력한 정보로 객체를 생성(Student)
		
		//리스트에 있는지 확인해서 없으면 알림 후 종료 => indexOf
		
		//학년, 학기, 과목을 입력
		
		//입력한 정보로 객체를 생성(Subject)
		
		//과목리스트에 등록된 과목인지 확인 후 아니면 알림 후 종료
		
		//학생에게 과목 정보를 주면서 성적을 삭제하라고 요청 하고 성공하면 성공 알림
		
		//실패하면 실패 알림
		
	}
	private static void updateScore() {
		//학년, 반, 번호를 입력
		
		//입력한 정보로 객체를 생성(Student)
		
		//리스트에 있는지 확인해서 없으면 알림 후 종료 => indexOf
		
		//학년, 학기, 과목을 입력
		
		//입력한 정보로 객체를 생성(Subject)
		
		//과목리스트에 등록된 과목인지 확인 후 아니면 알림 후 종료
		
		//새 과목 정보를 입력(학년, 학기, 과목)을 입력
		
		//과목 리스트에 등록된 과목인지 확인 후 아니면 알림 후 종료
		
		//성적을 입력
		
		//새 과목 정보와 성적을 이용하여 성적 객체를 생성
		
		//학생에게 기존 과목 정보와 성적 정보를 주면서 수정하라고 요청한 후 성공하면 알림
		
		//실패하면 알림
		
		
	}
	private static void insertScore() {
		//학년, 반, 번호를 입력
		
		//입력한 정보로 객체를 생성(Student)
		
		//리스트에 있는지 확인해서 없으면 알림 후 종료 => indexOf
		
		//학년, 학기, 과목을 입력
		
		//입력한 정보로 객체를 생성(Subject)
		
		//과목리스트에 등록된 과목인 확인 후 아니면 알림 후 종료
		
		//성적을 입력해서 과목 정보와 성적을 이용하여 객체를 생성(Score)
		
		//학생을 선택하여 객체 저장 list.get(xx).update() => tmp.update()
		
		
		{
		//학생 성적에 새 성적이 있는지 확인해서 없으면 추가후 알림
		//있으면 추가 안하고 알림
		
		//학생에게 새 성적을 주고 추가 하라고 시킨 후 추가 여부를 이용하여 추가했으면 성공 알림
		//실패했으면 실패 알림
		}
	}
	private static void deleteSubject() {
		//학년, 학기, 과목명을 입력
		
		//입력한 정보로 객체를 생성 
		
		//리스트에서 생성한 객체를 제거해서 성공하면 성공 알림
		
		//실패하면 실패 알림
		
	}
	private static void updateSubject() {
		/* 
		 * 1 1 국어
		 * 1 2 국어
		 * 2 1 영어
		 * 2 2 영어
		 * 1 1 수학
		 * 
		 * tmp : 1 3 국어 
		 * 
		 * 1 3 국어 => 1 1 국어 X
		 * 1 3 국어 => 1 3 국어 O
		 * 1 3 국어 => 1 1 수학 O
		 * */
		//학년, 학기, 과목명을 입력
		
		//입력한 정보로 객체를 생성 
		
		//등록된 과목이 아니면 알림 후 종료 => indexOf로 번지를 가져와서 사용
		
		//새 과목 정보를 입력(학년, 학기, 과목)
		
		//등록된 과목이면 알림 후 종료
			//리스트에서 index 번지에 있는 값을 제거 후 제거된 객체를 저장
		
			//제거된 리스트에 새 과목정보와 일치하는 과목이 있으면 제거된 객체를 다시 추가
		
		//아니면 수정
			//새 객체를 추가
		
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
		Student std = inputBaseStudent();
		
		//생성한 객체가 리스트에 있으면 번지를 가져옴
		int index = studentList.indexOf(std);
		
		//번지가 음수이면(없으면) 안내문구 출력 후 종료
		if(index < 0) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		
		//아니면(학생이 있으면) 수정할 학년, 반, 번호, 이름을 입력
		//입력받은 정보로 객체를 생성
		Student newStd = inputStudent();
		
		
		//번지에 있는 객체를 위에서 생성한 객체로 변경
		
	}

	private static void insertStudent() {
		
		//학년, 반, 번호, 이름 입력
		//주의 : 학생 객체 생성시 성적 리스트를 생성
		//입력 받은 학년, 반, 번호, 이름을 이용하여 객체 생성 => 리스트에 있는 기능을 활용하기 위해
		Student std = inputStudent();
		
		//생성한 객체가 리스트에 있는지 확인하여 있으면 종료 => Student클래스의 equals를 오버라이딩
		//리스트.indexOf(객체2) => Objects.equals(객체1, 객체2) => 객체1.equals(객체2)
		if(studentList.contains(std)) {
			System.out.println("이미 등록된 학생입니다.");
			return;
		}
		//없으면 리스트에 추가 후 안내 문구
		studentList.add(std);
		System.out.println("학생을 등록했습니다.");
	}
	
	/** 학년, 반, 번호를 입력하면 객체를 반환하는 메소드 */
	public static Student inputBaseStudent() {
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("학급 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		return new Student(grade, classNum, num, "");
	}
	/** 학년, 반, 번호, 이름을 입력하면 객체를 반환하는 메소드 */
	public static Student inputStudent() {
		Student tmp = inputBaseStudent();

		removeBuffer();
		
		System.out.print("이름 : ");
		String name = scan.nextLine();
		
		tmp.setName(name);
		return tmp;
	}
}







