package day03;

public class Ex08_Continue {

	public static void main(String[] args) {
		/* 1부터 10사이의 짝수를 출력하는 예제
		 * 
		 * 반복횟수 : i는 1부터 10까지 1씩 증가
		 * 규칙성 : i가 홀수이면 건너뜀. i를 출력
		 * 반복문 종료 후 없음.
		 * */
		
		for(int i = 1; i<=10; i++) {
			if(i % 2 != 0) {
				continue;
			}
			System.out.print(i + " ");
		}
	}

}
