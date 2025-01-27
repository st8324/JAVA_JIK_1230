package day18;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.InputMismatchException;
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
			e.printStackTrace();
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
			scan.nextLine();
			
			runMenu(menu);
			
		}while(menu != 3);
	}

	private void printMenu() {
		System.out.println("-----------------");
		System.out.println("1. 접속");
		System.out.println("2. 계좌 개설");
		System.out.println("3. 종료");
		System.out.println("-----------------");
		System.out.print("메뉴 선택 : ");
	}

	private void runMenu(int menu) {
		System.out.println("-----------------");
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
		Account account2 = null;
		try {
			//서버와 통신해서 account가 일치하는지 확인 => 서버에게 account와 이치하는 계좌 정보를 달라고 요청
			oos.writeInt(1);
			oos.writeObject(account);
			oos.flush();
			
			account2 = (Account)ois.readObject();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//일치하지 않으면 안내문구 후 종료
		if(account2 == null) {
			System.out.println("[계좌 정보가 잘못 되었습니다.]");
			return;
		}
		
		System.out.println("[계좌에 접속했습니다.]");
		
		int menu = 0;
		do {
			try {
				printLoginMenu();
				
				menu = scan.nextInt();
				scan.nextLine();
				
				runLoginMenu(menu, account2);
			}catch (InputMismatchException e) {
				//숫자가 아닌 메뉴를 입력하면
				System.out.println("[메뉴는 숫자입니다.]");
				scan.nextLine();
			}catch (Exception e) {
				
			}
		}while(menu != 4);
		
	}

	private Account inputAccount() {
		String bankName;
		do {
			Bank.printBanks();
			System.out.print("은행 : ");
			bankName = scan.nextLine();
		}while(!Bank.check(bankName));
		
		System.out.print("이름 : ");
		String name = scan.nextLine();
		System.out.print("계좌번호 : ");
		String num = scan.nextLine();
		System.out.print("비번 : ");
		String pw = scan.nextLine();
		return new Account(Bank.valueOf(bankName), num, name, pw);
	}

	private void printLoginMenu() {
		System.out.println("-----------------");
		System.out.println("1. 예금");
		System.out.println("2. 출금");
		System.out.println("3. 조회");
		System.out.println("4. 이전으로");
		System.out.println("-----------------");
		System.out.print("메뉴 선택 : ");
		
		
	}

	private void runLoginMenu(int menu, Account account) {
		switch(menu) {
		case 1:
			//deposit(account);
			depositAndWithdrawal(Type.입금, account);
			break;
		case 2:
			//withdrawal(account);
			depositAndWithdrawal(Type.출금, account);
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
		//예금액을 입력
		System.out.print("예금액 : ");
		long money = scan.nextLong(); 
		scan.nextLine();
		
		//예금액 예외 처리
		if(money <= 0) {
			System.out.println("[0원보다 큰 금액을 예금하세요.]");
			return;
		}
		//메뉴, 예금액과 계정 정보를 서버에 전송
		try {
			oos.writeInt(2); //메뉴
			oos.writeLong(money); //예금액
			oos.writeObject(account); //계좌 정보
			oos.flush();
			
			//결과를 입력받아 알림
			long res = ois.readLong();
			if( res >= 0) {
				System.out.println("[예금했습니다.]");
				System.out.println("[잔액 : " + res + "]");
			}else {
				System.out.println("[예금에 실패했습니다.]");
			}
		}catch (Exception e) {
			System.out.println("[예금 전송 중 예외 발생]");
			e.printStackTrace();
		}
		
		
	}

	private void withdrawal(Account account) {
		//출금액을 입력
		System.out.print("출금액 : ");
		long money = scan.nextLong(); 
		scan.nextLine();
		
		//출금액 예외 처리
		if(money <= 0) {
			System.out.println("[0원보다 큰 금액을 출금하세요.]");
			return;
		}
		//메뉴, 출금액과 계정 정보를 서버에 전송
		try {
			oos.writeInt(3); //메뉴
			oos.writeLong(money); //예금액
			oos.writeObject(account); //계좌 정보
			oos.flush();
			
			//결과를 입력받아 알림
			long res = ois.readLong();
			if( res >= 0) {
				System.out.println("[출금했습니다.]");
				System.out.println("[잔액 : " + res + "]");
			}else {
				System.out.println("[출금에 실패했습니다.]");
			}
		}catch (Exception e) {
			System.out.println("[출금 전송 중 예외 발생]");
			e.printStackTrace();
		}
		
	}

	private void depositAndWithdrawal(Type type, Account account) {
		//금액을 입력
		System.out.print(type + "액 : ");
		long money = scan.nextLong(); 
		scan.nextLine();
		
		//금액 예외 처리
		if(money <= 0) {
			System.out.println("[0원보다 큰 금액을 " + type + "하세요.]");
			return;
		}
		//메뉴, 출금액과 계정 정보를 서버에 전송
		try {
			int menu = Type.입금 == type ? 2 : 3;
			oos.writeInt(menu); //메뉴
			oos.writeLong(money); //예금액
			oos.writeObject(account); //계좌 정보
			oos.flush();
			
			//결과를 입력받아 알림
			long res = ois.readLong();
			if( res >= 0) {
				System.out.println("["+ type + "했습니다.]");
				System.out.println("[잔액 : " + res + "]");
			}else {
				System.out.println("["+ type + "에 실패했습니다.]");
			}
		}catch (Exception e) {
			System.out.println("["+ type + " 전송 중 예외 발생]");
			e.printStackTrace();
		}
	}
	
	private void check(Account account) {
		try {
			//메뉴, 계좌 정보를 서버에 전송
			int menu = 4;
			oos.writeInt(menu);
			oos.writeObject(account);
			oos.flush();
			
			//계좌 정보를 받아옴
			Account receiveAccount = (Account)ois.readObject();
			
			if(receiveAccount == null) {
				//말이 안되는 상황
				System.out.println("[계좌 정보가 없습니다.]");
			}else {
				//계좌 정보를 출력
				receiveAccount.print();
			}
		
		}catch (Exception e) {
			System.out.println("[조회 중 예외가 발생했습니다.]");
		}
	}

	private void open() {
		
		Account account = inputAccount();
		
		System.out.print("비번확인 : ");
		String pw2 = scan.nextLine();
		
		if(!account.getPw().equals(pw2)) {
			System.out.println("[비번과 비번확인이 일치하지 않습니다.]");
			return;
		}
		
		
		try {
			//서버에 메뉴를 전송
			oos.writeInt(0);
			
			//서버에게 계좌 정보를 전송
			oos.writeObject(account);
			oos.flush();
			
			//서버에게 결과를 받아 알림을 출력
			if(ois.readBoolean()) {
				System.out.println("[계좌를 등록했습니다.]");
			}else {
				System.out.println("[계좌 등록에 실패했습니다.]");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
