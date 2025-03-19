package kr.kh.spring.service;

import java.util.List;

import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.model.vo.PostVO;

public interface PostService {

	List<PostVO> getPostList();

	List<BoardVO> getBoardList();

	boolean insertBoard(String bo_name);

	boolean deleteBoard(int bo_num);

	boolean updateBoard(BoardVO board);

	

}
