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
			//System.out.println(std);
		}
		StudentVO std = studentService.getStudent(1,1,1); 
		System.out.println(std);
		
		StudentVO std2 = studentService.getStudent(new StudentVO(0, 1, 1, 1, null)); 
		System.out.println(std2);
		
	}

}
