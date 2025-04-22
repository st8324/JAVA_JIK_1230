package kr.kh.boot.dao;

import java.util.List;

import kr.kh.boot.model.vo.BoardVO;
import kr.kh.boot.model.vo.PostVO;

public interface PostDAO {

	List<PostVO> selectPostList(int bo_num);

	List<BoardVO> selectBoardList();
	
}
