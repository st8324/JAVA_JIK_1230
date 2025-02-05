package day23;

public class Ex04_Method {

	public static void main(String[] args) {
		
		/* 두 정수의 합을 구하는 메소드를 생성하고 테스트하세요. */
		int num1 = 1, num2 = 2;
		System.out.println(sum(num1, num2));
		/* 세 정수의 합을 구하는 메소드를 생성하고 테스트하세요. */
		int num3 = 3;
		System.out.println(sum(num1, num2, num3));
	}

	public static int sum(int num1, int num2) {
		return num1 + num2;
	}
	public static int sum(int num1, int num2, int num3) {
		return num1 + num2 + num3;
	}
}
