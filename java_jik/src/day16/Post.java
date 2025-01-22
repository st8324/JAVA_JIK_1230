package day16;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class Post implements Serializable {
	
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
