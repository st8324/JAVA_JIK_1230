package day02;

public class Ex03_OperatorConditional {

	public static void main(String[] args) {
		
		/* num가 홀수이면 false라고 출력하고 num가 짝수이면 true라고 출력하는 예제
		 * num가 홀수이면 홀수라고 출력하고 num가 작수이면 짝수라고 출력하는 예제 */
		
		int num = 3;
		boolean isEven = num % 2 == 0;
		System.out.println(num + "는 짝수? " + isEven);
		
		String result = (num % 2 == 0) ? "짝수" : "홀수";
		System.out.println(num + "는 " + result);
		
	}

}
