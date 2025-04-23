package kr.kh.boot.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.boot.dao.PostDAO;
import kr.kh.boot.model.vo.BoardVO;
import kr.kh.boot.model.vo.CommentVO;
import kr.kh.boot.model.vo.FileVO;
import kr.kh.boot.model.vo.PostVO;
import kr.kh.boot.utils.UploadFileUtils;

@Service
public class PostService {

	@Autowired
	PostDAO postDAO;

	@Value("${spring.path.upload}")
	String uploadPath;

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

	public boolean insertPost(PostVO post, MultipartFile[] fileList) {
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
		//첨부파일 추가 작업
		uploadFileList(post.getPo_num(), fileList);

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

	private void uploadFileList(int po_num, MultipartFile[] fileList) {
		if(fileList == null || fileList.length == 0){
			return;
		}
		
		for(MultipartFile file : fileList){
			uploadFile(po_num, file);
		}
	}

	private void uploadFile(int po_num, MultipartFile file) {
		if(file == null || file.getOriginalFilename().isEmpty()){
			return;
		}
		String fi_ori_name = file.getOriginalFilename();
		try {
			String fi_name = UploadFileUtils.uploadFile(uploadPath, fi_ori_name, file.getBytes());
			FileVO fileVO = new FileVO(po_num, fi_ori_name, fi_name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
