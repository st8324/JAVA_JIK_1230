package db.ex1.model.vo;

import lombok.Data;

@Data
public class ScoreVO {
	
	private SubjectVO subject;
	private int sc_num;
	private int sc_score;
	private int sc_st_key;
	private int sc_sj_num;
	
}
