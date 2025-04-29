package kr.kh.shoppingmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import kr.kh.shoppingmall.model.vo.ProductVO;
import kr.kh.shoppingmall.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;

	@GetMapping("/list/{ca_num}")
	public String list(Model model, @PathVariable int ca_num) {
		List<ProductVO> list = productService.getProductList(ca_num);
		model.addAttribute("productList", list);
		return "product/list";
	}
	
}
