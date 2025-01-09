package day08;

public class Ex06_AbstractClass {

	public static void main(String[] args) {
		//A1 a1 = new A1(); //에러 발생 : 추상 클래스는 객체를 직접 만들 수 없음
		//자식 클래스인 B1 클래스를 이용하여 객체를 생성 후 업캐스팅을 이용하여
		//클래스 형변환을 함
		A1 a1 = new B1();
	}

}
//추상 메소드가 없어도 abstract를 붙이면 추상 클래스가 됨
abstract class A1{
	
}

class B1 extends A1{
	
}
//추상 메소드가 있으면 반드시 추상 클래스로 만들어야 함
abstract class A2{
	//print는 추상메소드
	public abstract void print();
	//print2는 구현이 안된 메소드
	public void print2() {}
}
//추상 클래스를 상속받으면 추상 클래스가 될 수 있다
abstract class B2_1 extends A2{
	
}
//추상 클래스를 상속받았을 때, 추상 메소드를 오버라이딩하면 일반 클래스가 될 수 있다
class B2_2 extends A2{

	@Override
	public void print() {
		System.out.println("출력합니다.");		
	}
	
}


