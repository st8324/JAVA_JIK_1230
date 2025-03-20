package kr.kh.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.model.vo.PostVO;

public interface PostDAO {

	List<PostVO> selectPostList(@Param("po_bo_num")int po_bo_num);

	List<BoardVO> selectBoardList();

	boolean insertBoard(@Param("bo_name")String bo_name);

	boolean deleteBoard(@Param("bo_num")int bo_num);

	boolean updateBoard(@Param("board")BoardVO board);

	boolean insertPost(@Param("post")PostVO post);

	PostVO selectPost(@Param("po_num")int po_num);

	boolean deletePost(@Param("po_num")int po_num);

	boolean updatePost(@Param("post")PostVO post);

	void updateView(@Param("po_num")int po_num);

	
	
}
