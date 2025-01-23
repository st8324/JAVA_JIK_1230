package day17;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Ex01_Client {

	private static Scanner scan = new Scanner(System.in);
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		/* 숫자 야구 게임을 구현하세요.
		 * 단, 기록은 서버에 통신을 이용하여 저장
		 * 기록은 영문 3자와 횟수를 기록
		 * JIK 3
		 * 기록이 같은 경우 먼저 등록된 순으로 순위를 출력
		 * 기록은 상위 5명만 출력
		 * 서버
		 * - 플레이 기록 추가
		 * 	- 클라이언트가 보낸 이니셜과 기록을 저장해서 정렬(기록순, 등록순)
		 * - 플레이 기록 전송
		 * 	- 등록된 0번지부터 4번지까지의 기록을 전송
		 * 클라이언트
		 * - 프로그램 구현
		 * 	- 플레이
		 * 	 - 플레이 종료 후 이니셜과 기록을 서버에 전송
		 *  - 기록 조회
		 *   - 서버에게 상위 5개의 기록을 받아 조회
		 *  - 종료
		 * */
		
		//서버와 연결
		String ip = "192.168.40.3";
		int port = 5002;
		Socket socket;
		ObjectOutputStream oos;
		ObjectInputStream ois;
		try {
			socket = new Socket(ip, port);
			System.out.println("[연결 성공!]");
			//IO스트림 생성
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			
		}catch (Exception e) {
			System.out.println("[서버 연결 실패!]");
			System.out.println("프로그램을 종료합니다.");
			return;
		}
		
		
		int menu;
		do {
			printMenu();
			
			menu = scan.nextInt();
			//생성한 IO스트림을 넘겨줌
			runMenu(menu, ois, oos);
			
		}while(menu != 3);
	}
	
	private static void printMenu() {
		
		
	}

	private static void runMenu(int menu, ObjectInputStream ois, ObjectOutputStream oos) {
		switch(menu) {
		case 1:
			//IO스트림을 넘겨줌
			play(ois, oos);
			break;
		case 2:
			//IO스트림을 넘겨줌
			recordView(ois, oos);
			break;
		case 3:
			System.out.println("프로그램 종료");
			break;
		default:
			System.out.println("올바른 메뉴가 아닙니다.");
		}
		
	}

	private static void play(ObjectInputStream ois, ObjectOutputStream oos) {

		//랜덤 리스트 생성
		List<Integer> nums = randomList(1, 9, 3);
		
		Record r = playGame(nums);
		
		//서버에 전송
		sendRecord(r, ois, oos);
	}

	private static void sendRecord(Record r, ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			//메뉴를 전송
			oos.writeInt(1);
			
			//기록을 전송
			oos.writeObject(r);
			oos.flush();
			//서버에게 결과를 확인받고 실패한 경우 알림
			boolean res = ois.readBoolean();
			if(!res) {
				System.out.println("결과가 기록되지 않았습니다.");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static List<Integer> randomList(int min, int max, int size) {
		List<Integer> list = new ArrayList<Integer>();
		Set<Integer> set = new HashSet<Integer>();
		
		while(set.size() < size) {
			set.add(random(min, max));
		}
		
		list.addAll(set);
		Collections.shuffle(list);
		System.out.println(list);
		return list;
	}

	private static void recordView(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			//메뉴를 서버에 전송
			oos.writeInt(2);
			oos.flush();
			
			//전송받은 기록 리스트를 받아옴
			List<Record> list = (List<Record>) ois.readObject();
			
			//받아온 기록 리스트를 출력
			printRecords(list);
		}catch(Exception e) {
			
		}
	}

	private static void printRecords(List<Record> list) {
		if(list == null || list.isEmpty()) {
			System.out.println("등록된 기록이 없습니다.");
			System.out.println("지금 플레이하면 1등");
			return;
		}
		
		for(int i = 0 ; i<list.size(); i++) {
			System.out.println(i+1 + ". " + list.get(i));
		}
	}

	public static Record playGame(List<Integer> nums) {
		int strike, ball;
		List<Integer> user = new ArrayList<Integer>();
		int count = 0;
		do {
			user.clear();
			System.out.print("입력 : ");
			
			//사용자가 중복되지 않게 입력했다고 가정
			while(user.size() < 3) {
				user.add(scan.nextInt());
			}
			++count;
			
			strike = getStrike(nums, user);
			
			ball = getBall(nums, user);
			
			printResult(strike, ball);
			
		}while(strike < 3);
		
		//닉네임 입력
		System.out.print("이니셜 입력(최대 3자) : ");
		String nickName = scan.next();
		
		return new Record(count, nickName);
	}
	
	private static int getStrike(List<Integer> nums, List<Integer> user) {
		int count = 0;
		for(int i = 0; i<nums.size(); i++) {
			if(nums.get(i) == user.get(i)) {
				count++;
			}
		}
		return count;
	}

	private static int getBall(List<Integer> nums, List<Integer> user) {
		int count = 0;
		/*
		//이중 반복문을 이용하여 ball의 개수를 확인
		for(int i = 0; i< nums.size(); i++) {
			for(int j = 0; j<user.size(); j++) {
				if(i != j && nums.get(i) == user.get(j)) {
					count++;
				}
			}
		}
		*/
		for(int num : nums) {
			if(user.contains(num)) {
				count++;
			}
		}
		return count - getStrike(nums, user);
	}

	private static void printResult(int strike, int ball) {
		
		if(strike != 0) {
			System.out.print(strike + "S");
		}
		
		if(ball != 0) {
			System.out.print(ball + "B");
		}
		
		if(strike == 0 && ball == 0) {
			System.out.print("O");
		}
		System.out.println();
		
	}

	private static int random(int min, int max) {
		if(max < min) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		return (int)(Math.random() * (max - min + 1) + min);
	}

}
