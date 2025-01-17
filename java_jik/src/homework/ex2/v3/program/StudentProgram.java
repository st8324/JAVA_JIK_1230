package homework.ex2.v3.program;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import homework.ex2.v3.manager.StudentManager;
import homework.ex2.v3.vo.Student;

public class StudentProgram implements ConsoleProgram {

	private Scanner scan;
	private String fileName;
	
	private StudentManager studentManager;
	
	public StudentProgram(Scanner scan, List<Student> students) {
		this.scan = scan;
		studentManager = new StudentManager(students);
	}
	public StudentProgram(Scanner scan, List<Student> students, String fileName) {
		this(scan, students);
		this.fileName = fileName;
	}
	
	public StudentProgram() {
		this.scan = new Scanner(System.in);
		//파일명을 지정안한 경우 다운로드 폴더에 파일을 저장/불러오기
		this.fileName = getDownloadPath() + "/students.txt";
	}
	
	@Override
	public void printMenu() {

		System.out.println("---------------------");
		System.out.println("1. 학생 추가 ");
		System.out.println("2. 학생 수정 ");
		System.out.println("3. 학생 삭제 ");
		System.out.println("4. 학생 조회 ");
		System.out.println("5. 종료");
		System.out.println("---------------------");
		System.out.print("메뉴 선택 : ");
		
	}

	@Override
	public void runMenu(int menu) {
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
			searchStudent();
			break;
		case 5:
			System.out.println("프로그램 종료");
			break;
		default:
			System.out.println("올바른 메뉴가 아닙니다.");
			break;
		}
		
	}

	private void deleteStudent() {
		//학생 기본 정보 입력(학년, 반, 번호)
		Student student = studentManager.inputBaseStudent(scan);
		
		if(studentManager.deleteStudent(student)) {
			System.out.println("학생을 삭제했습니다.");
			return;
		}
		System.out.println("학생을 삭제하지 못했습니다.");
		
	}
	private void updateStudent() {
		//학생 기본 정보 입력(학년, 반, 번호)
		Student student = studentManager.inputBaseStudent(scan);
		
		//학생이 있는지 확인하여 없으면 알림 후 종료
		if(!studentManager.contains(student)) {
			System.out.println("등록되지 않은 학생입니다.");
			return;
		}
		
		System.out.println("수정할 학생 정보를 입력하세요.");
		Student newInfo = studentManager.inputStudent(scan);
		
		if(studentManager.updateStudent(student, newInfo)) {
			System.out.println("학생을 수정했습니다.");
			return;
		}
		System.out.println("수정하지 못했습니다.");
	}
	private void searchStudent() {
		//학생 기본 정보를 입력 받음(학년, 반, 번호)
		Student student = studentManager.inputBaseStudent(scan);
		
		//일치하는 학생 정보 출력
		studentManager.printStudent(student);
		
	}
	private void insertStudent() {
		//학생 정보를 입력 받음(학년, 반, 번호, 이름)
		Student student = studentManager.inputStudent(scan);
		
		//학생을 추가하고 결과를 알림
		if(studentManager.insertStudent(student)) {
			System.out.println("학생을 추가했습니다.");
			return;
		}
		System.out.println("학생을 추가하지 못했습니다.");
	}
	
	
	
	@Override
	public void run() {
		int menu = 0; //예외처리 때문에 초기화를 해야 함.
		final int EXIT = 5;
		
		if(fileName != null) {
			List<Student> tmps= (List<Student>) load(fileName);

			//불러오기 실패하면 빈 리스트, 성공하면 데이터리스트
			studentManager = new StudentManager(tmps);
		}
		do {
			//메뉴 출력
			printMenu();
			
			try {
				//메뉴 선택
				menu = scan.nextInt();
				
				//앞에서 입력한 엔터를 처리
				removeBuffer();
				
				System.out.println("---------------------");
				
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
		if(fileName != null) {
			save(fileName, studentManager.getList());
		}
		
	}
	@Override
	public void removeBuffer() {
		scan.nextLine();
	}
}
