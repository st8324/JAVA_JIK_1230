package day10;

import java.util.ArrayList;

public class Ex01_List {

	public static void main(String[] args) {
		/* 컬렉션 프레임워크를 왜 사용할까?
		 * 	- 여러 데이터를 편하게 사용하기 위해서
		 * 	- 배열은 꽉 차면 직접 늘려줘야 함
		 * 	- 배열은 중간에 삭제하면 앞으로 당겨줘야 함
		 * Collection 인터페이스의 자식 인터페이스
		 * List는 인터페이스
		 * 	- 중복 허용
		 * 	- 순서 보장 => 특정 번지에 접근 가능
		 * ArrayList
		 * 	- List 인터페이스의 구현 클래스
		 * 	- 제네릭 클래스
		 * 	  - 멤버변수/메서드의 타입이 정해지지 않은 클래스
		 * 	  - 타입을 객체를 생성할 때 정함
		 * 	  - 타입은 클래스만 가능
		 * 
		 * */
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(10);	//Collection 인터페이스에서 제공하는 메소드
		list.add(20);
		list.add(30);
		
		System.out.println(list);
		
		list.add(1, 11);	//List 인터페이스에서 제공하는 메소드 => Set에 없음
		
		System.out.println(list);

		list.remove((Integer)10);	//Collection 인터페이스에서 제공하는 메소드
		
		System.out.println(list);
		
		list.remove(0);	//List 인터페이스에서 제공하는 메소드 => Set에 없음
		
		System.out.println(list);
		
		System.out.println(list.get(0));	//List 인터페이스에서 제공
		
		System.out.println(list.contains(20)); //Collection 인터페이스에서 제공
		
		System.out.println(list.indexOf(20));	//List 인터페이스에서 제공
	}

}
