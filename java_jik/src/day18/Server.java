package day18;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class Server {

	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private List<Account> list;
	
	public Server(Socket socket, List<Account> list) {
		this.socket = socket;
		this.list = list;
		if(socket == null) {
			return;
		}
		try {
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
		}catch (Exception e) {
			//e.printStackTrace();
		}
		
	}

	public void run() {
		if(socket == null || oos == null || ois == null || list == null) {
			return;
		}
		Thread t = new Thread(()->{
			int menu;
			try {
				do {
					//메뉴를 수신
					menu = ois.readInt();
					//메뉴에 따라 기능을 실행
					runMenu(menu);
				}while(menu != 5);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		t.start();
	}

	private void runMenu(int menu) {
		switch(menu) {
		case 0://계좌 개설
			open();
			break;
		case 1://접속
			login();
			break;
		case 2://입금
			deposit();
			break;
		case 3://출금
			withdrawal();
			break;
		case 4://조회
			check();
			break;
		default:
		}
	}

	private void login() {
		try {
			//클라이언트가 보낸 계좌 정보를 가져옴
			Account account = (Account)ois.readObject();
			int index = list.indexOf(account);
			Account sendAccount = null;
			
			if(index >= 0) {
				sendAccount = (Account)list.get(index).clone();
			}
			
			oos.writeObject(sendAccount);
			oos.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void open() {
		try {
			//계좌정보를 클라리언트에게 받아옴
			Account account = (Account) ois.readObject();
			
			boolean res = false;
			//있는지 확인해서 없으면 추가
			if(!list.contains(account)) {
				list.add(account);
				res = true;
			}
			//추가 여부를 클라이언트에게 전송
			oos.writeBoolean(res);
			oos.flush();
			
			System.out.println("[계좌 등록]");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void deposit() {
		try {
			//계좌 정보와 예금을 클라이언트에게 전달 받음
			long money = ois.readLong();
			Account account = (Account)ois.readObject();
			
			long res = -1;
			
			int index = list.indexOf(account);
			//예금 정보도 올바른지 확인, //계좌 정보가 있는지 확인
			if(money <= 0 || index < 0) {
				//클라이언트에게 결과를 전송
				oos.writeLong(res);
				oos.flush();
				return;
			}
			//계좌에 예금을 추가하여, 입출금 내역이 추가되도록 함.
			
			Account tmp = list.get(index);
			synchronized (tmp) {
				res = tmp.deposit(money) ? tmp.getMoney() : -1;
				
				//클라이언트에게 결과를 전송
				oos.writeLong(res);
				oos.flush();
				Thread.sleep(500);
			}
			
		}catch (Exception e) {
			System.out.println("[입금 하는 중에 예외가 발생했습니다.]");
			e.printStackTrace();
		}
	}

	private void withdrawal() {
		// TODO Auto-generated method stub
		
	}

	private void check() {
		// TODO Auto-generated method stub
		
	}

}
