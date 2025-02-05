package day23;

public class Ex08_Exception {

	public static void main(String[] args) {
		
		/* 다음 코드를 실행했을 생기는 예외에 대한 원인과 해결 방법에 대해 설명하세요. 
		 * 프로그램 종료가 출력되도록 해결 */
		
		/* 방법1 : num2가 0이 되지 않게 수정 */
		int num1 = 1, num2 = 0;
		
		/* 방법2 : try catch를 이용하여 예외 처리 */
		try {
			System.out.println(num1 + "/" + num2 + "=" + num1/num2);
		}catch(Exception e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}
		System.out.println("프로그램 종료");
	}

}
