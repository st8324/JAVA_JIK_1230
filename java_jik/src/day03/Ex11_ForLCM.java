package day03;

import java.util.Scanner;

public class Ex11_ForLCM {

	public static void main(String[] args) {
		
		/* 정수 num1과 num2를 입력받고 두 정수의 최소 공배수를 구하는 코드를 작성하세요.
		 * A의 배수 : 어떤 수를 A로 나누었을 때 나머지가 0이 되는 수
		 * 공배수 : 공통으로 있는 배수
		 * 최소 공배수 : 공배수 중 가장 작은 공배수
		 * 2의 배수 : 2 4 6 8 10 ...
		 * 3의 배수 : 3 6 9 12 ...
		 * 2와 3의 공배수 : 6 12 18 24 
		 * 2와 3의 최소 공배수 : 6
		 * 
		 * 반복횟수 : i는 1부터 1씩 증가
		 * 규칙성 : 
		 * 		i가 num1과 num2의 배수이면 i를 출력하고 종료
		 * 		=> i를 num1로 나누었을 때 나머지가 0과 같고 
		 * 		   i를 num2로 나누었을 때 나머지가 0과 같다면
		 * 		   i를 출력하고 반복문을 종료
		 * 반복문 종료 후 : 없음
		 * */

		Scanner scan = new Scanner(System.in);
		
		System.out.print("두 정수를 입력하세요 : ");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		
		int count = 1;
		
		for(int i = 1; ; i++, count++) {
			if(i % num1 == 0 && i % num2 == 0) {
				System.out.println(num1 + "과 " + num2 + "의 최소 공배수 : " + i + ", 반복횟수 : " + count);
				break;
			}
		}
		
		/* 반복횟수 : i는 num1부터 num1씩 증가 => num1의 배수를 활용
		 * 규칙성 : 
		 * 		i가 num2의 배수이면 i를 출력하고 종료
		 * 		=> i를 num2로 나누었을 때 나머지가 0과 같다면
		 * 		   i를 출력하고 반복문을 종료
		 * 반복문 종료 후 : 없음
		 * */
		count = 1;
		for(int i = num1; ; i += num1, count++) {
			if(i % num2 == 0) {
				System.out.println(num1 + "과 " + num2 + "의 최소 공배수 : " + i+ ", 반복횟수 : " + count);
				break;
			}
		}
	}

}
