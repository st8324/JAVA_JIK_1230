package day08.ex02;

public class BenzCar extends Car {

	public String logo = "벤츠";
	
	@Override
	public void repair() {
		System.out.println("벤츠를 수리합니다.");
	}
}
