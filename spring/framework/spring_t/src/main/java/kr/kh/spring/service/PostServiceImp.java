package kr.kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.PostDAO;
import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.model.vo.PostVO;

@Service
public class PostServiceImp implements PostService {

	@Autowired
	private PostDAO postDao;

	@Override
	public List<PostVO> getPostList() {
		return postDao.selectPostList();
	}

	@Override
	public List<BoardVO> getBoardList() {
		return postDao.selectBoardList();
	}

	@Override
	public boolean insertBoard(String bo_name) {
		if(bo_name == null || bo_name.trim().length() == 0) {
			return false;
		}
		try {
			//bo_name이 중복된 경우 예외 발생 => 추가 실패 => return false;
			return postDao.insertBoard(bo_name);
		}catch (Exception e) {
			//e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteBoard(int bo_num) {
		return postDao.deleteBoard(bo_num);
	}

	@Override
	public boolean updateBoard(BoardVO board) {
		if(board == null || board.getBo_name() == null || board.getBo_name().trim().length() == 0) {
			return false;
		}
		return postDao.updateBoard(board);
	}

	@Override
	public boolean insertPost(PostVO post, MemberVO user) {
		if(	post == null || 
			post.getPo_title().trim().length() == 0 || 
			post.getPo_content().length() == 0) {
			return false;
		}
		if(user == null) {
			return false;
		}
		post.setPo_me_id(user.getMe_id());
		boolean res = postDao.insertPost(post);
		
		
		return res;
	}

		
}
