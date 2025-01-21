package day15.socket1;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Ex02_Server {

	//클라이언트와 연결하고, 연결된 클라이언트에서 문자열을 받아 출력하고, 클라이언트에 문자열을 보내는 예제
	public static void main(String[] args) {
		
		//서버 포트를 지정
		int port = 5001;
		
		Scanner scan = new Scanner(System.in);
		
		//서버용 객체를 생성
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			System.out.println("[연결 대기 중]");
			//클라이언트가 접속 요청을 할 때까지 대기
			//요청이 오면 수락 후 클라이언트 소켓 객체를 생성
			Socket socket = serverSocket.accept();
			
			System.out.println("[연결 완료]");
			
			//작업(IO 스트림을 이용하여)
			//클라이언트가 보낸 데이터를 받아서 콘솔에 출력
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
				
			String str = ois.readUTF();
			System.out.println("받은 문자열 : " + str);
			
			System.out.print("보낼 문자열 : ");
			String sendStr = scan.nextLine();
			
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeUTF(sendStr);
			oos.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
