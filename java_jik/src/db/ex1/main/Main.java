package db.ex1.main;

import java.util.List;

import db.ex1.model.vo.ScoreVO;
import db.ex1.model.vo.StudentVO;
import db.ex1.model.vo.SubjectVO;
import db.ex1.service.ScoreService;
import db.ex1.service.ScoreServiceImp;
import db.ex1.service.StudentService;
import db.ex1.service.StudentServiceImp;
import db.ex1.service.SubjectService;
import db.ex1.service.SubjectServiceImp;

public class Main {

	static StudentService studentService = new StudentServiceImp();
	static SubjectService subjectService = new SubjectServiceImp();
	static ScoreService scoreService = new ScoreServiceImp();
	
	public static void main(String[] args) {
		//등록된 모든 학생을 가져와서 콘솔창에 확인하는 코드
		List<StudentVO> list = studentService.getStudentList();
		for(StudentVO std : list) {
			//System.out.println(std);
		}
		//1학년 1반 1번 학생을 가져와서 확인하는 코드
		StudentVO std = studentService.getStudent(1,1,1); 
		//System.out.println(std);
		
		//1학년 1반 1번 학생을 가져와서 확인하는 코드
		StudentVO std2 = studentService.getStudent(new StudentVO(0, 1, 1, 1, null)); 
		//System.out.println(std2);
		
		/* 등록된 모든 과목을 가져와서 콘솔창에 확인하는 코드 */
		List<SubjectVO> subjectList = subjectService.getSubjectList();
		//System.out.println(subjectList);
		
		/* 등록된 모든 성적을 가져오는 코드*/
		List<ScoreVO> scoreList = scoreService.getScoreList();
		System.out.println(scoreList);
		
		/* 1학년 1반 1번 학생의 등록된 성적들을 가져오는 코드 */
		
	}

}
