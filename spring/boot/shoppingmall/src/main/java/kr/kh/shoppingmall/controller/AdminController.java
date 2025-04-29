package kr.kh.shoppingmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import kr.kh.shoppingmall.model.vo.CategoryVO;
import kr.kh.shoppingmall.service.AdminService;
import kr.kh.shoppingmall.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	ProductService productService;

	@GetMapping("/page")
	public String page() {
		return "admin/page";
	}
	
	@GetMapping("/category")
	public String category(Model model) {
		List<CategoryVO> list = productService.getCategory();
		model.addAttribute("list", list);
		return "admin/category";
	}
	@GetMapping("/category/insert")
	public String categoryInsert(CategoryVO category) {
		String res = productService.insertCategory(category);
		System.out.println(res);
		return "redirect:/admin/category";
	}
	
}
