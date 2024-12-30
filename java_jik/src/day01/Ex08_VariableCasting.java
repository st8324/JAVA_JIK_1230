package day01;

public class Ex08_VariableCasting {

	public static void main(String[] args) {
		
		//자동 자료형 변환
		double num1 = 1;//int 1이 double로 자동 형변환
		
		int num2 = 'A'; //A의 정수값이 저장. char A가 int로 자동 형변환
		
		long num3 = 1234;//int 1234가 long으로 자동 형변환
		
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);

		//강제 자료형 변환 : 데이터 손실이 발생할 수 있기 때문에(반드시)
		int num4 = (int)3.14; //double 값이 int로 변하면 소수점이 사라질 수 있어서 에러가 발생
		
		int num5 = (int)123L;//long 값이 int로 변하면 표현하지 못하는 부분이 사라질 수 있어서 에러가 발생

		System.out.println(num4);
		System.out.println(num5);
		
		//강제 자료형 변환 : 원하는 결과값을 위해서 
		double result = (double)1 / 2;
		
		System.out.println(result);
		
	}

}
