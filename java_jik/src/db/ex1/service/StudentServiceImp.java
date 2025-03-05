package db.ex1.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.ex1.dao.StudentDAO;
import db.ex1.model.vo.StudentVO;

public class StudentServiceImp implements StudentService {

	StudentDAO studentDao;
	
	public StudentServiceImp() {
		String resource = "db/ex1/config/mybatis-config.xml";
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

	@Override
	public List<StudentVO> getStudentList() {
		return studentDao.selectStudentList();
	}

	@Override
	public StudentVO getStudent(int grade, int classNum, int num) {
		return studentDao.selectStudent(grade, classNum, num);
	}

	@Override
	public StudentVO getStudent(StudentVO studentVO) {
		if(studentVO == null) {
			return null;
		}
		return studentDao.selectStudent2(studentVO);
	}

	@Override
	public boolean addStudent(StudentVO std) {
		StudentVO dbStd = studentDao.selectStudent2(std);
		//학년 반 번호가 일치하는 학생이 존재하면 
		if(dbStd != null) {
			return false;
		}
		return studentDao.insertStudent(std);
	}

	@Override
	public boolean updateStudentName(StudentVO std) {
		if(std == null) {
			return false;
		}
		return studentDao.updateStudentName(std);
	}

	@Override
	public boolean deleteStudent(StudentVO std) {
		if(std == null) {
			return false;
		}
		return studentDao.deleteStudent(std);
	}
}
