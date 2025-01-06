package day05;

import java.util.Scanner;

public class Ex12_Lotto {

	public static void main(String[] args) {
		/* 1~45 사이의 랜덤한 수 6개를 생성하고, 1개의 보너스 번호를 생성한다.
		 * 1~45 사이의 정수 6개를 입력받아 입력한 정수가 몇등인지 확인하는 코드를 작성하세요.
		 * 1등 : 6개 일치
		 * 2등 : 5개 일치, 보너스 일치
		 * 3등 : 5개 일치
		 * 4등 : 4개 일치
		 * 5등 : 3개 일치
		 * 꽝 : 나머지
		 * */

		int min = 1, max = 45;
		//랜덤으로 중복되지 않은 배열을 생성
		int [] lotto = Ex11_ArrayRandom2.createRandomArray(min, max, 6);
		
		Ex11_ArrayRandom2.printArray(lotto);
		
		int bonus;
		//반복문 : 랜덤으로 생성된 숫자가 배열에 있으면 반복. 없으면 종료
		do {
			//랜덤으로 보너스 번호를 생성
			bonus = (int)(Math.random() * (max - min + 1) + min);
		}while(Ex11_ArrayRandom2.contains(lotto, bonus));
		
		System.out.println("보너스 : " + bonus);
		
		int user [] = new int[6];
		Scanner scan = new Scanner(System.in);
		System.out.print("로또 번호를 입력하세요 : ");
		//반복문 : 6번
		for(int i = 0; i<user.length; i++) {
			//번호를 입력
			user[i] = scan.nextInt();
		}
		
		//랜덤 번호와 입력 번호의 일치하는 개수를 셈
		int count = 0;
		for(int i = 0; i<lotto.length; i++) {
			//로또에서 꺼내서 사용자 번호와 일치하는지 확인해서 일치하면 개수 증가
			if(Ex11_ArrayRandom2.contains(user, lotto[i])) {
				count++;
			}
		}
		
		//일치하는 개수에 따라 등수 출력
		switch(count) {
			//6개 일치하면 1등이라고 출력
		case 6:
			System.out.println("1등!");
			break;
			//5개 일치
		case 5:
				//보너스 번호도 일치하면 2등이라고 출력
			if(Ex11_ArrayRandom2.contains(user, bonus)) {
				System.out.println("2등!");
			}
				//아니면 3등이라고 출력
			else {
				System.out.println("3등!");
			}
			break;
		case 4:
			//4개 일치하면 4등이라고 출력
			System.out.println("4등!");
			break;
			//3개 일치하면 5등이라고 출력
		case 3:
			System.out.println("5등!");
			break;
			//아니면 꽝이라고 출력
		default:
			System.out.println("꽝!");
		}
	}

}
