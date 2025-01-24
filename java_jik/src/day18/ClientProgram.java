package day18;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientProgram {

	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private Scanner scan;
	
	public ClientProgram(Socket socket) {
		this.socket = socket;
		this.scan = new Scanner(System.in);
		
		if(socket == null) {
			return;
		}
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
		}catch (Exception e) {
			//e.printStackTrace();
		}
	}

	public void run() {
		
		if(socket == null || ois == null || oos == null) {
			System.out.println("[서버 연결에 실패했습니다.]");
			return;
		}
		
		int menu;
		do {
			printMenu();
			
			menu = scan.nextInt();
			
			runMenu(menu);
			
		}while(menu != 3);
	}

	private void printMenu() {

		
	}

	private void runMenu(int menu) {

		switch(menu) {
		case 1:
			login();
			break;
		case 2:
			open();
			break;
		case 3:
			break;
		default:
		}
		
	}

	private void login() {
		
		Account account = inputAccount();
		System.out.println("[접속 중]");
		System.out.println("[같은 계정으로 다른 사용자가 먼저 사용중이면 대기할 수 있습니다.]");
		//서버와 통신해서 account가 일치하는지 확인 => 서버에게 account왈 이치하는 계좌 정보를 달라고 요청
		
		//일치하지 않으면 안내문구 후 종료
		
		System.out.println("[계좌에 접속했습니다.]");
		int menu;
		do {
			printLoginMenu();
			
			menu = scan.nextInt();
			
			runLoginMenu(menu, account);
			
		}while(menu != 4);
		
	}

	private Account inputAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	private void printLoginMenu() {
		// TODO Auto-generated method stub
		
	}

	private void runLoginMenu(int menu, Account account) {
		switch(menu) {
		case 1:
			deposit(account);
			break;
		case 2:
			withdrawal(account);
			break;
		case 3:
			check(account);
			break;
		case 4:
			break;
		default:
		}
		
	}

	private void deposit(Account account) {
		// TODO Auto-generated method stub
		
	}

	private void withdrawal(Account account) {
		// TODO Auto-generated method stub
		
	}

	private void check(Account account) {
		// TODO Auto-generated method stub
		
	}

	private void open() {
		
		
	}

}
