package kr.kh.spring2.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring2.model.vo.BoardVO;
import kr.kh.spring2.model.vo.FileVO;
import kr.kh.spring2.model.vo.MemberVO;
import kr.kh.spring2.model.vo.PostVO;
import kr.kh.spring2.pagination.Criteria;
import kr.kh.spring2.pagination.PageMaker;

public interface PostService {

	List<BoardVO> getBoardList();

	List<PostVO> getPostList(Criteria cri);

	PageMaker getPageMaker(Criteria cri);

	PostVO getPost(int po_num);

	List<FileVO> getFileList(int po_num);

	boolean insertPost(PostVO post, MemberVO user, MultipartFile[] fileList);

}
