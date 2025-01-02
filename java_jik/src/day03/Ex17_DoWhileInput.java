package day03;

import java.util.Scanner;

public class Ex17_DoWhileInput {

	public static void main(String[] args) {
		/* 문자를 입력받아 문자가 q일 때 종료하는 코드를 작성하세요.
		 * */

		Scanner scan = new Scanner(System.in);
		char ch;
		do {
			System.out.print("입력 : ");
			ch = scan.next().charAt(0);
		}while(ch != 'q');
		
		System.out.println("프로그램을 종료합니다.");
	}

}
