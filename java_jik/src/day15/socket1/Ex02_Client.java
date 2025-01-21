package day15.socket1;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Ex02_Client {

	//서버와 연결 후 서버에서 문자열을 보내고, 서버에서 받은 문자열을 출력하는 예제
	public static void main(String[] args) {

		//서버 IP와 서버 포트를 지정
		String ip = "127.0.0.1"; //localhost
		int port = 5001;
		Scanner scan = new Scanner(System.in);
		
		//소켓을 생성하고 연결을 요청
		try (Socket socket = new Socket(ip, port)) {
			System.out.println("[연결 완료]");
			//IO 스트림을 열여서 작업
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			System.out.print("보낼 문자열 입력 : ");
			String str = scan.nextLine();
			oos.writeUTF(str);
			oos.flush();
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
				
			String receiveStr = ois.readUTF();
			System.out.println("받은 문자열 : " + receiveStr);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		

	}

}
