package db.ex2.dao;

import org.apache.ibatis.annotations.Param;

import db.ex2.model.vo.Student;

public interface StudentDAO {

	Student selectStudent(@Param("std")Student std);

	boolean insertStudent(@Param("std")Student std);

	boolean updateStudent(@Param("old")Student oldStd, @Param("new")Student newStd);

}
