package kr.kh.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.boot.dao.CommentDAO;
import kr.kh.boot.model.vo.CommentVO;
import kr.kh.boot.model.vo.CustomUser;
import kr.kh.boot.utils.CommentCriteria;
import kr.kh.boot.utils.Criteria;
import kr.kh.boot.utils.PageMaker;

@Service
public class CommentService {
	@Autowired
	CommentDAO commentDAO;

	public boolean insertComment(CommentVO comment, CustomUser customUser) {
		if(comment == null || customUser == null || comment.getCo_content().isBlank()){
			return false;
		}
		comment.setCo_me_id(customUser.getMember().getMe_id());
		return commentDAO.insertComment(comment);
	}

	public List<CommentVO> getCommentList(Criteria cri) {
		if(cri == null){
			return null;
		}
		return commentDAO.selectCommentList(cri);
	}

	public PageMaker getPageMaker(Criteria cri) {
		if(cri == null){
			return null;
		}
		int count = commentDAO.selectCountCommentList(cri);
		return new PageMaker(3, cri, count);
	}

	public boolean deleteComment(int co_num) {
		return commentDAO.deleteComment(co_num);
	}
}
