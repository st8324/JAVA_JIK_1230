package kr.kh.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.boot.dao.CommentDAO;
import kr.kh.boot.model.vo.CommentVO;
import kr.kh.boot.model.vo.CustomUser;

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
}
