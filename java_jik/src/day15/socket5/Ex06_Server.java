package day15.socket5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Ex06_Server {

	
	
	public static void main(String[] args) {

		/* 학생 관리하는 프로그램을 구현하고. 프로그램에서 관리하는 정보를 서버에 기록하는 예제
		 * */

		String fileName = "src/day15/socket5/data.txt";
		List<Student> list = (List<Student>) load(fileName);
		if(list == null) {
			list = new ArrayList<Student>();
		}
		
		int port = 5001;
		
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			
			while(true) {
				save(fileName, list);
				Socket socket = serverSocket.accept();
				System.out.println("[연결 성공]");
				
				Server server = new Server(list, socket);
				server.run();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			save(fileName, list);
		}
		
	}

	private static void save(String fileName, Object obj) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			
			oos.writeObject(obj);
			
		} catch (Exception e) {
			System.out.println("-----------------");
			System.out.println("저장하기 실패");
			System.out.println("-----------------");
		}
		
	}
	private static Object load(String fileName) {
		try(FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)){
			
			return ois.readObject();
			
		} catch (Exception e) {
			System.out.println("-----------------");
			System.out.println("불러오기 실패");
			System.out.println("-----------------");
		}
		return null;
	}

}
