package day02;

public class Ex01_OperatorLogical {

	public static void main(String[] args) {
		//성적이 B인지 아닌지 확인하는 예제(논리연산자 &&)
		//성적을 저장하기 위한 정수 변수를 선언하고, 80으로 초기화 하세요.
		//자료형 변수명 = 초기값;
		int score = 95;

		/* 성적이 80점 이상이고 성적이 90점 미만이다
		 * score가 80보다 (크거나 같)(고) score가 90보다 (작다)
		 * score가 80보다 (크거나 같다) && score가 90보다 (작다)
		 * score >= 80 && score < 90
		 * */
		boolean isB = score >= 80 && score < 90;
		System.out.println(score + "는 B입니까? " + isB);
		
		//나이가 19세이상이면 성인으로 판별하는 예제
		int age = 15;
		/* 나이가 19세 이상이다
		 * age가 19보다 크거나 같다
		 * */
		boolean isAdult = age >= 19;
		System.out.println(age + "살은 성인입니까? " + isAdult);
		//나이가 19세이상이 아니면 미성년자으로 판별하는 예제(!연산자)
		System.out.println(age + "살은 미성년자입니까? " + !isAdult);
		
		//정수가 0이상인지 판별하는 예제(||연산자)
		int num = -1;
		/* num가 0보다 크거나 num가 0과 같다*/
		boolean isPositive = num > 0 || num == 0; //num >= 10
		System.out.println(num + "는 0이상인가? " + isPositive);
	}

}
