package day21;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Chat implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String chat;
	private Date date;

}
