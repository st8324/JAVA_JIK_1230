package day04;

public class Ex08_Class2 {

	public static void main(String[] args) {
		//(10,10)위치에 점을 생성
		Point1 p1 = new Point1(10, 10);
		p1.print();
		//점의 위치를 (20,20)으로 이동한 후 출력
		p1.move(20, 20);
		p1.print();
	}

}

/* 화면의 점을 나타내기 위한 클래스를 생성하세요.
 *  
 * */
class Point1{
	//필드 : x,y좌표
	private int x, y;
	
	//메소드 : x,y좌표 출력, 좌표 이동 기능
	public void print() {
		System.out.println("(" + x + "," + y + ")");
	}
	public void move(int x1, int y1) {
		x = x1;
		y = y1;
	}
	
	//생성자 : 기본 생성자, 원하는 위치로 이동하는 생성자
	public Point1() {}
	
	public Point1(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	
}