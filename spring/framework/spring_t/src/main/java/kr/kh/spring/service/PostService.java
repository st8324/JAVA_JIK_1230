package kr.kh.spring.service;

import java.util.List;

import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.model.vo.PostVO;

public interface PostService {

	List<PostVO> getPostList();

	List<BoardVO> getBoardList();

	

}
