package kr.kh.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.model.vo.PostVO;
import kr.kh.spring.service.PostService;

@Controller
public class PostController {

	@Autowired
	private PostService postService;
	
	@GetMapping("/post/list")
	public String postList(Model model) {
		//게시글 목록 전체를 가져옴
		List<PostVO> list = postService.getPostList();
		//화면에 게시글 목록을 전송
		//매퍼의 resultType=kr.kh.spring.model.vo.postVO
		model.addAttribute("list", list);
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
	public String postInsertPost(PostVO post) {
		//추후 삭제될 예정
		MemberVO user = new MemberVO();
		user.setMe_id("admin");
		if(postService.insertPost(post, user)) {
			
		}else {
			
		}
		return "redirect:/post/list";
	}
}
