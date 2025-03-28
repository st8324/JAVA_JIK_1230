package kr.kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.CommentDAO;
import kr.kh.spring.model.vo.CommentVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.pagination.PageMaker;

@Service
public class CommentServiceImp implements CommentService {

	@Autowired
	CommentDAO commentDao;

	@Override
	public boolean insertComment(CommentVO comment, MemberVO user) {
		if(comment == null) {
			return false;
		}
		if(user == null) {
			return false;
		}
		try {
			comment.setCo_me_id(user.getMe_id());
			return commentDao.insertComment(comment);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<CommentVO> getCommentList(Criteria cri) {
		if(cri == null) {
			return null;
		}
		return commentDao.selectCommentList(cri);
	}

	@Override
	public PageMaker getPageMaker(Criteria cri) {
		if(cri == null) {
			return null;
		}
		return new PageMaker(3, cri, 0);
	}
}
