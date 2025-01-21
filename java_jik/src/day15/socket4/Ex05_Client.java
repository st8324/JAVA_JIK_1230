package day15.socket4;

import java.net.Socket;
import java.util.Scanner;

public class Ex05_Client {

	public static void main(String[] args) {
		int port = 5001;
		String ip = "192.168.40.3";
		Scanner scan = new Scanner(System.in);
		try{
			//소켓 생성
			Socket socket = new Socket(ip, port);
			System.out.println("[연결 성공!]");
			
			System.out.print("아이디 : ");
			String id = scan.nextLine();
			Client c = new Client(id, socket);
			c.receive();
			c.send();
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
