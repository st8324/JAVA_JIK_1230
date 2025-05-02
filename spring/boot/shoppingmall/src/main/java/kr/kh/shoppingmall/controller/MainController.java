package kr.kh.shoppingmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.kh.shoppingmall.model.vo.BuyVO;
import kr.kh.shoppingmall.model.vo.CategoryVO;
import kr.kh.shoppingmall.model.vo.MemberVO;
import kr.kh.shoppingmall.service.MemberService;
import kr.kh.shoppingmall.service.ProductService;
import kr.kh.shoppingmall.utils.CustomUser;



@Controller
public class MainController {

	@Autowired
	MemberService memberService;
	@Autowired
	ProductService productService;
	
	@GetMapping("/")
	public String main() {
		return "index";
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "user/signup";
	}
	
	@PostMapping("/signup")
	public String signupPost(MemberVO member) {
		if(memberService.signup(member)){
			return "redirect:/";
		}
		return "redirect:/signup";
	}
	@GetMapping("/check/id")
	@ResponseBody
	public boolean checkId(@RequestParam String id) {
		return memberService.checkId(id);
	}
	
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
	@GetMapping("/category/{ca_num}")
	public String category(Model model, @PathVariable int ca_num) {
		List<CategoryVO> list = productService.getCategory();
		model.addAttribute("list", list);
		return "layout/header";
	}
	@GetMapping("/mypage")
	public String mypage(Model model, @AuthenticationPrincipal CustomUser customUser) {
		List<BuyVO> buyList = productService.getBuyList(customUser);
		System.out.println(buyList);
		model.addAttribute("buyList", buyList);
		test(1, "1");
		
		return "user/mypage";
	}
	public void test(int a, String b){

	}
}
