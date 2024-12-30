package day01;

public class Ex13_EvenNumber {

	public static void main(String[] args) {
		
		/*
		 * 주어진 num가 짝수이면 true를 아니면 false가 출력되도록 코드를 작성하세요.
		 * 출력 예시1
		 * 3은 짝수인가? false
		 * 출력 예시2
		 * 4는 짝수인가? true 
		*/
		int num = 4;
		//num를 2로 나누었을 때 나머지가 0과 같다
		boolean isEven = num % 2 == 0;
		System.out.println(num +"는 짝수인가?" + isEven );
	}

}
