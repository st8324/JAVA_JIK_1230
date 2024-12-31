package day02;

public class Ex06_IfEvenNumber2 {

	public static void main(String[] args) {
		
		/* 홀짝 판별 예제 if else문 
		 * num가 짝수이면 짝수라고 출력하고 아니면(짝수가 아니면) 홀수라고 출력하세요. */
		int num = 4;
		if(num % 2 == 0) {
			System.out.println(num + "는 짝수");
		} else {
			System.out.println(num + "는 홀수");
		}
		
	}

}
