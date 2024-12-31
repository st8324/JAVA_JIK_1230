package day02;

import java.util.Scanner;

public class Ex10_Scanner {

	public static void main(String[] args) {
		
		//Scanner를 이용해서 콘솔에서 입력받은 값 활용하는 예제

		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 : ");
		int num = scan.nextInt();
		System.out.println("입력받은 정수 : " + num);
		
		System.out.print("실수를 입력하세요 : ");
		double num2 = scan.nextDouble();
		System.out.println("입력받은 실수 : " + num2);
		
		System.out.print("단어를 입력하세요 : ");
		String str = scan.next(); //next()는 공백을 제외한 단어를 가져옴
		System.out.println("입력받은 단어 : " + str);
		
		System.out.print("문자를 입력하세요 : ");
		char ch = scan.next().charAt(0); //단어를 가져와서 단어의 첫글자를 가져옴
		System.out.println("입력받은 문자 : " + ch);
		
		scan.nextLine();//앞에서 입력한 엔터를 처기하기 위해서 사용
		System.out.print("문장을 입력하세요 : ");
		String str2 = scan.nextLine();
		System.out.println("입력받은 문장 : " + str2);
	}

}
