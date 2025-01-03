package day04.access.modifier1;

import day04.access.modifier2.B;

public class Ex08_AccessModifier {

	public static void main(String[] args) {
		//A클래스는 이 예제와 같은 패키지
		//B클래스는 이 예제와 다른 패키지
		A a1 = new A();
		B b1 = new B();
		
		//public인 필드들은 다른 패키지에 클래스에서도 사용할 수 있다
		a1.name = "홍길동";
		b1.name = "임꺽정";
		
		//default인 필드들은 같은 패키지에 있는 클래스에서 사용할 수 있다
		a1.address = "서울시";
		//b1.address = "서울시";//다른 패키지어서 사용할 수 없음
		
		//private은 해당 클래스가 아니면 사용할 수 없음
		//a1.num = "000101-1234567";
		//b1.num = "001101-1234567";
		b1.setNum("001101-1234567");
		System.out.println(b1.getNum());
		
	}

}
