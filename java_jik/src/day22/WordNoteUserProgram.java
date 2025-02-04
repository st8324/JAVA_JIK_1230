package day22;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WordNoteUserProgram implements ConsoleProgram {

	private Scanner scan;
	private WordManager wm;
	private MyWordManager mm;
	private String id;
	
	public WordNoteUserProgram(Scanner scan, List<Word> words, Map<String, List<String>> myWords, String id) {
		this.scan = scan;
		this.wm = new WordManager(words);
		this.mm = new MyWordManager(myWords);
		this.id = id;
	}

	@Override
	public void run() {
		int menu;
		final int EXIT = 3;
		
		do {
		
			printMenu();
			
			menu = scan.nextInt();
			scan.nextLine();
			
			runMenu(menu);
			
		}while(menu != EXIT);
		
	}

	@Override
	public void printMenu() {
		System.out.println("----------------");
		System.out.println("1. 단어 검색");
		System.out.println("2. 내 검색 단어 보기");
		System.out.println("3. 종료");
		System.out.println("----------------");
		System.out.print("메뉴 선택 : ");
		
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			search();
			break;
		case 2:
			printMyWords();
			break;
		case 3:
			System.out.println("[프로그램을 종료합니다.]");
			break;
		default:
			System.out.println("[잘못된 메뉴입니다.]");
		}
		
	}

	private void search() {

		System.out.print("단어 : ");
		String word = scan.nextLine();
		
		wm.print(word);
		
		mm.add(id, word);
		
	}

	private void printMyWords() {
		mm.print(id);
	}

}
