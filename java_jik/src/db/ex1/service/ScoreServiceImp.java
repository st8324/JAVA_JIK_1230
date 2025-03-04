package db.ex1.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.ex1.dao.ScoreDAO;
import db.ex1.dao.SubjectDAO;
import db.ex1.model.vo.ScoreVO;
import db.ex1.model.vo.SubjectVO;

public class ScoreServiceImp implements ScoreService {
	
	private ScoreDAO scoreDao;

	public ScoreServiceImp() {
		String resource = "db/ex1/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			scoreDao = session.getMapper(ScoreDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ScoreVO> getScoreList() {
		return scoreDao.selectScoreList();
	}
}
