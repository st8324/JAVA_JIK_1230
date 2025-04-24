package kr.kh.boot.dao;

import java.util.List;

import kr.kh.boot.model.vo.BoardVO;
import kr.kh.boot.model.vo.CommentVO;
import kr.kh.boot.model.vo.FileVO;
import kr.kh.boot.model.vo.LikeVO;
import kr.kh.boot.model.vo.PostVO;
import kr.kh.boot.utils.Criteria;

public interface PostDAO {

	List<PostVO> selectPostList(Criteria cri);

	List<BoardVO> selectBoardList();

	PostVO selectPost(int po_num);

	List<FileVO> selectFileList(int po_num);

	boolean insertPost(PostVO post);

	void insertComment(CommentVO comment);

	void insertFile(FileVO file);

	void deleteFile(int fi_num);

	boolean deletePost(int po_num);

	void updatePost(PostVO dbPost);

	FileVO selectFile(int fi_num);

	int selectCountPostList(Criteria cri);

	LikeVO selectLike(LikeVO likeVO);

	void insertLike(LikeVO likeVO);

	void deleteLike(int li_num);

	void updateLike(LikeVO likeVO);

	void updatePostLike(int po_num);

	void updateView(int po_num);
	
}
