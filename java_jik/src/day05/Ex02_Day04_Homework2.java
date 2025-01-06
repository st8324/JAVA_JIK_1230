package day05;

import java.util.Scanner;

public class Ex02_Day04_Homework2 {
	
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		/* 다음과 같이 실행되도록 프로그램을 작성하세요.(UpDown 게임 참고)
		 * 
		 * 메뉴
		 * 1. UpDown 게임 실행
		 * 2. 최고 기록 확인
		 * 3. 프로그램 종료
		 * 메뉴 선택 : 2
		 * 게임을 실행한 적이 없습니다.
		 * 메뉴
		 * 1. UpDown 게임 실행
		 * 2. 최고 기록 확인
		 * 3. 프로그램 종료
		 * 메뉴 선택 : 1
		 * 입력 : 50
		 * Down!
		 * 입력 : 25
		 * 정답!
		 * 메뉴
		 * 1. UpDown 게임 실행
		 * 2. 최고 기록 확인
		 * 3. 프로그램 종료
		 * 
		 * 2회
		 * 메뉴로 가려면 엔터를 입력하세요.
		 * 메뉴
		 * 1. UpDown 게임 실행
		 * 2. 최고 기록 확인
		 * 3. 프로그램 종료
		 * 메뉴 선택 :3
		 * 프로그램을 종료합니다.
		 * */
		char menu;
		int minCount = 0;
		//반복문
		do {
			//메뉴 출력
			printMenu();
			//메뉴를 입력
			menu = scan.next().charAt(0);
			//메뉴에 맞는 기능을 실행
			minCount = runMenu(menu, minCount);
		}while(menu != '3');
	}
	//메뉴 출력
	private static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. UpDown 게임 실행");
		System.out.println("2. 최고 기록 확인");
		System.out.println("3. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}
	
	private static int runMenu(char menu, int minCount) {
	
		//메뉴에 맞는 기능을 실행
		switch(menu) {
		case '1':
			//게임을 진행 후 기록을 가져옴
			int count = playGame();
			//최고 기록과 방금 플레이한 기록을 이용해서 최고 기록을 업데이트
			minCount = recordGame(minCount, count);
			break;
		case '2':
			printRecord(minCount);
			break;
		case '3':
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("올바른 메뉴가 아닙니다.");
		}
		return minCount;
	}
	private static int playGame() {
		int min = 1, max = 100;
		//랜덤한 정수 생성
		int random = (int)(Math.random() * (max - min + 1) + min);
		//반복 : 맞출때까지
		int input, count = 0;
		System.out.println(random);//테스트 용
		do {
			++count;
			//입력 
			System.out.print("입력 : ");
			input = scan.nextInt();
			//입력한 값에 따라 결과를 출력
			//입력한 값이 랜덤보다 크면 Down, 작으면 Up, 같으면 정답을 출력
			if(input > random) {
				System.out.println("Down!");
			}
			else if(input < random) {
				System.out.println("Up!");
			}
			else {
				System.out.println("정답!");
			}
		}while(random != input );//랜덤한 정수와 입력한 수가 같으면 종료. 같지 않으면 반복
		
		return count;
	}
	private static int recordGame(int minCount, int count) {
		//첫 게임 후 
		if(minCount == 0) {
			return count;
		}
		/*
		//현재 기록이 최고 기록보다 좋으면
		if(minCount > count) {
			return count;
		}
		//최고 기록이 좋으면
		return minCount;
		*/
		//위 조건식을 한줄로
		return minCount > count ? count : minCount;
	}
	private static void printRecord(int minCount) {

		//기록이 있으면 쵯수를 출력하고 없으면 게임을 실행한 적이 없습니다.
		if(minCount != 0) {
			System.out.println("최고 기록 : " + minCount);
		}
		else {
			System.out.println("게임을 실행한 적이 없습니다.");
		}
		System.out.print("메뉴로 가려면 엔터를 입력하세요.");
		scan.nextLine();//메뉴와 함께 입력한 엔터 처리용
		scan.nextLine();//메뉴로 돌아가기 위한 엔터 처리
		
	}

	
	
}
