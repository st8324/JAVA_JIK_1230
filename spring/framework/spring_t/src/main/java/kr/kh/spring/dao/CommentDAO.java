package kr.kh.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.model.vo.CommentVO;
import kr.kh.spring.pagination.Criteria;

public interface CommentDAO {

	boolean insertComment(@Param("comment")CommentVO comment);

	List<CommentVO> selectCommentList(@Param("cri")Criteria cri);

	CommentVO selectComment(@Param("co_num")int co_num);

	boolean deleteComment(@Param("co_num")int co_num);

	int selectCountCommentList(@Param("cri")Criteria cri);
	
}
