package db.ex1.service;

import java.util.List;

import db.ex1.model.vo.StudentVO;

public interface StudentService {

	List<StudentVO> getStudentList();

	StudentVO getStudent(int grade, int classNum, int num);

	StudentVO getStudent(StudentVO studentVO);

}
