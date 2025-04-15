package kr.kh.spring2.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring2.dao.PostDAO;
import kr.kh.spring2.model.vo.BoardVO;
import kr.kh.spring2.model.vo.FileVO;
import kr.kh.spring2.model.vo.MemberVO;
import kr.kh.spring2.model.vo.PostVO;
import kr.kh.spring2.pagination.Criteria;
import kr.kh.spring2.pagination.PageMaker;
import kr.kh.spring2.pagination.PostCriteria;
import kr.kh.spring2.utils.UploadFileUtils;

@Service
public class PostServiceImp implements PostService {
	
	@Autowired
	PostDAO postDao;
	
	@Value("${file.location}")
	String uploadPath;

	@Override
	public List<BoardVO> getBoardList() {
		return postDao.selectBoardList();
	}

	@Override
	public List<PostVO> getPostList(Criteria cri) {
		if(cri == null) {
			return null;
		}
		return postDao.selectPostList(cri);
	}

	@Override
	public PageMaker getPageMaker(Criteria cri) {
		if(cri == null) {
			return null;
		}
		
		int count = postDao.selectCountPostList(cri);
		return new PageMaker(1, cri, count);
	}

	@Override
	public PostVO getPost(int po_num) {
		return postDao.selectPost(po_num);
	}

	@Override
	public List<FileVO> getFileList(int po_num) {
		return postDao.selectFileList(po_num);
	}

	@Override
	public boolean insertPost(PostVO post, MemberVO user, MultipartFile[] fileList) {
		if(post == null || user == null) {
			return false;
		}
		
		//첨부파일이 없으면
		if(fileList == null || fileList.length == 0) {
			return false;
		}

		int count = 0;
		//첨부파일 목록이 실제 파일이 없으수 있음. 
		for(MultipartFile file : fileList) {
			//첨부파일이 있으면 count를 증가
			if(file.getOriginalFilename().length() != 0) {
				count++;
			}
		}
		if(count == 0) {
			return false;
		}
		
		post.setPo_me_id(user.getMe_id());
		
		boolean res = postDao.insertPost(post);
	
		if(!res) {
			return false;
		}
		
		for(MultipartFile file : fileList) {
			if(file.getOriginalFilename().length() == 0) {
				continue;
			}
			insertFile(post.getPo_num(), file);
		}
		
		return true;
	}

	private void insertFile(int po_num, MultipartFile file) {
		if(file == null) {
			return; 
		}
		
		String fi_ori_name = file.getOriginalFilename();
		
		if(fi_ori_name.length() == 0) {
			return;
		}
		
		try {
			String fi_name = UploadFileUtils.uploadFile(uploadPath, fi_ori_name, file.getBytes());
			FileVO fileVo = new FileVO(fi_ori_name, fi_name, po_num);
			postDao.insertFile(fileVo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
