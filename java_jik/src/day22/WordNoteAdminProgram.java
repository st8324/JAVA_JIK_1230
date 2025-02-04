package day22;

import java.util.List;
import java.util.Scanner;

public class WordNoteAdminProgram implements ConsoleProgram {
	
	private Scanner scan;
	private WordManager wm;

	public WordNoteAdminProgram(Scanner scan, List<Word> words) {
		this.scan = scan;
		wm = new WordManager(words);
	}

	@Override
	public void run() {
		
		int menu;
		final int EXIT = 4;
		
		do {
		
			printMenu();
			
			menu = scan.nextInt();
			scan.nextLine();
			
			runMenu(menu);
			
			wm.sort();
			//wm.print();
			
		}while(menu != EXIT);
		
	}

	@Override
	public void printMenu() {
		System.out.println("----------------");
		System.out.println("1. 단어 등록");
		System.out.println("2. 단어 수정");
		System.out.println("3. 단어 삭제");
		System.out.println("4. 종료");
		System.out.println("----------------");
		System.out.print("메뉴 선택 : ");
	}

	@Override
	public void runMenu(int menu) {
		
		switch(menu) {
		case 1:
			insert();
			break;
		case 2:
			update();
			break;
		case 3:
			delete();
			break;
		case 4:
			System.out.println("[프로그램을 종료합니다.]");
			break;
		default:
			System.out.println("[잘못된 메뉴입니다.]");
		}
		
	}
	private Word input() {
		System.out.print("단어 : ");
		String word = scan.nextLine();
		
		System.out.print("품사[명, 대, 동, 형, 부, 전, 접, 관] : ");
		String partsOfSpeech = scan.next();
		scan.nextLine();
		
		System.out.print("의미 : ");
		String meaning = scan.nextLine();
		return new Word(word, partsOfSpeech, meaning);
	}

	private void insert() {
		System.out.println("[추가할 단어 정보를 입력하세요.]");
		Word wordObj = input();
		
		if(wm.insert(wordObj)) {
			System.out.println("[단어를 등록했습니다.]");
		}else {
			System.out.println("[단어를 등록하지 못했습니다.]");
		}
		
	}

	private void update() {
		//수정할 단어를 입력
		System.out.print("단어 : ");
		String word = scan.nextLine();
		
		//수정할 단어를 검색해서 출력
		//word와 일치하는 단어들의 리스트를 반환
		List<Word> tmpList = wm.getWordList(word);
		
		
		//단어 리스트를 출력
		wm.print(tmpList);

		if(tmpList.isEmpty()) {
			return;
		}
		
		//수정할 단어를 선택
		int index = scan.nextInt() - 1;
		scan.nextLine();
		
		if(index < 0 || index >= tmpList.size()) {
			System.out.println("[잘못 선택했습니다.]");
			return;
		}
		
		//수정할 단어, 품사, 뜻을 입력
		Word wordObj = input();
		
		//수정
		if(wm.update(tmpList.get(index), wordObj)) {
			System.out.println("[단어를 수정했습니다.]");
		}else {
			System.out.println("[단어를 수정하지 못했습니다.]");
		}
		
	}

	private void delete() {
		//삭제할 단어를 입력
		System.out.print("단어 : ");
		String word = scan.nextLine();
		
		//삭제할 단어를 검색해서 출력
		//word와 일치하는 단어들의 리스트를 반환
		List<Word> tmpList = wm.getWordList(word);
		
		
		//단어 리스트를 출력
		wm.print(tmpList);

		if(tmpList.isEmpty()) {
			return;
		}
		
		//삭제할 단어를 선택
		int index = scan.nextInt() - 1;
		scan.nextLine();
		
		if(index < 0 || index >= tmpList.size()) {
			System.out.println("[잘못 선택했습니다.]");
			return;
		}
		
		//삭제
		if(wm.delete(tmpList.get(index))) {
			System.out.println("[단어를 삭제했습니다.]");
		}else {
			System.out.println("[단어를 삭제하지 못했습니다.]");
		}
		
	}

}
