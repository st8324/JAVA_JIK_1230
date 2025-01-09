package day08;

public class Ex05_Super {

	public static void main(String[] args) {
		
		Parent p = new Parent("홍길동");
		p.print();
		System.out.println("-----------");
		Child c = new Child("임꺽정");
		c.print();
	}

}
class Parent{
	
	String name;

	public Parent(String name) {
		this.name = name;
	}
	
	public void print() {
		System.out.println("출력합니다.");
	}
}
class Child extends Parent{
	
	String type;
	
	public Child() {
		super("");
		type = "";
	}
	public Child(String name) {
		super(name);
		type = "일반";
	}
	
	@Override
	public void print() {
		//출력합니다.
		//name : type
		super.print();
		System.out.println(name + " : " + type);
	}
}




