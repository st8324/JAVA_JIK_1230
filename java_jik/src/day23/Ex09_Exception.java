package day23;

public class Ex09_Exception {

	public static void main(String[] args) {

		/* 0으로 나누었을 때 0으로 나눌 수 없습니다를 처리하도록 수정 */
		double num1 = 1, num2 = 0;

		/* 조건문을 이용하여 num2가 0일 때 0으로 나눌 수 없습니다가 출력되게 하고, else로 아래 코드를 출력 */
		/* num2가 0이면 예외를 발생시켜서 try catch로 예외 처리*/
		
		try {
			if(num2 == 0) {
				throw new Exception();
			}
			System.out.println(num1 + "/" + num2 + "=" + num1/num2);
		}catch(Exception e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}
	}

}
