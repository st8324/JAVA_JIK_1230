package kr.kh.spring2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring2.dao.PostDAO;
import kr.kh.spring2.model.vo.BoardVO;
import kr.kh.spring2.model.vo.PostVO;

@Service
public class PostServiceImp implements PostService {
	
	@Autowired
	PostDAO postDao;

	@Override
	public List<BoardVO> getBoardList() {
		return postDao.selectBoardList();
	}

	@Override
	public List<PostVO> getPostList(int num) {
		return postDao.selectPostList(num);
	}
}
