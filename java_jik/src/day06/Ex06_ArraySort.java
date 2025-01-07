package day06;

import java.util.Arrays;
import java.util.Collections;

public class Ex06_ArraySort {

	public static void main(String[] args) {
		//정렬 예제
		int [] arr = new int[] {1,3,5,7,9,2,4,6,8,10};
		
		/* 1 3 5 7 9 2 4 6 8 10
		 * 1 3 5 7 2 4 6 8 9 10 : 10이 정렬
		 * 1 3 5 2 4 6 7 8 9 10 : 9가 정렬
		 * */
		/* 버블정렬 시간복잡도 O(n^2)
		 * */
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = 0; j < arr.length - 1; j++) {
				if(arr[j] < arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		Ex05_EnhancedFor.print2(arr);
		
		int [] arr2 = new int[] {1,3,5,7,9,2,4,6,8,10};
		/* Arrays.sort(배열) : 오름차순으로 정렬. 
		 * Dual-Pivot Quicksort 알고리즘 이용. 시간복잡도 O(nlogn)*/
		Arrays.sort(arr2);
		//Arrays.toString(배열) : 배열을 문자열로 변환. [값, 값, ...]
		System.out.println(Arrays.toString(arr2));
		
		Integer [] arr3 = {1,3,5,7,9,2,4,6,8,10};
		/* 배열의 내림차순은 기본 자료형으로는 제공이 안됨.
		 * Integer 배열을 활용.
		 * Arrays.sort(배열, Collections.reverseOrder()) : 내림차순
		 * */
		Arrays.sort(arr3, Collections.reverseOrder());
		System.out.println(Arrays.toString(arr3));
	}

}
