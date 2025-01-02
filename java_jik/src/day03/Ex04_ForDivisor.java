package day03;

import java.util.Scanner;

public class Ex04_ForDivisor {

	public static void main(String[] args) {
		/* 입력받은 num의 약수를 출력하는 코드를 작성하세요.
		 * 약수 : 나누었을 때 나머지가 0이 되는 수
		 * 12의 약수 : 1 2 3 4 6 12
		 * 
		 * 반복횟수 : i는 1부터 num까지 1씩 증가
		 * 규칙성 : i가 num의 약수이면 i를 출력
		 * 		  num를 i로 나누었을 때 나머지가 0과 같다면 i를 출력
		 * 반복문 종료 후 : 없음
		 * */
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 : ");
		int num = scan.nextInt();
		
		for(int i = 1; i <= num ; i++) {
			if(num % i ==  0) {
				System.out.print(i + " ");
			}
		}
		
	}

}
