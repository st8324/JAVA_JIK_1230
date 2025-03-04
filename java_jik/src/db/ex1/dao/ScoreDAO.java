package db.ex1.dao;

import java.util.List;

import db.ex1.model.vo.ScoreVO;

public interface ScoreDAO {

	List<ScoreVO> selectScoreList();

}
