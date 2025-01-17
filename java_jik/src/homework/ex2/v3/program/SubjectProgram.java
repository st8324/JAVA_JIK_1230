package homework.ex2.v3.program;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import homework.ex2.v3.manager.StudentManager;
import homework.ex2.v3.manager.SubjectManager;
import homework.ex2.v3.vo.Student;
import homework.ex2.v3.vo.Subject;

public class SubjectProgram implements ConsoleProgram {

	private Scanner scan;
	private String fileName;
	
	private SubjectManager subjectManager;
	
	public SubjectProgram(Scanner scan, List<Subject> subjects) {
		this.scan = scan;
		this.subjectManager = new SubjectManager(subjects);
	}
	public SubjectProgram(Scanner scan, List<Subject> subjects, String fileName) {
		this.scan = scan;
		this.subjectManager = new SubjectManager(subjects);
		this.fileName = fileName;
	}
	public SubjectProgram() {
		this.scan = new Scanner(System.in);
		//파일명을 지정안한 경우 다운로드 폴더에 파일을 저장/불러오기
		this.fileName = getDownloadPath() + "/subject.txt";
	}
	
	@Override
	public void printMenu() {
		System.out.println("---------------------");
		System.out.println("1. 과목 추가 ");
		System.out.println("2. 과목 수정 ");
		System.out.println("3. 과목 삭제 ");
		System.out.println("4. 과목 조회 ");
		System.out.println("5. 종료");
		System.out.println("---------------------");
		System.out.print("메뉴 선택 : ");
		
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertSubject();
			break;
		case 2:
			updateSubject();
			break;
		case 3:
			deleteSubject();
			break;
		case 4:
			searchSubject();
			break;
		case 5:
			System.out.println("프로그램 종료");
			break;
		default:
			System.out.println("올바른 메뉴가 아닙니다.");
			break;
		}
		
	}

	public Subject inputSubject() {
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("학기 : ");
		int semester = scan.nextInt();
		removeBuffer();
		System.out.print("과목명: ");
		String name = scan.nextLine();
		return new Subject(grade, semester, name);
	}
	
	private void insertSubject() {
		//과목 정보 입력
		Subject subject = inputSubject();
		
		if(subjectManager.insert(subject)) {
			System.out.println("과목을 등록했습니다.");
			return;
		}
		System.out.println("과목을 등록하지 못했습니다.");
	}
	private void updateSubject() {
		//기존 과목 정보 입력
		Subject oldSubject = inputSubject();
		
		//등록된 과목이 아니면 알림
		if(!subjectManager.contains(oldSubject)) {
			System.out.println("등록된 과목이 아닙니다.");
			return;
		}
		
		//새 과목 정보 입력
		System.out.println("수정할 과목 정보를 입력하세요.");
		Subject newSubject = inputSubject();
		
		if(subjectManager.update(oldSubject, newSubject)) {
			System.out.println("과목을 수정했습니다.");
			return;
		}
		System.out.println("과목을 수정하지 못했습니다.");
		
	}
	private void deleteSubject() {
		//기존 과목 정보 입력
		Subject subject = inputSubject();
		
		if(subjectManager.delete(subject)) {
			System.out.println("과목을 삭제했습니다.");
			return;
		}
		System.out.println("과목을 삭제하지 못했습니다.");
		
	}
	private void searchSubject() {
		subjectManager.print();
	}
	@Override
	public void run() {
		int menu = 0; //예외처리 때문에 초기화를 해야 함.
		final int EXIT = 5;
		
		if(fileName != null) {
			List<Subject> tmps= (List<Subject>) load(fileName);

			//불러오기 실패하면 빈 리스트, 성공하면 데이터리스트
			subjectManager = new SubjectManager(tmps);
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
			save(fileName, subjectManager.getList());
		}
		
	}
	@Override
	public void removeBuffer() {
		scan.nextLine();
	}
	
}
