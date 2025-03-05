package db.ex2.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.ex1.dao.ScoreDAO;
import db.ex2.dao.StudentDAO;
import db.ex2.model.vo.Student;
import db.ex2.model.vo.Subject;
import db.ex2.model.vo.SubjectScore;
import lombok.Data;

@Data
public class StudentManager {

	private List<Student> list;
	
	private StudentDAO studentDao;
	
	public StudentManager() {
		String resource = "db/ex2/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			studentDao = session.getMapper(StudentDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean insertStudent(Student std) {
		if(std == null) {
			return false;
		}
		//학생 중복 확인 
		//DB에서 std를 이용하여 학생 정보를 가져옴 
		Student dBstd = studentDao.selectStudent(std);
		
		System.out.println("DB에서 가져온 학생 정보 : " + std);
		
		//DB에서 가져온 학생 정보가 있으면 중복 => false를 반환 
		if(dBstd != null) {
			return false;
		}
		//학생이 중복되지 않으면 학생을 추가
		return list.add(std);
	}

	public Student getStudent(Student std) {
		int index = list.indexOf(std);
		
		return index < 0 ? null : list.get(index);
	}
	//1 1 1 => 1 1 1
	public boolean updateStudent(Student selStd, Student newStd) {
		if(selStd == null || newStd == null || list == null) {
			return false;
		}
		if(!list.contains(selStd)) {
			return false;
		}
		Student tmp = getStudent(newStd);
		//수정될 정보가 업거나 이전 학생 정보이면 수정 
		if(tmp == null || tmp == getStudent(selStd)) {
			getStudent(selStd).update(newStd);
			return true;
		}
		return false;
	}

	public boolean deleteStudent(Student std) {
		if(std == null || list == null) {
			return false;
		}
		return list.remove(std);
	}

	public void printStudent(Student std) {
		if(std == null) {
			System.out.println("학생 정보가 없습니다.");
			return;
		}	
		if(list == null) {
			System.out.println("학생 리스트가 없습니다.");
			return;
		}
		Student tmp = getStudent(std);
		if(tmp == null) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		tmp.print();
	}

	public boolean insertScore(Student std, SubjectScore subjectScore) {
		if(list == null || std == null || subjectScore == null) {
			return false;
		}
		std = getStudent(std);
		if(std == null) {
			return false;
		}
		return std.insertScore(subjectScore);
	}

	public boolean updateScore(Student std, Subject subject, SubjectScore subjectScore) {
		if(list == null || std == null || subject == null || subjectScore == null) {
			return false;
		}
		std = getStudent(std);
		if(std == null) {
			return false;
		}
		return std.updateScore(subject, subjectScore);
	}

	public boolean deleteScore(Student std, Subject subject) {
		if (std == null || subject == null || list == null) {
			return false;
		}
		std = getStudent(std);
		if(std == null) {
			return false;
		}
		return std.deleteScore(subject);
	}

	public void printScore(Student std, Subject subject) {
		if(std == null || subject == null || list == null) {
			System.out.println("출력할 수 없습니다.");
			return ;
		}
		std = getStudent(std);
		if(std == null) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		std.printScore(subject);
	}
}










