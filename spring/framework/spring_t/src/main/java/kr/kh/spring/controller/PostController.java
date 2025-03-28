package kr.kh.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.model.vo.FileVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.model.vo.PostVO;
import kr.kh.spring.pagination.PageMaker;
import kr.kh.spring.pagination.PostCriteria;
import kr.kh.spring.service.PostService;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class PostController {

	@Autowired
	private PostService postService;
	
	@GetMapping("/post/list")
	public String postList(Model model, PostCriteria cri) {
		cri.setPerPageNum(2);
		//게시글 목록 전체를 가져옴
		List<PostVO> list = postService.getPostList(cri);
		List<BoardVO> boardList = postService.getBoardList();
		PageMaker pm = postService.getPageMaker(cri);
		
		//화면에 게시글 목록을 전송
		//매퍼의 resultType=kr.kh.spring.model.vo.postVO
		model.addAttribute("boardList", boardList);
		model.addAttribute("list", list);
		model.addAttribute("pm", pm);
		return "/post/list";
	}
	
	@GetMapping("/post/insert")
	public String postInsert(Model model) {
		//등록된 게시판 리스트를 가져와서 화면에 전송
		List<BoardVO> list = postService.getBoardList();
		model.addAttribute("list", list);
		return "/post/insert";
	}
	
	@PostMapping("/post/insert")
	public String postInsertPost(Model model, PostVO post, HttpSession session, MultipartFile[] fileList) {
		MemberVO user = (MemberVO) session.getAttribute("user");
		if(postService.insertPost(post, user, fileList)) {
			model.addAttribute("url", "/post/list");
			model.addAttribute("msg", "게시글을 등록했습니다.");
		}else {
			model.addAttribute("url", "/post/insert");
			model.addAttribute("msg", "게시글을 등록하지 못했습니다.");
		}
		return "/msg/msg";
	}
	@GetMapping("/post/detail/{po_num}")
	public String postDetail(Model model, @PathVariable("po_num")int po_num) {
		//게시글 조회수를 증가
		postService.updateView(po_num);
		//게시글을 가져옴
		PostVO post = postService.getPost(po_num);
		//첨부파일을 가져옴
		List<FileVO> list = postService.getFileList(po_num);
		
		//화면에 전송
		model.addAttribute("post", post);
		model.addAttribute("list", list);
		return "/post/detail";
	}
	@GetMapping("/post/delete/{po_num}")
	public String postDelete(Model model, @PathVariable("po_num")int po_num, HttpSession session) {
		//로그인한 회원 정보를 가져옴
		MemberVO user = (MemberVO) session.getAttribute("user");
		if(postService.deletePost(po_num, user)) {
			model.addAttribute("url", "/post/list");
			model.addAttribute("msg", "게시글을 삭제했습니다.");
		}else {
			model.addAttribute("url", "/post/detail/" + po_num);
			model.addAttribute("msg", "게시글을 삭제하지 못했습니다.");
		}
		return "/msg/msg";
	}
	@GetMapping("/post/update/{po_num}")
	public String postUpdate(Model model, @PathVariable("po_num")int po_num, HttpSession session) {
		
		//게시글을 가져옴
		PostVO post = postService.getPost(po_num);
		//작성자인지 아닌지 확인하는 작업 
		MemberVO user = (MemberVO) session.getAttribute("user");

		//로그인 안되어 있거나, 없는 게시글이거나 작성자가 아니면
		if(user == null || post == null || !post.getPo_me_id().equals(user.getMe_id())) {
			model.addAttribute("url", "/post/list");
			model.addAttribute("msg", "작성자가 아니거나 없는 게시글입니다.");
			return "/msg/msg";
		}
		
		
		List<BoardVO> list = postService.getBoardList();
		
		List<FileVO> fileList = postService.getFileList(po_num);
		
		//화면에 전송
		model.addAttribute("post", post);
		model.addAttribute("list", list);
		model.addAttribute("fileList", fileList);
		return "/post/update";			
		
		
	}
	@PostMapping("/post/update")
	public String postUpdatePost(Model model, PostVO post, 
			HttpSession session, MultipartFile [] fileList, int [] delNums) {
		MemberVO user = (MemberVO) session.getAttribute("user");
		if(postService.updatePost(post, user, fileList, delNums)) {
			model.addAttribute("msg", "게시글을 수정했습니다.");
		}else {
			model.addAttribute("msg", "게시글을 수정하지 못했습니다.");
		}
		model.addAttribute("url", "/post/detail/"+post.getPo_num());
		return "/msg/msg";
	}
}
