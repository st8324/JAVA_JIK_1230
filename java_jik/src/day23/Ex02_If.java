package day23;

public class Ex02_If {

	public static void main(String[] args) {

		/* 짝수이면 짝수라고 출력하고, 2로 나눈 값을 출력
		 * 홀수이면 홀수라고 출력하고 +1한 값을 출력
		 * */
		int num = 3;
		//실행문이 2줄인데 {}을 생략해서 2번째 실행문이 무조건 실행되어서 문제
		if( num % 2 == 0)
			System.out.println(num + "는 짝수");
			System.out.println(num / 2);
		if( num % 2 != 0) {
			System.out.println(num + "는 홀수");
			System.out.println(num + 1);
		}

	}

}
