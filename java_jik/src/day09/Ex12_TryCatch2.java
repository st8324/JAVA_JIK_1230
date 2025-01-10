package day09;

import java.text.MessageFormat;
import java.util.Scanner;

public class Ex12_TryCatch2 {

	public static void main(String[] args) {
		/* 두 정수와 산술 연산자를 입력받아 산술 연산 결과를 출력하는 메소드를 작성하세요.
		 * 단 예외 처리를 적용
		 * 입력 : 1 + 2
		 * 결과 : 3.0
		 * 입력 : 1 / 2
		 * 결과 : 0.5
		 * 입력 : 1 % 0
		 * 결과 : 0으로 나눌 수 없습니다.
		 * 입력 : 1 / 0
		 * 결과 : Infinity
		 * */
		
		Scanner scan = new Scanner(System.in);
		int num1, num2;
		char op;

		//입력
		System.out.print("입력 : ");
		num1 = scan.nextInt();
		op = scan.next().charAt(0);
		num2 = scan.nextInt();
		//연산자에 따라 연산을 해줌
		try {
			double res = calculate(num1, op, num2);
			//결과를 출력
			System.out.println("결과 : " + res);
		}catch(ArithmeticException e) {
			System.out.println("결과 : 0으로 나눌 수 없습니다.");
		}catch(RuntimeException e) {
			System.out.println(MessageFormat.format("결과 : {0}", e.getMessage()));
		}catch(Exception e) {
			System.out.println(MessageFormat.format("결과 : {0}", e.getMessage()));
		}
		
	}

	private static double calculate(int num1, char op, int num2) throws Exception {
		switch(op) {
		case '+':
			return num1 + num2;
		case '-':
			return num1 - num2;
		case '*':
			return num1 * num2;
		case '%':
			return num1 % num2;
		case '/':
			return num1 / (double)num2;
		default:
			throw new Exception("산술 연산자가 아닙니다.");
		}
	}

}
