package day21;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class Chat implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String chat;
	private Date date;
	
	public String getDateStr() {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return f.format(date);
	}
	
	@Override
	public String toString() {
		return id + " : " + chat + " (" + getDateStr() + ")";
	}

	public Chat(String id, String chat) {
		this.id = id;
		this.chat = chat;
		this.date = new Date();
	}
	
	
}








