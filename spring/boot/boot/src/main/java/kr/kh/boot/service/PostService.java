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
import kr.kh.boot.model.vo.CustomUser;
import kr.kh.boot.model.vo.FileVO;
import kr.kh.boot.model.vo.LikeVO;
import kr.kh.boot.model.vo.MemberVO;
import kr.kh.boot.model.vo.PostVO;
import kr.kh.boot.utils.Criteria;
import kr.kh.boot.utils.PageMaker;
import kr.kh.boot.utils.PostCriteria;
import kr.kh.boot.utils.UploadFileUtils;

@Service
public class PostService {

	@Autowired
	PostDAO postDAO;

	@Value("${spring.path.upload}")
	String uploadPath;

	public List<PostVO> getPostList(Criteria cri) {
		return postDAO.selectPostList(cri);
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
			postDAO.insertFile(fileVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean deletePost(int num, MemberVO user) {
		if(user == null){
			return false;
		}

		PostVO post = postDAO.selectPost(num);
		//작성자 확인
		if(post == null || !post.getPo_me_id().equals(user.getMe_id())){
			return false;
		}
		//첨부파일 db에서 삭제 및 서버에서 삭제
		List<FileVO> list = postDAO.selectFileList(num);
		deleteFileList(list);

		return postDAO.deletePost(num);
	}

	private void deleteFileList(List<FileVO> list) {
		if(list == null || list.isEmpty()){
			return;
		}
		for(FileVO file : list){
			deleteFile(file);
		}
	}

	private void deleteFile(FileVO file) {
		UploadFileUtils.deleteFile(uploadPath, file.getFi_name());
		postDAO.deleteFile(file.getFi_num());
	}

	public void updatePost(PostVO post, CustomUser customUser, int[] dels, MultipartFile[] fileList) {
		if(post == null || customUser == null){
			return;
		}
		MemberVO user = customUser.getMember();
		if(user == null){
			return;
		}
		PostVO dbPost = postDAO.selectPost(post.getPo_num());
		//작성자 체크
		if(dbPost == null || !dbPost.getPo_me_id().equals(user.getMe_id())){
			return;
		}
		//제목, 내용 체크
		String po_title = post.getPo_title();
		String po_content = post.getPo_content();
		if(po_title == null || po_title.isBlank() || po_content == null || po_content.isBlank()){
			return;
		}
		dbPost.setPo_title(po_title);
		dbPost.setPo_content(po_content);
		postDAO.updatePost(dbPost);

		uploadFileList(post.getPo_num(), fileList);
		deleteFileList(post.getPo_num(), dels);
	}

	private void deleteFileList(int po_num, int[] dels) {
		if(dels == null || dels.length == 0){
			return;
		}
		for(int del : dels){
			FileVO file = postDAO.selectFile(del);
			if(file == null || file.getFi_po_num() != po_num){
				continue;
			}
			deleteFile(file);
		}
	}

	public PageMaker getPageMaker(Criteria cri) {
		int count = postDAO.selectCountPostList(cri);
		return new PageMaker(3, cri, count);
	}

	public int like(LikeVO likeVO, CustomUser customUser) {
		if(likeVO == null){
			throw new RuntimeException("추천 정보가 없습니다.");
		}
		if(customUser == null){
			throw new RuntimeException("로그인이 필요한 서비스입니다.");
		}
		MemberVO user = customUser.getMember();
		likeVO.setLi_me_id(user.getMe_id());

		LikeVO dbLikeVO = postDAO.selectLike(likeVO);
		try{
			//없으면 추가
			if(dbLikeVO == null){
				postDAO.insertLike(likeVO);
				return likeVO.getLi_state();
			}
			//있으면
			//취소인 경우 : 삭제
			if(dbLikeVO.getLi_state() == likeVO.getLi_state()){
				postDAO.deleteLike(dbLikeVO.getLi_num());
				return 0;
			}
			//취소가 아닌 경우 : 수정
			likeVO.setLi_num(dbLikeVO.getLi_num());
			postDAO.updateLike(likeVO);
			return likeVO.getLi_state();
		}catch(Exception e){
			throw new RuntimeException("예외 발생");
		}finally{
			//게시글 추천/비추천 수 수정
			postDAO.updatePostLike(likeVO.getLi_po_num());

		}
		
		
	}

	public LikeVO getLike(int po_num, CustomUser customUser) {
		if(customUser == null ){
			return null;
		}
		LikeVO like = new LikeVO();
		like.setLi_po_num(po_num);
		like.setLi_me_id(customUser.getMember().getMe_id());
		return postDAO.selectLike(like);
	}

	public void updateView(int po_num) {
		postDAO.updateView(po_num);
	}
}
