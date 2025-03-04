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
}
