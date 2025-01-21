package day15.socket2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Ex03_Client {

	//쓰레드를 이용하여 문자열을 서버에 보내고, 서버에서 문자열을 받아 출력하는 예제
	public static void main(String[] args) {
		int port = 5001;
		String ip = "127.0.0.1";
		
		try{
			//소켓 생성
			Socket socket = new Socket(ip, port);
			System.out.println("[연결 성공!]");
			
			//쓰레드 생성 : 콘솔에서 문자열을 입력받아 전송하는 쓰레드
			Thread t1 = new Thread(()->{
				Scanner scan = new Scanner(System.in);
				
				try {
					ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

					while(true) {
						System.out.print("입력(종료 : EXIT) : ");
						String str = scan.nextLine();
						oos.writeUTF(str);
						oos.flush();
						if(str.equals("EXIT")) {
							break;
						}
					}
					System.out.println("[전송 기능을 종료합니다.]");
				}catch(Exception e) {
					e.printStackTrace();
				}
			});
			
			//쓰레드 생성 : 통신을 통해 문자열을 받아서 콘솔에 출력하는 쓰레드
			Thread t2 = new Thread(()->{
				
				try {
					ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
					while(true) {
						String str = ois.readUTF();
						System.out.println("수신 : " + str);
						if(str.equals("EXIT")) {
							break;
						}
					}
					System.out.println("[수신 기능을 종료합니다.]");
				} catch (Exception e) {
				
					e.printStackTrace();
				}
				
			});
			
			//각 쓰레드를 실행
			t1.start();
			t2.start();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
