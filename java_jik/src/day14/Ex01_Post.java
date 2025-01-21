package day14;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import lombok.Data;

public class Ex01_Post {

	static Scanner scan = new Scanner(System.in);
	static List<Post> list = new ArrayList<Post>();
	
	public static void main(String[] args) {
		/* 게시글 프로그램을 위한 클래스를 선언하세요.
		 * 게시글 등록
		 *  - 제목, 내용, 작성자를 입력
		 * 게시글 수정
		 * 	- 게시글 번호를 선택
		 * 	- 제목, 내용을 수정
		 * 게시글 삭제
		 * 	- 게시글 번호를 선택해서 삭제
		 * 게시글 조회
		 * 	- 게시글 번호를 이용하여 조회하고 조회수 1 증가
		 * */
		int menu;
		
		String fileName = "src/day14/post.txt";
		
		list = (ArrayList<Post>)load(fileName);
		
		if(list == null || list.size() == 0) {
			list = new ArrayList<Post>();
		}
		else {
			int lastIndex = list.size()-1;
			Post lastPost = list.get(lastIndex);
			int lastNum = lastPost.getNum();
			Post.setCount(lastNum + 1);
		}
		
		do {
			
			printMenu();
			
			menu = scan.nextInt();
			scan.nextLine();
			System.out.println("--------------------");
			
			runMenu(menu);
			
		}while(menu != 5);
		save(fileName, list);
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

	private static void printMenu() {
		System.out.println("--------------------");
		System.out.println("1. 게시글 등록");
		System.out.println("2. 게시글 수정");
		System.out.println("3. 게시글 삭제");
		System.out.println("4. 게시글 조회");
		System.out.println("5. 종료");
		System.out.println("--------------------");
		System.out.print("메뉴 선택 : ");
	}

	private static void runMenu(int menu) {
		
		switch(menu) {
		case 1:
			insert();
			break;
		case 2:
			update();
			break;
		case 3:
			delete();
			break;
		case 4:
			view();
			break;
		case 5:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("올바른 메뉴를 선택하세요.");
		}
		
	}

	private static void insert() {
		
		//제목, 내용, 작성자를 입력
		System.out.print("제목 : ");
		String title = scan.nextLine();
		System.out.print("내용 : ");
		String content = scan.nextLine();
		System.out.print("작성자 : ");
		String writer = scan.nextLine();
		
		//입력받은 내용으로 객체를 생성
		Post post = new Post(title, content, writer);
		
		//목록에 추가
		list.add(post);
		System.out.println(list);
	}

	private static void update() {
		
		//번호를 입력
		System.out.print("번호 : ");
		int num = scan.nextInt();
		scan.nextLine();
		
		//번호와 일치하는 게시글이 있는지 확인해서 없으면 알림 후 종료
		//Objects.equals(o1, o2) => o1과 o2가 다른 클래스이면 무조건 false
		int index = list.indexOf(new Post(num)); 
		
		if(index < 0) {
			System.out.println("등록되지 않거나 삭제된 게시글입니다.");
			return;
		}
		
		//제목, 내용을 입력
		System.out.print("제목 : ");
		String title = scan.nextLine();
		System.out.print("내용 : ");
		String content = scan.nextLine();
		
		//목록에서 번호와 일치하는 게시글을 가져옴
		Post post = list.get(index);
		//가져온 게시글의 제목과 내용을 수정
		post.setTitle(title);
		post.setContent(content);
	}

	private static void delete() {
		//번호를 입력
		System.out.print("번호 : ");
		int num = scan.nextInt();
		scan.nextLine();
		
		if(list.remove(new Post(num))) {
			System.out.println("게시글을 삭제 했습니다.");
			return;
		}
		System.out.println("등록되지 않거나 삭제된 게시글입니다.");
		
	}

	private static void view() {
		//번호를 입력
		System.out.print("번호 : ");
		int num = scan.nextInt();
		scan.nextLine();
		
		//번호와 일치하는 게시글이 있는지 확인해서 없으면 알림 후 종료
		//Objects.equals(o1, o2) => o1과 o2가 다른 클래스이면 무조건 false
		int index = list.indexOf(new Post(num)); 
		
		if(index < 0) {
			System.out.println("등록되지 않거나 삭제된 게시글입니다.");
			return;
		}
		//해당 게시글이 있으면 조회수 증가 후 출력
		Post post = list.get(index);
		post.view();
		//post.setView(post.getView()+1);
		post.print();
		
	}

}

@Data
class Post implements Serializable{
	
	private static final long serialVersionUID = 7950467669298764591L;
	
	private static int count;
	private int num;
	private String title, content, writer;
	private Date date;
	private int view;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) 
			return false;
		Post other = (Post) obj;
		return num == other.num;
	}

	public void view() {
		view++;
	}

	public Post(String title, String content, String writer) {
		num = ++count;
		this.title = title;
		this.content = content;
		this.writer = writer;
		date = new Date();
	}
	
	public Post(int num) {
		this.num = num;
	}

	public void print() {
		System.out.println("------------------------");
		System.out.println("번호 : " + num);
		System.out.println("제목 : " + title);
		System.out.println("내용 : " + content);
		System.out.println("작성자 : " + writer);
		System.out.println("작성일 : " + getDateStr() );
		System.out.println("조회수 : " + view);
		System.out.println("------------------------");
	}

	private String getDateStr() {
		//Date -> String
		//yyyy-MM-dd HH:mm:ss
		SimpleDateFormat format = 
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	}
	
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Post.count = count;
	}
}






