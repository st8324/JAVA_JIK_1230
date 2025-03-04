package db.ex1.main;

import java.util.List;

import db.ex1.model.vo.StudentVO;
import db.ex1.service.StudentService;
import db.ex1.service.StudentServiceImp;

public class Main {

	static StudentService studentService = new StudentServiceImp();
	
	public static void main(String[] args) {
	
		List<StudentVO> list = studentService.getStudentList();
		for(StudentVO std : list) {
			System.out.println(std);
		}
	}

}
