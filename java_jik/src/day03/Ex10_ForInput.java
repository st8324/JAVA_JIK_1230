package day03;

import java.util.Scanner;

public class Ex10_ForInput {

	public static void main(String[] args) {
		/* 문자를 입력받아 입력받은 문자가 q이면 종료되도록 코드를 작성하세요. 
		 * 
		 * 반복횟수 : 계속
		 * 규칙성 : 문자를 입력. 입력받은 문자가 q이면 반복문을 종료
		 * 반복문 종료 후 : 프로그램이 종료되었습니다.를 출력
		 * */
		Scanner scan = new Scanner(System.in);
		
		for( ; ; ) {
			System.out.print("문자를 입력하세요 : ");
			char ch = scan.next().charAt(0);
			if(ch == 'q') {
				break;
			}
		}
		System.out.println("프로그램이 종료 되었습니다.");
	}

}
