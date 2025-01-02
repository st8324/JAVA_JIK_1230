package day03;

public class Ex03_ForEvenNumber {

	public static void main(String[] args) {
		/* 10이하의 짝수를 출력하는 코드를 작성하세요. */

		/* 반복횟수 : i는 1부터 10까지 1씩 증가
		 * 규칙성 : i가 짝수이면 i를 출력
		 * 반복문 종료 후 : 없음
		 * */
		int num = 10;
		for(int i = 1; i<=num; i++) {
			if(i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		
		/* 반복횟수 : i는 2부터 10까지 2씩 증가
		 * 규칙성 : i를 출력
		 * 반복문 종료 후 : 없음
		 * */
		for(int i = 2; i<=num; i+=2) {
			System.out.print(i + " ");
		}
		System.out.println();
		/* 반복횟수 : i는 1부터 5까지 1씩 증가
		 * 규칙성 : 2*i를 출력
		 * 반복문 종료 후 : 없음
		 * */
		for(int i = 1; i<=num/2; i++) {
			System.out.print(2 * i + " ");
		}
		
	}

}
