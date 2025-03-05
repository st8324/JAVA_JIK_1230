package db.ex2.dao;

import org.apache.ibatis.annotations.Param;

import db.ex2.model.vo.SubjectScore;

public interface ScoreDAO {

	SubjectScore selectScore(@Param("score")SubjectScore subjectScore);

	boolean insertScore(@Param("score")SubjectScore subjectScore);

}
