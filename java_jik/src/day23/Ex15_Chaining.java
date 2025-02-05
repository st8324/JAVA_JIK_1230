package day23;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex15_Chaining {

	public static void main(String[] args) {
		
		Point4 p = new Point4(10, -10);
		//print1은 리턴이 void이어서 체이닝을 사용할 수 없음
		p.print1();
		System.out.println("-----------");
		//print2는 리턴이 Point4 객체이이서 Point4에서 제공하는 메소드를 이어서 체이닝할수 있음
		p.print2().print1();
		System.out.println("-----------");
		//print2는 리턴이 Point4이어서 Point4에서 제공하는 메소드를 이어서 체이닝 할수 있었고,
		//toString은 리턴이 String이어서 String에서 제공하는 substring을 체이닝으로 사용할 수 있다
		String str = p.print2().toString().substring(3);
		System.out.println("-----------");
		/* System 클래스의 클래스로 필드(static이 붙은 필드)로 PrintStream클래스 객체 out이 있고,
		 * PrintStream에서 제공하는 println을 사용할 수 있다 
		 * */
		System.out.println(str);
	}

}

@Data
@AllArgsConstructor
class Point4{
	private int x, y;
	
	public void print1() {
		System.out.println(x + "," + y);
	}
	public Point4 print2() {
		System.out.println(x + "," + y);
		return this;
	}
}
