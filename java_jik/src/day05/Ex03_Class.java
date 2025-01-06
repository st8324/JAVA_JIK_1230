package day05;

public class Ex03_Class {

	public static void main(String[] args) {
		String name = "임꺽정";
		int count = 100;
		
		System.out.println("이름 : " + name + " - " + count + "회");
		record1(name, count);
		System.out.println("이름 : " + name + " - " + count + "회");
		
		System.out.println("-----------------------------");
		
		Record r1 = new Record(name, count);
		r1.print();
		record2(r1);
		r1.print();

	}
	
	public static void record1(String name, int count) {
		name = "홍길동";
		count = 2;
	}
	public static void record2(Record r1) {
		r1.setName("홍길동");
		r1.setCount(2);
	}
}


class Record{
	//멤버 변수, 필드
	private int count;
	private String name;
	
	//메소드 : 기능
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void print() {
		System.out.println("이름 : " + name + " - " + count + "회");
	}
	
	//생성자
	public Record(String name, int count) {
		this.name = name;
		this.count = count;
	}
	public Record() {
		this("홍길동", 100);
		//name = "홍길동";
		//count = 100;
	}
	
}
