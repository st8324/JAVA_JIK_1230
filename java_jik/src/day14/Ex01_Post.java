package day14;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import lombok.Data;

public class Ex01_Post {

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
		Post p1 = new Post("", "", "");
		p1.print();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Post p2 = new Post("", "", "");
		p2.print();
	}

}

@Data
class Post{
	
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

	public Post(String title, String content, String writer) {
		num = ++count;
		this.title = title;
		this.content = content;
		this.writer = writer;
		date = new Date();
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
	
}






