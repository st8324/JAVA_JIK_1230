package day04;

public class Ex07_Class {

	public static void main(String[] args) {
		Car car1 = new Car("현대", "아반떼", 2025); 
		System.out.println(car1.name);
		
		Car car2 = new Car("기아", "K5", 2025);
		System.out.println(car2.name);
		
		car1.print();
		car1.turnOn();
		car1.print();
		car1.changeGear('D');
		for(int i = 1; i<=10; i++) {
			car1.speedUp();
		}
		car1.print();
		
		car1.color = "Green";//접근 제어자가 public이어서 다른 클래스에서 접근할 수 있음
		System.out.println(car1.color);
		//car1.gear = 'N'; //접근제어자가 private이어서 다른 클래스에서 직접 접근할 수 없음
	}

}
/* 자동차 클래스
 * - 정보 : 연료 종류, 회사, 종류, 색상, 년식, 차명
 * - 기능 : 시동 켜기/끄기, 기어 변경, 액셀 누름, 브레이크 누름, 핸들 변경
 * */
class Car{
	//멤버변수, 필드
	public String company;
	public String name;
	public String type;
	public String color;
	public int year;
	public String oilType;
	private boolean power; //전원
	private char gear; //기어
	private int speed; //속력
	private int deg;//방향의 각도
	
	//메소드
	/* 시동을 키는 메소드
	 * 매개변수 : 없음.
	 * 리턴타입 : 없음 => void
	 * 메소드명 : turnOn */
	public void turnOn() {
		power = true;
	}
	public void trunOff() {
		if(speed == 0) {
			power = false;
		}
	}
	/* 엑셀레이터를 밟아서 속력이 1 증가하는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음=> void
	 * 메소드명 : speedUp
	 * */
	public void speedUp() {
		
		if(power && (gear == 'D' || gear == 'R')) {
			speed++;			
		}
	}
	public void speedDown() {
		if(power) {
			speed--;
		}
	}
	/* 원하는 기어로 변경하는 메소드
	 * 매개변수 : 원하는 기어 => char gear1
	 * 리턴타입 : 없음 => void
	 * 메소드명 : changeGear
	 * */
	public void changeGear(char gear1) {
		if(power) {
			gear = gear1;
		}
	}
	public void changeDeg(int deg1) {
		deg = deg1;
	}
	//자동차 정보를 확인하는 메소드
	public void print() {
		System.out.println("--------------");
		System.out.println("전원 : " + power);
		System.out.println("속력 : " + speed);
		System.out.println("기어 : " + gear);
		System.out.println("--------------");
	}
	
	//기본 생성자
	/* 
	public Car(){
	
	}
	 * */
	
	public Car(String company1) {
		company = company1;
		gear = 'P';
	}
	//생성자 오버로딩
	public Car(String company1, String name1, int year1) {
		company = company1;
		name = name1;
		year = year1;
		gear = 'P';
	}
}