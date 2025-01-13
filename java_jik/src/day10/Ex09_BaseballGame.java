package day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Ex09_BaseballGame {

	public static void main(String[] args) {
		
		/* 숫자 야구 게임을 구현하세요.
		 * */
		ArrayList<Integer> com = new ArrayList<Integer>();
		ArrayList<Integer> user = new ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);
		
		int strike = 0, ball = 0;

		//랜덤으로 1~9사이의 중복되지 않은 수를 생성
		createRandomList(1, 9, 3, com);
		
		System.out.println(com);
		
		//반복 : 맞출 때까지
		while(strike != 3) {
			
			//clear()를 통해 리스트에 있는 값을 초기화
			user.clear();
			//입력
			System.out.print("입력 : ");
			for(int i = 0; i<3; i++) {
				user.add(scan.nextInt());
			}

			//스트라이크의 개수 판별
			strike = getStrike(com, user);
			
			//볼의 개수 판별
			ball = getBall(com, user);
		
			//결과 출력
			printResult(strike, ball);
		
		}
		
		
	}

	private static void printResult(int strike, int ball) {

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

	private static int getBall(ArrayList<Integer> com, ArrayList<Integer> user) {
		//일치하는 숫자의 개수(위치 상관X) - 스트라이크 개수
		int count = 0;
		for(int tmp : com) {
			if(user.contains(tmp)) {
				count++;
			}
		}
		return count - getStrike(com, user);
	}

	private static int getStrike(ArrayList<Integer> com, ArrayList<Integer> user) {
		//get(번지)
		int strike = 0;
		for(int i = 0; i<com.size(); i++) {
			if(com.get(i) == user.get(i)) {
				strike++;
			}
		}
		return strike;
	}

	private static void createRandomList(int min, int max, int size, 
			ArrayList<Integer> com) {
		//Set에 1~9사이의 랜덤수를 저장 => 3개가 될때까지
		HashSet<Integer> set = new HashSet<Integer>();
		
		while(set.size() < size) {
			int r = (int)(Math.random() * (max - min + 1) + min);
			set.add(r);
		}
		//Set에 있는 값을 List로 옮김
		com.addAll(set);
		//List에 있는 값들을 섞어줌
		Collections.shuffle(com);
	}

}
