package db.ex1.dao;

import java.util.List;

import db.ex1.model.vo.StudentVO;

public interface StudentDAO {

	List<StudentVO> selectStudentList();

}
