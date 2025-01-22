package day15.socket5;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Server {
	
	private List<Student> list;
	private Socket socket;
	
	public void run() {
		Thread t = new Thread(()->{
			try {
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

				//클라이언트가 메뉴를 보내면 서버는 메뉴를 수신
				int menu;
				do {
					menu = ois.readInt();
					runMenu(menu, ois, oos);
				}while(menu != 5);
				
				
				//수신한 메뉴에 따라 작업이 달라짐
			} catch (IOException e) {
				System.out.println("[클라이언트 연결이 끊어졌습니다.]");
			}
			
		});
		t.start();
	}

	private synchronized void runMenu(int menu, ObjectInputStream ois, ObjectOutputStream oos) {
		switch (menu) {
		case 1:
			insert(ois, oos);
			break;
		case 2:
			update(ois, oos);
			break;
		case 3:
			delete(ois, oos);
			break;
		case 4:
			search(ois, oos);
			break;
		default:
			
		}
	}

	private void insert(ObjectInputStream ois, ObjectOutputStream oos) {

		try {
			//클라이언트가 학생 정보를 보내줌
			Student std = (Student)ois.readObject();

			boolean res = true;
			//중복확인해서 있으면 클라이언트에게 false를 전송
			if(list.contains(std)) {
				res = false;
			}
			//없으면 리스트에 추가
			else {
				list.add(std);
			}
			//추가 여부를 클라이언트에게 전송
			oos.writeBoolean(res);
			oos.flush();
			sort();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void update(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			//학생 기본 정보를 클라이언트에게 받음
			Student std = (Student)ois.readObject();
			//수정할 학생 정보를 클라이언트에게 받음
			Student newStd = (Student)ois.readObject();
			
			boolean res = true;
			//학생이 없으면 false를 저장
			if(!list.contains(std)) {
				res = false;
			}
			//다른 학생으로 수정하려는데 이미 등록됐으면
			//학생과 수정할 학생이 다르고 수정할 학생이 있으면 false를 저장
			else if(!std.equals(newStd) && list.contains(newStd)) {
				res = false;
			}
			//기존 학생 정보를 가져와서 수정
			else {
				list.remove(std);
				list.add(newStd);
				sort();
			}
			//클라이언트에게 결과를 전송
			oos.writeBoolean(res);
			oos.flush();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	private void sort() {
		list.sort((o1,o2)->{
			if(o1.getGrade() != o2.getGrade()) {
				return o1.getGrade() - o2.getGrade();
			}
			if(o1.getClassNum() != o2.getClassNum()) {
				return o1.getClassNum() - o2.getClassNum();
			}
			return o1.getNum() - o2.getNum();
		});
		System.out.println(list);
	}
	
	private void delete(ObjectInputStream ois, ObjectOutputStream oos) {
		
		try {
			//클라이언트에게 학생 정보를 받음
			Student std = (Student)ois.readObject();
			//삭제 결과를 클라이언트에게 전송
			boolean res = list.remove(std);
			oos.writeBoolean(res);
			oos.flush();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void search(ObjectInputStream ois, ObjectOutputStream oos) {
		
		try {
			//클라이언트가 보내준 학생 정보를 받아옴
			Student receiveStd 
				= (Student) ois.readObject();
			//받은 학생 정보를 이용해서 일치하는 학생 정보를 가져옴
			Student std = null;
			int index = list.indexOf(receiveStd);
			if(index >= 0) {
				std = list.get(index);
			}
			
			//일치하는 학생 정보(없을 수도 있음)를 클라이언트에게 전송
			oos.writeObject(std);
			oos.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
