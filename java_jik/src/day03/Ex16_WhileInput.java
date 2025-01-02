package day03;

import java.util.Scanner;

public class Ex16_WhileInput {

	public static void main(String[] args) {
		/* 문자를 입력받아 문자가 q일 때 종료하는 코드를 작성하세요.
		 * */
		//'q'가 아닌 문자로 초기화
		char ch = 'a';
		
		Scanner scan = new Scanner(System.in);
		
		while(ch != 'q') {
			System.out.print("입력 : ");
			ch = scan.next().charAt(0);
		}
		System.out.println("프로그램을 종료합니다.");
	}

}
