package day08;

import day08.ex02.BenzCar;
import day08.ex02.Car;
import day08.ex02.KiaCar;

public class Ex04_Polymorphism {

	public static void main(String[] args) {
		
		KiaCar kia = new KiaCar();
		BenzCar benz = new BenzCar();
		
		repair(benz);
		repair(kia);
		
	}
	/*
	//아래와 같이 자동차별로 기능을 만들면 자동차 종류별로 메소드 오버로딩을 여러개 해야 함
	public static void repair(KiaCar kia) {
		kia.repair();
	}
	
	public static void repair(BenzCar benz) {
		benz.repair();
	}
	*/
	public static void repair(Car car) {
		car.repair();
	}
}
