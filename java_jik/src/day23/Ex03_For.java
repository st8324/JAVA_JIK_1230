package day23;

public class Ex03_For {

	public static void main(String[] args) {
		/* 10부터 1까지 차례대로 출력하는 예제. 잘못된 부분을 찾아 수정하세요. */
		
		//조건식이 잘못되서 한번도 실행되지 않음
		for(int i = 10; i>= 1; i--) {
			System.out.println(i);
		}
		//증감식이 잘못되서 무수히 많이 실행 됨(정확히는 무한 루프는 아님)
		for(int i = 10; i >= 1; i++) {
			System.out.println(i);
		}
	}

}
