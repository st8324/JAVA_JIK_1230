package day06;

import java.util.Arrays;
import java.util.Scanner;

public class Ex07_BaseballGame {

	public static void main(String[] args) {
		/* 1~9 숫자 야구 게임을 구현하세요.
		 * S : 숫자가 있고, 위치가 같은 경우
		 * B : 숫자는 있지만 위차가 다른 경우
		 * 3O : 일치하는 숫자가 하나도 없는 경우
		 * 
		 * 랜덤 수 : 3 7 1
		 * 입력 : 1 2 3
		 * 2B
		 * 입력 : 4 5 6 
		 * 3O
		 * 입력 : 8 7 9
		 * 1S
		 * 입력 : 3 1 7
		 * 1S2B
		 * 입력 : 3 7 1
		 * 3S
		 * 프로그램을 종료합니다.
		 * */

		//랜덤수 생성 : 중복되지 않은 1~9사이의 3개의 정수
		int [] com = createRandomArray(1, 9, 3);
		
		System.out.println(Arrays.toString(com));
		
		int strike, ball;
		int [] user = new int[3];
		
		
		//반복문 
		do {
			strike = 0;
			ball = 0;
			user = new int[3];
			//정수 입력
			if(!inputNum(user)) {
				continue;
			}
			
			//판별
			//스트라이크 판별 : 같은 번지에 있는 값들이 같으면 개수 증가
			strike = getStrike(com, user);
			
			//볼 판별
			ball = getBall(com, user);

			//스트라이크와 볼의 개수에 따라 출력
			printResult(strike, ball);
			
		}while(strike < 3);
		System.out.println("프로그램을 종료합니다.");
	}

	public static boolean inputNum(int[] user) {
		Scanner scan = new Scanner(System.in);
		System.out.print("정수 3개 입력(1 ~ 9, 중복 X) : ");
		boolean outOfBounds = false;
		boolean duplicated = false;
		for(int i = 0; i< user.length; i++) {
			int tmp = scan.nextInt();
			
			if(tmp < 1 || tmp > 9) {
				outOfBounds = true;
			}
			
			if(contains(user, tmp)) {
				duplicated = true;
			}
				
			user[i] = tmp;
		}
		if(outOfBounds || duplicated) {
			System.out.println("범위를 벗어나거나 중복된 수가 있습니다.");
		}
		return !outOfBounds && !duplicated;
	}

	public static void printResult(int strike, int ball) {
		if(strike != 0) {
			System.out.print(strike + "S");
		}
		
		if(ball != 0) {
			System.out.print(ball + "B");
		}
		
		if(strike == 0 && ball == 0) {
			System.out.print("3O");
		}
		
		System.out.println();
	}

	public static int getBall(int[] com, int[] user) {
		//같은 개수를 판별 : 볼 + 스트라이크를 합친 수
		int count = 0;
		for(int tmp : com) {
			if(contains(user, tmp)) {
				count++;
			}
		}
		//같은 개수 - 스트라이크 개수 = 볼의 개수
		return count - getStrike(com, user);
	}

	public static boolean contains(int[] user, int num) {
		for(int tmp : user) {
			if(tmp == num) {
				return true;
			}
		}
		return false;
	}

	public static int getStrike(int[] com, int[] user) {
		int strike = 0;
		for(int i = 0; i<com.length; i++) {
			if(com[i] == user[i]) {
				strike++;
			}
		}
		
		return strike;
	}

	public static int[] createRandomArray(int min, int max, int size) {
		if(max < min) {
			int tmp = max;
			max = min;
			min = tmp;
		}
		//랜덤 범위보다 size가 큰 경우
		if(max - min + 1 < size) {
			return null;
		}
		if(size <= 0) {
			return null;
		}
		int count = 0;
		int [] arr = new int[size];
		//반복 : 3개의 수를 생성할 때 까지
		do {
			//랜덤한수 생성
			int r = (int)(Math.random() * (max - min + 1) + min);
			//배열에 중복된 값이 있는지 확인해서 없으면 랜덤한 수를 배열에 저장하고, 
			//저장된 개수를 1증가
			if(!contains(arr, r)) {
				arr[count++] = r;
			}
		}while(count < 3);
		return arr;
	}

}
