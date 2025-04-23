package kr.kh.boot.dao;

import java.util.List;

import kr.kh.boot.model.vo.BoardVO;
import kr.kh.boot.model.vo.CommentVO;
import kr.kh.boot.model.vo.FileVO;
import kr.kh.boot.model.vo.PostVO;

public interface PostDAO {

	List<PostVO> selectPostList(int bo_num);

	List<BoardVO> selectBoardList();

	PostVO selectPost(int po_num);

	List<FileVO> selectFileList(int po_num);

	boolean insertPost(PostVO post);

	void insertComment(CommentVO comment);

	void insertFile(FileVO file);

	void deleteFile(int fi_num);

	boolean deletePost(int po_num);
	
}
