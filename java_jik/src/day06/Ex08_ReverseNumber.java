package day06;

import java.util.Scanner;

public class Ex08_ReverseNumber {

	public static void main(String[] args) {

		/*
		 * 4자리의 정수를 입력받아 입력받은 정수를 역순으로 출력하는 코드를 작성하세요.
		 * 입력 : 1234
		 * 결과 : 4321
		 * 입력 : 1230
		 * 결과 : 0321
		*/
		Scanner scan = new Scanner(System.in);
		System.out.print("4자리 정수 입력 : ");
		int num = scan.nextInt();
		
		/* 1234 => 4
		 * 1234 => 123
		 * 123 => 3
		 * 123 => 12
		 * 12 => 2
		 * 12 => 1
		 * 1 => 1
		 * 1 => 0
		 * */
		int tmp = num;
		
		if(!checkNumber(num, 4)) {
			System.out.println("4자리 정수가 아닙니다.");
			return;
		}
		while(tmp > 0) {
			//1의 자리 숫자 출력
			System.out.print(tmp % 10);
			//1의 자리 숫자를 제거
			tmp /= 10;//tmp = tmp / 10;
		}
		/* 1234 => 1
		 * 1234 / (10, 4-1)
		 * 1234 => 234
		 * 234 / (10, 4-2) => 2
		 * 234 => 34
		 * 34 / (10, 4-3) =>3
		 * 34 => 4
		 * 4 / (10, 4-4) => 4
		 * 4 => 0
		 * */
		int []res = new int[4];
		tmp = num;
		for(int i = 0; i<res.length; i++) {
			int lastNum = tmp / (int)pow(10, res.length - i - 1); 
			res[i] = lastNum;
			tmp = tmp % (int)pow(10, res.length - i - 1);
		}
		System.out.println();
		for(int i = res.length - 1; i >= 0; i--) {
			System.out.print(res[i]);
		}
	}
	
	public static boolean checkNumber(int num, int size) {
		int min = 1*(int)pow(10,size-1);
		//Math.pow(a,b) : a의 b제곱
		int max = 1*(int)Math.pow(10, size);
		if(num >= max || num < min) {
			return false;
		}
		return true;
	}
	//a의 n제곱
	public static double pow(int a, int n) {
		if(n == 0) {
			return 1;
		}
		double res = 1;
		
		if(n > 0 ) {
			for(int i = 0; i<n; i++) {
				res *= a;
			}
			return res;
		}
		n = -n;
		for(int i = 0; i<n; i++) {
			res /= (double)a;
		}
		return res;
	}
}
