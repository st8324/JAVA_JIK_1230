package day01;

public class Ex03_VariableNumber {

	public static void main(String[] args) {
		byte num1 = 1;
		//num1 = 12345; //byte가 저장할 수 있는 범위를 넘었기 때문에 에러가 발생
		System.out.println(num1);
		int num2 = 123456789;
		//num2 = 123456789012;//int가 저장할 수 있는 범위를 넘었기 때문에 에러가 발생
		System.out.println(num2);
		long num3 = 123456789012L;//접미사 L(l)으 안 붙이면 에러 발생. L이 안 붙으면 int형이기 때문에
		System.out.println(num3);

		float num4 = 3.14F;//3.14는 double형이기 때문에 float에 저장할 수 없음. 접미사 F(f)를 붙임
		//소수점 9자리까지 확인.
		System.out.printf("%.9f\n", num4);
		
		double num5 = 3.14;
		//소수점 20자리까지 확인.
		System.out.printf("%.20f\n", num5);
		
		//십진수 표현이 아닌 값을 정수에 저장하는 예제
		int num6 = 0x10; //16진수 10 => 16
		System.out.println(num6);
		
		int num7 = 010; //8진수 10 => 8
		System.out.println(num7);
		
		int num8 = 0b10; //2진수 10 => 2
		System.out.println(num8);
		
		int num9 = 'A'; //'A'의 해당하는 정수값(0041)이 저장 => 65
		System.out.println(num9);
		
		double num10 = 1e3; //1*10^3 => 1000.0
		System.out.println(num10);
		
	}

}
