package kr.kh.spring.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.model.vo.CommentVO;

public interface CommentDAO {

	boolean insertComment(@Param("comment")CommentVO comment);
	
}
