package day04;

import java.util.Scanner;

public class Ex03_Method {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("두 정수를 입력하세요 : ");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		
		int gcd = gcd2(num1, num2);
		int lcm = lcm2(num1, num2);
		int lcm2 = lcm3(num1, num2);
		System.out.println(num1 + "과 " + num2 + "의 최대 공약수 : " + gcd);
		System.out.println(num1 + "과 " + num2 + "의 최소 공배수 : " + lcm);
		System.out.println(num1 + "과 " + num2 + "의 최소 공배수 : " + lcm2);
		
		int min = 1, max = 10;
		int r = random2(min, max);
		System.out.println(min + "과 " + max + " 사이의 랜덤한 수 : " + r);
	}

	/* 기능 : 두 정수의 최대 공약수를 알려주는 메소드
	 * 매개변수 : 두 정수 => int num1, int num2
	 * 리턴타입 : 두 정수의 최대 공약수 => 정수 => int
	 * 메소드명 : gcd2
	 */
	/**
	 * 두 정수의 최대 공약수를 알려주는 메소드
	 * @param num1 정수1
	 * @param num2 정수2
	 * @return 두 정수의 최대 공약수
	 */
	public static int gcd2(int num1, int num2) {
		
		int gcd = 1;
		
		for(int i = 1 ; i<= num1; i++) {
			if(num1 % i == 0) {
				if(num2 % i == 0) {
					gcd = i;
				}
			}
		}
		return gcd;
	}
	/* 기능 : 두 정수의 최소 공배수를 알려주는 메소드
	 * 매개변수 : 두 정수 => int num1, int num2
	 * 리턴타입 : 두 정수의 최소 공배수 => 정수 => int
	 * 메소드명 : lcm2
	 * */
	public static int lcm2(int num1, int num2) {
		for(int i = num1; ; i += num1) {
			if(i % num2 == 0) {
				return i;
			}
		}
	}

	public static int lcm3(int num1, int num2) {
		//최대 공약수를 알 때 최소 공배수를 계산
		/* A : Ga, B : Gb
		 * L : Gab => A*B/G
		 * */
		return num1 * num2 / gcd2(num1, num2);
	}
	
	/* 기능 : 최소값과 최댓값 사이의 랜덤한 수를 생성하는 메소드
	 * 매개변수 : 최솟값, 최대값 => int min, int max
	 * 리턴타입 : 랜덤한 정수 => 정수 => int
	 * 메소드명 : random2
	 * */
	public static int random2(int min, int max) {
		return (int)(Math.random()*(max - min + 1) + min);
	}
}
