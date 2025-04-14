package kr.kh.spring2.service;

import java.util.List;

import kr.kh.spring2.model.vo.BoardVO;
import kr.kh.spring2.model.vo.PostVO;

public interface PostService {

	List<BoardVO> getBoardList();

	List<PostVO> getPostList(int num);

}
