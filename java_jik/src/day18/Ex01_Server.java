package day18;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Ex01_Server {

	public static void main(String[] args) {

		int port = 5003; 
		ServerSocket serverSocket;
		
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			System.out.println("[예외가 발생하여 서버가 종료됩니다.]");
			e.printStackTrace();
			return;
		}
		
		List<Account> list = new ArrayList<Account>();
		while(true) {
			//클라이언트와 연결
			Socket socket;
			try {
				socket = serverSocket.accept();
				System.out.println("[클라이언트와 연결되었습니다.]");
			} catch (IOException e) {
				System.out.println("[예외가 발생하여 클라이언트와 연결을 종료합니다.]");
				e.printStackTrace();
				continue;
			}
			
			//서버를 실행
			Server server = new Server(socket, list);
			server.run();
		}
	}

}
