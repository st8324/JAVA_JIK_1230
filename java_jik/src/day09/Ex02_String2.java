package day09;

import java.util.Scanner;

public class Ex02_String2 {

	public static void main(String[] args) {
		/* 파일명을 수정하는 기능을 구현하세요.
		 * 기존 파일명을 입력받고(확장자를 포함)
		 * 수정하려는 파일명을 입력받아(확장자 제외)
		 * 파일명을 수정하세요.
		 * 
		 * 입력 : test.txt
		 * 수정 : 연습
		 * 결과 : 연습.txt
		 * 
		 * lastIndexOf, substring, replace
		 * */

		Scanner scan = new Scanner(System.in);
		System.out.print("입력 : ");
		String fileName = scan.nextLine();
		System.out.print("수정 : ");
		String newFileName = scan.nextLine();
		
		//뒤에서 첫 .의 위치를 찾음
		int index = fileName.lastIndexOf(".");
		
		if(index < 0) {
			System.out.println("확장자가 없는 파일명입니다.");
			return;
		}
		//0번지부터 .의 위치전까지 문자열을 추출
		String oriFileName = fileName.substring(0, index);
		
		//추출한 문자열을 입력받은 문자열로 교체
		fileName = fileName.replace(oriFileName, newFileName);
		
		System.out.println("결과 : " + fileName);
	}

}
