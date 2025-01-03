package day04;

public class Ex05_Method3 {

	public static void main(String[] args) {
		/* 2단에서 9단까지 구구단을 출력하는 코드를 작성하세요. 단, 메소드를 활용해서
		 * */
		int num = 2;
		
		for(num = 2; num <= 9; num++) {
			System.out.println(num + "단");
			//num단
			printMutipleTable(num);
		}
		
	}
	
	/**num단을 출력하는 메소드
	 * 매개변수 : 출력할 단 => int num
	 * 리턴타입 : 없음 => void
	 * 메소드명 : printMutipleTable
	 * @param num 출력할 단
	 * @return void 없음
	 */
	public static void printMutipleTable(int num) {
		for(int i = 1; i<=9; i++) {
			System.out.println(num + " X " + i + " = " + num * i);
		}
	}
	
}
