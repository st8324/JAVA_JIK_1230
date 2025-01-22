package day16;

import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.naming.directory.SearchControls;

public class Ex01_Client {

	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		/* day14/Ex01_Post 예제를 활용하여 게시글 관리 프로그램을 작성하세요.
		 * 단, 네트워크 통신을 이용하여 서버와 클라이언트로 동작하는 프로그램을 작성하세요.
		 * */
		String ip = "127.0.0.1";
		int port = 5001;
		Socket socket = null;
		
		try {
			socket = new Socket(ip, port);
			System.out.println("연결 성공");
			
		}catch (Exception e) {
			System.out.println("서버와 연결이 되지 않아 프로그램을 종료합니다.");
			return;
		}
		
		int menu = 0;
		do {
			printMenu();
			
			menu = scan.nextInt();
			scan.nextLine();
				
			runMenu(menu, socket);
			
		}while(menu != 5);
	}
	
	private static void runMenu(int menu, Socket socket) {

		switch(menu) {
		case 1:
			insert(socket);
			break;
		case 2:
			update(socket);
			break;
		case 3:
			delete(socket);
			break;
		case 4:
			search(socket);
			break;
		case 5:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			
		}
		
	}

	private static void insert(Socket socket) {
		
	}

	private static void update(Socket socket) {
		
	}

	private static void delete(Socket socket) {
		
	}

	private static void search(Socket socket) {
		
	}

	private static void printMenu() {
		System.out.println("--------------------");
		System.out.println("1. 게시글 등록");
		System.out.println("2. 게시글 수정");
		System.out.println("3. 게시글 삭제");
		System.out.println("4. 게시글 조회");
		System.out.println("5. 종료");
		System.out.println("--------------------");
		System.out.print("메뉴 선택 : ");
	}
}

