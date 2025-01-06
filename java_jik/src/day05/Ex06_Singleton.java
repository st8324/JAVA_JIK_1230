package day05;

public class Ex06_Singleton {

	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		
		System.out.println(s1.getNum());
		System.out.println(s2.getNum());
		
		s1.setNum(20);
		System.out.println(s1.getNum());
		System.out.println(s2.getNum());
	}

}

class Singleton{
	//싱글톤 클래스는 객체를 생성해서 클래스 변수에 연결. 생성자는 이때만 사용
	private static Singleton s = new Singleton();
	
	private int num = 10;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	private Singleton() {
		num = 10;
	}
	
	public static Singleton getInstance() {
		return s;
	}
	
	
}

