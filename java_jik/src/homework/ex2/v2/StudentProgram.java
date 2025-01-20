package homework.ex2.v2;

import java.awt.im.InputSubset;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class StudentProgram implements ConsoleProgram {

	private Scanner scan = new Scanner(System.in);
	
	private StudentManager studentManager;
	private SubjectManager subjectManager;
	
	public void run() {
		

		int menu = 0; //예외처리 때문에 초기화를 해야 함.
		final int EXIT = 13;
		
		//불러오기
		String studentFileName = "src/homework/ex2/v2/student.txt";
		String subjectFileName = "src/homework/ex2/v2/subject.txt";
		
		List<Student>students = (ArrayList<Student>)load(studentFileName);
		List<Subject>subjects = (List<Subject>) load(subjectFileName);
		
		studentManager = new StudentManager(students);
		subjectManager = new SubjectManager(subjects);
		
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
		save(studentFileName, studentManager.getList());
		save(subjectFileName, subjectManager.getList());
	}
	
	private void removeBuffer() {
		scan.nextLine();
	}
	
	@Override
	public void printMenu() {
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
	
	private void searchScore() {
		System.out.println("-----------------");
		System.out.println("조회하려는 학생 정보를 입력하세요.");
		System.out.println("-----------------");
		
		//학년, 반, 번호를 입력
		//입력한 정보를 이용해서 객체를 생성
		Student std = inputBaseStudent();
		
		if(studentManager.getStudent(std) == null) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		
		System.out.println("-----------------");
		System.out.println("조회하려는 과목 정보를 입력하세요.");
		System.out.println("-----------------");

		//학년, 학기, 과목명을 입력
		//과목정보로 객체를 생성
		Subject subject = inputSubject();
		

		studentManager.printScore(std, subject);
		
	}
	private void searchSubject() {
		//과목 매니저에게 등록된 과목을 출력하라고 요청
		subjectManager.print();
	}
	private void searchStudent() {
		//학년, 반, 번호를 입력
		Student std = inputBaseStudent();
		
		studentManager.printStudent(std);
		
	}
	private void deleteScore() {
		//학년, 반, 번호를 입력
		//입력한 정보로 객체를 생성(Student)
		System.out.println("-----------------");
		System.out.println("학생 정보를 입력하세요.");
		System.out.println("-----------------");
		Student std = inputBaseStudent();
		
		//리스트에 있는지 확인해서 없으면 알림 후 종료 => indexOf
		if(studentManager.getStudent(std) == null){
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		System.out.println("-----------------");
		System.out.println("성적 정보를 입력하세요.");
		System.out.println("-----------------");
		//학년, 학기, 과목을 입력
		//입력한 정보로 객체를 생성(Subject)
		Subject subject = inputSubject();
		
		//과목리스트에 등록된 과목인 확인 후 아니면 알림 후 종료
		if(!subjectManager.contains(subject)){
			System.out.println("일치하는 과목이 없습니다.");
			return;
		}
		
		//학생에게 과목 정보를 주면서 성적을 삭제하라고 요청 하고 성공하면 성공 알림
		if(studentManager.deleteScore(std, subject)) {
			System.out.println("성적을 삭제했습니다.");
			return;
		}
		//실패하면 실패 알림
		System.out.println("일치하는 성적이 없습니다.");
		
		
	}
	private void updateScore() {
		
		//학년, 반, 번호를 입력
		//입력한 정보로 객체를 생성(Student)
		System.out.println("-----------------");
		System.out.println("학생 정보를 입력하세요.");
		System.out.println("-----------------");
		Student std = inputBaseStudent();
		
		//리스트에 있는지 확인해서 없으면 알림 후 종료 => indexOf
		if(studentManager.getStudent(std) == null){
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		System.out.println("-----------------");
		System.out.println("성적 정보를 입력하세요.");
		System.out.println("-----------------");
		//학년, 학기, 과목을 입력
		//입력한 정보로 객체를 생성(Subject)
		Subject subject = inputSubject();
		
		//과목리스트에 등록된 과목인 확인 후 아니면 알림 후 종료
		if(!subjectManager.contains(subject)){
			System.out.println("일치하는 과목이 없습니다.");
			return;
		}
		
		System.out.println("-----------------");
		System.out.println("새 성적 정보를 입력하세요.");
		System.out.println("-----------------");
		
		//새 과목 정보를 입력(학년, 학기, 과목)을 입력
		Subject newSubject = inputSubject();
		
		//과목 리스트에 등록된 과목인지 확인 후 아니면 알림 후 종료
		if(!subjectManager.contains(newSubject)){
			System.out.println("일치하는 과목이 없습니다.");
			return;
		}
		//성적을 입력
		System.out.print("성적 : ");
		int score = scan.nextInt();
		//새 과목 정보와 성적을 이용하여 성적 객체를 생성
		SubjectScore subjectScore = new SubjectScore(newSubject, score);
		//학생에게 기존 과목 정보와 성적 정보를 주면서 수정하라고 요청한 후 성공하면 알림
		if(studentManager.updateScore(std, subject, subjectScore)) {
			System.out.println("성적을 수정했습니다.");
			return;
		}
		//실패하면 알림
		System.out.println("이미 등록된 성적입니다.");
		
	}
	private void insertScore() {
		//학년, 반, 번호를 입력
		//입력한 정보로 객체를 생성(Student)
		System.out.println("-----------------");
		System.out.println("학생 정보를 입력하세요.");
		System.out.println("-----------------");
		Student std = inputBaseStudent();
		
		//리스트에 있는지 확인해서 없으면 알림 후 종료 => indexOf
		if(studentManager.getStudent(std) == null ){
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		System.out.println("-----------------");
		System.out.println("성적 정보를 입력하세요.");
		System.out.println("-----------------");
		//학년, 학기, 과목을 입력
		//입력한 정보로 객체를 생성(Subject)
		Subject subject = inputSubject();
		
		//과목리스트에 등록된 과목인 확인 후 아니면 알림 후 종료
		if(!subjectManager.contains(subject)){
			System.out.println("일치하는 과목이 없습니다.");
			return;
		}
		//성적을 입력해서 과목 정보와 성적을 이용하여 객체를 생성(Score)
		System.out.print("성적 : ");
		int score = scan.nextInt();
		
		SubjectScore subjectScore = new SubjectScore(subject, score);
		
		//학생을 선택하여 객체 저장 list.get(xx).update() => tmp.update()
		if(studentManager.insertScore(std, subjectScore)){
			System.out.println("성적을 추가했습니다.");
			return;
		}
		System.out.println("이미 등록된 성적입니다.");
		
	}
	private void deleteSubject() {
		//학년, 학기, 과목명을 입력
		//입력한 정보로 객체를 생성 
		System.out.println("-----------------");
		System.out.println("과목 정보를 입력하세요.");
		System.out.println("-----------------");
		Subject subject = inputSubject();
		
		//과목 매니저에게 과목 객체를 주면서 삭제하라고 요청 후 결과에 따라 알림
		if(subjectManager.deleteSubject(subject)) {
			System.out.println("과목을 삭제 했습니다.");
			return;
		}
		System.out.println("일치하는 과목이 없습니다.");
		
	}
	private void updateSubject() {
		//학년, 학기, 과목명을 입력
		//입력한 정보로 객체를 생성 
		System.out.println("-----------------");
		System.out.println("과목 정보를 입력하세요.");
		System.out.println("-----------------");
		Subject subject = inputSubject();
		
		if(!subjectManager.contains(subject)) {
			System.out.println("일치하는 과목이 없습니다.");
			return;
		}
		
		System.out.println("-----------------");
		System.out.println("새 과목 정보를 입력하세요.");
		System.out.println("-----------------");
		//새 과목 정보를 입력(학년, 학기, 과목)
		Subject newSubject = inputSubject();
		//과목 매니저에게 기존 과목객체와 새 과목 객체를 주면서 수정하라고 요청 후 결과에 따라 알림
		if(subjectManager.updateSubject(subject, newSubject)) {
			System.out.println("과목을 수정했습니다.");
			return;
		}
		System.out.println("이미 등록된 과목입니다.");
	}
	private void insertSubject() {
		//학년, 학기, 과목명을 입력
		//과목 객체 생성
		Subject subject = inputSubject();
		
		//과목 매니저에게 과목을 주면서 등록하라고 요청 후 결과에 따라 알림
		if(subjectManager.insertSubject(subject)) {
			System.out.println("과목을 추가했습니다.");
			return;
		}
		System.out.println("이미 등록된 과목입니다.");
	}
	private void deleteStudent() {
		//학년, 반, 번호를 입력
		//입력받은 정보로 객체 생성
		Student std = inputBaseStudent();
		
		//생성한 객체를 이용하여 리스트에서 삭제
		//삭제에 성공하면 성공알림문구
		if(studentManager.deleteStudent(std)) {
			System.out.println("학생을 삭제했습니다.");
			return;
		}
		
		//실패하면 실패 알림문구 출력
		System.out.println("일치하는 학생이 없습니다.");
		
	}

	private void updateStudent() {

		System.out.println("-----------------");
		System.out.println("학생 정보를 입력하세요.");
		System.out.println("-----------------");
		Student std = inputBaseStudent();
		
		Student selStd = studentManager.getStudent(std);
		
		if(selStd == null) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		System.out.println("-----------------");
		System.out.println("새 학생 정보를 입력하세요.");
		System.out.println("-----------------");
		Student newStd = inputStudent();
		
		if(studentManager.updateStudent(selStd, newStd)) {
			System.out.println("학생을 수정했습니다.");
			return;
		}
		
		System.out.println("이미 등록된 학생입니다.");

	}

	private void insertStudent() {
		
		//학생 정보를 입력받아 객체를 생성
		Student std = inputStudent();
		
		//생성된 학생 정보를 매니저에게 주면서 등록하라고 요청한 후 성공 여부를 알려달라고 함
		if(!studentManager.insertStudent(std)) {
			System.out.println("이미 등록된 학생입니다.");
			return;
		}
		System.out.println("학생을 등록했습니다.");
		
	}
	
	/** 학년, 반, 번호를 입력하면 객체를 반환하는 메소드 */
	public Student inputBaseStudent() {
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("학급 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		return new Student(grade, classNum, num, "");
	}
	/** 학년, 반, 번호, 이름을 입력하면 객체를 반환하는 메소드 */
	public Student inputStudent() {
		Student tmp = inputBaseStudent();

		removeBuffer();
		
		System.out.print("이름 : ");
		String name = scan.nextLine();
		
		tmp.setName(name);
		return tmp;
	}
	
	/* 학년, 학기, 과목명을 입력하여 과목 객체를 생성하는 메소드*/
	public Subject inputSubject() {
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("학기 : ");
		int semester = scan.nextInt();
		
		removeBuffer();
		
		System.out.print("과목 : ");
		String name = scan.nextLine();
		
		return new Subject(grade, semester, name);
	}
}
