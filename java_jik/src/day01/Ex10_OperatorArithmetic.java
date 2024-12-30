package day01;

public class Ex10_OperatorArithmetic {

	public static void main(String[] args) {
		int num1 = 5, num2 = 3;
		
		System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
		System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
		System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
		//정수 / 정수 => 정수이므로 정수 / 실수로 변환해서 계산
		System.out.println(num1 + " / " + num2 + " = " + (num1 / (double)num2));
		System.out.println(num1 + " % " + num2 + " = " + (num1 % num2));

	}

}
