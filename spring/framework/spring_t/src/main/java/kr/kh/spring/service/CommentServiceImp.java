package kr.kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.CommentDAO;
import kr.kh.spring.model.vo.CommentVO;

@Service
public class CommentServiceImp implements CommentService {

	@Autowired
	CommentDAO commentDao;

	@Override
	public boolean insertComment(CommentVO comment) {
		if(comment == null) {
			return false;
		}
		try {
			return commentDao.insertComment(comment);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
