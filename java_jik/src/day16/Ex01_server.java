package day16;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex01_server {

	public static void main(String[] args) {
		
		int port = 5001;
		
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			
			//서버가 대기하다 연결 요청이 오면 Socket 객체를 생성
			//1. 서버 대기, 2. 연결 요청 수락, 3. Socket 객체 생성
			Socket socket = serverSocket.accept();
			System.out.println("[연결 완료]");
			
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			
			while(true) {
				//메뉴를 입력 받음
				int menu = ois.readInt();
				//입력받은 메뉴에 맞는 기능을 실행
				runMenu(menu, oos, ois);
				
			}
	
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void runMenu(int menu, ObjectOutputStream oos, ObjectInputStream ois) {
		switch(menu) {
		case 1:
			insert(oos, ois);
			break;
		case 2:
			update(oos, ois);
			break;
		case 3:
			delete(oos, ois);
			break;
		case 4:
			search(oos, ois);
			break;
		default:
			System.out.println("[잘못된 메뉴를 클라이언트가 전송했습니다.]");
		}
		
	}
	private static void insert(ObjectOutputStream oos, ObjectInputStream ois) {
		
	}

	private static void update(ObjectOutputStream oos, ObjectInputStream ois) {
		
	}

	private static void delete(ObjectOutputStream oos, ObjectInputStream ois) {
		
	}

	private static void search(ObjectOutputStream oos, ObjectInputStream ois) {
		
	}

}
