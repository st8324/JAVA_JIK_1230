package day23;

import java.util.Scanner;

public class Ex12_String {

	public static void main(String[] args) {
		/* 다음 코드 중 잘못된 곳을 찾아 수정하세요.
		 * 문자열을 입력받아 출력하고, 문자열이 EXIT인 경우 종료하는 프로그램
		 * */

		String str;
		Scanner scan = new Scanner(System.in);
		
		do {
			System.out.println("입력 : ");
			str = scan.next();
			System.out.println("출력 : " + str);
			//문자열을 ==나 !=로 비교하면 정상적으로 작동하지 않을 수 있다. 그래서 equals를 이용
		}while(str != "EXIT");
	}

}
