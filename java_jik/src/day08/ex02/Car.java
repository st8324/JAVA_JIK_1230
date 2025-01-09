package day08.ex02;

import lombok.Data;

@Data
public class Car{
	
	private boolean power;
	protected int speed;
	
	public void turnOn() 	{	this.power = true; }
	public void turnOff() 	{	this.power = false;}
	
	public void speedUp() 	{ speed++; 	}
	public void speedDown() { speed--;	}
	
	public void repair() {
		System.out.println("자동차를 수리합니다.");
	}
}
