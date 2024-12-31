package day02;

public class Ex05_IfAdult {

	public static void main(String[] args) {
		/* 나이를 저장하는 변수 age를 선언 및 초기화하고
		 * age가 19세 이상이면 성인이라고 출력하고, 
		 * age가 19세 이상이 아니면 미성년자라고 출력하는 코드를 
		 * 작성하세요.
		 * */
		int age = 30;
		
		if(age >= 19) {
			System.out.println(age + "살은 성인");
		}
		if( !(age >= 19)) {
			System.out.println(age + "살은 미성년자");
		}
	}

}
