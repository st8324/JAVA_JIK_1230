package kr.kh.boot.controller;

import java.lang.reflect.Member;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import kr.kh.boot.model.vo.BoardVO;
import kr.kh.boot.model.vo.CustomUser;
import kr.kh.boot.model.vo.FileVO;
import kr.kh.boot.model.vo.LikeVO;
import kr.kh.boot.model.vo.MemberVO;
import kr.kh.boot.model.vo.PostVO;
import kr.kh.boot.service.PostService;
import kr.kh.boot.utils.Criteria;
import kr.kh.boot.utils.PageMaker;
import kr.kh.boot.utils.PostCriteria;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
public class PostController {
	
	@Autowired
	PostService postService;

	@GetMapping("/post/list/{bo_num}")
	public String postList(Model model, @PathVariable int bo_num, PostCriteria cri) {
		//등록된 전체 게시판을 가져옴
		List<BoardVO> boardList = postService.getBoardList();
		cri.setBo_num(bo_num);
		cri.setPerPageNum(2);
		//게시판 번호에 맞는 게시글 목록을 가져옴
		List<PostVO> list = postService.getPostList(cri);
		PageMaker pm = postService.getPageMaker(cri);

		model.addAttribute("list", list);
		model.addAttribute("url", "/post/list");
		model.addAttribute("boardList", boardList);
		model.addAttribute("pm", pm);
		return "post/list";
	}
	
	@GetMapping("/post/detail/{po_num}")
	public String getMethodName(Model model, @PathVariable int po_num) {
		postService.updateView(po_num);
		PostVO post = postService.getPost(po_num);
		List<FileVO> list = postService.getFileList(po_num);
		model.addAttribute("post", post);
		model.addAttribute("list", list);
		return "post/detail";
	}
	
	@GetMapping("/post/insert")
	public String postInsert(Model model) {
		List<BoardVO> list = postService.getBoardList();
		model.addAttribute("list", list);
		return "post/insert";
	}
	@PostMapping("/post/insert")
	public String postInsertPost(PostVO post, @AuthenticationPrincipal CustomUser customUser, 
		MultipartFile[] fileList) {
		
		//로그인한 회원 정보를 가져옴
		if(customUser != null){
			MemberVO user = customUser.getMember();
			post.setPo_me_id(user.getMe_id());
		}
		if(postService.insertPost(post, fileList)){
			return "redirect:/post/list/" + post.getPo_bo_num();
		}
		return "redirect:/post/insert";
	}
	@PostMapping("/post/delete/{num}")
	public String postDelete(@PathVariable int num, @AuthenticationPrincipal CustomUser customUser) {
		if(customUser == null){
			return "redirect:/post/detail/"+num;
		}
		MemberVO user = customUser.getMember();
		if(postService.deletePost(num, user)){
			return "redirect:/post/list/0";
		}
		return "redirect:/post/detail/"+num;
	}
	@GetMapping("/post/update/{po_num}")
	public String postUpdate(Model model, 
		@PathVariable int po_num, 
		@AuthenticationPrincipal CustomUser customUser) {
		PostVO post = postService.getPost(po_num);
		
		//로그인 안한 사용자이거나 없는 게시글인 경우
		if(customUser == null || post == null){
			return "redirect:/post/detail/"+po_num;
		}
		//작성자가 아닌 경우
		MemberVO user = customUser.getMember();
		if(!user.getMe_id().equals(post.getPo_me_id())){
			return "redirect:/post/detail/"+po_num;
		}
		List<FileVO> list = postService.getFileList(po_num);
		model.addAttribute("post", post);
		model.addAttribute("list", list);
		return "post/update";
	}
	@PostMapping("/post/update/{po_num}")
	public String postUpdatePost(@PathVariable int po_num, 
		@AuthenticationPrincipal CustomUser customUser, 
		PostVO post ,
		int [] dels,
		MultipartFile [] fileList) {

		post.setPo_num(po_num);
		postService.updatePost(post, customUser, dels, fileList);
		return "redirect:/post/detail/"+po_num;
	}
	
	@ResponseBody
	@PostMapping("/post/like")
	public int postLikePost(@RequestBody LikeVO likeVO, @AuthenticationPrincipal CustomUser customUser) {
		
		return postService.like(likeVO, customUser);
	}
	
	@GetMapping("/post/like")
	public String postLike(Model model, @RequestParam int po_num, @AuthenticationPrincipal CustomUser customUser) {
		LikeVO like = postService.getLike(po_num, customUser);
		model.addAttribute("like", like);
		return "post/like";
	}
}
