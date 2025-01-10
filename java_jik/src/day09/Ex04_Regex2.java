package day09;

import java.util.regex.Pattern;

public class Ex04_Regex2 {

	public static void main(String[] args) {
		/* 아이디가 주어진 조건에 맞는지 확인하는 코드를 작성하세요 
		 * 아이디는 숫자, 또는 영문 또는 특수만주(!@#$)로 이루어져있다.
		 * 아이디는 최소 8자에서 최대 13자이다.
		 * */
		String id = "123456789!123123123";
		//String regex = "^[a-zA-Z0-9!@#$]{8,13}$";
		String regex = "^(\\w|[!@#$]){8,13}$";
		if(Pattern.matches(regex, id)) {
			System.out.println(id + "는 사용이 가능합니다.");
		}
		else {
			System.out.println(id + "는 사용이 불가능한 아이디입니다.");
		}
		
	}

}
