package kr.kh.spring.dao;

import java.util.List;

import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.model.vo.PostVO;

public interface PostDAO {

	List<PostVO> selectPostList();

	List<BoardVO> selectBoardList();

	
	
}
