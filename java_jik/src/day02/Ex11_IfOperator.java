package day02;

import java.util.Scanner;

public class Ex11_IfOperator {

	public static void main(String[] args) {
		/* 두 정수와 산술 연산자를 입력받는 코드를 작성하세요.
		 * 예시 
		 * 두 정수와 산술 연산자를 입력하세요( 예: 1 + 2 ) : 3 * 4
		 * 3 * 4
		 * */
		int num1, num2;
		char operator;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("두 정수와 산술 연산자를 입력하세요( 예: 1 + 2 ) : ");
		num1 = scan.nextInt();
		operator = scan.next().charAt(0);
		num2 = scan.nextInt();
		
		/* 연산자가 + 이면 두 수의 더한 값을 출력하고
		 * operator가 +와 같다면 num1 + num2를 출력
		 * 연산자가 - 이면 두 수의 뺀 값을 출력하고
		 * operator가 -와 같다면 num1 - num2를 출력
		 * 연산자가 * 이면 두 수의 곱을 출력하고
		 * operator가 *와 같다면 num1 * num2를 출력
		 * 연산자가 / 이면 두 수의 나눈 값을 출력하고
		 * operator가 /와 같다면 num1 / num2를 출력
		 * 연산자가 % 이면 두 수의 나머지를 출력하고
		 * operator가 %와 같다면 num1 % num2를 출력
		 * 산술연산자가 아니면 잘못된 산술연산자입니다라고 출력
		 * operator가 산술연산자가 아니면 잘못된 산술연산자입니다라고 출력  
		 * */
		if(operator == '+') {
			System.out.println("" + num1 + " " + operator + " " + num2 + " = " + (num1 + num2));
		}
		else if(operator == '-') {
			System.out.println("" + num1 + " " + operator + " " + num2 + " = " + (num1 - num2));
		} 
		else if(operator == '*') {
			System.out.println("" + num1 + " " + operator + " " + num2 + " = " + (num1 * num2));
		} 
		else if(operator == '/') {
			System.out.println("" + num1 + " " + operator + " " + num2 + " = " + ((double)num1 / num2));
		} 
		else if(operator == '%') {
			System.out.println("" + num1 + " " + operator + " " + num2 + " = " + (num1 % num2));
		} 
		else {
			System.out.println(operator + "는 잘못된 산술연산자입니다.");
		}
		
	}

}
