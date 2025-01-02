package day03;

import java.util.Scanner;

public class Ex05_ForPrimeNumber {

	public static void main(String[] args) {
		/* 정수를 입력받아 입력받은 정수가 소수인지 아닌지 판별하는 코드를 작성하세요.
		 * 소수 : 약수가 1과 자기자신만 있는 수
		 * 소수 : 2, 3, 5, 7, 11, 13, 17...
		 * 
		 * 반복횟수 : i는 1부터 num까지 1씩 증가
		 * 규칙성 : i가 num의 약수이면 약수의 개수인 count를 1증가
		 * 반복문 종료 후 : count가 2이면 소수, 아니면 소수가 아님이라고 출력
		 * 
		 * */
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 : ");
		int num = scan.nextInt();
		int count = 0;
		
		for(int i = 1; i <= num ; i++) {
			if(num % i ==  0) {
				count++;
			}
		}
		
		if(count == 2) {
			System.out.println(num +"는 소수");
		}
		else {
			System.out.println(num +"는 소수가 아님");
		}
		
		/* 반복횟수 : i는 2부터 num-1까지 1씩 증가
		 * 규칙성 : i가 num의 약수이면 약수의 개수인 count를 1증가
		 * 반복문 종료 후 : count가 0이고 num가 1이 아니면 소수, 아니면 소수가 아님이라고 출력
		 * */
		count = 0;
		for(int i = 2; i < num ; i++) {
			if(num % i ==  0) {
				count++;
			}
		}
		
		if(count == 0 && num != 1) {
			System.out.println(num +"는 소수");
		}
		else {
			System.out.println(num +"는 소수가 아님");
		}
	}

}
