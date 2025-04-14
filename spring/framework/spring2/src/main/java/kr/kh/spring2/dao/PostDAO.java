package kr.kh.spring2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring2.model.vo.BoardVO;
import kr.kh.spring2.model.vo.PostVO;

public interface PostDAO {

	List<BoardVO> selectBoardList();

	List<PostVO> selectPostList(@Param("po_bo_num")int num);

}
