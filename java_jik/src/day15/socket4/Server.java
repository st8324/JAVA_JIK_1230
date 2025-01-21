package day15.socket4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Server {

	//클라이언트들에게 메세지를 보내기 위한 리스트
	private List<ObjectOutputStream> list = new ArrayList<ObjectOutputStream>();
	
	private Socket socket;
	
	private final static String EXIT = "EXIT";
	
	//클라이언트 중 한명이 메세지를 보내면 모든 클라이언트들에게 메세지를 전송
	public void receive() {
		Thread t = new Thread(()->{
			String id = "";
			try {
				//list에 연결된 클라이언트를 추가
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				list.add(oos);
				
				//문한루프로 반복
				while(true) {
					id = ois.readUTF();
					String chat = ois.readUTF();
					
					System.out.println(id + " : " + chat);//확인용
					boolean flag = false;
					synchronized (list) {
						for(ObjectOutputStream client : list) {
							//메세지를 쓴 클라이언트에겐 메세지를 보내지 않음
							if(client != oos && !chat.equals(EXIT)) {
								send(client, id, chat);
							}
							//연결된 클라이언트가 EXIT를 입력했을 때
							else if(client == oos && chat.equals(EXIT)) {
								//클라이언트의 receive()에 있는 쓰레드를 종료하기 위해서
								send(client, id, chat);
								flag = true;
							}
						}
					}
					if(flag) {
						list.remove(oos);
					}
				}
				
			}catch(IOException e) {
				System.out.println(id + "님이 나갔습니다.");
			}catch(Exception e) {
				e.printStackTrace();
			}
		});
		t.start();
	}
	
	private void send(ObjectOutputStream client, String id, String chat) {
		if(client == null || id == null || chat == null) {
			return;
		}
		
		try {
			/* 하나의 클라이언트에 여러 메세지를 동시에 보내려고 하면 순서가 꼬이거나 예상치 못한 문제가 발생할 수 있다
			 * 이 때 동기화를 통해 먼저 들어온 작업부터 실행되도록 해줌 */
			synchronized (client) {
				client.writeUTF(id);
				client.writeUTF(chat);
				client.flush();
			}
			
		}catch(Exception e) {
			list.remove(client);
			e.printStackTrace();
		}
	}

}
