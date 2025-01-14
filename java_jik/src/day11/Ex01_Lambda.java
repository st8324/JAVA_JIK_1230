package day11;

public class Ex01_Lambda {

	public static void main(String[] args) {
		/* 인터페이스의 객체를 생성하기 위해 구현 클래스를 선언 후 구현 클래스의 객체를 생성 */
		MyMath mm = new MyMathClass();
		System.out.println(mm.max(1, 2));
		
		/* 인터페이스의 객체를 생성하기 위해 익명 클래스를 선언 후 객체를 생성 */
		MyMath mm2 = new MyMath() {
			@Override
			public int max(int num1, int num2) {
				return num1 > num2 ? num1 : num2;
			}
		};
		System.out.println(mm2.max(1, 2));

		/* 인터페이스의 객체를 생성하기 위해 익명 클래스를 선언 후 객체를 생성 : 람다식 */
		MyMath mm3 = (num1, num2)-> num1 > num2 ? num1 : num2;

		System.out.println(mm3.max(1, 2));
		
		Abs abs = num-> num < 0 ? -num : num;
		
		System.out.println(abs.abs(-10));
	}

}
interface Abs{
	int abs(int num);
}

interface MyMath{
	int max(int num1, int num2);
}
//구현 클래스
class MyMathClass implements MyMath{

	@Override
	public int max(int num1, int num2) {
		return num1 > num2 ? num1 : num2;
	}
	
}