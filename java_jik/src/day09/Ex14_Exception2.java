package day09;

import java.util.Arrays;

public class Ex14_Exception2 {

	public static void main(String[] args) {
		
		int []arr = new int [] {1,2,3,4,5};
		
		arr =  expend(arr, 5);
		System.out.println(Arrays.toString(arr));
		
		//예외가 발생할 수 있는 상황 : 축소하는 경우 복사하는 과정에서 문제가
		//발생할 수 있다
		try {
			//arr = expend(arr, -10);
			//예외가 발생할 수 있는 상황
			//배열이 null이어서 예외가 발생
			arr = null;
			arr = expend(arr, 10);
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("프로그램 종료.");

	}
	
	public static int [] expend(int [] arr, int addSize) {
		if(addSize < 0) {
			throw new RuntimeException("배열을 축소할 수 없습니다.");
		}
		if(arr == null) {
			throw new NullPointerException("없는 배열을 확장할 수 없습니다.");
		}
		int [] tmp = new int[arr.length + addSize];
		System.arraycopy(arr, 0, tmp, 0, arr.length);
		return tmp;
	}

}
