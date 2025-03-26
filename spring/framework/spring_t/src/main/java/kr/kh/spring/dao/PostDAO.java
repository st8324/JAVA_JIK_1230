package kr.kh.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.model.vo.FileVO;
import kr.kh.spring.model.vo.PostVO;
import kr.kh.spring.pagination.Criteria;

public interface PostDAO {

	List<PostVO> selectPostList(@Param("cri")Criteria cri);

	List<BoardVO> selectBoardList();

	boolean insertBoard(@Param("bo_name")String bo_name);

	boolean deleteBoard(@Param("bo_num")int bo_num);

	boolean updateBoard(@Param("board")BoardVO board);

	boolean insertPost(@Param("post")PostVO post);

	PostVO selectPost(@Param("po_num")int po_num);

	boolean deletePost(@Param("po_num")int po_num);

	boolean updatePost(@Param("post")PostVO post);

	void updateView(@Param("po_num")int po_num);

	void insertFile(@Param("file")FileVO fileVo);

	List<FileVO> selectFileList(@Param("po_num")int po_num);

	void deleteFile(@Param("fi_num")int fi_num);

	FileVO selectFile(@Param("fi_num")int fi_num);

	int selectCountPostList(@Param("cri")Criteria cri);

	
	
}
