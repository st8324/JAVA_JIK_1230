package day06;

public class Ex02_ArrayMax {

	public static void main(String[] args) {
		/* 배열에 저장된 값 중 가장 큰 값을 출력하는 코드를 작성하세요. */
		int [] arr = new int[] {-1, -10, -9, -20, -3, -4};

		int max = arr[0];
		
		for(int i = 1; i < arr.length; i++) {
			//max가 i번지에 있는 값보다 작으면 i번지에 있는 값을 max에 저장
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		
		System.out.println("배열에서 가장 큰 수 : " + max);
		
	}

}
