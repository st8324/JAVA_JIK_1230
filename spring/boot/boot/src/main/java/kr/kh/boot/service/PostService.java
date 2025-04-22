package kr.kh.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.boot.dao.PostDAO;
import kr.kh.boot.model.vo.BoardVO;
import kr.kh.boot.model.vo.FileVO;
import kr.kh.boot.model.vo.PostVO;

@Service
public class PostService {

	@Autowired
	PostDAO postDAO;

	public List<PostVO> getPostList(int bo_num) {
		return postDAO.selectPostList(bo_num);
	}

	public List<BoardVO> getBoardList() {
		return postDAO.selectBoardList();
	}

	public PostVO getPost(int po_num) {
		return postDAO.selectPost(po_num);
	}

	public List<FileVO> getFileList(int po_num) {
		return postDAO.selectFileList(po_num);
	}
}
