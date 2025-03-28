package kr.kh.spring.service;

import java.util.List;

import kr.kh.spring.model.vo.CommentVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.pagination.PageMaker;

public interface CommentService {

	boolean insertComment(CommentVO comment, MemberVO user);

	List<CommentVO> getCommentList(Criteria cri);

	PageMaker getPageMaker(Criteria cri);

	boolean deleteComment(int co_num, MemberVO user);

	boolean updateComment(CommentVO comment, MemberVO user);

}
