package day03;

import java.util.Scanner;

public class Ex19_NestingPrimeNumber {

	public static void main(String[] args) {
		/* 100이하의 소수를 출력하는 코드를 작성하세요.
		 * 2 3 5 7 11 13 ...
		 * */

		int num = 4;
		int count = 0;
		
		/* 반복횟수 : num가 2부터 100까지 1씩 증가
		 * 규칙성 : num가 소수이면 num를 출력
		 * 반복문 종료 후 : 없음 
		 * */
		
		for(num = 2; num <= 100; num++) {
			count = 0;
			for(int i = 1; i <= num ; i++) {
				if(num % i ==  0) {
					count++;
				}
			}
			
			if(count == 2) {
				System.out.print(num + " ");
			}
		}
		
		
	}

}
