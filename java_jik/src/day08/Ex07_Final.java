package day08;

public class Ex07_Final {

	public static void main(String[] args) {
		/* final : 변하지 않은
		 * - 변수 : 변수가 변하지 않음 => 상수
		 * 		Math.PI
		 * - 메소드 : 메소드가 변하지 않음 => 오버라이딩 불가능
		 * - 클래스 : 클래스가 변하지 않음 => 상속이 불가능
		 * 		String
		 * */
		//상수는 재할당이 한번만 가능한 변수
		final int max;
		max = 10;
		
	}

}

final class C1{}
class C2{
	public void test1() {}
	public final void test2() {}
}
//에러 발생. final class인 C1은 부모가 될 수 없기 때문에
//class D1 extends C1{}
//final이 붙지 않은 클래스는 상속이 가능
class D2 extends C2{
	
	@Override
	public void test1() {}
	
	//아래 메소드는 final 메소드이기 때문에 오버라이드 할 수 없음
	//public void test2() {} //에러 발생
}

