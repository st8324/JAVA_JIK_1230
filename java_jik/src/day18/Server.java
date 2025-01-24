package day18;

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
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
		}catch (Exception e) {
			//e.printStackTrace();
		}
		
	}

	public void run() {
		if(socket == null || oos == null || ois == null || list == null) {
			return;
		}
		//메뉴를 수신
		int menu = 0;
		//메뉴에 따라 기능을 실행
		runMenu(menu);
	}

	private void runMenu(int menu) {
		switch(menu) {
		case 0://계좌 개설
			open();
			break;
		case 1://입금
			deposit();
			break;
		case 2://출금
			withdrawal();
			break;
		case 3://조회
			check();
			break;
		default:
		}
	}

	private void open() {
		// TODO Auto-generated method stub
		
	}

	private void deposit() {
		// TODO Auto-generated method stub
		
	}

	private void withdrawal() {
		// TODO Auto-generated method stub
		
	}

	private void check() {
		// TODO Auto-generated method stub
		
	}

}
