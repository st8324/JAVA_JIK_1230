package day23;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

public class Ex05_List {

	public static void main(String[] args) {
		/* 리스트에 좌표의 점을 저장해서 관리하는 예제. 잘못된 점은 찾아 수정하세요. */
		/*
		List<Point> list = new ArrayList<Point>();
		list.add(new Point());
		//생성자가 없음. 생성자를 추가
		list.add(new Point(1,2));
		list.add(new Point(1));
		//리스트에 추가하려면 Point 클래스의 객체가 와야 하는데 정수가 와서 안됨. Point 클래스의 객체로 변환하거나 삭제
		list.add(1);
		*/
		
		/* 리스트에 좌표의 점과 문자열, 정수를 함께 관리하려 한다. 이때 필요한 리스트를 선언하세요.
		 */
		 //점 클래스, 문자열 클래스, 정수 클래스의 공통 조상인 Object를 이용
		 List<Object> list = new ArrayList<Object>();
		 list.add(new Point());
		 list.add("안녕");
		 list.add(1);
		 
		
	}
}

@Data
class Point{
	int x, y;
}
