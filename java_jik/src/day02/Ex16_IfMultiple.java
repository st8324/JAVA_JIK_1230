package day02;

public class Ex16_IfMultiple {

	public static void main(String[] args) {
		
		/* 정수 num가 2의 배수인지, 3의배수인지, 6의 배수인지, 2,3,6의 배수가 아닌지를 판별하는 코드를 작성하세요. 
		 * 2 : 2의 배수
		 * 3 : 3의 배수
		 * 4 : 2의 배수
		 * 5 : 2,3,6의 배수가 아님
		 * 6 : 6의 배수 
		 * */
		int num = 12;
		//순서에 상관없이 => 조건식이 복잡
		//num가 2의 배수이고 3의 배수가 아니면 2의 배수라고 출력하고
		if(num % 2 == 0 && num % 3 != 0) {
			System.out.println(num + "는 2의 배수");
		}
		//num가 3의 배수이고 2의 배수가 아니면 3의 배수라고 출력하고
		else if(num % 3 == 0 && num % 2 != 0) {
			System.out.println(num + "는 3의 배수");
		}
		//num가 6의 배수이면 6의 배수라고 출력하고
		else if(num % 6 == 0) {
			System.out.println(num + "는 6의 배수");
		}
		//아니면 2,3,6의 배수가 아니라고 출력
		else {
			System.out.println(num + "는 2,3,6의 배수가 아님");
		}
		
		//순서가 중요 => 조건식이 간단
		//num가 6의 배수이면 6의 배수라고 출력하고
		if(num % 6 == 0) {
			System.out.println(num + "는 6의 배수");
		}
		//num가 2의 배수이면 2의 배수라고 출력하고
		else if(num % 2 == 0) {
			System.out.println(num + "는 2의 배수");
		}
		//num가 3의 배수이면 3의 배수라고 출력하고
		else if(num % 3 == 0) {
			System.out.println(num + "는 3의 배수");
		}
		//아니면 2,3,6의 배수가 아니라고 출력
		else {
			System.out.println(num + "는 2,3,6의 배수가 아님");
		}
		
		//중첩 if문
		//num가 2의 배수이면
		if(num % 2 == 0) {
			//num가 3의 배수이면 6의 배수라고 출력하고
			if(num % 3 == 0) {
				System.out.println(num + "는 6의 배수");
			}
			//아니면 2의 배수라고 출력하고
			else {
				System.out.println(num + "는 2의 배수");
			}
		
		}
		//num가 3의 배수이면 3의 배수라고 출력하고
		else if(num % 3 == 0) {
			System.out.println(num + "는 3의 배수");
		}
		//아니면 2,3,6의 배수가 아니라고 출력
		else {
			System.out.println(num + "는 2,3,6의 배수가 아님");
		}

	}

}
