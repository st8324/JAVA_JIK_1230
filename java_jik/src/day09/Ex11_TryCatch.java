package day09;

public class Ex11_TryCatch {

	public static void main(String[] args) {
		
		try {
			//System.out.println(1/0);
			int [] arr = new int[10];
			arr[10] = 10;
			System.out.println("123");
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}catch(RuntimeException e) {
			System.out.println("실행 예외가 발생했습니다.");
		}catch(Exception e) {
			System.out.println("예외가 발생했습니다.");
		}
		System.out.println("프로그램을 종료합니다.");
		System.out.println("---------");
		print();
	}
	
	public static void print() {
		try {
			System.out.println(1/0);
		}catch(Exception e) {
			System.out.println("예외 발생");
			return;
		}finally {
			System.out.println("메소드 종료");
		}
	}
}
