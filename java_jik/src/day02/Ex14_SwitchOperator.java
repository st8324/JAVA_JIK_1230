package day02;

import java.util.Scanner;

public class Ex14_SwitchOperator {

	public static void main(String[] args) {
		/* switch문을 이용해서 두 정수의 산술 연산 결과를 출력하는 코드를 작성하세요.
		 * 두 정수와 산술 연산자를 입력하세요(예: 1 + 2 ) : 1 / 2
		 * 1 / 2 = 0.5
		 * */

		//A == a, A == b, A == c,
		Scanner scan = new Scanner(System.in);
		
		System.out.print("두 정수와 산술 연산자를 입력하세요(예: 1 + 2 ) : ");
		int num1 = scan.nextInt();
		char operator = scan.next().charAt(0);
		int num2 = scan.nextInt();
		
		//operator == '+', operator == '-'
		
		switch(operator) {
		case '+':
			System.out.println(num1 + " " + operator + " " + num2 + " = " + (num1 + num2));
			break;
		case '-':
			System.out.println(num1 + " " + operator + " " + num2 + " = " + (num1 - num2));
			break;
		case '*':
			System.out.println(num1 + " " + operator + " " + num2 + " = " + (num1 * num2));
			break;
		case '/':
			System.out.println(num1 + " " + operator + " " + num2 + " = " + ((double)num1 / num2));
			break;
		case '%':
			System.out.println(num1 + " " + operator + " " + num2 + " = " + (num1 % num2));
			break;
		default:
			System.out.println(operator + "는 산술 연산자가 아닙니다.");
		}
		
	}

}
