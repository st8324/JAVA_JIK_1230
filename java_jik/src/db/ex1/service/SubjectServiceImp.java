package db.ex1.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.ex1.dao.StudentDAO;
import db.ex1.dao.SubjectDAO;
import db.ex1.model.vo.SubjectVO;

public class SubjectServiceImp implements SubjectService {
	
	private SubjectDAO subjectDao;

	public SubjectServiceImp() {
		String resource = "db/ex1/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			subjectDao = session.getMapper(SubjectDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<SubjectVO> getSubjectList() {
		return subjectDao.selectSubjectList();
	}
}
