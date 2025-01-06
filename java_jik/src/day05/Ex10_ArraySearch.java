package day05;

public class Ex10_ArraySearch {

	public static void main(String[] args) {
		/* 다음 배열에 num이 있는지 없는지 판별하는 코드를 작성하세요. 
		 * */
		
		int [] array = new int[] {1,2,3,4,5};
		int num = 4;

		boolean result = false;
		
		for(int i = 0; i < array.length; i++) {
			//i번지에 있는 값과 num가 같으면 result 변수에 true를 저장 후 반복문 종료
			if(array[i] == num) {
				result = true;
				break;
			}
		}
		if(result) {
			System.out.println(num + "는 배열에 있음.");
		}
		else {
			System.out.println(num + "는 배열에 없음.");
		}
		
		if(contains(array, num)) {
			System.out.println(num + "는 배열에 있음.");
		}
		else {
			System.out.println(num + "는 배열에 없음.");
		}
		
		if(contains(array, 3, num)) {
			System.out.println(num + "는 배열에 3개 안에 있음.");
		}
		else {
			System.out.println(num + "는 배열에 3개 안에 없음.");
		}
		
	}

	/* 배열에 num가 있는지 없는지 알려주는 메소드 
	 * 매개변수 : 배열과 num => int [] arr, int num
	 * 리턴타입 : 있는지 없는지 => boolean
	 * 메소드명 : contains */
	public static boolean contains(int [] arr, int num) {
		for(int i = 0; i < arr.length; i++) {
			//찾으면 찾았다고 알려줌
			if(arr[i] == num) {
				return true;
			}
		}
		return false;
	}
	
	
	/* 배열 중 0번지부터 n개를 비교하여 num가 있는지 없는지 알려주는 메소드
	 * 매개변수 : 배열, 비교 개수, num => int [] arr, int count, int num
	 * 리턴타입 : 있는지 없는지 => boolean
	 * 메소드명 : contains */
	public static boolean contains(int [] arr,int count, int num) {
		//배열의 크기보다 큰 숫자가 count로 오면 count를 배열의 크기로 변경
		if(arr.length < count) {
			count = arr.length;
		}
		for(int i = 0; i < count; i++) {
			//찾으면 찾았다고 알려줌
			if(arr[i] == num) {
				return true;
			}
		}
		return false;
	}
}






