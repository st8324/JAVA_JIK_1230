package day03;

public class Ex20_NestingAlphabet {

	public static void main(String[] args) {
		/* 다음과 같이 출력되도록 코드를 작성하세요.
		 * a
		 * ab
		 * abc
		 * abcd
		 * abcde
		 * ...
		 * abcdefg...xyz
		 * 
		 * 반복횟수 : lastCh가 a부터 z까지 1씩 증가
		 * 규칙성 : a부터 lastCh까지 알파벳을 출력
		 * 반복문 종료 후 : 없음
		 * */
		char ch, lastCh = 'a';
		
		for(lastCh = 'a'; lastCh <= 'z'; lastCh++) {
			for(ch = 'a'; ch <= lastCh; ch++) {
				System.out.print(ch);
			}
			System.out.println();
		}
		
	}

}
