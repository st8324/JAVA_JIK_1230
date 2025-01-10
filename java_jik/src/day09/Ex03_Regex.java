package day09;

import java.util.regex.Pattern;

public class Ex03_Regex {

	public static void main(String[] args) {
		
		//주어진 문자열이 숫자로만 되어 있는지 확인하는 예제
		String str = "00123123a";
		String regex = "^\\d+$";
		if(Pattern.matches(regex, str)) {
			System.out.println(str + "은 숫자로만 이루어졌습니다.");
		}
		else {
			System.out.println(str + "에 숫자가 아닌 문자가 있습니다.");
		}

	}

}
