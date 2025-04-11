package kr.kh.spring2.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.kh.spring2.model.vo.MemberVO;
import kr.kh.spring2.service.MemberService;


@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("/signup")
	public String signup() {
		return "/member/signup";
	}
	
	@PostMapping("/signup")
	public String signupPost(MemberVO member) {
		boolean res = memberService.signup(member);
		if(res) {
			return "redirect:/";
		}
		return "redirect:/signup";
	}
	@GetMapping("/login")
	public String login() {
		return "/member/login";
	}
	@PostMapping("/login")
	public String loginPost(Model model, MemberVO member) {
		MemberVO user = memberService.login(member);
		if(user == null) {
			return "redirect:/login";
		}
		//화면에서 자동 로그인 여부를 로그인한 회원 정보에 저장
		user.setAuto(member.isAuto());
		model.addAttribute("user", user);
		return "redirect:/";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//회원 정보에서 쿠키값을 null로 수정
		MemberVO user = (MemberVO)session.getAttribute("user");
		if(user != null) {
			memberService.updateMemberCookie(user.getMe_id(), null, null);
		}
		session.removeAttribute("user");
		
		return "redirect:/";
	}
}
