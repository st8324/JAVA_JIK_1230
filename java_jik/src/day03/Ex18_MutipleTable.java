package day03;

public class Ex18_MutipleTable {

	public static void main(String[] args) {
		/* 2~9단을 출력하는 코드를 작성하세요.
		 * 2단
		 * 2 X 1 = 2
		 * 2 x 2 = 4
		 * ...
		 * 2 x 9 = 18
		 * 3단
		 * ...
		 * 9단
		 * ...
		 * 9 X 9 = 81
		 * 
		 * 반복횟수 : num는 2부터 9까지 1씩 증가
		 * 규칙성 : num단 출력
		 * 반복문 종료 후 : 없음
		 * */
		
		int num = 2;
		
		for(num = 2; num <= 9; num++) {
			System.out.println(num + "단");
			//num단
			for(int i = 1; i<=9; i++) {
				System.out.println(num + " X " + i + " = " + num * i);
			}
		}
		
	}

}
