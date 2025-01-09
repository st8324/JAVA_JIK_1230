package day08;

public class Ex08_Interface {

	public static void main(String[] args) {
		
		System.out.println(ConsoleProgram.num);
		/* 구현 클래스와 인터페이스의 형변환 */
		ConsoleProgram cp = new StudentScoreProgram();
		cp.run();
		ConsoleProgram.test();
	}

}
//인터 페이스 정의
interface ConsoleProgram{
	
	/*public static final */ int num = 10;
	
	void run();
	
	void printMenu();
	
	void runMenu(int menu);
	
	//default 메소드는 나중에 추가 되도 기존 구현 클래스들에게 문제를 일으키지 않음
	default void func1() {	}
	static void test() {
		System.out.println("정적 메소드");
	}
}
//인터페이스를 이용하여 구현클래스를 정의 => 메소드 오버라이딩을 통해 인터페이스의 추상 메소드를 구현
class StudentScoreProgram implements ConsoleProgram{

	@Override
	public void printMenu() {
		System.out.println("메뉴 출력");
	}

	@Override
	public void runMenu(int menu) {
		System.out.println("메뉴에 따른 기능 실행");
	}

	@Override
	public void run() {
		System.out.println("프로그램 구동");		
	}
	
}

interface Program { 
	void run();
}
/* Prgram의 run과 ConsoleProgram의 run은 둘다 추상메소드이기 때문에 오버라이딩이 필요
 * */
interface GeneralProgram extends Program, ConsoleProgram{
	
}




