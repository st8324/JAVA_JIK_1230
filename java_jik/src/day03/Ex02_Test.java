package day03;

import java.util.Scanner;

public class Ex02_Test {

	public static void main(String[] args) {
		/* 월을 입력받고 월의 마지막 일을 출력하는 코드를 작성하세요.
		 * 31 : 1 3 5 7 8 10 12
		 * 30 : 4 6 9 11
		 * 28 : 2
		 * 잘못된 월입니다. : 1~12가 아닌 월.
		 * */
		Scanner scan = new Scanner(System.in);
		
		//안내문구 출력
		System.out.print("월을 입력하세요 : ");
		//월을 입력
		int month = scan.nextInt();
		//마지막 일을 저장하는 변수를 선언 및 0으로 초기화
		int lastDay = 0;
		//switch문으로 월에 따라 마지막일을 판별하여 저장
		switch(month) {
		case 1, 3, 5, 7, 8, 10, 12:
			lastDay = 31;
			break;
		case 4, 6, 9, 11:
			lastDay = 30;
			break;
		case 2:
			lastDay = 28;
		}
		//if문으로 마지막일이 0이면 잘못된 월입니다. 아니면 xx월은 xx일까지 있습니다라고 출력
		if(lastDay == 0) {
			System.out.println(month +"월은 잘못된 월입니다.");
		}
		else {
			System.out.println(month + "월은 " + lastDay + "일까지 있습니다.");
		}
	}

}
