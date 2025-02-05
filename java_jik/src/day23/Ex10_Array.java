package day23;

public class Ex10_Array {

	public static void main(String[] args) {
		
		int [] arr = new int[5];
		/* 배열의 모든 값을 확인하기 위해 다음 코드를 작성하였다. 잘못된 부분을 수정 */
		//배열의 번지는 크기보다 작아야 하는데 i가 arr.length까지 가서 범위를 벗어남
		//=를 빼면
		for(int i = 0; i<=arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

}
