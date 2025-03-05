package db.ex2.dao;

import org.apache.ibatis.annotations.Param;

import db.ex2.model.vo.Student;

public interface StudentDAO {

	Student selectStudent(@Param("std")Student std);

}
