package db.ex1.service;

import java.util.List;

import db.ex1.model.vo.ScoreVO;

public interface ScoreService {

	List<ScoreVO> getScoreList();

	List<ScoreVO> getScoreList(int st_key);

}
