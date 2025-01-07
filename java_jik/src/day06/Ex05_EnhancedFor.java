package day06;

public class Ex05_EnhancedFor {

	public static void main(String[] args) {
		int [] arr = new int[] {1,5, 10, 2, 3};
		
		print(arr);
		System.out.println("----------");
		print2(arr);
	}

	public static void print(int [] arr) {
		for(int i = 0; i<arr.length; i++) {
			int tmp = arr[i];
			System.out.print(tmp + " ");
		}
		System.out.println();
	}
	
	public static void print2(int [] arr) {
		for(int tmp : arr) {
			System.out.print(tmp + " ");
		}
		System.out.println();
	}
}
