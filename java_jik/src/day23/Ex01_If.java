package day23;

public class Ex01_If {

	public static void main(String[] args) {

		/* 홀 짝 판별하는 예제입니다. 잘못된 부분을 찾아 수정하세요.
		 * */
		int num = 3;
		//if()뒤에 ;이 잘못됨
		if( num % 2 == 0); {
			System.out.println(num + "는 짝수");
		}
		if( num % 2 != 0) {
			System.out.println(num + "는 홀수");
		}

	}

}
