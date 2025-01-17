package homework.ex2.v3.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class SubjectScore implements Serializable{
	
	private static final long serialVersionUID = 3L;

	private Subject subject;
	private int score;
	
	@Override
	public String toString() {
		return subject + " " + score + "점";
	}
	
	
}
