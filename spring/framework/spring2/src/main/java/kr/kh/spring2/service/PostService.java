package kr.kh.spring2.service;

import java.util.List;

import kr.kh.spring2.model.vo.BoardVO;
import kr.kh.spring2.model.vo.PostVO;
import kr.kh.spring2.pagination.Criteria;
import kr.kh.spring2.pagination.PageMaker;

public interface PostService {

	List<BoardVO> getBoardList();

	List<PostVO> getPostList(Criteria cri);

	PageMaker getPageMaker(Criteria cri);

}
