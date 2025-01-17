package homework.ex2.v3.program;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import homework.ex2.v3.vo.Student;
import homework.ex2.v3.vo.Subject;

public class Program implements ConsoleProgram {

	private Scanner scan = new Scanner(System.in);
	
	private List<Student> students = new ArrayList<Student>();
	private List<Subject> subjects = new ArrayList<Subject>(); 
	
	public void run() {
		

		int menu = 0; //예외처리 때문에 초기화를 해야 함.
		final int EXIT = 4;
		
		//불러오기
		String studentFileName = "src/homework/ex2/v3/student.txt";
		String subjectFileName = "src/homework/ex2/v3/subject.txt";
		
		students = (ArrayList<Student>)load(studentFileName);
		subjects = (List<Subject>) load(subjectFileName);

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
		
		students.add(new Student(1,1,1,"홍길동"));
		
		//저장하기
		save(studentFileName, students);
		save(subjectFileName, subjects);
	}
	
	public void removeBuffer() {
		scan.nextLine();
	}
	
	@Override
	public void printMenu() {
		System.out.println("---------------------");
		System.out.println("1. 학생 관리 ");
		System.out.println("2. 과목 관리 ");
		System.out.println("3. 성적 관리 ");
		System.out.println("4. 프로그램 종료");
		System.out.println("---------------------");
		System.out.print("메뉴 선택 : ");
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			StudentProgram studentProgram = new StudentProgram(scan, students);
			studentProgram.run();
			break;
		case 2:
			SubjectProgram subjectProgram = new SubjectProgram(scan, subjects);
			subjectProgram.run();
			break;
		case 3:
			SubjectScoreProgram subjectScoreProgram = new SubjectScoreProgram(scan, students, subjects);
			subjectScoreProgram.run();
			break;
		case 4:
			System.out.println("프로그램 종료");
			break;
		default:
			System.out.println("올바른 메뉴가 아닙니다.");
			break;
		}
	}
	
}
