package db.ex2.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.ex2.dao.ScoreDAO;
import db.ex2.dao.StudentDAO;
import db.ex2.dao.SubjectDAO;
import db.ex2.model.vo.Student;
import db.ex2.model.vo.Subject;
import db.ex2.model.vo.SubjectScore;
import lombok.Data;

@Data
public class StudentManager {

	private List<Student> list;
	
	private StudentDAO studentDao;
	private ScoreDAO scoreDao;
	private SubjectDAO subjectDao;
	
	public StudentManager() {
		String resource = "db/ex2/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			studentDao = session.getMapper(StudentDAO.class);
			scoreDao = session.getMapper(ScoreDAO.class);
			subjectDao = session.getMapper(SubjectDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean contains(Student std) {
		//DB에서 std를 이용하여 학생 정보를 가져옴 
		Student dBstd = studentDao.selectStudent(std);
		
		//DB에서 가져온 학생 정보가 있으면 중복 
		if(dBstd != null) {
			return true;
		}
		return false;
	}
	
	public boolean insertStudent(Student std) {
		if(std == null) {
			return false;
		}
		//학생 중복 확인 
		if(contains(std)) {
			return false;
		}
		//학생이 중복되지 않으면 학생을 추가
		return studentDao.insertStudent(std);
	}

	public Student getStudent(Student std) {
		return contains(std) ? std : null;
	}
	//1 1 1 => 1 1 1
	public boolean updateStudent(Student selStd, Student newStd) {
		if(selStd == null || newStd == null) {
			return false;
		}
		//학년 반 번호가 같은 경우=>이름만 바꾸는 경우
		if(selStd.equals(newStd)) {
			return studentDao.updateStudent(newStd, newStd);		
		}
		//학년 반 번호가 다른 경우
		//새 학생 정보가 중복된 경우
		if(contains(newStd)) {
			return false;
		}
		return studentDao.updateStudent(selStd, newStd);	
		
	}

	public boolean deleteStudent(Student std) {
		if(std == null) {
			return false;
		}
		return studentDao.deleteStudent(std);
	}

	public void printStudent(Student std) {
		if(std == null) {
			System.out.println("학생 정보가 없습니다.");
			return;
		}	
		Student tmp = studentDao.selectStudent(std);
		if(tmp == null) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		tmp.print();
	}

	public int getScoreNum(Student std, SubjectScore subjectScore) {
		if(std == null || subjectScore == null || subjectScore.getSubject() == null) {
			return -1;
		}
		//등록된 학생인지 확인
		Student dbStd = studentDao.selectStudent(std);
		if(dbStd == null) {
			return -1;
		}
		//등록된 과목인지 확인 
		Subject dbSubject = subjectDao.selectSubject(subjectScore.getSubject());
		if(dbSubject == null) {
			return -1;
		}
		subjectScore.setKey(dbStd.getKey());
		subjectScore.getSubject().setNum(dbSubject.getNum());
		SubjectScore dbSubScore = scoreDao.selectScore(subjectScore);
		
		return dbSubScore != null ? dbSubScore.getNum() : -1;
	}
	
	public boolean insertScore(Student std, SubjectScore subjectScore) {
		if(std == null || subjectScore == null) {
			return false;
		}
		//새로 등록할 학생의 성적이 이미 등록되어 있는지를 확인 
		if(getScoreNum(std, subjectScore) != -1) {
			return false;
		}
		return scoreDao.insertScore(subjectScore);
	}

	public boolean updateScore(Student std, Subject subject, SubjectScore subjectScore) {
		if(	std == null || subject == null || 
			subjectScore == null || subjectScore.getSubject() == null) {
			return false;
		}
		//std와 subject를 이용하여 기존 성적 정보를 가져옴 
		SubjectScore tmp = new SubjectScore(subject, 0);
		int scNum = getScoreNum(std, tmp);
		//등록된 성적이 아니면
		if(scNum == -1) {
			return false;
		}
		Subject dbSubject = subjectDao.selectSubject(subjectScore.getSubject());
		//수정할 성적의 과목 정보가 없으면 
		if(dbSubject == null) {
			return false;
		}
		//현재 성적의 기본키를 가져옴
		subjectScore.setNum(scNum);
		//새 성적의 과복의 기본키를 가져옴 
		subjectScore.getSubject().setNum(dbSubject.getNum());
		return scoreDao.updateScore(subjectScore);
	}

	public boolean deleteScore(Student std, Subject subject) {
		if (std == null || subject == null) {
			return false;
		}
		Student dbStd = studentDao.selectStudent(std);
		if(dbStd == null) {
			return false;
		}
		Subject dbSubject = subjectDao.selectSubject(subject);
		if(dbSubject == null) {
			return false;
		}
		return scoreDao.deleteScore(dbStd.getKey(), dbSubject.getNum());
	}

	public void printScore(Student std, Subject subject) {
		if(std == null || subject == null) {
			System.out.println("출력할 수 없습니다.");
			return ;
		}
		std = studentDao.selectStudent(std);
		if(std == null) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		subject = subjectDao.selectSubject(subject);
		if(subject == null) {
			System.out.println("일치하는 과목 정보가 없습니다.");
			return;
		}
		SubjectScore tmp = new SubjectScore(new Subject(0, 0, ""),0);
		tmp.setKey(std.getKey());
		tmp.getSubject().setNum(subject.getNum());
		
		SubjectScore score = scoreDao.selectScore(tmp);
		if(score == null ) {
			System.out.println("등록된 성적이 없습니다.");
			return;
		}
		System.out.println(std + " " + score);
	}

	public void printStudentList() {
		List<Student> stds = studentDao.selectStudentList();
		System.out.println(stds);
		
	}
}










