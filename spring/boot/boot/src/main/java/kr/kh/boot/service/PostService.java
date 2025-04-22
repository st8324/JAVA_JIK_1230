package kr.kh.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.boot.dao.PostDAO;
import kr.kh.boot.model.vo.BoardVO;
import kr.kh.boot.model.vo.CommentVO;
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

	public boolean insertPost(PostVO post) {
		if(post == null || post.getPo_title().isBlank() || post.getPo_content().isBlank()){
			return false;
		}

		if(post.getPo_me_id() == null){
			return false;
		}

		boolean res = postDAO.insertPost(post);

		if(!res){
			return false;
		}
		//댓글 추가 작업
		List<CommentVO> list = post.getList();
		if(list == null || list.isEmpty()){
			return true;
		}
		for(CommentVO comment : list){
			try{
				comment.setCo_po_num(post.getPo_num());
				postDAO.insertComment(comment);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return true;
	}
}
