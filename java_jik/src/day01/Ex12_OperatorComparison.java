package day01;

public class Ex12_OperatorComparison {

	public static void main(String[] args) {
		//비교 연산자 예제 : 결과가 false 아니면 true
		int num1 = 1, num2 = 2;
		System.out.println(num1 + " > " + num2 + " ? " + (num1 > num2));
		System.out.println(num1 + " >= " + num2 + " ? " + (num1 >= num2));
		System.out.println(num1 + " < " + num2 + " ? " + (num1 < num2));
		System.out.println(num1 + " <= " + num2 + " ? " + (num1 <= num2));
		System.out.println(num1 + " == " + num2 + " ? " + (num1 == num2));
		System.out.println(num1 + " != " + num2 + " ? " + (num1 != num2));
		
		String str1 = "abc";
		String str2 = "abc";
		String str3 = new String("abc");
		System.out.println(str1 + " == " + str2 + " ? " + (str1 == str2));
		System.out.println(str1 + " == " + str3 + " ? " + (str1 == str3));
		
		System.out.println("------------------------");
		System.out.println(str1 + " equals " + str2 + " ? " + (str1.equals(str2)));
		System.out.println(str1 + " equals " + str3 + " ? " + (str1.equals(str3)));
		
	}

}
