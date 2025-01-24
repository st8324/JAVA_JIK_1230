package day18;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Item implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private Date date;//입출금 날짜
	private Type type; //입금 또는 출금
	private int money; //금액
	
}
