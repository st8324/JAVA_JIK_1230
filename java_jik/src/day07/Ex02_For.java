package day07;

public class Ex02_For {

	public static void main(String[] args) {
		/* 1부터 10까지 합을 구하는 코드를 작성하세요.
		 * 1 - 2 + 3 - 4 + 5 - 6 + 7 - 8 + 9 - 10를 출력하는 코드를
		 * 작성하세요.
		 * */
		int sum = 0;
		int max = 10;
		for(int i = 1; i<= max; i++) {
			//홀수이면 더하고
			if(i % 2 != 0) {
				sum += i;
			}
			//짝수이면 뺌
			else {
				sum -= i;
			}
		}
		System.out.println("결과 : " + sum);
	}

}
