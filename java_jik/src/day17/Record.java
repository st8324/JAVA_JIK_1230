package day17;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Record implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int count;
	private String nickName;
	private Date date;
	
	public Record(int count, String nickName) {
		this.count = count;

		if(nickName == null) {
			nickName = "";
		}
		
		//닉네임 3자이상이면 3자만 추출
		if(nickName.length() > 3) {
			this.nickName = nickName.substring(0, 3);
			return;
		}
		
		//nickName이 3자 미만으면 남은자리를 ?으로 채움
		int repeatCount = 3 - nickName.length();
		this.nickName = nickName + "?".repeat(repeatCount);
		this.date = new Date();
	}

	@Override
	public String toString() {
		return nickName + " : " + count + "회";
	}
	
	
}
