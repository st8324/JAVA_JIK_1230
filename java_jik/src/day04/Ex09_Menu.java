package day04;

import java.util.Scanner;

public class Ex09_Menu {

	public static void main(String[] args) {
		/* 다음과 같이 실행되는 코드를 작성하세요.
		 * 메뉴
		 * 1. 프로그램 실행
		 * 2. 종료
		 * 메뉴 선택 : 1
		 * 문자를 입력하세요(종료하려면 q) : 1
		 * 문자를 입력하세요(종료하려면 q) : a
		 * 문자를 입력하세요(종료하려면 q) : q
		 * 메뉴
		 * 1. 프로그램 실행
		 * 2. 종료
		 * 메뉴 선택 : 2
		 * 프로그램을 종료합니다.
		 * */
		//반복문
		char menu;
		Scanner scan = new Scanner(System.in);
		do {
			//메뉴 출력
			printMenu();
			//메뉴를 선택
			menu = scan.next().charAt(0);
			System.out.println("------------");
			//선택한 메뉴에 따라 기능을 실행
			runMenu(menu);
		}while(menu != '2');
	}
	/**
	 * 메뉴를 콘솔에 출력하는 메소드
	 */
	public static void printMenu() {
		System.out.println("------------");
		System.out.println("메뉴");
		System.out.println("1. 프로그램 실행");
		System.out.println("2. 프로그램 종료");
		System.out.println("------------");
		System.out.print("메뉴 선택 : ");
	}
	/**
	 * 메뉴에 따라 기능을 실행하는 메소드
	 * @param menu 선택한 메뉴
	 * @return 없음
	 */
	public static void runMenu(char menu) {
		
		switch(menu) {
			//프로그램
		case '1':
			program();
			break;
			//프로그램 종료 안내문구 출력
		case '2':
			System.out.println("프로그램을 종료합니다.");
			break;
		//잘못된 메뉴 선택
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}
	/**
	 * 프로그램을 실행하는 메소드
	 */
	public static void program() {
		Scanner scan = new Scanner(System.in);
		//반복문
		char ch;
		do {
				//안내문구
			System.out.print("문자를 입력하세요(종료하려면 q) : ");
				//문자를 입력
			ch = scan.next().charAt(0);
				//입력받은 문자에 따라 종료될지를 결정
		}while(ch != 'q');
	}
}
