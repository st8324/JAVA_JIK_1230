package day18;

import java.net.Socket;

public class Ex01_Client {

	public static void main(String[] args) {

		/* 은행 계좌 관리 프로그램
		 * - 접속
		 * 	- 은행. 이름. 계좌번호. 비밀번호
		 * - 계좌 개설
		 * 	- 은행. 이름. 계좌번호. 비밀번호. 비밀번호 확인
		 * - 종료
		 * 
		 * 	- 예금 조회
		 * 	- 입금
		 * 	- 출금
		 * 	- 이전
		 * 
		 * 주의사항
		 * 	- 한 계좌에 여러명이 동시에 접근하는 경우 먼저 접근한 사람이 사용하도록 처리
		 * */
		
		//서버와 소켓으로 연결 : 실패 시 프로그램 종료
		
		String ip = "127.0.0.1";
		int port = 5003;
		
		try(Socket socket = new Socket(ip, port)) {
			System.out.println("[서버와 연결되었습니다.]");
			//프로그램 구현
			ClientProgram program = new ClientProgram(socket);
			program.run();
		}catch (Exception e) {
			System.out.println("[서버와 연결되지 않아 프로그램을 종료합니다.]");
			e.printStackTrace();
		}
		
	}

}
