package day21;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex01_Client {

	/* 1대1 채팅 프로그램을 구현하세요.
	 * - 채팅 기록을 관리하는 기능을 추가 
	 * 
	 * 메뉴
	 * - 접속
	 *  - 사용자 아이디를 입력
	 * 	- EXIT를 채팅으로 보내면 채팅을 종료 하도록 작성
	 * - 채팅 기록 확인
	 * - 종료
	 * 
	 * USER : 안녕하세요.
	 * ADMIN : 안녕하세요.
	 * */
	private static Scanner scan = new Scanner(System.in);
	private static List<Chat> list = new ArrayList<Chat>(); //채팅 내역
	
	public static void main(String[] args) {

		
		
		int menu;
		do {
			printMenu();
			
			menu = scan.nextInt();
			scan.nextLine();
			
			runMenu(menu);
			
		}while(menu != 3);
		
	}

	private static void printMenu() {
		System.out.println("1. 접속");
		System.out.println("2. 채팅 기록 확인");
		System.out.println("3. 종료");
		System.out.print("메뉴 선택 : ");
		
	}

	private static void runMenu(int menu) {
		switch(menu) {
		case 1:
			connect();
			break;
		case 2:
			log();
			break;
		case 3:
			System.out.println("[프로그램을 종료합니다.]");
			break;
		default:
			System.out.println("[잘못된 메뉴입니다.]");
		}
	}

	private static void connect() {
		String ip = "127.0.0.1";
		int port = 3001;
		
		//아이디 입력
		System.out.print("아이디 : ");
		String id = scan.next();
		//소켓 객체 생성(ip와 port 이용)
		try(Socket socket = new Socket(ip, port);) {

			//ChatClient 객체 생성
			ChatClient cc = new ChatClient(id, socket, list);
			//객체를 실행해서 채팅
			cc.run();
			
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}

	private static void log() {
		//기록된 채팅 리스트를 출력
		if(list.isEmpty()) {
			System.out.println("채팅 기록이 없습니다.");
			return;
		}
		for(Chat chat : list) {
			System.out.println(chat);
		}
	}

}


