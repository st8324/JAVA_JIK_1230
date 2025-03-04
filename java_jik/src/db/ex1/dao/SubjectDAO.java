package db.ex1.dao;

import java.util.List;

import db.ex1.model.vo.SubjectVO;

public interface SubjectDAO {

	List<SubjectVO> selectSubjectList();

}
