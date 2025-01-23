package day17;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex01_Server2 {

	static List<Record> list = new ArrayList<Record>();
	
	public static void main(String[] args) {
		int port = 5002;

		try {
			ServerSocket serverSocket 
				= new ServerSocket(port);

			while(true) {
				Socket socket = serverSocket.accept();
				Server server = new Server(socket, list);
				server.run();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

	

}
