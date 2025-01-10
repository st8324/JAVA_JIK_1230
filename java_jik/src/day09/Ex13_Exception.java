package day09;

public class Ex13_Exception {

	public static void main(String[] args) {
		
		try {
			test1();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			//예외가 발생 했을 때 발생한 메소드들을 추적하여 출력
			e.printStackTrace();
		}
		System.out.println("프로그램 종료");

	}

	public static void test1() {
		test2();
	}

	private static void test2() {
		test3();
	}

	private static void test3() {
		throw new RuntimeException("예외 발생");
	}
	
}
