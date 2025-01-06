package day05;

import java.util.Scanner;

public class Ex08_Array {

	public static void main(String[] args) {
		
		//학생 3명의 국어 성적을 관리하기 위해서 배열을 선언하고, 
		//콘솔을 통해 성적을 입력받고, 입력받은 성적을 출력하는 코드
		int studentCount = 3;
		int [] kors = new int[studentCount];
		
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0; i < studentCount; i++) {
			System.out.print("학생" + (i+1)+ " 국어 성적 입력 : ");
			kors[i] = scan.nextInt();
		}
		
		for(int i = 0; i < studentCount; i++) {
			System.out.println("학생" + (i+1)+ " 국어 성적 : " + kors[i]);
		}
		
		//3학생의 평균을 구해서 출력하는 코드를 작성하세요.
		int sum = 0;
		for(int i = 0; i<studentCount; i++) {
			sum += kors[i];
		}
		System.out.println("학생들의 국어 성적 평균 : " + sum / (double)studentCount);
	}

}
