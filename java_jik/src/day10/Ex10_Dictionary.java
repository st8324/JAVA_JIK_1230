package day10;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex10_Dictionary {

	/* 다음 기능을 갖는 사전 프로그램을 작성하세요.
	 * -----------------
	 * 1. 단어 등록
	 * 2. 단어 수정
	 * 3. 단어 삭제
	 * 4. 단어 검색
	 * 5. 종료
	 * 메뉴 선택 : 1
	 * 단어 : apple
	 * 의미 : 사과, 회사명
	 * 단어가 등록됐습니다.
	 * -----------------
	 * 1. 단어 등록
	 * 2. 단어 수정
	 * 3. 단어 삭제
	 * 4. 단어 검색
	 * 5. 종료
	 * 메뉴 선택 : 1
	 * 단어 : apple
	 * 의미 : apple
	 * 이미 등록된 단어입니다.
	 * -----------------
	 * 1. 단어 등록
	 * 2. 단어 수정
	 * 3. 단어 삭제
	 * 4. 단어 검색
	 * 5. 종료
	 * 메뉴 선택 : 2
	 * 단어 : apple
	 * 의미 : 사과, 회사명(애플)
	 * 단어가 수정됐습니다.
	 * -----------------
	 * 1. 단어 등록
	 * 2. 단어 수정
	 * 3. 단어 삭제
	 * 4. 단어 검색
	 * 5. 종료
	 * 메뉴 선택 : 4
	 * 단어 : a
	 * apple : 사과, 회사명(애플)
	 * -----------------
	 * 1. 단어 등록
	 * 2. 단어 수정
	 * 3. 단어 삭제
	 * 4. 단어 검색
	 * 5. 종료
	 * 메뉴 선택 : 3
	 * 단어 : apple
	 * 단어가 삭제됐습니다.
	 * -----------------
	 * 1. 단어 등록
	 * 2. 단어 수정
	 * 3. 단어 삭제
	 * 4. 단어 검색
	 * 5. 종료
	 * 메뉴 선택 : 5
	 * */
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Word> list = new ArrayList<Word>();
	
	public static void main(String[] args) {
		
		int menu;
		
		do {
			
			printMenu();
			
			menu = scan.nextInt();
			scan.nextLine();
			
			runMenu(menu);
			
		}while(menu != 5);
	}

	private static void runMenu(int menu) {
		switch (menu) {
		case 1: 
			insertWord();
			break;
		case 2:
			updateWord();
			break;
		case 3:
			deleteWord();
			break;
		case 4:
			searchWord();
			break;
		case 5:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("올바른 메뉴를 선택하세요.");
		}
		
	}

	private static void insertWord() {
		
		//단어와 뜻을 입력
		System.out.print("단어 : ");
		String word = scan.nextLine();
		
		System.out.print("의미 : ");
		String meaning = scan.nextLine();
		
		Word wordObj = new Word(word, meaning);
		//단어가 단어장에 있으면 알림문구 후 종료
		if(list.contains(wordObj)) {
			System.out.println("이미 등록된 단어입니다.");
			return;
		}
		/*
		//반복문을 이용하여 단어가 있는지 없는지 확인
		for(Word tmp : list) {
			if(tmp.getWord().equals(word)) {
				//안내문구
				System.out.println("이미 등록된 단어입니다.");
				return;
			}
		}
		*/
		//단어를 추가
		list.add(wordObj);
		System.out.println("단어를 등록했습니다.");
		System.out.println(list);
	}

	private static void updateWord() {
		
		//단어와 새 뜻을 입력
		System.out.print("단어 : ");
		String word = scan.nextLine();
		
		System.out.print("의미 : ");
		String meaning = scan.nextLine();
		
		//단어가 없으면 알림문구 후 종료
		//단어가 몇번인지 확인후 -1번지이면 알림문구 후 종료
		Word wordObj = new Word(word, meaning);
		
		int index = list.indexOf(wordObj);
		if(index < 0) {
			System.out.println("일치하는 단어가 없습니다.");
			return;
		}
		
		//단어를 수정
		//번지에 있는 단어를 가져와서 단어를 수정
		list.set(index, wordObj);
		System.out.println("단어를 수정했습니다.");
		
	}

	private static void deleteWord() {
		//단어를 입력
		System.out.print("단어 : ");
		String word = scan.nextLine();
		//단어가 있으면 단어를 삭제 후 알림문구 출력
		//없으면 알림문구 출력
		if(list.remove(new Word(word, ""))) {
			System.out.println("단어를 삭제했습니다.");
		}
		else {
			System.out.println("일치하는 단어가 없습니다.");
		}
	}

	private static void searchWord() {
		//단어 입력
		System.out.print("단어 : ");
		String word = scan.nextLine();
		int count = 0;
		//단어장에 있는 단어가 검색 단어를 포함하고 있으면 출력
		for(Word tmp : list) {
			if(tmp.getWord().contains(word)) {
				System.out.println(tmp);
				count++;
			}
		}
		if(count == 0) {
			System.out.println("일치하는 단어가 없습니다.");
		}
	}

	private static void printMenu() {
		
		System.out.print("-----------------\r\n"
				+ "1. 단어 등록\r\n"
				+ "2. 단어 수정\r\n"
				+ "3. 단어 삭제\r\n"
				+ "4. 단어 검색\r\n"
				+ "5. 종료\r\n"
				+ "-----------------\r\n"
				+ "메뉴 선택 : ");
		
	}

}

@Data
@AllArgsConstructor
class Word{
	private String word, meaning;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		return Objects.equals(word, other.word);
	}

	@Override
	public String toString() {
		return word + " : " + meaning;
	}
	
}

