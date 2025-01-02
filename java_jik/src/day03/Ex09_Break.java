package day03;

public class Ex09_Break {

	public static void main(String[] args) {
		/* 1부터 10까지 출력하는 예제 */
		
		for(int i = 1; ; i++) {
			System.out.println(i);
			if( i == 10) {
				break;
			}
		}

	}

}
