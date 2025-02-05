package day23;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex11_Array {

	public static void main(String[] args) {
		/* 다음 코드의 잘못된 점을 찾아 수정하세요. */
		Point2 [] arr = new Point2[5];
		
		//클래스 배열은 각 번지가 null로 초기화 되기 때문에 객체를 생성하서 넣어주지 않으면 필드,메소드를 사용할 수 없음
		//반복문 전에 객체를 각 번지에 추가
		for(int i = 0; i<arr.length; i++) {
			System.out.println(arr[i].getX() + ", " + arr[i].getY());
		}
		
	}

}
@Data
@AllArgsConstructor
class Point2{
	int x, y;
}
